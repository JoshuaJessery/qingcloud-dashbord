package org.nodcloud.persistent.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nod_securitygroups")
public class SecurityGroup extends IdEntity {

    private User user;

    /**
     * 地层资源编号
     */
    private String uuid;

    /**
     * 防火墙名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 是否是系统默认防火墙，1为是，0为不是
     */
    private int isDefault;

    // TODO 应用该防火墙的资源 主机，路由器

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
