package com.finance.finance_manager;

import com.finance.finance_manager.model.Category;
import com.finance.finance_manager.model.Expense;
import com.finance.finance_manager.repository.CategoryRepository;
import com.finance.finance_manager.repository.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ExpenseRepository expenseRepository;

    public DataLoader(CategoryRepository categoryRepository, ExpenseRepository expenseRepository) {
        this.categoryRepository = categoryRepository;
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Criar categorias
        Category food = new Category();
        food.setName("Alimentação");
        food.setDescription("Gastos com comida");
        categoryRepository.save(food);

        Category transport = new Category();
        transport.setName("Transporte");
        transport.setDescription("Gastos com mobilidade");
        categoryRepository.save(transport);

        // Criar despesas
        Expense expense1 = new Expense();
        expense1.setDescription("Supermercado");
        expense1.setAmount(new BigDecimal("150.75"));
        expense1.setExpenseDate(LocalDate.now());
        expense1.setCategory(food);
        expenseRepository.save(expense1);

        Expense expense2 = new Expense();
        expense2.setDescription("Uber");
        expense2.setAmount(new BigDecimal("32.50"));
        expense2.setExpenseDate(LocalDate.now());
        expense2.setCategory(transport);
        expenseRepository.save(expense2);
    }
}
