package com.example.demo.service;

import com.example.demo.entity.CustomerLoan;
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
    public List<CustomerLoan> getAllLoans() {
        try {
            return loanRepository.findAll();
        } catch (Exception e) {
            // Log the exception or handle it according to your application's needs
            e.printStackTrace();
            throw new RuntimeException("Error while fetching all loans");
        }
    }

    // Service method to get a loan by ID
    public CustomerLoan getLoanById(Long id) {
        try {
            Optional<CustomerLoan> optionalLoan = loanRepository.findById(id);
            return optionalLoan.orElse(null);
        } catch (Exception e) {
            // Log the exception or handle it according to your application's needs
            e.printStackTrace();
            throw new RuntimeException("Error while fetching loan by ID: " + id);
        }
    }

    // Service method to apply for a loan
    public CustomerLoan applyForLoan(CustomerLoan loan) {
        try {
            // Your business logic for loan approval goes here
            // For simplicity, auto-approve loans with amounts less than 10000
            if (loan.getAmount() < 10000) {
                loan.setApproved(true);
            }

            return loanRepository.save(loan);
        } catch (Exception e) {
            // Log the exception or handle it according to your application's needs
            e.printStackTrace();
            throw new RuntimeException("Error while applying for a loan");
        }
    }

    // Service method to update a loan
    public CustomerLoan updateLoan(Long id, CustomerLoan updatedLoan) {
        try {
            Optional<CustomerLoan> optionalLoan = loanRepository.findById(id);
            if (optionalLoan.isPresent()) {
                CustomerLoan existingLoan = optionalLoan.get();

                // Update fields based on your business logic
                existingLoan.setApplicantName(updatedLoan.getApplicantName());
                existingLoan.setAmount(updatedLoan.getAmount());
                existingLoan.setInterestRate(updatedLoan.getInterestRate());
                existingLoan.setApproved(updatedLoan.isApproved());

                return loanRepository.save(existingLoan);
            } else {
                return null;
            }
        } catch (Exception e) {
            // Log the exception or handle it according to your application's needs
            e.printStackTrace();
            throw new RuntimeException("Error while updating loan with ID: " + id);
        }
    }

    // Service method to delete a loan
    public boolean deleteLoan(Long id) {
        try {
            Optional<CustomerLoan> optionalLoan = loanRepository.findById(id);
            if (optionalLoan.isPresent()) {
                loanRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            // Log the exception or handle it according to your application's needs
            e.printStackTrace();
            throw new RuntimeException("Error while deleting loan with ID: " + id);
        }
    }
}
