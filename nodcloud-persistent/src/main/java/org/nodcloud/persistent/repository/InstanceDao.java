/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.nodcloud.persistent.repository;

import java.util.List;

import org.nodcloud.persistent.entity.Instance;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InstanceDao extends PagingAndSortingRepository<Instance, Long>, JpaSpecificationExecutor<Instance> {

    public List<Instance> findAllByUserIdAndZone(Long id, String zone);

    public List<Instance> findAllByUserIdAndZoneAndEipIsNull(Long id, String zone);

    public Instance findByUserIdAndId(Long userId, Long id);

    public Instance findByEipId(Long id);

}
