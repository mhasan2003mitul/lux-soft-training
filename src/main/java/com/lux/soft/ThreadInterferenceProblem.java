package com.lux.soft;

public class ThreadInterferenceProblem {

  public static void main(String[] args) {
    SharedCounter sharedCounter = new SharedCounter();
    Runnable task1 = new Runnable() {
      @Override
      public void run() {
        sharedCounter.increment();
      }
    };

    Runnable task2 = new Runnable() {
      @Override
      public void run() {
        sharedCounter.decrement();
      }
    };

    Thread thread1 = new Thread(task1);

    Thread thread2 = new Thread(task2);

    thread1.start();
    thread2.start();
  }
}

class SharedCounter{
  static int counter = 1;
  public void increment(){
    for(int j=0;j<5;j++){
      counter++;
      System.out.println("After its increment is "+counter);
    }
  }
  public void decrement(){
    for(int j=0;j<5;j++){
      counter--;
      System.out.println("After its decrement is "+counter);
    }
  }
}
