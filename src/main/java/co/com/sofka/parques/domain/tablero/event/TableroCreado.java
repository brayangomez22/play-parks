package co.com.sofka.parques.domain.tablero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;

public class TableroCreado extends DomainEvent {
    private final JuegoId juegoId;

    public TableroCreado(JuegoId juegoId) {
        super("parques.tablero.tablerocreado");
        this.juegoId = juegoId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
