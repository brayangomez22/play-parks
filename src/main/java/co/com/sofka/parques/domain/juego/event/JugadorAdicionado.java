package co.com.sofka.parques.domain.juego.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;

public class JugadorAdicionado extends DomainEvent {
    private final JugadorId jugadorId;
    private final Nombre nombre;

    public JugadorAdicionado(JugadorId jugadorId, Nombre nombre) {
        super("parques.juego.jugadoradicionado");
        this.jugadorId = jugadorId;
        this.nombre = nombre;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
