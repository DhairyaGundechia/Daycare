package com.neu.csye6200.daycare;

public class Notifer {
    private String message;

    public Notifer(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void notifyUser() {
        System.out.println("Notifying user: " + message);
    }
}
