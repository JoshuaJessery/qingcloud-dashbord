package org.nodcloud.commons.utilites;

import java.lang.reflect.Field;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;
import org.nodcloud.commons.model.notifaction.impl.ErrorNotifaction;
import org.nodcloud.exception.ErrorResponseException;
import org.nodcloud.exception.ServiceException;
import org.nodcloud.web.controller.SessionAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import static org.nodcloud.web.common.NodCloudConstruct.NOTIFICATION__MESSAGE;

public class ExceptionResolver implements HandlerExceptionResolver {

    private static Logger LOG = LoggerFactory.getLogger(ExceptionResolver.class);

    private static final String DEFAULT_ERROR_VIEW = "500.jsp";

    private static final String DEFAULT_ERROR_MESSAGE = "Service Throw Exception. Please retry after a moment";

    private static final String DEFAULT_REDIRECT_URL_FIELD_NAME = "REDIRECT_URL";


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ex.printStackTrace();

        ModelAndView modelAndView = new ModelAndView(DEFAULT_ERROR_VIEW);
        String errorMessage = DEFAULT_ERROR_MESSAGE;

        LOG.info("resolveException getHandler class-> " + handler.getClass() + "and errorMessage is" + ex.getMessage());

        String urlRedirect = getRedirectUrl((HandlerMethod) handler);

        if (!Strings.isNullOrEmpty(urlRedirect)) {
            modelAndView.setViewName(urlRedirect);
        }

        if (ex instanceof ServiceException) {
            errorMessage = "服务不可用请扫后再试";
        } else if (ex instanceof ErrorResponseException) {
            errorMessage = "错误码：" + ((ErrorResponseException) ex).getCode() + ", 错误信息：" + ex.getMessage();
        }
        notifactionErrorMessage(request, errorMessage);
        return modelAndView;

    }

    /**
     * 反射获取Controller的RedirectURL 地址
     */
    private String getRedirectUrl(HandlerMethod handler) {
        String urlRedirect = "";
        Object bean = handler.getBean();
        LOG.info("resolveException get Controller class-> " + bean.getClass());
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                if (field.getName().equalsIgnoreCase(DEFAULT_REDIRECT_URL_FIELD_NAME)) {
                    urlRedirect = (String) field.get(bean);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return urlRedirect;
    }

    private void notifactionErrorMessage(HttpServletRequest request, String errorMessage) {
        new SessionAccessor(request).addFlashAttribute(NOTIFICATION__MESSAGE, new ErrorNotifaction(errorMessage));
    }

}
