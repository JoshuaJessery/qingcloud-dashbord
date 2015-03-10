package org.nodcloud.web.service.impl;

import javax.annotation.PostConstruct;

import org.nodcloud.persistent.repository.VxnetDao;
import org.nodcloud.qing.sdk.core.model.QingVxnet;
import org.nodcloud.qing.sdk.core.request.vxnet.DescribeVxnetsRequest;
import org.nodcloud.qing.sdk.core.response.vxnet.DescribeVxnetsResponse;
import org.nodcloud.commons.utilites.builder.VxnetBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.nodcloud.web.service.AbstractNocloudService;
import org.nodcloud.web.service.VxnetService;

@Service
public class VxnetNocloudServiceImpl extends AbstractNocloudService implements VxnetService {

    private static final Logger LOG = LoggerFactory.getLogger(VxnetService.class);

    @Autowired
    private VxnetDao vxnetDao;

    @Override
    @PostConstruct
    public void initialization() {

        DescribeVxnetsRequest request = new DescribeVxnetsRequest();
        try {
            DescribeVxnetsResponse response = getVxnetManager().describeVxnets(request);
            for (QingVxnet qingVxnet : response.getVxnets()) {
                vxnetDao.save(new VxnetBuilder().withQingVxnet(qingVxnet).build());
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

    }

}
