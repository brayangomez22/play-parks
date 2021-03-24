package co.com.sofka.parques.domain.juego;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.event.JuegoCreado;
import co.com.sofka.parques.domain.juego.event.JuegoInicializado;
import co.com.sofka.parques.domain.juego.event.JugadorAdicionado;
import co.com.sofka.parques.domain.juego.factory.JugadorFactory;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;

import java.util.List;
import java.util.Map;

public class Juego extends AggregateEvent<JuegoId> {

    protected Boolean juegoInicializado;
    protected Map<JugadorId, Jugador> jugadores;

    public Juego(JuegoId entityId, JugadorFactory jugadorFactory) {
        super(entityId);
        appendChange(new JuegoCreado(entityId)).apply();
        jugadorFactory.getJugadores()
                .forEach(jugador -> adicionarJugador(jugador.identity(), jugador.getNombre()));
    }

    private Juego(JuegoId entityId){
        super(entityId);
        subscribe(new JuegoChange(this));
    }

    public static Juego from(JuegoId entityId, List<DomainEvent> events){
        var juego = new Juego(entityId);
        events.forEach(juego::applyEvent);
        return juego;
    }

    private void adicionarJugador(JugadorId jugadorId, Nombre nombre) {
        appendChange(new JugadorAdicionado(jugadorId, nombre));
    }

    public void iniciarJuego(){
        var jugadoresIds = jugadores.keySet();
        appendChange(new JuegoInicializado(jugadoresIds)).apply();
    }

    public Boolean isJuegoInicializado() {
        return juegoInicializado;
    }
}
