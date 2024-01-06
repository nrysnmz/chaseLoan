package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CustomerLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;
    private double amount;
    private double interestRate;
    private boolean approved;

    // Constructors, getters, and setters

    // Default constructor
    public CustomerLoan() {
        // Default constructor for JPA
    }

    // Parameterized constructor
    public CustomerLoan(String applicantName, double amount, double interestRate, boolean approved) {
        this.applicantName = applicantName;
        this.amount = amount;
        this.interestRate = interestRate;
        this.approved = approved;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    // toString method for better representation in logs, etc.
    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", applicantName='" + applicantName + '\'' +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", approved=" + approved +
                '}';
    }
}