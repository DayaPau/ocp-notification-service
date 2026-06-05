package com.dayana.calidad.ocp;

public class PushNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Enviando Notificación Push: " + message);
    }
}
