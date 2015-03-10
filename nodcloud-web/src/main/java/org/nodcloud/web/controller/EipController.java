package org.nodcloud.web.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletRequest;

import com.google.common.base.Strings;
import org.nodcloud.persistent.entity.Eip;
import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.qing.sdk.core.status.EipStatus;
import org.nodcloud.web.Servlets;
import org.nodcloud.commons.model.notifaction.impl.SuccessNotifaction;
import org.nodcloud.commons.model.notifaction.impl.WarnNotifaction;
import org.nodcloud.web.service.EipService;
import org.nodcloud.web.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.nodcloud.web.common.NodCloudConstruct.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = EipController.URL_MAPPING)
public class EipController extends AbstractController {

    private static final String PAGE_SIZE = "5";
    public static final String URL_MAPPING = DASHBORD_URL_MAP_ROOT + "eips";
    public static final String REDIRECT_URL = "redirect:" + DASHBORD_URL_MAP_ROOT + "eips";

    public static final String SUCCESS_MESSAGE_EIP_CREATE = "公网IP创建成功";
    public static final String WARN_MESSAGE_ALREADY_BIND_EIP = "Server Already bind eip, ignore request";
    public static final String WARN_MESSAGE_EIP_ALREADY_ASSOCIATE = "EIP Already bind eip, ignore request";
    public static final String SUCCESS_MESSAGE_EIP_BIND = "IP绑定成功";
    public static final String SUCCESS_MESSAGE_RELEASE_EIP = "释放IP成功";
    public static final String SUCCESS_MESSAGE_DISSOCIATE_EIP = "解绑IP成功";


    @Autowired
    private EipService eipService;

    @Autowired
    private InstanceService instanceService;

    @RequestMapping(method = GET)
    public ModelAndView eips(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                             @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                             @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                             Model model,
                             ServletRequest request) throws Exception {

        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<Eip> eips = eipService.getPage(getCurrentUserId(), getCurrentZone(), searchParams, pageNumber, pageSize, sortType);
        updateEipStatus(eips);
        model.addAttribute("eips", eips);
        return new ModelAndView(MODEL_AND_VIEW_DASHBORD_EIP);
    }

    @RequestMapping(value = "create", method = POST)
    public String create(@ModelAttribute Eip eip, @RequestParam("count") int count, RedirectAttributes redirectAttributes) throws Exception {

        eip.setUser(getCurrentUser());
        eip.setZone(getCurrentZone());
        eipService.saveEip(eip, count);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_EIP_CREATE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "associate", method = POST)
    public String associate(@RequestParam("targetId") long target, @RequestParam("eip") long eipId, RedirectAttributes redirectAttributes) throws Exception {

        Instance instance = instanceService.getInstance(target);

        if (instance.getEip() != null) {
            redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new WarnNotifaction(WARN_MESSAGE_ALREADY_BIND_EIP));
            return REDIRECT_URL;
        }

        Eip eip = eipService.getEip(eipId);
        if (eip.getStatus().equalsIgnoreCase(EipStatus.ASSOCIATED)) {
            redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new WarnNotifaction(WARN_MESSAGE_EIP_ALREADY_ASSOCIATE));
            return REDIRECT_URL;
        }

        eipService.associate(target, eipId);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_EIP_BIND));
        return REDIRECT_URL;
    }

    @RequestMapping(value = "releaseEip", method = POST)
    public String releaseEip(@RequestParam("id") Long[] ids, RedirectAttributes redirectAttributes) throws Exception {
        eipService.release(Arrays.asList(ids));
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_RELEASE_EIP));
        return REDIRECT_URL;
    }

    @RequestMapping(value = "dissociateEip", method = POST)
    public String dissociateEip(@RequestParam("id") Long[] ids, RedirectAttributes redirectAttributes) throws Exception {
        eipService.dissociateEips(Arrays.asList(ids));
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_DISSOCIATE_EIP));
        return REDIRECT_URL;
    }

    private void updateEipStatus(Page<Eip> eips) {

        for (Eip eip : eips.getContent()) {
            if (EipStatus.PENDING.equalsIgnoreCase(eip.getStatus()) || Strings.isNullOrEmpty(eip.getStatus())) {
                try {
                    eipService.update(eip);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
