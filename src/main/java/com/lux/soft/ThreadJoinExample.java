package com.lux.soft;

public class ThreadJoinExample {
  public static void main(String[] args) {
    Runnable task1 = new Runnable() {
      @Override
      public void run() {
        int i = 0;
        while (i < 5) {
          try {
            System.out.println("Thread-1");
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          i++;
        }
      }
    };

    Thread thread1 = new Thread(task1);

    Runnable task2 =  new Runnable() {
      @Override
      public void run() {
        int i = 0;
        while (i < 5) {
          try {
            System.out.println("Thread-2");
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          i++;
        }
      }
    };

    Thread thread2 = new Thread(task2);

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Bye Bye... This is end of the Main Thread execution.");
  }
}
