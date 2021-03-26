package co.com.sofka.parques.domain.tablero.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.tablero.entity.BaseTablero;

import java.util.List;

public class CrearTablero implements Command {
    protected List<BaseTablero> bases;
    private final JuegoId juegoId;

    public CrearTablero(List<BaseTablero> bases, JuegoId juegoId) {
        this.bases = bases;
        this.juegoId = juegoId;
    }

    public List<BaseTablero> getBases() {
        return bases;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
