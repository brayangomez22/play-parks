package co.com.sofka.parques.domain.tablero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.tablero.entity.BaseTablero;
import co.com.sofka.parques.domain.tablero.valueObject.BaseId;


public class BaseAñadida extends DomainEvent {
    private final JuegoId juegoId;
    private final BaseTablero baseTablero;
    private final BaseId baseId;

    public BaseAñadida(JuegoId juegoId, BaseTablero baseDelTablero, BaseId baseId) {
        super("parques.tablero.basesañadidas");
        this.juegoId = juegoId;
        this.baseTablero = baseDelTablero;
        this.baseId = baseId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

    public BaseTablero getBaseTablero() {
        return baseTablero;
    }

    public BaseId getBaseId() {
        return baseId;
    }
}
