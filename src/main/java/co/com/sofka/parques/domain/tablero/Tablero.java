package co.com.sofka.parques.domain.tablero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.entity.Jugador;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.tablero.entity.BaseTablero;
import co.com.sofka.parques.domain.tablero.entity.Dado;
import co.com.sofka.parques.domain.tablero.entity.Turno;
import co.com.sofka.parques.domain.tablero.event.*;
import co.com.sofka.parques.domain.tablero.valueObject.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tablero extends AggregateEvent<TableroId> {

    protected Boolean tableroCreado;
    protected Boolean tableroInicializado;
    protected Boolean ganadorIndicado = false;
    protected List<BaseTablero> baseTablero;
    protected Map<DadoId, Dado> dados;
    protected JuegoId juegoId;
    protected Map<TurnoId, Turno> turnos;
    protected JugadorId jugadorId;
    protected Jugador jugador;
    protected TableroId tableroId;

    public Tablero(TableroId entityId, JuegoId juegoId) {
        super(entityId);
        appendChange(new TableroCreado(juegoId)).apply();
    }

    private Tablero(TableroId entityId){
        super(entityId);
        subscribe(new TableroChange(this));
    }

    public static Tablero from(TableroId entityId, List<DomainEvent> events){
        var tablero = new Tablero(entityId);
        events.forEach(tablero::applyEvent);
        return tablero;
    }

    public void inicializarTablero() {
        appendChange(new TableroInicializado(juegoId)).apply();
    }

    public void indicarGanador(){
        if (ganadorIndicado != false){
            appendChange(new IndicarGanador(juegoId, tableroId, jugadorId, jugador));
        }
    }

    public void tirarDados(){
        var cara1 = this.dados
                .values()
                .stream()
                .map(dado -> Map.of(dado.identity(), dado.getCarasDado1()))
                .collect(Collectors.toList());

        var cara2 = this.dados
                .values()
                .stream()
                .map(dado -> Map.of(dado.identity(), dado.getCarasDado2()))
                .collect(Collectors.toList());

        appendChange(new LanzarDados(juegoId, cara1, cara2)).apply();
    }

    public void finalizarTablero() {
        appendChange(new TableroFinalizado(juegoId)).apply();
    }

    public Boolean isTableroCreado() {
        return tableroCreado;
    }

    public Boolean isTableroInicializado() {
        return tableroInicializado;
    }
}
