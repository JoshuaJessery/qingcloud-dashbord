package org.nodcloud.web.common.page.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BreadCrumbs implements PageIterable<BreadCrumb> {

    public List<BreadCrumb> breadCrumbs = new ArrayList<BreadCrumb>();

    public void addBreadCrumb(BreadCrumb breadCrumb) {
        this.breadCrumbs.add(breadCrumb);
    }

    public List<BreadCrumb> getBreadCrumbs() {
        return breadCrumbs;
    }

    public void setBreadCrumbs(List<BreadCrumb> breadCrumbs) {
        this.breadCrumbs = breadCrumbs;
    }

    @Override
    public Iterator<BreadCrumb> iterator() {
        return breadCrumbs.iterator();
    }
}
