package org.nodcloud.web.common.page.model;

import java.util.Iterator;
import java.util.List;

import org.nodcloud.persistent.entity.Image;


public class Images implements PageIterable<Image> {

    private List<Image> images;

    public Images(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public Iterator<Image> iterator() {
        return images.iterator();
    }
}
