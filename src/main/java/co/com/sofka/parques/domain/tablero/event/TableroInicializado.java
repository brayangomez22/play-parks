package co.com.sofka.parques.domain.tablero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;

import java.util.Set;

public class TableroInicializado extends DomainEvent {
    private final JuegoId juegoId;

    public TableroInicializado(JuegoId juegoId) {
        super("parques.tablero.tableroinicializado");
        this.juegoId = juegoId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

}
