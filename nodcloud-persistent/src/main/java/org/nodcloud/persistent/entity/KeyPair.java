package org.nodcloud.persistent.entity;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "nod_key_pairs")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({"user"})
public class KeyPair extends IdEntity {

    private User user;

    private String uuid;

    private String name;

    private String description;

    /**
     * 加密算法 有效值为 ssh-rsa 和 ssh-dss
     */
    private String encryptMethod = "ssh-rsa";

    private String pubKey;

    private String priKey;

    private List<Instance> instances;

    @ManyToMany
    // 集合按id排序
    @OrderBy("id ASC")
    // 缓存策略
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

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

    public String getEncryptMethod() {
        return encryptMethod;
    }

    public void setEncryptMethod(String encryptMethod) {
        this.encryptMethod = encryptMethod;
    }

    @Column(columnDefinition = "TEXT")
    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    @Column(columnDefinition = "TEXT")
    public String getPriKey() {
        return priKey;
    }

    public void setPriKey(String priKey) {
        this.priKey = priKey;
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
