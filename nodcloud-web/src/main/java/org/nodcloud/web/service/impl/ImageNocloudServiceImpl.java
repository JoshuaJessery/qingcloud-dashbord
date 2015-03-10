package org.nodcloud.web.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.nodcloud.commons.utilites.builder.ImageBuilder;
import org.nodcloud.persistence.DynamicSpecifications;
import org.nodcloud.persistence.SearchFilter;
import org.nodcloud.persistent.entity.Image;
import org.nodcloud.persistent.repository.ImageDao;
import org.nodcloud.qing.sdk.core.model.QingImage;
import org.nodcloud.qing.sdk.core.model.QingZones;
import org.nodcloud.qing.sdk.core.request.image.DescribeImagesRequest;
import org.nodcloud.qing.sdk.core.response.image.DescribeImagesResponse;
import org.nodcloud.web.service.AbstractNocloudService;
import org.nodcloud.web.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ImageNocloudServiceImpl extends AbstractNocloudService implements ImageService {

    private final static Logger LOG = LoggerFactory.getLogger(ImageNocloudServiceImpl.class);

    @Autowired
    private ImageDao imageDao;

    @Override
    public Image getImage(long id) {
        return imageDao.findOne(id);
    }

    @Override
    public Image getImageByUUID(String uuid) {
        return null;
    }

    @Override
    public Image saveImage(Image image) {
        return imageDao.save(image);
    }

    @Override
    public void deleteImage(long id) {
        imageDao.delete(id);
    }

    @Override
    @PostConstruct
    public void initialization() throws Exception {

        for (QingZones zone : QingZones.values()) {
            final DescribeImagesRequest describeImagesRequest = new DescribeImagesRequest();
            describeImagesRequest.setProvider("system");
            DescribeImagesResponse response = getImageManager(zone).describeImages(describeImagesRequest);
            List<QingImage> images = response.getImageSet();
            for (QingImage qingCloudImage : images) {
                try {
                    Image image = new ImageBuilder().withQingImage(qingCloudImage).build();
                    image.setZone(zone.getId());
                    imageDao.save(image);
                } catch (Exception e) {
                    LOG.debug(e.getMessage());
                }
            }
        }

    }

    @Override
    public List<Image> getAllImages() {
        return (List<Image>) imageDao.findAll();
    }

    @Override
    public List<Image> getAllUserImages(final Long userId) {

        return imageDao.findAll(new Specification<Image>() {
            @Override
            public Predicate toPredicate(Root<Image> imageRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(imageRoot.get("user.id"), userId);
            }
        });
    }

    @Override
    public List<Image> getAllUserAvailableImages(Long userId, String zone) {
        return imageDao.findAllByUserIdAndStatusAndZone(userId, "available", zone);

    }

    @Override
    public Page<Image> getSystemImagesByPage(Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) {

        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Image> spec = buildSystemImageSpecification(searchParams);
        return imageDao.findAll(spec, pageRequest);

    }

    @Override
    public List<Image> getPublicImagesByZone(String zone) {
        return imageDao.findAllByProviderAndStatusAndZone("public", "available", zone);
    }

    @Override
    public List<Image> getAvailablePublicImages() {
        return imageDao.findAllByProviderAndStatus("public", "available");
    }

    @Override
    public Page<Image> getPage(Long userId, String zone, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) {

        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Image> spec = buildPrivateImageSpecification(userId, zone, searchParams);
        return imageDao.findAll(spec, pageRequest);

    }

    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "id");
        } else if ("title".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "title");
        }

        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }

    /**
     * 创建动态查询条件组合.
     */
    private Specification<Image> buildSystemImageSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put("provider", new SearchFilter("provider", SearchFilter.Operator.EQ, "public"));
        Specification<Image> spec = DynamicSpecifications.bySearchFilter(filters.values(), Image.class);
        return spec;
    }

    /**
     * 创建动态查询条件组合.
     */
    private Specification<Image> buildPrivateImageSpecification(Long userId, String zone, Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put("user.id", new SearchFilter("user.id", SearchFilter.Operator.EQ, userId));
        filters.put("zone", new SearchFilter("zone", SearchFilter.Operator.EQ, zone));
        filters.put("provider", new SearchFilter("provider", SearchFilter.Operator.EQ, "private"));
        Specification<Image> spec = DynamicSpecifications.bySearchFilter(filters.values(), Image.class);
        return spec;
    }

}
