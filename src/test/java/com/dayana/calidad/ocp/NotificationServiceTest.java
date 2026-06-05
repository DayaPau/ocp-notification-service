package com.dayana.calidad.ocp;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NotificationServiceTest {

    @Test
    void debeDelegarElEnvioALaNotificacionRecibida() {

        NotificationService service = new NotificationService();
        AtomicReference<String> mensajeRecibido = new AtomicReference<>();

        Notification notification = mensajeRecibido::set;

        service.sendNotification(notification, "Mensaje de prueba");

        assertEquals("Mensaje de prueba", mensajeRecibido.get());
    }

    @Test
    void debePermitirAgregarUnaNuevaNotificacionSinModificarElServicio() {

        NotificationService service = new NotificationService();
        AtomicReference<String> resultado = new AtomicReference<>();

        Notification whatsappNotification =
                mensaje -> resultado.set("WhatsApp: " + mensaje);

        service.sendNotification(
                whatsappNotification,
                "Hola desde una nueva notificación"
        );

        assertEquals(
                "WhatsApp: Hola desde una nueva notificación",
                resultado.get()
        );
    }

    @Test
    void debeRechazarUnaNotificacionNula() {

        NotificationService service = new NotificationService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.sendNotification(null, "Mensaje")
        );
    }
}
