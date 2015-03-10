package org.nodcloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.nodcloud.web.common.NodCloudConstruct.DASHBORD_URL_MAP_ROOT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = InstanceSnapshotController.INSTANCE_SNAPSHOTS_URL)
public class InstanceSnapshotController extends AbstractController {

    public static final String INSTANCE_SNAPSHOTS_URL = DASHBORD_URL_MAP_ROOT + "snapshots";

    @RequestMapping(method = GET)
    public String showPage() {
        return "dashbord/snapshots";
    }

}
