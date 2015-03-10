package org.nodcloud.persistent.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nod_volumes")
public class Volume extends IdEntity {

    /**
     * 对应底层编号
     */
    private String uuid;

    /**
     * 存储卷名称
     */
    private String name;

    /**
     * 存储卷大小 GB
     */
    private int size;

    /**
     * 存储卷状态 pending, available, in-use, suspended, deleted, ceased
     */
    private String status;

    /**
     * 过度状态
     * creating, attaching, detaching, suspending，resuming，deleting，recovering
     */
    private String transitionStatus;

    private Instance instance;

    private User user;

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransitionStatus() {
        return transitionStatus;
    }

    public void setTransitionStatus(String transitionStatus) {
        this.transitionStatus = transitionStatus;
    }

    @ManyToOne
    @JoinColumn(name = "instance_id")
    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
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
