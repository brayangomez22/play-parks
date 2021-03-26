package co.com.sofka.parques.domain.tablero.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;
import co.com.sofka.parques.domain.tablero.valueObject.TurnoId;

public class Turno extends Entity<TurnoId> {
    private final Nombre nombre;
    private final Boolean salirDeCasa;

    public Turno(TurnoId entityId, Nombre nombre, Boolean salirDeCasa) {
        super(entityId);
        this.nombre = nombre;
        this.salirDeCasa = salirDeCasa;
    }

    public void avanzarCasillas(){
        
    }
}
