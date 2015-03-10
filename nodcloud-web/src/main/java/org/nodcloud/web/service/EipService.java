package org.nodcloud.web.service;

import java.util.List;
import java.util.Map;

import org.nodcloud.persistent.entity.Eip;
import org.springframework.data.domain.Page;

public interface EipService {

    Eip getEip(long id) throws Exception;

    Eip saveEip(Eip eip, int count) throws Exception;

    Eip updateEip(Eip eip) throws Exception;

    public void update(Eip eip) throws Exception;

    Page<Eip> getPage(Long userId, String zone, Map searchParams, int pageNumber, int pageSize, String sortType);

    public void associate(long instanceId, long eipId) throws Exception;

    void release(List<Long> strings) throws Exception;

    void dissociateEips(List<Long> ids) throws Exception;

    void dissociateEip(long id) throws Exception;

    void release(long id) throws Exception;
}
