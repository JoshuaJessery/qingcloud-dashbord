package org.nodcloud.web.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;

import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.persistent.entity.Volume;
import org.nodcloud.web.Servlets;
import org.nodcloud.web.common.page.model.BreadCrumb;
import org.nodcloud.web.common.page.model.BreadCrumbs;
import org.nodcloud.web.common.page.model.Instances;
import org.nodcloud.commons.model.notifaction.impl.SuccessNotifaction;
import org.nodcloud.web.service.InstanceService;
import org.nodcloud.web.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.nodcloud.web.common.NodCloudConstruct.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = VolumesController.URL_MAPPING)
public class VolumesController extends AbstractController {

    private static final String PAGE_SIZE = "5";

    public static final String URL_MAPPING = DASHBORD_URL_MAP_ROOT + "volumes";

    private static final String REDIRECT_URL = "redirect:/dashbord/volumes";

    @Autowired
    private VolumeService volumeService;

    @Autowired
    private InstanceService instanceService;

    @RequestMapping(method = GET)
    public String volumes(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                          @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                          @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                          Model model,
                          ServletRequest request) throws Exception {


        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<Volume> volumes = volumeService.getPage(getCurrentUserId(), getCurrentZone(), searchParams, pageNumber, pageSize, sortType);
        List<Instance> instances = instanceService.getAllInstances();

        BreadCrumbs breadCrumbs = new BreadCrumbs();
        breadCrumbs.addBreadCrumb(new BreadCrumb("volumes", "#"));

        model.addAttribute("breadCrumbs", breadCrumbs);
        model.addAttribute("instances", new Instances(instances));
        model.addAttribute("volumes", volumes);
        return MODEL_AND_VIEW_DASHBORD_VOLUME;
    }

    @RequestMapping(value = "create", method = POST)
    public String createVolume(@ModelAttribute Volume volume, @RequestParam("count") int count, RedirectAttributes redirectAttributes) throws Exception {
        volume.setUser(getCurrentUser());
        volume.setZone(getCurrentZone());
        volumeService.saveVolume(volume);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction("存储卷创建成功"));
        return REDIRECT_URL;
    }

    @RequestMapping(value = "delete", method = POST)
    public String deleteVolume(@RequestParam("id") List<Long> ids, RedirectAttributes redirectAttributes) throws Exception {
        volumeService.deleteVolumes(ids);
        redirectAttributes.addFlashAttribute(NOTIFICATION__MESSAGE, new SuccessNotifaction("存储卷删除成功"));
        return REDIRECT_URL;
    }


}
