package org.nodcloud.web.service;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.nodcloud.persistent.entity.Image;
import org.springframework.data.domain.Page;

public interface ImageService {
    Image getImage(long id);

    Image getImageByUUID(String uuid);

    Image saveImage(Image image);

    void deleteImage(long id);

    @PostConstruct
    void initialization() throws Exception;

    List<Image> getAllImages();

    List<Image> getAllUserImages(Long userId);

    List<Image> getAllUserAvailableImages(Long userId, String zone);

    List<Image> getPublicImagesByZone(String zone);

    List<Image> getAvailablePublicImages();

    Page<Image> getSystemImagesByPage(Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType);

    Page<Image> getPage(Long userId, String zone, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType);
}
