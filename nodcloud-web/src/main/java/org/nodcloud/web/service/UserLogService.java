package org.nodcloud.web.service;

import java.util.List;

import org.nodcloud.persistent.entity.User;
import org.nodcloud.persistent.entity.UserLog;

public interface UserLogService {

    public List<UserLog> getRecentOperations(User user);

    public List<UserLog> getRecentOperations(User user, int limit);

}
