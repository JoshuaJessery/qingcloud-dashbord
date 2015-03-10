package org.nodcloud.persistent.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "nod_images")
public class Image extends IdEntity {

    /**
     * 底层镜像编号
     */
    private String uuid;

    /**
     * 镜像名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private String status;

    /**
     * 镜像大小
     */
    private int ImageSize;

    /**
     * 处理器类型
     */
    private String processType;

    /**
     * 可见范围：自由，公共
     */
    private String provider;

    private String osFamily;

    private String visibility;

    /**
     * 镜像平台 window,linux
     */
    private String platform;

    /**
     * 创建者
     */
    private User user;

    private Set<Instance> instance = new HashSet<Instance>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(unique = true)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImageSize() {
        return ImageSize;
    }

    public void setImageSize(int imageSize) {
        ImageSize = imageSize;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsFamily() {
        return osFamily;
    }

    public void setOsFamily(String osFamily) {
        this.osFamily = osFamily;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @OneToMany(mappedBy = "image")
    public Set<Instance> getInstance() {
        return instance;
    }

    public void setInstance(Set<Instance> instance) {
        this.instance = instance;
    }
}
