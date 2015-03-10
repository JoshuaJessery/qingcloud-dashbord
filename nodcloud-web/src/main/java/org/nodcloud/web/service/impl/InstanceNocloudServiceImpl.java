package org.nodcloud.web.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.google.common.collect.Lists;
import org.nodcloud.commons.utilites.CloudAction;
import org.nodcloud.commons.utilites.LoginMode;
import org.nodcloud.commons.utilites.annotation.BusinessLog;
import org.nodcloud.commons.utilites.annotation.LogIgnore;
import org.nodcloud.commons.utilites.builder.InstanceBuilder;
import org.nodcloud.exception.ServiceException;
import org.nodcloud.persistence.DynamicSpecifications;
import org.nodcloud.persistence.SearchFilter;
import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.persistent.entity.KeyPair;
import org.nodcloud.persistent.repository.InstanceDao;
import org.nodcloud.qing.sdk.core.Response;
import org.nodcloud.qing.sdk.core.model.QingInstance;
import org.nodcloud.qing.sdk.core.request.instance.*;
import org.nodcloud.qing.sdk.core.response.instance.DescribeInstancesResponse;
import org.nodcloud.qing.sdk.core.response.instance.RunInstancesResponse;
import org.nodcloud.qing.sdk.core.status.InstanceStatus;
import org.nodcloud.web.service.AbstractNocloudService;
import org.nodcloud.web.service.InstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static org.nodcloud.persistence.SearchFilter.Operator;

@Service
public class InstanceNocloudServiceImpl extends AbstractNocloudService implements InstanceService {

    private static final Logger LOG = LoggerFactory.getLogger(InstanceNocloudServiceImpl.class);

    @Autowired
    private InstanceDao instanceDao;


    @PostConstruct
    private void initialization() {

        try {
            DescribeInstancesResponse response = getInstanceManager().describeInstances(new DescribeInstancesRequest());
            List<QingInstance> instances = response.getInstanceSet();
            for (QingInstance qingInstance : instances) {
                Instance instance = new InstanceBuilder().withQingInstance(qingInstance).build();
                instanceDao.save(instance);
            }
        } catch (Exception e) {
            LOG.debug(e.getMessage());
        }

    }

    @Override
    public void updateInstance(Instance instance) {
        instanceDao.save(instance);
    }

    @Override
    public Instance getInstance(long id) {
        return instanceDao.findOne(id);
    }

    @Override
    public Instance getUserInstance(long id, long userId) {
        return instanceDao.findByUserIdAndId(userId, id);
    }

    @Override
    public void deleteUserInstances(long userId, List<Long> ids) throws Exception {

        for (Long id : ids) {
            deleteUserInstance(userId, id);
        }

    }

    @Override
    @BusinessLog
    public void deleteUserInstance(final long userId, final long instanceId) throws Exception {

        Specification<Instance> specification = new Specification<Instance>() {

            @Override
            public Predicate toPredicate(Root<Instance> instanceRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                predicates.add(criteriaBuilder.equal(instanceRoot.get("user").get("id"), userId));
                predicates.add(criteriaBuilder.equal(instanceRoot.get("id"), instanceId));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };

        Instance instance = instanceDao.findOne(specification);
        if (instance != null) {
            deleteInstance(instance.getId());
        } else {
            throw new ServiceException();
        }

    }

    @Override
    public List<Instance> getAllInstances() {
        return (List<Instance>) instanceDao.findAll();
    }

    @Override
    public List<Instance> getAssociateAvailable(final long userId, final String zone) throws Exception {
        return instanceDao.findAllByUserIdAndZoneAndEipIsNull(userId, zone);
    }

    @Override
    @LogIgnore
    public Page<Instance> getPage(Long userId, String zone, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) {

        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Instance> spec = buildSpecification(userId, zone, searchParams);
        return instanceDao.findAll(spec, pageRequest);

    }

    /**
     * 启动主机
     */
    @Override
    @BusinessLog
    public void startInstance(List<Long> instances) throws Exception {

        for (final Long id : instances) {

            final StartInstancesRequest request = getStartInstanceRequest(id);
            executeActionWithOutResponse(new CloudAction() {

                @Override
                public Response callCloud() throws Exception {
                    return getInstanceManager().startInstances(request);
                }

                @Override
                public Object handleResponse(Response response) throws Exception {
                    Instance instance = instanceDao.findOne(id);
                    instance.setStatus(InstanceStatus.RUNNING);
                    instanceDao.save(instance);
                    return instance;
                }
            });
        }
    }

    /**
     * 重置主机
     */
    @Override
    @BusinessLog
    public void resetInstance(List<Long> instances, Instance instance) throws Exception {
        for (Long id : instances) {
            final ResetInstancesRequest request = getResetInstancesRequest(id, instance);
            executeActionWithOutResponse(new CloudAction() {
                @Override
                public Response callCloud() throws Exception {
                    return getInstanceManager().resetInstances(request);
                }

                @Override
                public Object handleResponse(Response response) throws Exception {
                    return null;
                }
            });
        }
    }

    /**
     * 停止主机
     */
    @Override
    @BusinessLog
    public void stopInstance(List<Long> instances) throws Exception {

        for (final Long id : instances) {

            final StopInstancesRequest request = getStopInstanceRequest(id);

            executeActionWithOutResponse(new CloudAction() {

                @Override
                public Response callCloud() throws Exception {
                    return getInstanceManager().stopInstances(request);
                }

                @Override
                public Object handleResponse(Response response) throws Exception {
                    Instance instance = instanceDao.findOne(id);
                    instance.setStatus(InstanceStatus.STOPPED);
                    instanceDao.save(instance);
                    return instance;
                }

            });
        }
    }

    @Override
    public void restartInstance(long id) throws Exception {
        final RestartInstancesRequest request = getRestartInstancesRequest(id);

        executeActionWithOutResponse(new CloudAction() {

            @Override
            public Response callCloud() throws Exception {
                return getInstanceManager().restartInstances(request);
            }

            @Override
            public Object handleResponse(Response response) throws Exception {
                return null;
            }
        });
    }

    /**
     * 重启主机
     */
    @Override
    @BusinessLog
    public void restartInstances(final List<Long> instances) throws Exception {

        for (long id : instances) {
            restartInstance(id);
        }
    }


    @Override
    @BusinessLog
    public void resizeInstance(List<Long> instances, final Instance instance) throws Exception {
        for (final Long id : instances) {
            final ResizeInstancesRequest request = getResizeInstancesRequest(id, instance);
            executeActionWithOutResponse(new CloudAction() {
                @Override
                public Response callCloud() throws Exception {
                    return getInstanceManager().resizeInstances(request);
                }

                @Override
                public Object handleResponse(Response response) throws Exception {
                    Instance _instance = instanceDao.findOne(id);
                    _instance.setMemory(instance.getMemory());
                    _instance.setCup(instance.getCup());
                    instanceDao.save(_instance);
                    return null;
                }
            });
        }
    }

    @Override
    @BusinessLog
    public Instance createInstance(final Instance instance) throws Exception {

        final RunInstancesRequest request = getRunInstancesRequest(instance);

        return (Instance) executeAction(new CloudAction<Instance>() {

            @Override
            public Response callCloud() throws Exception {
                return getInstanceManager().runInstances(request);
            }

            @Override
            public Instance handleResponse(Response response) throws Exception {
                RunInstancesResponse runInstancesResponse = (RunInstancesResponse) response;
                instance.setUuid(runInstancesResponse.getInstances()[0]);
                return instanceDao.save(instance);
            }
        });

    }

    @Override
    @BusinessLog
    public void deleteInstance(final long id) throws Exception {

        final TerminateInstancesRequest request = getTerminateInstancesRequest(id);

        executeActionWithOutResponse(new CloudAction() {
            @Override
            public Response callCloud() throws Exception {
                return getInstanceManager().terminateInstances(request);
            }

            @Override
            public Object handleResponse(Response response) throws Exception {
                instanceDao.delete(id);
                return null;
            }
        });

    }

    @Override
    @BusinessLog
    public void update(final Instance instance) throws Exception {
        final DescribeInstancesRequest request = new DescribeInstancesRequest();
        request.setInstancesN(instance.getUuid());

        executeActionWithOutResponse(new CloudAction() {
            @Override
            public Response callCloud() throws Exception {
                return getInstanceManager().describeInstances(request);
            }

            @Override
            public Object handleResponse(Response response) throws Exception {
                DescribeInstancesResponse describeInstancesResponse = (DescribeInstancesResponse) response;
                QingInstance qingInstance = describeInstancesResponse.getInstanceSet().get(0);
                instance.setStatus(qingInstance.getStatus());
                return instanceDao.save(instance);
            }
        });

    }

    @Override
    public void modify(Instance instance) throws Exception {
        Instance _instance = instanceDao.findOne(instance.getId());
        _instance.setName(instance.getName());
        _instance.setDescr(instance.getDescr());
        instanceDao.save(_instance);
    }

    private ResetInstancesRequest getResetInstancesRequest(long id, Instance instance) {
        final ResetInstancesRequest request = new ResetInstancesRequest();
        List<KeyPair> keyPairs = instance.getKeyPairs();
        if (keyPairs.size() != 0) {
            request.setLoginKeypair(keyPairs.get(0).getUuid());
        }
        request.setZone(instance.getZone());
        request.setLoginMode(LoginMode.valueOf(instance.getLoginMode()).getValue());
        request.setLoginPasswd(instance.getLoginPassword());
        request.setInstance0(instanceDao.findOne(id).getUuid());
        return request;
    }

    private ResizeInstancesRequest getResizeInstancesRequest(Long id, Instance instance) {
        final ResizeInstancesRequest request = new ResizeInstancesRequest();
        request.setInstancesN(instanceDao.findOne(id).getUuid());
        request.setCpu(instance.getCup());
        request.setMemory(Integer.valueOf(instance.getMemory()).toString());
        return request;
    }

    private RestartInstancesRequest getRestartInstancesRequest(long id) {
        final RestartInstancesRequest request = new RestartInstancesRequest();
        request.setInstancesN(instanceDao.findOne(id).getUuid());
        return request;
    }

    private StopInstancesRequest getStopInstanceRequest(long id) {
        final StopInstancesRequest request = new StopInstancesRequest();
        request.setInstancesN(instanceDao.findOne(id).getUuid());
        return request;
    }

    private StartInstancesRequest getStartInstanceRequest(long id) {
        final StartInstancesRequest request = new StartInstancesRequest();
        request.setInstancesN(instanceDao.findOne(id).getUuid());
        return request;
    }

    private RunInstancesRequest getRunInstancesRequest(Instance instance) {
        final RunInstancesRequest request = new RunInstancesRequest();
        List<KeyPair> keyPairs = instance.getKeyPairs();
        if (keyPairs.size() != 0) {
            request.setLoginKeypair(keyPairs.get(0).getUuid());
        }
        request.setCpu(instance.getCup());
        request.setMemory(instance.getMemory());
        request.setLoginPassword(instance.getLoginPassword());
        request.setImage_id(instance.getImage().getUuid());
        request.setLoginMode(LoginMode.valueOf(instance.getLoginMode()).getValue());
        return request;
    }

    private TerminateInstancesRequest getTerminateInstancesRequest(long id) {
        TerminateInstancesRequest request = new TerminateInstancesRequest();
        request.setInstancesNo(instanceDao.findOne(id).getUuid());
        return request;
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
    private Specification<Instance> buildSpecification(Long userId, String zone, Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
        filters.put("zone", new SearchFilter("zone", Operator.EQ, zone));
        Specification<Instance> spec = DynamicSpecifications.bySearchFilter(filters.values(), Instance.class);
        return spec;
    }


}
