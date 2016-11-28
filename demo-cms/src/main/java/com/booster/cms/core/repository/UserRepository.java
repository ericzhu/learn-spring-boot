package com.booster.cms.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booster.cms.core.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
