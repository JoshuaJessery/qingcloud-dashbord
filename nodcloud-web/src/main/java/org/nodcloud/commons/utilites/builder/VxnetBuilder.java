package org.nodcloud.commons.utilites.builder;

import org.nodcloud.persistent.entity.Router;
import org.nodcloud.persistent.entity.Vxnet;
import org.nodcloud.qing.sdk.core.model.QingRouter;
import org.nodcloud.qing.sdk.core.model.QingVxnet;

import static org.nodcloud.commons.utilites.datetime.DateTimeUtils.fromQingCloudDateTime;

public class VxnetBuilder {

    private Vxnet vxnet;

    public VxnetBuilder() {
        this.vxnet = new Vxnet();
    }

    public VxnetBuilder withQingVxnet(QingVxnet qingVxnet) {

        this.vxnet.setDescription(qingVxnet.getDescription());
        this.vxnet.setCreateAt(fromQingCloudDateTime(qingVxnet.getCreateTime()));
        this.vxnet.setUuid(qingVxnet.getVxnetId());
        this.vxnet.setName(qingVxnet.getVxnetName());
        this.vxnet.setPrivateIp(qingVxnet.getPrivateIp());

        Router router = new Router();

        QingRouter qingRouter = qingVxnet.getRouter();
        router.setUuid(qingRouter.getRouterId());
        router.setName(qingRouter.getRouterName());
        vxnet.setRouter(router);
        return this;

    }

    public Vxnet build() {
        return this.vxnet;
    }
}
