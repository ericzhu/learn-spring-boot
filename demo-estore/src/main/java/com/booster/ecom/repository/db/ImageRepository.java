package com.booster.ecom.repository.db;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.booster.ecom.model.entity.Image;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {

    public Image findByName(String name);

}
