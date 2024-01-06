//package com.example.demo.service;
//
//package com.example.demo.service;
//
//import java.util.Scanner;
//
//public class LoanCalculator {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Get user details
//        System.out.print("Enter your credit score (between 300 and 850): ");
//        int creditScore = scanner.nextInt();
//
//        System.out.print("Enter your annual income: ");
//        double annualIncome = scanner.nextDouble();
//
//        System.out.print("Enter desired loan amount: ");
//        double requestedLoanAmount = scanner.nextDouble();
//
//        // Check eligibility based on credit score and income using multithreading
//        boolean isEligible = checkEligibilityConcurrently(creditScore, annualIncome);
//
//        if (isEligible) {
//            // Allow the user to choose fixed or variable interest rate
//            System.out.print("Is the interest rate fixed? (true/false): ");
//            boolean isFixedRate = scanner.nextBoolean();
//
//            // Calculate adjusted loan amount based on credit score
//            double adjustedLoanAmount = adjustLoanAmount(requestedLoanAmount, creditScore);
//
//            // Get loan details
//            System.out.print("Enter loan term (in years): ");
//            int loanTerm = scanner.nextInt();
//
//            System.out.print("Enter interest rate (as a decimal): ");
//            double interestRate = scanner.nextDouble();
//
//            // Calculate monthly payment
//            double monthlyPayment;
//            if (isFixedRate) {
//                monthlyPayment = calculateFixedRateMonthlyPayment(adjustedLoanAmount, loanTerm, interestRate);
//            } else {
//                System.out.print("Enter variable interest rate for the first year (as a decimal): ");
//                double initialVariableRate = scanner.nextDouble();
//                monthlyPayment = calculateVariableRateMonthlyPayment(
//                        adjustedLoanAmount, loanTerm, interestRate, initialVariableRate);
//            }
//
//            // Display the result
//            System.out.printf("Your monthly payment is: $%.2f\n", monthlyPayment);
//        } else {
//            System.out.println("Sorry, you are not eligible for a loan based on your credit score and income.");
//        }
//
//        scanner.close();
//    }
//
//    private static boolean checkEligibility(int creditScore, double annualIncome) {
//        // Additional eligibility checks can be added based on specific criteria
//        return creditScore >= 600 && annualIncome >= 30000;
//    }
//
//    // Multithreading the eligibility check
//    private static boolean checkEligibilityConcurrently(int creditScore, double annualIncome) {
//        Thread eligibilityCheckThread = new Thread(() -> {
//            // Simulating a time-consuming eligibility check
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        eligibilityCheckThread.start();
//
//        // Continue with other tasks while eligibility check is in progress
//
//        // Wait for the eligibility check to complete
//        try {
//            eligibilityCheckThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Assuming the eligibility check is successful
//        return true;
//    }
//
//    private static double adjustLoanAmount(double requestedLoanAmount, int creditScore) {
//        // Adjust loan amount based on credit score
//        if (creditScore >= 700) {
//            return requestedLoanAmount * 1.1; // Increase loan amount by 10% for good credit
//        } else if (creditScore >= 650) {
//            return requestedLoanAmount * 1.05; // Increase loan amount by 5% for fair credit
//        } else {
//            return requestedLoanAmount; // No adjustment for lower credit scores
//        }
//    }
//
//    private static double calculateFixedRateMonthlyPayment(double loanAmount, int loanTerm, double interestRate) {
//        // The implementation for calculating fixed-rate monthly payment
//        // ...
//
//        double monthlyInterestRate = interestRate / 12 / 100;
//        int numberOfPayments = loanTerm * 12;
//
//        double numerator = loanAmount * monthlyInterestRate;
//        double denominator = 1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments);
//
//        return numerator / denominator;
//    }
//
//    private static double calculateVariableRateMonthlyPayment(double loanAmount, int loanTerm,
//                                                              double interestRate, double initialVariableRate) {
//        // The implementation for calculating variable-rate monthly payment
//        // ...
//
//        // For simplicity, assuming the variable rate stays constant after the initial year
//        double averageRate = (interestRate + initialVariableRate) / 2;
//        return calculateFixedRateMonthlyPayment(loanAmount, loanTerm, averageRate);
//    }
//}
