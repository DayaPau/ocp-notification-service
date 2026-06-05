package com.dayana.calidad.ocp;

public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}
