package com.example.demo.service;
import com.example.demo.entity.Loan;
import com.example.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    // Service method to get all loans
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // Service method to get a loan by ID
    public Loan getLoanById(Long id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        return optionalLoan.orElse(null);
    }

    // Service method to apply for a loan
    public Loan applyForLoan(Loan loan) {
        // Your business logic for loan approval goes here
        // For simplicity, auto-approve loans with amounts less than 10000
        if (loan.getAmount() < 10000) {
            loan.setApproved(true);
        }

        return loanRepository.save(loan);
    }

    // Service method to update a loan
    public Loan updateLoan(Long id, Loan updatedLoan) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent()) {
            Loan existingLoan = optionalLoan.get();

            // Update fields based on your business logic
            existingLoan.setApplicantName(updatedLoan.getApplicantName());
            existingLoan.setAmount(updatedLoan.getAmount());
            existingLoan.setInterestRate(updatedLoan.getInterestRate());
            existingLoan.setApproved(updatedLoan.isApproved());

            return loanRepository.save(existingLoan);
        } else {
            return null;
        }
    }

    // Service method to delete a loan
    public boolean deleteLoan(Long id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent()) {
            loanRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}