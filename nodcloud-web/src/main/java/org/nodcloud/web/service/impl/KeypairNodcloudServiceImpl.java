package org.nodcloud.web.service.impl;

import java.util.List;
import java.util.Map;

import com.google.common.base.Strings;
import org.nodcloud.commons.utilites.CloudAction;
import org.nodcloud.commons.utilites.annotation.BusinessLog;
import org.nodcloud.persistence.DynamicSpecifications;
import org.nodcloud.persistence.SearchFilter;
import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.persistent.entity.KeyPair;
import org.nodcloud.persistent.repository.InstanceDao;
import org.nodcloud.persistent.repository.KeyPairDao;
import org.nodcloud.qing.sdk.core.Response;
import org.nodcloud.qing.sdk.core.request.keypair.CreateKeyPairRequest;
import org.nodcloud.qing.sdk.core.request.keypair.DeleteKeyPairRequest;
import org.nodcloud.qing.sdk.core.response.keypair.CreateKeyPairResponse;
import org.nodcloud.web.service.AbstractNocloudService;
import org.nodcloud.web.service.KeypairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class KeypairNodcloudServiceImpl extends AbstractNocloudService implements KeypairService {

    @Autowired
    private KeyPairDao keyPairDao;

    @Autowired
    private InstanceDao instanceDao;

    @Override
    public KeyPair getKeyPair(long id) {
        return keyPairDao.findOne(id);
    }

    @Override
    @BusinessLog
    public KeyPair saveKeyPair(final KeyPair keyPair) throws Exception {

        final CreateKeyPairRequest createKeyPairRequest = getCreateKeyPairRequest(keyPair);

        return (KeyPair) executeAction(new CloudAction<KeyPair>() {
            @Override
            public Response callCloud() throws Exception {
                return getKeyPairManager().createKeyPair(createKeyPairRequest);
            }

            @Override
            public KeyPair handleResponse(Response response) throws Exception {
                CreateKeyPairResponse createKeyPairResponse = (CreateKeyPairResponse) response;
                keyPair.setUuid(createKeyPairResponse.getKeypairId());
                keyPair.setPriKey(createKeyPairResponse.getPrivateKey());
                return keyPairDao.save(keyPair);
            }
        });

    }

    private CreateKeyPairRequest getCreateKeyPairRequest(KeyPair keyPair) {
        CreateKeyPairRequest request = new CreateKeyPairRequest();
        request.setEncryptMethod(keyPair.getEncryptMethod());
        return request;
    }

    @Override
    public void deleteKeyPair(final long id) throws Exception {

        final KeyPair keyPair = keyPairDao.findOne(id);
        if (Strings.isNullOrEmpty(keyPair.getUuid())) {
            keyPairDao.delete(id);
            return;
        }

        final DeleteKeyPairRequest request = new DeleteKeyPairRequest();
        request.setKeypairsNo(keyPair.getUuid());

        executeActionWithOutResponse(new CloudAction() {
            @Override
            public Response callCloud() throws Exception {
                return getKeyPairManager().deleteKeyPair(request);
            }

            @Override
            public Object handleResponse(Response response) throws Exception {

                final List<Instance> instances = keyPair.getInstances();
                for(Instance instance:instances) {

                    instance.getKeyPairs().remove(keyPair);
                    instanceDao.save(instance);

                }
                keyPairDao.delete(id);
                return null;
            }
        });

    }

    @Override
    @BusinessLog
    public void deleteKeyPairs(List<Long> ids) throws Exception {
        for (Long id : ids) {
            deleteKeyPair(id);
        }
    }

    @Override
    public List<KeyPair> getAllKeyPair() {
        return (List<KeyPair>) keyPairDao.findAll();
    }

    @Override
    public List<KeyPair> getAllKeyPair(Long userId, String zone) {
        return keyPairDao.findAllByUserIdAndZone(userId, zone);
    }

    @Override
    public Page<KeyPair> getPage(Long userId, String zone, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<KeyPair> spec = buildSpecification(userId, zone, searchParams);
        return keyPairDao.findAll(spec, pageRequest);
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
    private Specification<KeyPair> buildSpecification(Long userId, String zone, Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put("user.id", new SearchFilter("user.id", SearchFilter.Operator.EQ, userId));
        filters.put("zone", new SearchFilter("zone", SearchFilter.Operator.EQ, zone));
        Specification<KeyPair> spec = DynamicSpecifications.bySearchFilter(filters.values(), KeyPair.class);
        return spec;
    }

}
