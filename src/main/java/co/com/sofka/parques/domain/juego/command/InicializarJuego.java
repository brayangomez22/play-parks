package co.com.sofka.parques.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;

public class InicializarJuego implements Command {
    private final JuegoId juegoId;

    public InicializarJuego(JuegoId juegoId) {
        this.juegoId = juegoId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
