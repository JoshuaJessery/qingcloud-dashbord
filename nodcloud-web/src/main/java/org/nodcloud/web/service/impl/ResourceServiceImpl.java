package org.nodcloud.web.service.impl;

import org.nodcloud.persistent.repository.*;
import org.nodcloud.commons.model.service.ResourceItem;
import org.nodcloud.commons.model.service.ResourceSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nodcloud.web.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private InstanceDao instanceDao;

    @Autowired
    private VolumeDao volumeDao;

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private SnapshotDao snapshotDao;

    @Autowired
    private EipDao eipDao;

    @Autowired
    private LoadBalancerDao loadBalancerDao;

    @Autowired
    private SecurityGroupDao securityGroupDao;

    @Autowired
    private KeyPairDao keyPairDao;

    public ResourceSummary getSummary(long id, String zone) {

        ResourceSummary resources = new ResourceSummary(zone);
        resources.addResource(new ResourceItem("instance", instanceDao.findAllByUserIdAndZone(id, zone).size()));
        resources.addResource(new ResourceItem("volume", volumeDao.findAllByUserIdAndZone(id, zone).size()));
        resources.addResource(new ResourceItem("image", imageDao.findAllByUserIdAndZone(id, zone).size()));
        resources.addResource(new ResourceItem("snapshot", snapshotDao.findAllByUserIdAndZone(id, zone).size()));
        resources.addResource(new ResourceItem("eip", eipDao.findAllByUserIdAndZone(id, zone).size()));
        resources.addResource(new ResourceItem("network", 0));
        resources.addResource(new ResourceItem("load-balanace", loadBalancerDao.findAllByUserIdAndZone(id, zone).size()));
        resources.addResource(new ResourceItem("security-group", securityGroupDao.findAllByUserIdAndZone(id, zone).size()));
        resources.addResource(new ResourceItem("keypair", keyPairDao.findAllByUserIdAndZone(id, zone).size()));

        return resources;
    }
}
