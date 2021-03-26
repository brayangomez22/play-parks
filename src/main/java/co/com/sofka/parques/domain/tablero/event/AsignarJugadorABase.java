package co.com.sofka.parques.domain.tablero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.tablero.valueObject.BaseId;

public class AsignarJugadorABase extends DomainEvent {
    private final JugadorId jugadorId;
    private final BaseId baseId;

    public AsignarJugadorABase(JugadorId jugadorId, BaseId baseId) {
        super("parques.tablero.asignarjugadorabase");
        this.jugadorId = jugadorId;
        this.baseId = baseId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public BaseId getBaseId() {
        return baseId;
    }
}
