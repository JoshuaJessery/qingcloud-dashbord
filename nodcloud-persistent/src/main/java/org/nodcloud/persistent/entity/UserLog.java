package org.nodcloud.persistent.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nod_user_log")
public class UserLog extends IdEntity {

    private long userId;

    private String message;

    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
