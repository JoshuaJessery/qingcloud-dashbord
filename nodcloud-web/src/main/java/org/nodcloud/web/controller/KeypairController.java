package org.nodcloud.web.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nodcloud.persistent.entity.KeyPair;
import org.nodcloud.web.Servlets;
import org.nodcloud.commons.model.notifaction.impl.SuccessNotifaction;
import org.nodcloud.web.service.KeypairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.nodcloud.web.common.NodCloudConstruct.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = KeypairController.URL_MAPPING)
public class KeypairController extends AbstractController {

    private static Logger logger = LoggerFactory.getLogger(KeypairController.class.getSimpleName());

    private static final String PAGE_SIZE = "5";
    public static final String URL_MAPPING = DASHBORD_URL_MAP_ROOT + "keypairs";
    public static final String REDIRECT_URL = "redirect:" + URL_MAPPING;
    public static final String MODEL_AND_VIEW_DASHBORD_KEYPAIR = DASHBORD_ROOT + "keypairs";

    @Autowired
    KeypairService keypairService;

    @RequestMapping(value = "create", method = POST)
    public String create(@ModelAttribute KeyPair keyPair, RedirectAttributes redirectAttributes) throws Exception {
        keyPair.setUser(getCurrentUser());
        keyPair.setZone(getCurrentZone());
        keypairService.saveKeyPair(keyPair);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction("创建秘钥成功"));
        return REDIRECT_URL;
    }

    @RequestMapping(value = "delete", method = POST)
    public String delete(@RequestParam("id") List<Long> ids, RedirectAttributes redirectAttributes) throws Exception {

        keypairService.deleteKeyPairs(ids);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction("删除秘钥成功"));
        return REDIRECT_URL;
    }

    @RequestMapping(method = GET)
    public String keypairs(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                           @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                           @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                           Model model,
                           ServletRequest request) throws Exception {

        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<KeyPair> keyPairs = keypairService.getPage(getCurrentUserId(), getCurrentZone(), searchParams, pageNumber, pageSize, sortType);
        model.addAttribute("keyPairs", keyPairs);
        return MODEL_AND_VIEW_DASHBORD_KEYPAIR;
    }

    @RequestMapping(value = "download/{id}")
    public ModelAndView download(@PathVariable("id") long id, HttpServletResponse response) {

        KeyPair keyPair = keypairService.getKeyPair(id);
        String privateKey = keyPair.getPriKey();

        try {

            response.setHeader("Content-disposition", "attachment;filename=" + keyPair.getUuid());
            response.setContentType("application/txt");
            InputStream is = new ByteArrayInputStream(privateKey.getBytes());
            BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
            int len;
            byte[] buf = new byte[1024];
            while ((len = is.read(buf)) > 0) {
                outs.write(buf, 0, len);
            }
            outs.close();

        } catch (MalformedURLException e) {
            logger.error("Error ModelAndView.viewMain - MalformedURLException : " + e.toString() + " -- " + e.getStackTrace()[0].toString());
            return null;
        } catch (IOException e) {
            logger.error("Error ModelAndView.viewMain - IOException : " + e.toString() + " -- " + e.getStackTrace()[0].toString());
            return null;
        }

        return null;
    }

}
