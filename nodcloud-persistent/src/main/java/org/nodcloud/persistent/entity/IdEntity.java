/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.nodcloud.persistent.entity;

import java.sql.Timestamp;
import javax.persistence.*;

import org.joda.time.DateTime;


// JPA 基类的标识
@MappedSuperclass
public abstract class IdEntity {

    protected Long id;

    protected String zone;

    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp createAt = new Timestamp(new DateTime().getMillis());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}
