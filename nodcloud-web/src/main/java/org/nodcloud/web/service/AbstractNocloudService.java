package org.nodcloud.web.service;

import org.nodcloud.commons.utilites.CloudAction;
import org.nodcloud.commons.utilites.CloudClientFactory;
import org.nodcloud.exception.ErrorResponseException;
import org.nodcloud.qing.sdk.CloudClient;
import org.nodcloud.qing.sdk.core.Response;
import org.nodcloud.qing.sdk.core.manager.*;
import org.nodcloud.qing.sdk.core.model.QingZones;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractNocloudService {

    @Autowired
    private CloudClientFactory factory;

    public Object executeAction(CloudAction action) throws Exception {

        Response response = action.callCloud();
        if (!response.isSuccessful()) {
            throw new ErrorResponseException(response);
        }

        return action.handleResponse(response);

    }

    public void executeActionWithOutResponse(CloudAction action) throws Exception {

        Response response = action.callCloud();
        if (!response.isSuccessful()) {
            throw new ErrorResponseException(response);
        }

        action.handleResponse(response);

    }

    private CloudClient getCloudClient() {
        return factory.getCloudClient();
    }

    private CloudClient getCloudClient(QingZones zone) {
        return factory.getCloudClient(zone);
    }

    protected EipManager getEipManager() {
        return getCloudClient().getEipManager();
    }

    protected ImageManager getImageManager() {
        return getCloudClient().getImageManager();
    }

    protected ImageManager getImageManager(QingZones zone) {
        return getCloudClient(zone).getImageManager();
    }

    protected InstanceManager getInstanceManager() {
        return getCloudClient().getInstanceManager();
    }

    protected KeyPairManager getKeyPairManager() {
        return getCloudClient().getKeyPairManager();
    }

    protected VolumeManager getVolumeManager() {
        return getCloudClient().getVolumeManager();
    }

    protected VxnetManager getVxnetManager() {
        return getCloudClient().getVxnetManager();
    }
}
