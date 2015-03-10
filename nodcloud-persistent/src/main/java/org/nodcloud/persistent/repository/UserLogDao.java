/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.nodcloud.persistent.repository;

import java.util.List;

import org.nodcloud.persistent.entity.UserLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserLogDao extends PagingAndSortingRepository<UserLog, Long>, JpaSpecificationExecutor<UserLog> {

    public List<UserLog> findByUserId(long id);

    public List<UserLog> findByUserId(long id, Pageable pageable);

}
