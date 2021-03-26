package co.com.sofka.parques.domain.tablero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;

public class DadosLanzados implements Command {
    private final JuegoId juegoId;
    private final JugadorId jugadorId;

    public DadosLanzados(JuegoId juegoId, JugadorId jugadorId) {
        this.juegoId = juegoId;
        this.jugadorId = jugadorId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }
}
