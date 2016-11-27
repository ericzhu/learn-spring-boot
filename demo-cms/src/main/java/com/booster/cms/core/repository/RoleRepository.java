package com.booster.cms.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booster.cms.core.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
