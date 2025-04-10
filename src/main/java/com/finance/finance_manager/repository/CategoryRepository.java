package com.finance.finance_manager.repository;

import com.finance.finance_manager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
