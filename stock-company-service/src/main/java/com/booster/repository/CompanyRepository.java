package com.booster.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.booster.entity.Company;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select c from Company c where c.name like :keyword")
    public Page<Company> companiesByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
