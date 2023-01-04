package com.lux.soft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExampleUsingExecutorService {

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

    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(task1);
    executorService.submit(task2);
    executorService.shutdown();
  }
}
