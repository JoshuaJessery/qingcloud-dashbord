package org.nodcloud.web.controller;

import java.util.List;

import org.nodcloud.commons.model.notifaction.impl.SuccessNotifaction;
import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.web.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.nodcloud.web.common.NodCloudConstruct.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = InstanceController.URL_MAPPING)
public class InstanceController extends AbstractController {

    public static final String URL_MAPPING = DASHBORD_URL_MAP_ROOT + "instance";
    public static final String REDIRECT_URL = "redirect:" + URL_MAPPING;

    public static final String SUCCESS_MESSAGE_DELETE_INSTANCE = "Instance删除成功";
    public static final String SUCCESS_MESSAGE_START_INSTANCE = "Instance启动成功";
    public static final String SUCCESS_MESSAGE_STOP_INSTANCE = "Instance停止成功";
    public static final String SUCCESS_MESSAGE_RESET_INSTANCE = "Instance重置成功";
    public static final String SUCCESS_MESSAGE_RESTART_INSTANCE = "Instance重启成功";
    public static final String SUCCESS_MESSAGE_RESIZE_INSTANCE = "Instance重置大小成功";

    @Autowired
    private InstanceService instanceService;

    @RequestMapping(value = "/{id}", method = GET)
    public String show(@PathVariable("id") long id, Model model) {

        final Instance instance = instanceService.getUserInstance(id, getCurrentUserId());
        model.addAttribute("instance", instance);
        return DASHBORD_ROOT + "instance";
    }

    @RequestMapping(value = "/{id}/delete", method = POST)
    public String delete(@PathVariable("id") List<Long> instances, RedirectAttributes redirectAttributes) throws Exception {
        instanceService.deleteUserInstances(getCurrentUserId(), instances);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_DELETE_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "/{id}/start", method = POST)
    public String start(@PathVariable(value = "id") List<Long> instances, RedirectAttributes redirectAttributes) throws Exception {
        instanceService.startInstance(instances);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_START_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "/{id}/stop", method = POST)
    public String stop(@PathVariable("id") List<Long> instances, RedirectAttributes redirectAttributes) throws Exception {
        instanceService.stopInstance(instances);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_STOP_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "/{id}/reset", method = POST)
    public String reset(@PathVariable("id") long id, RedirectAttributes redirectAttributes) throws Exception {
        /*instanceService.resetInstance(id);*/
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_RESET_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "/{id}/restart", method = POST)
    public String restart(@PathVariable("id") long id, RedirectAttributes redirectAttributes) throws Exception {

        instanceService.restartInstance(id);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_RESTART_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "/{id}/resize", method = POST)
    public String resize(@PathVariable("id") long id, RedirectAttributes redirectAttributes) throws Exception {

        /*instanceService.resizeInstance(id);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_RESIZE_INSTANCE));*/
        return REDIRECT_URL;

    }

}
