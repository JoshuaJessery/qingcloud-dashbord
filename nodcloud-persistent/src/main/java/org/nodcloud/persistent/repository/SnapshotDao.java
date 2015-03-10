/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.nodcloud.persistent.repository;

import java.util.List;

import org.nodcloud.persistent.entity.Snapshot;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SnapshotDao extends PagingAndSortingRepository<Snapshot, Long>, JpaSpecificationExecutor<Snapshot> {

    List<Snapshot> findAllByUserIdAndZone(Long id, String zone);

}
