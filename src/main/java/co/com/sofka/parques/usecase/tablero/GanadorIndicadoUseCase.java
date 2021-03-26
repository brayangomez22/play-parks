package co.com.sofka.parques.usecase.tablero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.parques.domain.juego.entity.Jugador;
import co.com.sofka.parques.domain.tablero.Tablero;
import co.com.sofka.parques.domain.tablero.event.IndicarGanador;

public class GanadorIndicadoUseCase extends UseCase<TriggeredEvent<IndicarGanador>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<IndicarGanador> input) {
        var event = input.getDomainEvent();
        var tablero = Tablero.from(event.getTableroId(), retrieveEvents());
        tablero.indicarGanador();
        tablero.finalizarTablero();

        var ganador = new Jugador(event.getJugadorId(), event.getJugador().getNombre());

        emit().onResponse(new ResponseEvents(tablero.getUncommittedChanges()));
    }
}
