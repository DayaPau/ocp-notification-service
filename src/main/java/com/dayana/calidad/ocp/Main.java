package com.dayana.calidad.ocp;

public class Main {

    public static void main(String[] args) {

        NotificationService service = new NotificationService();

        service.sendNotification(
                new EmailNotification(),
                "¡Hola por Email!"
        );

        service.sendNotification(
                new SMSNotification(),
                "¡Hola por SMS!"
        );

        service.sendNotification(
                new PushNotification(),
                "¡Hola por Push!"
        );

        service.sendNotification(
                new FaxNotification(),
                "¡Hola por Fax!"
        );
    }
}
