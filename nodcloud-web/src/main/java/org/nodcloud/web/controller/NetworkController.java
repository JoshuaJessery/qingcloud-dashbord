package org.nodcloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.nodcloud.web.common.NodCloudConstruct.DASHBORD_URL_MAP_ROOT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = NetworkController.PAGE_URL)
public class NetworkController extends AbstractController {

    public static final String PAGE_URL = DASHBORD_URL_MAP_ROOT + "networks";


    @RequestMapping(method = GET)
    public String showPage() {
        return "dashbord/networks";
    }

}
