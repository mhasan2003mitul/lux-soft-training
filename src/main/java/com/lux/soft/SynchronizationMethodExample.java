package com.lux.soft;

public class SynchronizationMethodExample {

  public static void main(String[] args) {
    SynchronizedMethodCounter synchronizedMethodCounter = new SynchronizedMethodCounter();
    Runnable task1 = new Runnable() {
      @Override
      public void run() {
        synchronizedMethodCounter.increment();
      }
    };

    Runnable task2 = new Runnable() {
      @Override
      public void run() {
        synchronizedMethodCounter.decrement();
      }
    };

    Thread thread1 = new Thread(task1);

    Thread thread2 = new Thread(task2);

    thread1.start();
    thread2.start();
  }
}

class SynchronizedMethodCounter{
  static int counter = 1;
  public synchronized void increment(){
    for(int j=0;j<5;j++){
      counter++;
      System.out.println("After its increment is "+counter);
    }
  }
  public synchronized void decrement(){
    for(int j=0;j<5;j++){
      counter--;
      System.out.println("After its decrement is "+counter);
    }
  }
}

