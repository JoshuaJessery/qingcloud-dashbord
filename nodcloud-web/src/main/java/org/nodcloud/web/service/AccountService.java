package org.nodcloud.web.service;

import java.util.List;
import java.util.Map;

import org.nodcloud.persistent.entity.Role;
import org.nodcloud.persistent.entity.User;
import org.nodcloud.persistent.repository.RoleDao;
import org.nodcloud.persistent.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public interface AccountService {
    void saveUser(User user);

    User getUser(Long id);

    List<User> getAllUserInitialized();

    User findUserByLoginName(String loginName);

    User findUserByEmail(String email);

    User findUserByNameInitialized(String name);

    List<User> searchUser(Map<String, Object> searchParams);

    Long getUserCount();

    List<Role> getAllRole();

    @Autowired
    void setUserDao(UserDao userDao);

    @Autowired
    void setRoleDao(RoleDao roleDao);
}
