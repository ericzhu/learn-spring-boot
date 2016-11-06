package com.booster.ecom.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booster.ecom.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
