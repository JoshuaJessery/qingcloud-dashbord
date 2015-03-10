package org.nodcloud.web.service;

import org.nodcloud.commons.model.service.ResourceSummary;

public interface ResourceService {

    public ResourceSummary getSummary(long id, String zone);
}
