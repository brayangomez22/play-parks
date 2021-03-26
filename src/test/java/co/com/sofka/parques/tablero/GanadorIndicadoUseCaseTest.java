package co.com.sofka.parques.tablero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.parques.domain.juego.entity.Jugador;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;
import co.com.sofka.parques.domain.tablero.event.IndicarGanador;
import co.com.sofka.parques.domain.tablero.event.TableroFinalizado;
import co.com.sofka.parques.domain.tablero.valueObject.TableroId;
import co.com.sofka.parques.usecase.tablero.GanadorIndicadoUseCase;
import org.junit.jupiter.api.Test;

public class GanadorIndicadoUseCaseTest {

    @Test
    void establecerGanador(){
        var event = new IndicarGanador(JuegoId.of("xxx"), TableroId.of("fff"), JugadorId.of("123"), new Jugador(JugadorId.of("123"), new Nombre("brayan")));

        var tableroId = TableroId.of("xxxxx");

        var useCase = new GanadorIndicadoUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var tableroFinalizado = (TableroFinalizado) events.get(0);
    }
}
