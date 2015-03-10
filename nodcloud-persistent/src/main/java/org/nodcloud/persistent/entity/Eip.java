package org.nodcloud.persistent.entity;

import javax.persistence.*;

@Entity
@Table(name = "nod_eips")
public class Eip extends IdEntity {

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
     * 公网IP带宽信息
     */
    private int bandwidth;

    private String status;

    private String address;

    private Router router;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToOne
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
