package co.com.sofka.parques.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;

import java.util.Map;

public class CrearJuego implements Command {
    private final Map<JugadorId, Nombre> nombres;
    private final JuegoId juegoId;

    public CrearJuego(Map<JugadorId, Nombre> nombres, JuegoId juegoId) {
        this.nombres = nombres;
        this.juegoId = juegoId;
    }

    public Map<JugadorId, Nombre> getNombres() {
        return nombres;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
