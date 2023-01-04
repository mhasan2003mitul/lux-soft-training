package com.lux.soft;

public class ConcurrencyExample {
  public static void main(String[] args) {
    Runnable task1 = new Runnable() { // Task 1
      @Override
      public void run() {
        int i = 0;
        while (i < 5) {
          try {
            System.out.println("Thread-1");
            Thread.sleep(1000); // Moved into blocked state
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          i++;
        }
      }
    };

    // Job 1
    Thread thread1 = new Thread(task1);

    Runnable task2 =  new Runnable() { //Task 2
      @Override
      public void run() {
        int i = 0;
        while (i < 5) {
          try {
            System.out.println("Thread-2");
            Thread.sleep(1000); // Moved into blocked state
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          i++;
        }
      }
    };

    Thread thread2 = new Thread(task2); // Creation of a thread

    thread1.start();
    thread2.start();

    System.out.println("Finish Main Thread.");
  }
}
