package co.com.sofka.parques.domain.tablero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.entity.Jugador;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.tablero.valueObject.TableroId;

public class IndicarGanador extends DomainEvent {
    private final JuegoId juegoId;
    private final JugadorId jugadorId;
    private final Jugador jugador;
    private final TableroId tableroId;

    public IndicarGanador(JuegoId juegoId, TableroId tableroId, JugadorId jugadorId, Jugador jugador) {
        super("parques.tablero.ganadorindicado");
        this.juegoId = juegoId;
        this.jugadorId = jugadorId;
        this.jugador = jugador;
        this.tableroId = tableroId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public TableroId getTableroId() {
        return tableroId;
    }
}
