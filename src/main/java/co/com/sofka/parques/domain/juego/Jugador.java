package co.com.sofka.parques.domain.juego;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;

public class Jugador extends Entity<JugadorId> {
    private final Nombre nombre;

    public Jugador(JugadorId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
