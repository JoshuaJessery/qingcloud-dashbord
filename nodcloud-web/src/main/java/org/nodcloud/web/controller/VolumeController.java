package org.nodcloud.web.controller;

import org.nodcloud.web.service.InstanceService;
import org.nodcloud.web.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.nodcloud.web.common.NodCloudConstruct.DASHBORD_ROOT;
import static org.nodcloud.web.common.NodCloudConstruct.DASHBORD_URL_MAP_ROOT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = VolumeController.URL_MAPPING)
public class VolumeController extends AbstractController {

    private static final String PAGE_SIZE = "5";

    public static final String URL_MAPPING = DASHBORD_URL_MAP_ROOT + "volume";

    private static final String REDIRECT_URL = "redirect:" + URL_MAPPING;

    private static final String MODEL_AND_VIEW_VOLUME = DASHBORD_ROOT + "volume";

    @Autowired
    private VolumeService volumeService;

    @Autowired
    private InstanceService instanceService;

    @RequestMapping(value = "/{id}", method = GET)
    public String volumes(@PathVariable("id") long id) throws Exception {
        return MODEL_AND_VIEW_VOLUME;
    }


}
