package org.nodcloud.web.rest;

import org.nodcloud.qing.sdk.core.model.QingZones;
import org.nodcloud.web.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.nodcloud.web.common.NodCloudConstruct.DASHBORD_URL_MAP_REST_ROOT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = CommonsRestful.URL_MAPPING)
public class CommonsRestful extends AbstractController {

    public static final String URL_MAPPING = DASHBORD_URL_MAP_REST_ROOT + "commons";

    @ResponseBody
    @RequestMapping(value = "zones", method = GET)
    public QingZones[] getAvailableZones() {
        return QingZones.values();
    }

    @ResponseBody
    @RequestMapping(value = "currentZone", method = GET)
    public QingZones getCurrentZones() {
        return getCurrentQingZone();
    }

}
