```java

class Cliente {
    List<NotificacionObserver> notificacionObservers
    List<MailObservers> mailObservers
    Guardarropas guardarropas

    void suscribirseAObserverNotificacion(observer) {
        notificacionObservers(observer)
    }

    void suscribirseAObserverMail(observer) {
        mailObservers.add(observer)
    }

    void recibirSugerencia(sugerencia) {
        this.guardarropas.agregar(sugerencia)
    }
    
    void recibirNotificacion(notificacion) {

        validarNotificacion(notificacion)

        if (notificacion.class == SugerenciaDiaria) {
            // handle
        }

        else if (notificacion.class == AlertaGranizo) {
            // handle
        }
        else if (notificacion.class = AlertaLluvia) {
            // handle
        }
    }
}


interface NotificacionObserver {
    void notificar()
}


interface MailObserver {
    void enviarMail()
}


class SugerenciaDiaria implements NotificacionObserver {
    List<Usuario> usuarios
    Sugerencia sugerencia

    void notificarATodosLosUsuarios() {
        usuarios.forEach(usuario -> enviarNotificacion(usuario))
    }

    void enviarNotificacion(usuario) {
        send(usuario, sugerencia)
    }    
}


class AlertaGranizo implements NotificacionObserver {
    List<Usuario> usuarios
    String descripcion

    void notificarATodosLosUsuarios() {
        usuarios.forEach(usuario -> enviarNotificacion(usuario))
    }

    void enviarNotificacion(usuario) {
        send(usuario, descripcion)
    } 
}


class AlertaLluvia implements NotificacionObserver {
    List<Usuario> usuarios
    String descripcion

    void notificarATodosLosUsuarios() {
        usuarios.forEach(usuario -> enviarNotificacion(usuario))
    }

    void enviarNotificacion(usuario) {
        send(usuario, descripcion)
    }   
}


class MailAlerta implements MailObserver {
    List<Usuario> usuarios
    String descripcion

    void enviarMailATodosLosUsuarios() {
        usuarios.forEach(usuario -> enviarMail(usuario))
    }

    void enviarMail() {
        send(usuario, descripcion)
    }
}


enum TipoAlerta {
    TORMENTA,
    GRANIZO
}


```