package com.booster.ecom.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booster.ecom.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
