package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        Thread thread = new Thread(new InputThread());
        thread.start();

    }
}
class Console{
    private final BufferedReader in;
    private static class Singleton{
        static final Console INSTANCE = new Console();
    }
    public static Console getInstance(){
        return Singleton.INSTANCE;
    }
    private Console() {
        in = new BufferedReader(new InputStreamReader(System.in));

    }
    public String readLine() throws IOException{
        return in.readLine();
    }
}