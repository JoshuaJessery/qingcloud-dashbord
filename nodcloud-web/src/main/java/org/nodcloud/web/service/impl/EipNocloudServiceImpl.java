package org.nodcloud.web.service.impl;

import java.util.List;
import java.util.Map;

import org.nodcloud.persistence.DynamicSpecifications;
import org.nodcloud.persistence.SearchFilter;
import org.nodcloud.persistent.entity.Eip;
import org.nodcloud.persistent.entity.Instance;
import org.nodcloud.persistent.repository.EipDao;
import org.nodcloud.persistent.repository.InstanceDao;
import org.nodcloud.qing.sdk.core.Response;
import org.nodcloud.qing.sdk.core.model.QingEip;
import org.nodcloud.qing.sdk.core.request.eip.*;
import org.nodcloud.qing.sdk.core.response.eip.AllocateEipResponse;
import org.nodcloud.qing.sdk.core.response.eip.DescribeEipResponse;
import org.nodcloud.qing.sdk.core.status.EipStatus;
import org.nodcloud.commons.utilites.CloudAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.nodcloud.web.service.AbstractNocloudService;
import org.nodcloud.web.service.EipService;

@Service
public class EipNocloudServiceImpl extends AbstractNocloudService implements EipService {

    @Autowired
    private EipDao eipDao;

    @Autowired
    private InstanceDao instanceDao;


    @Override
    public Page<Eip> getPage(Long userId, String zone, Map searchParams, int pageNumber, int pageSize, String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Eip> spec = buildSpecification(userId, zone, searchParams);
        return eipDao.findAll(spec, pageRequest);
    }

    @Override
    public Eip getEip(long id) throws Exception {
        return eipDao.findOne(id);
    }


    @Override
    public void release(List<Long> ids) throws Exception {

        for (long id : ids) {
            release(id);
        }

    }

    @Override
    public void dissociateEips(List<Long> ids) throws Exception {
        for (long id : ids) {
            dissociateEip(id);
        }
    }

    @Override
    public Eip updateEip(Eip eip) throws Exception {
        return eipDao.save(eip);
    }

    private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "id");
        } else if ("title".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "title");
        }

        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }

    private Specification<Eip> buildSpecification(Long userId, String zone, Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put("user.id", new SearchFilter("user.id", SearchFilter.Operator.EQ, userId));
        filters.put("zone", new SearchFilter("zone", SearchFilter.Operator.EQ, zone));
        Specification<Eip> spec = DynamicSpecifications.bySearchFilter(filters.values(), Eip.class);
        return spec;
    }

    @Override
    public void dissociateEip(long id) throws Exception {
        final Eip eip = eipDao.findOne(id);
        final Instance instance = instanceDao.findByEipId(id);

        final DissociateEipRequest request = new DissociateEipRequest(eip.getUuid());

        executeActionWithOutResponse(new CloudAction() {
            @Override
            public Response callCloud() throws Exception {
                return getEipManager().dissociateEip(request);
            }

            @Override
            public Object handleResponse(Response response) throws Exception {
                instance.setEip(null);
                eip.setStatus(EipStatus.AVAILIABLE);
                return instanceDao.save(instance);
            }
        });

    }

    @Override
    public void release(long id) throws Exception {

        final Eip eip = eipDao.findOne(id);
        final ReleaseEipsRequest request = new ReleaseEipsRequest(eip.getUuid());

        executeActionWithOutResponse(new CloudAction() {
            @Override
            public Response callCloud() throws Exception {
                return getEipManager().releaseEip(request);
            }

            @Override
            public Object handleResponse(Response response) throws Exception {
                eipDao.delete(eip.getId());
                return null;
            }
        });

    }

    @Override
    public Eip saveEip(final Eip eip, int count) throws Exception {

        final AllocateEipRequest request = new AllocateEipRequest(eip.getBandwidth());
        request.setCount(count);

        return (Eip) executeAction(new CloudAction<Eip>() {
            @Override
            public Response callCloud() throws Exception {
                return getEipManager().allocateEip(request);
            }

            @Override
            public Eip handleResponse(Response response) throws Exception {
                AllocateEipResponse allocateEipResponse = (AllocateEipResponse) response;
                eip.setUuid(allocateEipResponse.getEips().get(0));
                eip.setStatus(EipStatus.PENDING);
                return eipDao.save(eip);
            }
        });

    }


    @Override
    public void update(final Eip eip) throws Exception {
        final DescribeEipRequest describeEipRequest = new DescribeEipRequest();
        describeEipRequest.setEipId(eip.getUuid());

        executeActionWithOutResponse(new CloudAction() {
            @Override
            public Response callCloud() throws Exception {
                return getEipManager().describeEip(describeEipRequest);
            }

            @Override
            public Object handleResponse(Response response) throws Exception {
                DescribeEipResponse describeEipResponse = (DescribeEipResponse) response;
                QingEip qingEip = describeEipResponse.getEipList().get(0);
                eip.setStatus(qingEip.getStatus());
                eip.setAddress(qingEip.getEip_addr());
                return eipDao.save(eip);
            }
        });

    }

    @Override
    public void associate(long instanceId, long eipId) throws Exception {
        final Eip eip = eipDao.findOne(eipId);
        final Instance instance = instanceDao.findOne(instanceId);

        final AssociateEipRequest request = new AssociateEipRequest(eip.getUuid(), instance.getUuid());

        executeActionWithOutResponse(new CloudAction() {
            @Override
            public Response callCloud() throws Exception {
                return getEipManager().associateEip(request);
            }

            @Override
            public Object handleResponse(Response response) throws Exception {
                eip.setStatus(EipStatus.ASSOCIATED);
                instance.setEip(eip);
                eipDao.save(eip);
                instanceDao.save(instance);
                return null;
            }
        });

    }


}
