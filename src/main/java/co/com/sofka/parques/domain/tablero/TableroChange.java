package co.com.sofka.parques.domain.tablero;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.parques.domain.tablero.entity.BaseTablero;
import co.com.sofka.parques.domain.tablero.event.TableroCreado;
import co.com.sofka.parques.domain.tablero.valueObject.BaseId;
import co.com.sofka.parques.domain.tablero.valueObject.Colorsito;

public class TableroChange extends EventChange {
    public TableroChange(Tablero tablero) {
        apply((TableroCreado event) -> {
            tablero.tableroCreado = Boolean.TRUE;
        });
    }
}
