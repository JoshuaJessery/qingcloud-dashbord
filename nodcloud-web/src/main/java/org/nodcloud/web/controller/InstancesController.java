package org.nodcloud.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;

import com.google.common.base.Strings;
import org.nodcloud.commons.model.notifaction.impl.SuccessNotifaction;
import org.nodcloud.persistent.entity.Image;
import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.persistent.entity.KeyPair;
import org.nodcloud.web.Servlets;
import org.nodcloud.web.common.page.model.BreadCrumb;
import org.nodcloud.web.common.page.model.BreadCrumbs;
import org.nodcloud.web.common.page.model.Images;
import org.nodcloud.web.service.ImageService;
import org.nodcloud.web.service.InstanceService;
import org.nodcloud.web.service.KeypairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.nodcloud.qing.sdk.core.status.InstanceStatus.PENDING;
import static org.nodcloud.web.common.NodCloudConstruct.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = InstancesController.URL_MAPPING)
public class InstancesController extends AbstractController {

    private static final String PAGE_SIZE = "5";
    public static final String URL_MAPPING = DASHBORD_URL_MAP_ROOT + "instances";
    public static final String REDIRECT_URL = "redirect:" + URL_MAPPING;

    public static final String SUCCESS_MESSAGE_CREATE_INSTANCE = "Instance创建成功";
    public static final String SUCCESS_MESSAGE_DELETE_INSTANCE = "Instance删除成功";
    public static final String SUCCESS_MESSAGE_START_INSTANCE = "Instance启动成功";
    public static final String SUCCESS_MESSAGE_STOP_INSTANCE = "Instance停止成功";
    public static final String SUCCESS_MESSAGE_RESET_INSTANCE = "Instance重置成功";
    public static final String SUCCESS_MESSAGE_RESTART_INSTANCE = "Instance重启成功";
    public static final String SUCCESS_MESSAGE_RESIZE_INSTANCE = "Instance重置大小成功";


    @Autowired
    private InstanceService instanceService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private KeypairService keypairService;


    @RequestMapping(value = "create", method = POST)
    public String create(@ModelAttribute Instance instance, @RequestParam("imageId") long imageId, @RequestParam("keyPairId") long keyPairId, RedirectAttributes redirectAttributes) throws Exception {
        instance.setUser(getCurrentUser());
        instance.setZone(getCurrentZone());

        Image image = imageService.getImage(imageId);
        instance.setImage(image);

        if (keyPairId != 0) {
            KeyPair keyPair = keypairService.getKeyPair(keyPairId);
            instance.setKeyPairs(Arrays.asList(keyPair));
        }

        instanceService.createInstance(instance);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_CREATE_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "delete", method = POST)
    public String delete(@RequestParam("id") List<Long> instances, RedirectAttributes redirectAttributes) throws Exception {

        instanceService.deleteUserInstances(getCurrentUserId(), instances);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_DELETE_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "start", method = POST)
    public String start(@RequestParam(value = "id") List<Long> instances, RedirectAttributes redirectAttributes) throws Exception {

        instanceService.startInstance(instances);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_START_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "stop", method = POST)
    public String stop(@RequestParam("id") List<Long> instances, RedirectAttributes redirectAttributes) throws Exception {

        instanceService.stopInstance(instances);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_STOP_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "reset", method = POST)
    public String reset(Instance instance, @RequestParam("id") List<Long> instances, @RequestParam("keyPairId") long keyPairId, RedirectAttributes redirectAttributes) throws Exception {

        instance.setZone(getCurrentZone());

        if (keyPairId != 0) {
            KeyPair keyPair = keypairService.getKeyPair(keyPairId);
            instance.setKeyPairs(Arrays.asList(keyPair));
        }

        instanceService.resetInstance(instances, instance);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_RESET_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "restart", method = POST)
    public String restart(@RequestParam("id") List<Long> instances, RedirectAttributes redirectAttributes) throws Exception {

        instanceService.restartInstances(instances);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_RESTART_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "resize", method = POST)
    public String resize(@RequestParam("id") List<Long> instances, Instance instance, RedirectAttributes redirectAttributes) throws Exception {

        instanceService.resizeInstance(instances, instance);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction(SUCCESS_MESSAGE_RESIZE_INSTANCE));
        return REDIRECT_URL;

    }

    @RequestMapping(value = "modify", method = POST)
    public String resize(Instance instance) throws Exception {

        instanceService.modify(instance);
        return REDIRECT_URL;
    }

    @RequestMapping(method = GET)
    public String instances(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                            @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                            @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                            Model model,
                            ServletRequest request) throws Exception {

        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<Instance> instances = instanceService.getPage(getCurrentUserId(), getCurrentZone(), searchParams, pageNumber, pageSize, sortType);

        updateInstanceStatus(instances);

        Images publicImages = new Images(imageService.getAvailablePublicImages());

        BreadCrumbs breadCrumbs = new BreadCrumbs();
        breadCrumbs.addBreadCrumb(new BreadCrumb("Instance", "../instances"));

        model.addAttribute("publicImages", publicImages);
        model.addAttribute("breadCrumbs", breadCrumbs);
        model.addAttribute("instances", instances);
        return MODEL_AND_VIEW_DASHBORD_INSTANCES;
    }

    private void updateInstanceStatus(Page<Instance> instances) {
        try {
            for (Instance instance : instances.getContent()) {
                if (Strings.isNullOrEmpty(instance.getStatus()) || instance.getStatus().equalsIgnoreCase(PENDING)) {
                    instanceService.update(instance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
