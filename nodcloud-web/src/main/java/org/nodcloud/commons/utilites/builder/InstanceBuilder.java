package org.nodcloud.commons.utilites.builder;

import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.qing.sdk.core.model.QingInstance;

public class InstanceBuilder {

    private Instance instance;

    public InstanceBuilder() {
        instance = new Instance();
    }

    public InstanceBuilder withQingInstance(QingInstance qingInstance) {

        this.instance.setUuid(qingInstance.getInstance_id());
        this.instance.setName(qingInstance.getInstance_name());
        return this;

    }

    public Instance build() {
        return instance;
    }

}
