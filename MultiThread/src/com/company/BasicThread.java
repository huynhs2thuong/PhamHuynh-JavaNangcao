package com.company;
import learningbasic.*;
public class BasicThread {
    public static void main(String[] args) {
        //1:begin
        //running
        SimpleThread thread1 = new SimpleThread();
        thread1.setName("Thread - 1");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        SimpleThread thread2 = new SimpleThread();
        thread2.setName("Thread - 2");
        thread2.start();
        SimpleThread thread3 = new SimpleThread();
        thread3.setName("Thread - 3");
        thread3.start();
        //2: end
        System.out.println("Thread name : " + Thread.currentThread().getName());
        ThreadReader threadReader = new ThreadReader("com/company/BasicThread.java");
        threadReader.read();
    }
}

//Sub-thread
