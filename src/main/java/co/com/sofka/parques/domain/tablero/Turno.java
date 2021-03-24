package co.com.sofka.parques.domain.tablero;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;
import co.com.sofka.parques.domain.tablero.valueObject.TurnoId;

public class Turno extends Entity<TurnoId> {
    private final Nombre nombre;

    public Turno(TurnoId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    
}
