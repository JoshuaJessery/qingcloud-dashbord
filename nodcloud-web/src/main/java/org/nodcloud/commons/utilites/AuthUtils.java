package org.nodcloud.commons.utilites;

import org.apache.shiro.SecurityUtils;

import static org.nodcloud.web.service.ShiroDbRealm.ShiroUser;

public class AuthUtils {

    public static long getCurrentUserId() {
        final ShiroUser principal = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return principal.id;
    }

}
