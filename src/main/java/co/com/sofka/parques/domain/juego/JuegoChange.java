package co.com.sofka.parques.domain.juego;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.parques.domain.juego.event.JuegoCreado;
import co.com.sofka.parques.domain.juego.event.JuegoInicializado;
import co.com.sofka.parques.domain.juego.event.JugadorAdicionado;

import java.util.HashMap;

public class JuegoChange extends EventChange {
    public JuegoChange(Juego juego) {
        apply((JuegoCreado event) -> {
            juego.juegoInicializado = Boolean.FALSE;
            juego.jugadores = new HashMap<>();
        });

        apply((JuegoInicializado event) -> {
            juego.juegoInicializado = Boolean.TRUE;
        });

        apply((JugadorAdicionado event) -> {
            if (juego.juegoInicializado.equals(Boolean.TRUE)){
                throw new IllegalArgumentException("No se puede añadir un nuevo jugador al parques porque ya está en marcha");
            }
            juego.jugadores.put(event.getJugadorId(),
                    new Jugador(
                            event.getJugadorId(),
                            event.getNombre()
                    )
            );
        });
    }
}
