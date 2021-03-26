package co.com.sofka.parques.domain.tablero;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.parques.domain.tablero.event.TableroCreado;
import co.com.sofka.parques.domain.tablero.event.TableroFinalizado;
import co.com.sofka.parques.domain.tablero.event.TableroInicializado;

public class TableroChange extends EventChange {
    public TableroChange(Tablero tablero) {
        apply((TableroCreado event) -> {
            tablero.tableroCreado = Boolean.TRUE;
            tablero.tableroInicializado = Boolean.FALSE;
        });

        apply((TableroInicializado event) -> {
            tablero.tableroInicializado = Boolean.TRUE;
        });

        apply((TableroFinalizado event) -> {
            tablero.finalizarTablero();
        });
    }
}
