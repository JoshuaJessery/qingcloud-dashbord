package org.nodcloud.web.controller;

import java.util.Map;
import javax.servlet.ServletRequest;

import org.nodcloud.persistent.entity.Image;
import org.nodcloud.web.Servlets;
import org.nodcloud.web.common.page.model.BreadCrumb;
import org.nodcloud.web.common.page.model.BreadCrumbs;
import org.nodcloud.web.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.nodcloud.web.common.NodCloudConstruct.MODEL_AND_VIEW_DASHBORD_IMAGES;
import static org.nodcloud.web.common.NodCloudConstruct.URL_MAP_DASHBORD_IMAGE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = URL_MAP_DASHBORD_IMAGE)
public class ImageController extends AbstractController {

    private static final String PAGE_SIZE = "5";

    @Autowired
    private ImageService imageService;

    @RequestMapping(method = GET)
    public String images(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                         @RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
                         @RequestParam(value = "sortType", defaultValue = "auto") String sortType,
                         Model model,
                         ServletRequest request) throws Exception {

        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<Image> userImages = imageService.getPage(getCurrentUserId(), getCurrentZone(), searchParams, pageNumber, pageSize, sortType);

        Page<Image> systemImages = imageService.getSystemImagesByPage(searchParams, pageNumber, pageSize, sortType);

        BreadCrumbs breadCrumbs = new BreadCrumbs();
        breadCrumbs.addBreadCrumb(new BreadCrumb("Instance", "../images"));

        model.addAttribute("userImages", userImages);
        model.addAttribute("systemImages", systemImages);
        model.addAttribute("breadCrumbs", breadCrumbs);
        return MODEL_AND_VIEW_DASHBORD_IMAGES;

    }

}
