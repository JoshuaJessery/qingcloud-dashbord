/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package org.nodcloud.persistent.repository;

import java.util.List;

import org.nodcloud.persistent.entity.Image;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageDao extends PagingAndSortingRepository<Image, Long>, JpaSpecificationExecutor<Image> {

    public Image findByUuid(String uuid);

    public List<Image> findAllByUserIdAndZone(Long id, String zone);

    public List<Image> findAllByUserIdAndStatusAndZone(Long id, String status, String zone);

    public List<Image> findAllByProviderAndStatus(String provider, String status);

    public List<Image> findAllByProviderAndStatusAndZone(String provider, String status, String zone);

}
