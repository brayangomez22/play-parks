package co.com.sofka.parques.domain.tablero;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.tablero.entity.BaseTablero;
import co.com.sofka.parques.domain.tablero.entity.Dado;
import co.com.sofka.parques.domain.tablero.entity.Turno;
import co.com.sofka.parques.domain.tablero.event.*;
import co.com.sofka.parques.domain.tablero.valueObject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tablero extends AggregateEvent<TableroId> {

    protected Boolean tableroCreado;
    protected List<BaseTablero> baseTablero;
    protected Map<DadoId, Dado> dados;
    protected JuegoId juegoId;
    protected Map<TurnoId, Turno> turnos;
    protected Set<JugadorId> jugadorIds;

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

    public void finalizarTablero() {
        appendChange(new TableroFinalizado(juegoId)).apply();
    }

    public Boolean getTableroCreado() {
        return tableroCreado;
    }
}
