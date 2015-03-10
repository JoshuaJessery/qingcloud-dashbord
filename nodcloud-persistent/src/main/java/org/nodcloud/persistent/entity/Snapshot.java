package org.nodcloud.persistent.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nod_snapshots")
public class Snapshot extends IdEntity {

    private User user;

    /**
     * 底层资源编号
     */
    private String uuid;

    /**
     * 快照名称
     */
    private String name;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 备份类型, 0 为增量备份点，1 为全量备份点。
     */
    private int snapshotType;

    /**
     * 备份状态, 有效值为pending, available, suspended, deleted, ceased。
     * pending： 等待被创建
     * available： 可用
     * suspended： 由于欠费, 已被暂停使用
     * deleted： 已被删除, 但处于此状态的全量备份点在2小时之内仍可以被恢复为 available 状态。注意增量备份点删除之后无法恢复。
     * ceased： 已被彻底删除, 处于此状态的备份无法恢复
     */
    private String status;

    /**
     * 备份过渡状态, 有效值为creating, suspending, resuming, deleting, recovering。
     * <p/>
     * creating： 创建中, 由 pending 状态变成 available 状态
     * suspending： 欠费暂停中, 由 available 状态变成 suspended 状态
     * resuming： 恢复中, 由 suspended 状态变成 available 状态
     * deleting： 删除中, 由 available/suspended 状态变成 deleted 状态
     * recovering： 恢复中, 由 deleted 状态变成 available 状态
     */
    private String transitionStatus;

    private Timestamp snapshotTime;

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

    public int getSnapshotType() {
        return snapshotType;
    }

    public void setSnapshotType(int snapshotType) {
        this.snapshotType = snapshotType;
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

    public Timestamp getSnapshotTime() {
        return snapshotTime;
    }

    public void setSnapshotTime(Timestamp snapshotTime) {
        this.snapshotTime = snapshotTime;
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
