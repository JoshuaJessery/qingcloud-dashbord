package org.nodcloud.commons.utilites;

import org.nodcloud.qing.sdk.CloudClient;
import org.nodcloud.qing.sdk.core.model.QingZones;
import org.springframework.web.context.request.RequestContextHolder;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_SESSION;

public class CloudClientFactory {

    private CloudClient cloudClient;

    public CloudClientFactory(String accessKeyId, String secretKey, String endpoint) {
        cloudClient = CloudClient.newInstance(accessKeyId, secretKey, endpoint);
    }

    public CloudClient getCloudClient() {
        String zone;
        try {
            zone = (String) RequestContextHolder.currentRequestAttributes().getAttribute(SessionKeys.CURRENT_ZONE, SCOPE_SESSION);
        } catch (Exception ex) {
            zone = QingZones.DEFAULT.getId();
        }
        cloudClient.setZone(zone);
        return cloudClient;
    }

    public CloudClient getCloudClient(QingZones zone) {
        cloudClient.setZone(zone.getId());
        return cloudClient;
    }

}
