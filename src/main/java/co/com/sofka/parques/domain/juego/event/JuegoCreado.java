package co.com.sofka.parques.domain.juego.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;

public class JuegoCreado extends DomainEvent {
    private final JuegoId juegoId;

    public JuegoCreado(JuegoId juegoId) {
        super("parques.juego.creado");
        this.juegoId = juegoId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
