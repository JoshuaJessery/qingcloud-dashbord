package org.nodcloud.commons.model.service;

import java.util.ArrayList;
import java.util.List;

public class ResourceSummary {

    public String zone;

    public List<ResourceItem> resources = new ArrayList<ResourceItem>();

    public ResourceSummary(String zone) {
        this.zone = zone;
    }

    public List<ResourceItem> getResources() {
        return resources;
    }

    public void setResources(List<ResourceItem> resources) {
        this.resources = resources;
    }

    public void addResource(ResourceItem resourceItem) {
        this.resources.add(resourceItem);
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}

