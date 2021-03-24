package co.com.sofka.parques.domain.juego.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;

import java.util.Set;

public class JuegoInicializado extends DomainEvent {
    private final Set<JugadorId> jugadoresIds;

    public JuegoInicializado(Set<JugadorId> jugadoresIds) {
        super("parques.juego.juegoInicializado");
        this.jugadoresIds = jugadoresIds;
    }

    public Set<JugadorId> getJugadoresIds() {
        return jugadoresIds;
    }
}
