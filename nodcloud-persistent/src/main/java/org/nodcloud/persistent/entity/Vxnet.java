package org.nodcloud.persistent.entity;

import javax.persistence.*;

@Entity
@Table(name = "nod_vxnets")
public class Vxnet extends IdEntity {

    /**
     * 创建者
     */
    private User user;
    /**
     * 底层编号
     */
    private String uuid;

    /**
     * 私有网络名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 私有网络IP地址
     */
    private String privateIp;

    /**
     * 私有网络绑定的路由器
     */
    private Router router;

    @Column(unique = true)
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

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        this.privateIp = privateIp;
    }

    @ManyToOne
    @JoinColumn(name = "router_id")
    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
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
