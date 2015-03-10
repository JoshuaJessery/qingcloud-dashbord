package org.nodcloud.web.service.impl;

import java.util.List;

import org.nodcloud.persistent.entity.User;
import org.nodcloud.persistent.entity.UserLog;
import org.nodcloud.persistent.repository.UserLogDao;
import org.nodcloud.web.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogDao userLogDao;

    @Override
    public List<UserLog> getRecentOperations(User user) {
        return userLogDao.findByUserId(user.getId());
    }

    @Override
    public List<UserLog> getRecentOperations(User user, int limit) {
        final PageRequest pageRequest = new PageRequest(0, limit, Sort.Direction.DESC, "createAt");
        return userLogDao.findByUserId(user.getId(), pageRequest);
    }
}
