package com.example.demo.repository;

import com.example.demo.entity.CustomerLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<CustomerLoan, Long> {
    // You can define additional query methods here if needed
}