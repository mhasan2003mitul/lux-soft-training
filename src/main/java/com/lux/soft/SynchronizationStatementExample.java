package com.lux.soft;

public class SynchronizationStatementExample {

  public static void main(String[] args) {
    SynchronizedStatementCounter synchronizedStatementCounter = new SynchronizedStatementCounter();
    Runnable task1 = new Runnable() {
      @Override
      public void run() {
        synchronizedStatementCounter.increment();
      }
    };

    Runnable task2 = new Runnable() {
      @Override
      public void run() {
        synchronizedStatementCounter.decrement();
      }
    };

    Thread thread1 = new Thread(task1);

    Thread thread2 = new Thread(task2);

    thread1.start();
    thread2.start();
  }
}

class SynchronizedStatementCounter{
  static int counter = 1;
  static Object lock = new Object();
  public void increment(){
    synchronized (lock) {
      for(int j=0;j<5;j++){
        counter++;
        System.out.println("After its increment is "+counter);
      }
    }
  }
  public void decrement(){
    synchronized (lock) {
      for(int j=0;j<5;j++){
        counter--;
        System.out.println("After its decrement is "+counter);
      }
    }
  }
}

