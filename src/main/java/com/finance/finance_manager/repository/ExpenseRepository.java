package com.finance.finance_manager.repository;

import com.finance.finance_manager.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategoryId(Long categoryId);
}