/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.nodcloud.web.service.impl;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.nodcloud.persistence.DynamicSpecifications;
import org.nodcloud.persistence.Hibernates;
import org.nodcloud.persistence.SearchFilter;
import org.nodcloud.persistent.entity.Role;
import org.nodcloud.persistent.entity.User;
import org.nodcloud.persistent.repository.RoleDao;
import org.nodcloud.persistent.repository.UserDao;
import org.nodcloud.security.utils.Digests;
import org.nodcloud.utils.Encodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.nodcloud.web.service.AccountService;
import org.nodcloud.exception.ServiceException;

import static org.nodcloud.web.service.ShiroDbRealm.ShiroUser;


/**
 * 用户管理业务类.
 */
@Transactional
public class AccountServiceImpl implements AccountService {
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    private UserDao userDao;

    private RoleDao roleDao;


    /**
     * 在保存用户时,发送用户修改通知消息, 由消息接收者异步进行较为耗时的通知邮件发送.
     * <p/>
     * 如果企图修改超级用户,取出当前操作员用户,打印其信息然后抛出异常.
     */
    @Override
    public void saveUser(User user) {

        if (isSupervisor(user)) {
            logger.warn("操作员{}尝试修改超级管理员用户", getCurrentUserName());
            throw new ServiceException("不能修改超级管理员用户");
        }

        // 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
        if (StringUtils.isNotBlank(user.getPlainPassword())) {
            entryptPassword(user);
        }

        userDao.save(user);

        // 业务日志演示
        Map logData = Maps.newHashMap();
        logData.put("userId", user.getId());
    }

    /**
     * 按Id获得用户.
     */
    @Override
    public User getUser(Long id) {
        return userDao.findOne(id);
    }

    /**
     * 获取全部用户，并在返回前对用户的延迟加载关联角色进行初始化.
     */
    @Override
    public List<User> getAllUserInitialized() {
        List<User> result = (List<User>) userDao.findAll();
        for (User user : result) {
            Hibernates.initLazyProperty(user.getRoleList());
        }
        return result;
    }

    /**
     * 按登录名查询用户.
     */
    @Override
    public User findUserByLoginName(String loginName) {
        return userDao.findByLoginName(loginName);
    }

    /**
     * 查找github登录用户信息
     */
    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }


    /**
     * 按名称查询用户, 并在返回前对用户的延迟加载关联角色进行初始化.
     */
    @Override
    public User findUserByNameInitialized(String name) {
        User user = userDao.findByName(name);
        if (user != null) {
            Hibernates.initLazyProperty(user.getRoleList());
        }
        return user;
    }

    /**
     * 按页面传来的查询条件查询用户.
     */
    @Override
    public List<User> searchUser(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<User> spec = DynamicSpecifications.bySearchFilter(filters.values(), User.class);
        List<User> userList = userDao.findAll(spec);
        return userList;
    }

    /**
     * 获取当前用户数量.
     */
    @Override
    public Long getUserCount() {
        return userDao.count();
    }

    /**
     * 判断是否超级管理员.
     */
    private boolean isSupervisor(User user) {
        return ((user.getId() != null) && (user.getId() == 1L));
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
        user.setPassword(Encodes.encodeHex(hashPassword));
    }


    /**
     * 取出Shiro中的当前用户LoginName.
     */
    private String getCurrentUserName() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user.loginName;
    }

    // --------------------//
    // Role Management //
    // --------------------//

    @Override
    public List<Role> getAllRole() {
        return (List<Role>) roleDao.findAll();
    }

    // -----------------//
    // Setter methods //
    // -----------------//

    @Override
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

}
