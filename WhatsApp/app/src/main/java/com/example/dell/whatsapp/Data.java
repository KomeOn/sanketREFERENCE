package com.example.dell.whatsapp;

/**
 * Created by dell on 6/24/2017.
 */

public class Data {
    String name;
    String message;
    String time;

    public Data(String name, String message,String time) {
        this.name = name;
        this.message = message;
        this.time =time;
    }

    public String getTime() {return time;}

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
