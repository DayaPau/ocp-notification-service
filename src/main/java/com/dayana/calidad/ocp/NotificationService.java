package com.dayana.calidad.ocp;

public class NotificationService {

    public void sendNotification(Notification notification, String message) {
        if (notification == null) {
            throw new IllegalArgumentException(
                    "El tipo de notificación no puede ser nulo."
            );
        }

        notification.send(message);
    }
}
