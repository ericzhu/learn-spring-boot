package com.booster.cms.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booster.cms.core.domain.Plan;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Long> {
    public Plan findByName(String name);
}
