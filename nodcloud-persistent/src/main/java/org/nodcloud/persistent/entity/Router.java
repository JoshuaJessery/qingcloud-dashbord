package org.nodcloud.persistent.entity;

import java.util.List;
import javax.persistence.*;

import com.google.common.collect.Lists;

@Entity
@Table(name = "nod_router")
public class Router extends IdEntity {

    private User user;

    /**
     * 底层编号
     */
    private String uuid;

    /**
     * 名称
     */
    private String name;

    /**
     * 内网IP
     */
    private String privateIp;

    /**
     * 公网IP
     */
    private Eip eip;

    /**
     * 与路由器相连的私有网络信息
     */
    private List<Vxnet> vxnets = Lists.newArrayList();

    @OneToMany(mappedBy = "router")
    public List<Vxnet> getVxnets() {
        return vxnets;
    }

    public void setVxnets(List<Vxnet> vxnets) {
        this.vxnets = vxnets;
    }

    private SecurityGroup securityGroup;

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

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        this.privateIp = privateIp;
    }

    @OneToOne
    @JoinColumn(name = "eip_id")
    public Eip getEip() {
        return eip;
    }

    public void setEip(Eip eip) {
        this.eip = eip;
    }

    @OneToOne
    @JoinColumn(name = "security_group_id")
    public SecurityGroup getSecurityGroup() {
        return securityGroup;
    }

    public void setSecurityGroup(SecurityGroup securityGroup) {
        this.securityGroup = securityGroup;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
