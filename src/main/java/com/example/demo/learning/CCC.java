package com.example.demo.learning;

public class CCC {
}

 class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value " + i);
            try {
                Thread.sleep(100); // Introducing a 100 milliseconds delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

 class JoinExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();

        try {
            t1.join(); // Main thread waits for t1 to finish

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}

