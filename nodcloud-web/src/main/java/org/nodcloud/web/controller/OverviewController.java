package org.nodcloud.web.controller;

import java.util.List;

import org.nodcloud.persistent.entity.UserLog;
import org.nodcloud.web.service.UserLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import static org.nodcloud.commons.utilites.SessionKeys.CURRENT_ZONE;
import static org.nodcloud.web.common.NodCloudConstruct.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.context.request.RequestAttributes.SCOPE_SESSION;

@Controller
public class OverviewController extends AbstractController {

    private static Logger LOG = LoggerFactory.getLogger(OverviewController.class);

    private static final String URL_MAPPING_CHANGE_ZONES = DASHBORD_URL_MAP_ROOT + "changeZones";
    public static final String URL_MAPPING = DASHBORD_URL_MAP_ROOT + "overview";
    public static final String REDIRECT_URL = "redirect:" + URL_MAPPING;

    @Autowired
    private UserLogService userLogService;

    @RequestMapping(value = URL_MAPPING_CHANGE_ZONES, params = "zone")
    public String changeZone(@RequestParam("zone") String zone, WebRequest request) {
        setCurrentZone(zone);
        return REDIRECT_URL;
    }

    @RequestMapping(value = {DASHBORD_URL_MAP, DASHBORD_URL_MAP_ROOT, URL_MAP_DASHBORD_OVERVIEW}, method = GET)
    public String overview(Model model, WebRequest request) throws Exception {
        request.setAttribute(CURRENT_ZONE, getCurrentQingZone().getId(), SCOPE_SESSION);
        final List<UserLog> operations = userLogService.getRecentOperations(getCurrentUser(), 10);
        model.addAttribute("logs", operations);
        return MODEL_AND_VIEW_DASHBORD_OVERVIEW;
    }

}
