package com.booster.ecom.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booster.ecom.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
