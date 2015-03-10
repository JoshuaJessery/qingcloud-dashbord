package org.nodcloud.web.service.impl;

import java.util.List;
import java.util.Map;

import org.nodcloud.commons.utilites.annotation.BusinessLog;
import org.nodcloud.persistence.DynamicSpecifications;
import org.nodcloud.persistence.SearchFilter;
import org.nodcloud.persistent.entity.Volume;
import org.nodcloud.persistent.repository.VolumeDao;
import org.nodcloud.qing.sdk.core.request.volume.CreateVolumeRequest;
import org.nodcloud.qing.sdk.core.request.volume.DeleteVolumeRequest;
import org.nodcloud.qing.sdk.core.response.volume.CreateVolumeResponse;
import org.nodcloud.qing.sdk.core.response.volume.DeleteVolumeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.nodcloud.web.service.AbstractNocloudService;
import org.nodcloud.web.service.VolumeService;
import org.nodcloud.exception.ErrorResponseException;
import org.nodcloud.exception.ServiceException;

import static com.google.common.base.Strings.isNullOrEmpty;

@Service
public class VolumeNocloudServiceImpl extends AbstractNocloudService implements VolumeService {

    @Autowired
    private VolumeDao volumeDao;

    @Override
    public Volume getVolume(long id) {
        return volumeDao.findOne(id);
    }

    @Override
    @BusinessLog
    public Volume saveVolume(Volume volume) throws Exception {

        CreateVolumeRequest request = new CreateVolumeRequest(volume.getSize());
        request.setCount(1);
        request.setVolumeName(volume.getName());

        try {
            CreateVolumeResponse response = getVolumeManager().createVolume(request);
            if (response.isSuccessful()) {
                volume.setUuid(response.getVolumeList()[0]);
                return volumeDao.save(volume);
            } else {
                throw new ErrorResponseException(response.getRetCode(), response.getMessage());
            }

        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }


    }

    @Override
    public void deleteVolume(long id) throws Exception {
        Volume volume = volumeDao.findOne(id);

        String uuid = volume.getUuid();
        if (!isNullOrEmpty(uuid)) {
            DeleteVolumeRequest request = new DeleteVolumeRequest();
            request.setVolumeId(uuid);
            try {
                DeleteVolumeResponse response = getVolumeManager().deleteVolume(request);
                if (response.isSuccessful()) {
                    volumeDao.delete(id);
                } else {
                    throw new ErrorResponseException(response.getRetCode(), response.getMessage());
                }
            } catch (Exception e) {
                throw new ServiceException(e.getMessage());
            }
        } else {
            volumeDao.delete(id);
        }

    }

    @Override
    @BusinessLog
    public void deleteVolumes(List<Long> ids) throws Exception {
        for (long id : ids) {
            deleteVolume(id);
        }
    }

    @Override
    public List<Volume> getAllVolume() {
        return (List<Volume>) volumeDao.findAll();
    }

    @Override
    public Page<Volume> getPage(Long userId, String zone, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) {

        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Volume> spec = buildSpecification(userId, zone, searchParams);
        return volumeDao.findAll(spec, pageRequest);

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
    private Specification<Volume> buildSpecification(Long userId, String zone, Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put("user.id", new SearchFilter("user.id", SearchFilter.Operator.EQ, userId));
        filters.put("zone", new SearchFilter("zone", SearchFilter.Operator.EQ, zone));
        Specification<Volume> spec = DynamicSpecifications.bySearchFilter(filters.values(), Volume.class);
        return spec;

    }

}
