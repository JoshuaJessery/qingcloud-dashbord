package org.nodcloud.web.service;

import java.util.List;
import java.util.Map;

import org.nodcloud.persistent.entity.KeyPair;
import org.springframework.data.domain.Page;

public interface KeypairService {
    KeyPair getKeyPair(long id);

    KeyPair saveKeyPair(KeyPair KeyPair) throws Exception;

    void deleteKeyPair(long id) throws Exception;

    void deleteKeyPairs(List<Long> ids) throws Exception;

    List<KeyPair> getAllKeyPair();

    List<KeyPair> getAllKeyPair(Long userId, String zone);

    Page<KeyPair> getPage(Long userId, String zone, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType);
}
