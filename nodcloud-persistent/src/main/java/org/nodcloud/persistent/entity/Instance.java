package org.nodcloud.persistent.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "nod_instances")
@JsonIgnoreProperties(value={"user", "image", "keyPairs"})
public class Instance extends IdEntity {

    /**
     * 创建者
     */
    private User user;

    /**
     * 主机名称
     */
    private String name;

    /**
     * 主机描述
     */
    private String descr;

    /**
     * 底层主机编号
     */
    private String uuid;

    /**
     * CPU
     */
    private int cup;

    /**
     * 内存
     */
    private int memory;

    /**
     * 登录方式
     */
    private int loginMode;

    private String loginPassword;
    /**
     * 镜像
     */
    private Image image;

    /**
     * 主机绑定的公网IP地址
     */
    private Eip eip;

    private String status;

    /**
     * 主机加入的私有网络列表
     */
    private List<Vxnet> vxnets = Lists.newArrayList();

    /**
     * 主机的私钥列表
     */
    private List<KeyPair> keyPairs = Lists.newArrayList();

    private Set<Volume> volumes = new HashSet<Volume>();

    @OneToOne
    @JoinColumn(name = "eip_id")
    public Eip getEip() {
        return eip;
    }

    public void setEip(Eip eip) {
        this.eip = eip;
    }

    // 多对多定义
    @ManyToMany
    @JoinTable(name = "nod_instance_vxnet", joinColumns = {@JoinColumn(name = "instance_id")}, inverseJoinColumns = {@JoinColumn(name = "vxnet_id")})
    // Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    // 集合按id排序
    @OrderBy("id ASC")
    // 缓存策略
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<Vxnet> getVxnets() {
        return vxnets;
    }

    // 多对多定义
    @ManyToMany
    @JoinTable(name = "nod_instance_key_pairs", joinColumns = {@JoinColumn(name = "instance_id")}, inverseJoinColumns = {@JoinColumn(name = "keypair_id")})
    // Fecth策略定义
    @Fetch(FetchMode.SUBSELECT)
    // 集合按id排序
    @OrderBy("id ASC")
    // 缓存策略
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public List<KeyPair> getKeyPairs() {
        return keyPairs;
    }

    public void setKeyPairs(List<KeyPair> keyPairs) {
        this.keyPairs = keyPairs;
    }

    @OneToMany(mappedBy = "instance")
    public Set<Volume> getVolumes() {
        return volumes;
    }

    public void setVolumes(Set<Volume> volumes) {
        this.volumes = volumes;
    }

    public void setVxnets(List<Vxnet> vxnets) {
        this.vxnets = vxnets;
    }

    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() { return descr; }

    public void setDescr(String descr) { this.descr = descr; }

    @Column(unique = true)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getCup() {
        return cup;
    }

    public void setCup(int cup) {
        this.cup = cup;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(int loginMode) {
        this.loginMode = loginMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
