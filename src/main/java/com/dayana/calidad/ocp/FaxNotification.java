package com.dayana.calidad.ocp;

public class FaxNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Enviando Fax: " + message);
    }
}
