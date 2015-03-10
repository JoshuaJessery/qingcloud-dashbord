/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.nodcloud.persistent.entity;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.nodcloud.utils.Collections3;


@Entity
@Table(name = "nod_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User extends IdEntity {
    private String loginName;
    private String plainPassword;
    private String password;
    private String salt;
    private String fullname;
    private String name;
    private String email;
    private String status;
    /**
     * 第三方登录用户类型：weibo, github
     */
    private String type;

    private List<Role> roleList = Lists.newArrayList(); // 有序的关联对象集合

    public User() {

    }

    public User(long id) {
        this.id = id;
    }

    @NotBlank
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Transient
    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // 多对多定义
    @ManyToMany
    @JoinTable(name = "nod_user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    // Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    // 集合按id排序
    @OrderBy("id ASC")
    // 缓存策略
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Transient
    @JsonIgnore
    public String getRoleNames() {
        return Collections3.extractToString(roleList, "name", ", ");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}