package com.lux.soft;

public class ThreadSleepExample {
  public static void main(String[] args) {
    Runnable task1 = new Runnable() {
      @Override
      public void run() {
        try {
          System.out.println("Thread-1");
          long startTime = System.currentTimeMillis();
          System.out.println("Start Time: " + startTime );
          Thread.sleep(1000);
          long endTime = System.currentTimeMillis();
          System.out.println("End Time: "+ endTime);
          System.out.println("Difference of Start time and End time: " + (endTime - startTime));

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    Thread thread1 = new Thread(task1);
    thread1.start();
  }
}
