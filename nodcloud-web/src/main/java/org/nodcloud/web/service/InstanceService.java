package org.nodcloud.web.service;

import java.util.List;
import java.util.Map;

import org.nodcloud.persistent.entity.Instance;
import org.springframework.data.domain.Page;

public interface InstanceService {

    Instance getInstance(long id);

    Instance getUserInstance(long id, long userId);

    Instance createInstance(Instance instance) throws Exception;

    void deleteInstance(long id) throws Exception;

    void deleteUserInstances(long userId, List<Long> ids) throws Exception;

    void deleteUserInstance(long userId, long instanceId) throws Exception;

    List<Instance> getAllInstances() throws Exception;

    List<Instance> getAssociateAvailable(long userId, String zone) throws Exception;

    Page<Instance> getPage(Long userId, String zone, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) throws Exception;

    void startInstance(List<Long> instance) throws Exception;

    void resetInstance(List<Long> instances, Instance instance) throws Exception;

    void stopInstance(List<Long> instances) throws Exception;

    void restartInstance(long id) throws Exception;

    void restartInstances(List<Long> instances) throws Exception;

    void resizeInstance(List<Long> instances, Instance instance) throws Exception;

    void update(final Instance instance) throws Exception;

    void modify(Instance instance) throws Exception;

    void updateInstance(Instance instance);
}
