package org.nodcloud.web.common.page.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.nodcloud.persistent.entity.Instance;

public class Instances implements PageIterable<Instance> {

    private List<Instance> instances = new ArrayList<Instance>();

    public Instances(List<Instance> instances) {
        this.instances = instances;
    }

    public List<Instance> getInstances() {
        return instances;
    }

    @Override
    public Iterator<Instance> iterator() {
        return instances.iterator();
    }
}
