package org.nodcloud.commons.utilites.builder;

import org.nodcloud.persistent.entity.Image;
import org.nodcloud.qing.sdk.core.model.QingImage;

public class ImageBuilder {

    private Image image;

    public ImageBuilder() {
        image = new Image();
    }

    public ImageBuilder withQingImage(QingImage qingImage) {
        image.setImageSize(qingImage.getImageSize());
        image.setName(qingImage.getImageName());
        image.setUuid(qingImage.getImageId());
        image.setDescription(qingImage.getDescription());
        image.setProvider("public");
        image.setStatus(qingImage.getStatus());
        image.setOsFamily(qingImage.getOsFamily());
        return this;
    }

    public Image build() {
        return image;
    }
}
