package co.com.sofka.parques.domain.juego.factory;

import co.com.sofka.parques.domain.juego.Jugador;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;

import java.util.HashSet;
import java.util.Set;

public class JugadorFactory {
    private final Set<Jugador> jugadores;

    private JugadorFactory(){
        jugadores = new HashSet<>();
    }

    public static JugadorFactory builder() {
        return new JugadorFactory();
    }

    public JugadorFactory nuevoJugador(JugadorId jugadorId, Nombre nombre) {
        jugadores.add(new Jugador(jugadorId, nombre));
        return this;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }
}
