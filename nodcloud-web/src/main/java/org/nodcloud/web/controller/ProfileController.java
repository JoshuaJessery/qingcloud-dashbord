package org.nodcloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.nodcloud.web.common.NodCloudConstruct.MODEL_AND_VIEW_DASHBORD_PROFILE;
import static org.nodcloud.web.common.NodCloudConstruct.URL_MAP_DASHBORD_PROFILE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ProfileController extends AbstractController {

    @RequestMapping(value = URL_MAP_DASHBORD_PROFILE, method = GET)
    public String showPage() {
        return MODEL_AND_VIEW_DASHBORD_PROFILE;
    }

}
