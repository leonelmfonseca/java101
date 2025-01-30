package com.developer.java.output;

public class Printing {

    public static void print(String message, int numOfLinebreaks){
        print(message);
        for(int i = 0; i < numOfLinebreaks; i++){
            System.out.println();
        }
    }

    public static void print(String message){
        System.out.println(message);
    }

}
