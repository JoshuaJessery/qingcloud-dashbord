/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.nodcloud.persistent.repository;

import java.util.List;

import org.nodcloud.persistent.entity.LoadBalancer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoadBalancerDao extends PagingAndSortingRepository<LoadBalancer, Long>, JpaSpecificationExecutor<LoadBalancer> {

    public List<LoadBalancer> findAllByUserIdAndZone(Long id, String zone);

}
