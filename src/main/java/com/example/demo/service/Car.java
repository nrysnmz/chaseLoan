package com.example.demo.service;

public class Car {
    // Fields
    String make;
    static String model;
    int year;

    {
        String a = "hi";
        make = "tt";
        model = "hi";
    }

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display car information
    public void displayInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    public static void main(String[] args) {
        // Creating an instance of the Car class using the constructor

        String  a =null;
        System.out.println("hello " + a.hashCode());

//        add(3)
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }
}

