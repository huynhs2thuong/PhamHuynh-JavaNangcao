package com.company;
import learning.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        MyThread myThread = new MyThread();
        myThread.startThreadA();
        myThread.startThreadB();
    }
}
