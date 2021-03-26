package co.com.sofka.parques.domain.tablero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;

public class TableroFinalizado extends DomainEvent {
    private final JuegoId juegoId;

    public TableroFinalizado(JuegoId juegoId) {
        super("parques.tablero.tablerofinalizado");
        this.juegoId = juegoId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
