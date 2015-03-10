package org.nodcloud.web.controller;

import com.mysql.jdbc.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.nodcloud.persistent.entity.User;
import org.nodcloud.qing.sdk.core.model.QingZones;
import org.springframework.web.context.request.RequestContextHolder;

import static org.nodcloud.web.service.ShiroDbRealm.ShiroUser;
import static org.nodcloud.commons.utilites.SessionKeys.CURRENT_ZONE;
import static org.springframework.web.context.request.RequestAttributes.SCOPE_SESSION;

public class AbstractController {

    /**
     * 取出Shiro中的当前用户Id.
     */
    protected Long getCurrentUserId() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.id;
    }

    protected User getCurrentUser() {
        return new User(getCurrentUserId());
    }

    protected QingZones getQingZones(String zone) {
        return (null != zone && null != QingZones.valueOfId(zone.toLowerCase())) ?
                QingZones.valueOfId(zone.toLowerCase()) :
                QingZones.DEFAULT;
    }

    protected QingZones getCurrentQingZone() {
        String currentSessionZone = getCurrentZone();
        return getQingZones(currentSessionZone);
    }

    protected String getCurrentZone() {
        String currentSessionZone = (String) RequestContextHolder.currentRequestAttributes().getAttribute(CURRENT_ZONE, SCOPE_SESSION);
        if (StringUtils.isNullOrEmpty(currentSessionZone)) {
            setCurrentZone(QingZones.DEFAULT.getId());
            currentSessionZone = QingZones.DEFAULT.getId();
        }
        return currentSessionZone;
    }

    protected void setCurrentZone(String zoneId) {
        QingZones qingZones = QingZones.valueOfId(zoneId);
        if (qingZones == null) {
            qingZones = QingZones.DEFAULT;
        }
        RequestContextHolder.currentRequestAttributes().setAttribute(CURRENT_ZONE, qingZones.getId(), SCOPE_SESSION);
    }
}
