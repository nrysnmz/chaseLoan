package com.example.demo.controller;

import com.example.demo.entity.CustomerLoan;
import com.example.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Endpoint to get all loans
    @GetMapping
    public ResponseEntity<List<CustomerLoan>> getAllLoans() {
        List<CustomerLoan> loans = loanService.getAllLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    // Endpoint to get a loan by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerLoan> getLoanById(@PathVariable Long id) {
        CustomerLoan loan = loanService.getLoanById(id);
        if (loan != null) {
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to apply for a loan
    @PostMapping("/apply")
    public ResponseEntity<CustomerLoan> applyForLoan(@RequestBody CustomerLoan loan) {
        CustomerLoan appliedLoan = loanService.applyForLoan(loan);
        return new ResponseEntity<>(appliedLoan, HttpStatus.CREATED);
    }

    // Endpoint to update a loan
    @PutMapping("/{id}")
    public ResponseEntity<CustomerLoan> updateLoan(@PathVariable Long id, @RequestBody CustomerLoan updatedLoan) {
        CustomerLoan loan = loanService.updateLoan(id, updatedLoan);
        if (loan != null) {
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a loan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        boolean deleted = loanService.deleteLoan(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}