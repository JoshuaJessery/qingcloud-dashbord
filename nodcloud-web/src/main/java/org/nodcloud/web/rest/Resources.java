package org.nodcloud.web.rest;

import java.util.List;

import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.web.controller.AbstractController;
import org.nodcloud.web.service.InstanceService;
import org.nodcloud.web.service.ResourceService;
import org.nodcloud.commons.model.service.ResourceSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/secure/resources")
public class Resources extends AbstractController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private InstanceService instanceService;

    @ResponseBody
    @RequestMapping(value = "/summary", method = GET)
    public ResourceSummary getResources() {
        return resourceService.getSummary(getCurrentUserId(), getCurrentZone());
    }

    @ResponseBody
    @RequestMapping(value = "/associate/available", method = GET)
    public List<Instance> getAssociateAvailableInstances() throws Exception {
        return instanceService.getAssociateAvailable(getCurrentUserId(), getCurrentZone());
    }

}
