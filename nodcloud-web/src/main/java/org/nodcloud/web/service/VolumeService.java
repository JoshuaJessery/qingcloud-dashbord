package org.nodcloud.web.service;

import java.util.List;
import java.util.Map;

import org.nodcloud.persistent.entity.Volume;
import org.springframework.data.domain.Page;

public interface VolumeService {
    Volume getVolume(long id);

    Volume saveVolume(Volume volume) throws Exception;

    void deleteVolume(long id) throws Exception;

    void deleteVolumes(List<Long> ids) throws Exception;

    List<Volume> getAllVolume();

    Page<Volume> getPage(Long userId, String zone, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType);
}
