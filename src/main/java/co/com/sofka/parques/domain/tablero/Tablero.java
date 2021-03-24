package co.com.sofka.parques.domain.tablero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.parques.domain.tablero.valueObject.BaseId;
import co.com.sofka.parques.domain.tablero.valueObject.DadoId;
import co.com.sofka.parques.domain.tablero.valueObject.TableroId;

import java.util.Map;

public class Tablero extends AggregateEvent<TableroId> {

    protected Map<BaseId, BaseTablero> bases;
    protected Map<DadoId, Dado> dados;

    public Tablero(TableroId entityId) {
        super(entityId);
    }
}
