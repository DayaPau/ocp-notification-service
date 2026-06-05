# Ejercicio de Refactorización con Open/Closed Principle

## Descripción

Este proyecto demuestra la aplicación del principio Open/Closed Principle,
perteneciente a los principios SOLID.

El principio establece que las entidades de software deben estar abiertas
para extensión, pero cerradas para modificación.

El sistema permite enviar diferentes tipos de notificaciones, como correo
electrónico, SMS, notificaciones push y fax.

## Problema del código original

En la implementación original, la clase `NotificationService` utilizaba una
estructura de condicionales `if/else` para identificar el tipo de
notificación que debía enviar.

Cada vez que se necesitaba agregar un nuevo canal, como Fax, WhatsApp o
Slack, era necesario modificar directamente la clase `NotificationService`.

Esto ocasionaba los siguientes problemas:

- La clase crecía cada vez que se agregaba una notificación.
- Existía riesgo de afectar funcionalidades que ya funcionaban.
- El sistema dependía de cadenas de texto como `"Email"` o `"SMS"`.
- Era difícil probar cada notificación de manera independiente.

## Solución aplicada

Se creó la interfaz `Notification`, la cual define el método:

```java
void send(String message);
```

Cada tipo de notificación implementa esta interfaz de manera independiente:

- `EmailNotification`
- `SMSNotification`
- `PushNotification`
- `FaxNotification`

La clase `NotificationService` recibe cualquier objeto que implemente
`Notification` y delega el envío del mensaje.

## Aplicación del principio OCP

La clase `NotificationService` se encuentra cerrada para modificaciones
relacionadas con nuevos tipos de notificaciones.

Al mismo tiempo, el sistema está abierto para extensión, ya que se pueden
crear nuevos tipos de notificación implementando la interfaz `Notification`.

Para agregar una notificación por fax solamente fue necesario crear la clase
`FaxNotification`. No se modificó la lógica existente dentro de
`NotificationService`.

## Beneficios observados

- Se reduce el riesgo de afectar funcionalidades existentes.
- Cada notificación puede probarse de manera independiente.
- Se eliminan los grandes bloques de condicionales.
- El sistema puede incorporar nuevos canales fácilmente.
- El código es más mantenible, flexible y escalable.

## Pruebas realizadas

Se implementaron pruebas unitarias con JUnit para comprobar que:

- `NotificationService` delega correctamente el envío.
- Es posible agregar nuevas notificaciones sin modificar el servicio.
- El sistema rechaza notificaciones nulas.

Para ejecutar las pruebas:

```bash
mvn clean test
```

## Ejecución del proyecto

Para compilar el proyecto:

```bash
mvn clean package
```

Para ejecutar la aplicación:

```bash
java -cp target/classes com.dayana.calidad.ocp.Main
```

## Salida esperada

```text
Enviando Email: ¡Hola por Email!
Enviando SMS: ¡Hola por SMS!
Enviando Notificación Push: ¡Hola por Push!
Enviando Fax: ¡Hola por Fax!
```

## Evidencias

Guarda las capturas dentro de la carpeta:

```text
docs/evidencias/
```

Nombres sugeridos:

```text
ejecucion-notificaciones.png
pruebas-maven.png
```

## Reflexión

El principio Open/Closed no significa que el código nunca deba modificarse.
Significa que las funcionalidades nuevas deberían incorporarse principalmente
mediante extensiones, evitando modificar componentes estables que ya
funcionan.

En este ejercicio, la interfaz `Notification` representa el punto de
extensión. Las clases concretas representan los diferentes comportamientos,
mientras que `NotificationService` funciona sin conocer los detalles
internos de cada notificación.
