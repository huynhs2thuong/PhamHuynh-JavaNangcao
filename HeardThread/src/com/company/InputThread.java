package com.company;

import java.io.IOException;

public class InputThread implements Runnable{
    private Boolean running = true;
    String s = "";
    @Override
    public void run() {
        while (running){
            System.out.print("INPUT : ");
            try {
                s = Console.getInstance().readLine();
            }catch (IOException e) {
                e.printStackTrace();
            }
            if (s.equalsIgnoreCase("exit")){
                running =false;
            }

        }
        System.out.println(Thread.currentThread().getName() + " terminated");
    }
}
