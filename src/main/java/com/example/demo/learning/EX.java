package com.example.demo.learning;

import java.util.Scanner;

public class EX {
}


//class ExceptionExample {
//    public static void main(String[] args)  {
//        try {
//            // Attempt to perform an operation that may cause an exception
//            int result = divideNumbers(10, 0);  // This will raise an ArithmeticException
//            System.out.println("Result: " + result);  // This line will not be reached due to the exception
//        } catch (ArithmeticException e) {
//            // Handle the specific exception
//            System.out.println("Error: " + e.getMessage());
//        } finally {
//            // Code inside the finally block is always executed, whether an exception occurred or not
//            System.out.println("Finally block executed.");
//        }
//
//        System.out.println("finall");
//    }
//
//    // A method that performs division and may throw an exception
//    private static int divideNumbers(int numerator, int denominator)  {
//        return numerator / denominator;
//    }
//}

 class ExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            int numerator = scanner.nextInt();

            System.out.print("Enter another number: ");
            int denominator = scanner.nextInt();

            int result = divideNumbers(numerator, denominator);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
            scanner.close();
        }
    }

    // A method that performs division and declares that it may throw an exception using "throws"
    private static int divideNumbers(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            // Use "throw" to explicitly throw an exception
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return numerator / denominator;
    }
}

