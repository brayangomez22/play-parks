package co.com.sofka.parques.juego;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.parques.domain.juego.command.CrearJuego;
import co.com.sofka.parques.domain.juego.event.JuegoCreado;
import co.com.sofka.parques.domain.juego.event.JugadorAdicionado;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;
import co.com.sofka.parques.usecase.juego.CrearJuegoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Objects;

public class CrearJuegoUseCaseTest {

    @Test
    void CrearUnJuego(){
        var nombres = Map.of(
                JugadorId.of("123"), new Nombre("Brayan Gomez"),
                JugadorId.of("1234"), new Nombre("Jacobo Garces")
        );

        var command = new CrearJuego(nombres, new JuegoId());
        var useCase = new CrearJuegoUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var juegoCreado = (JuegoCreado) events.get(0);
        var jugadorAdicionadoParaJacobo = (JugadorAdicionado) events.get(2);
        var jugadorAdicionadoParaBrayan = (JugadorAdicionado) events.get(1);

        Assertions.assertTrue(Objects.nonNull(juegoCreado.getJuegoId().value()));

        Assertions.assertEquals("Brayan Gomez", jugadorAdicionadoParaBrayan.getNombre().value());
        Assertions.assertEquals("123", jugadorAdicionadoParaBrayan.getJugadorId().value());

        Assertions.assertEquals("Jacobo Garces", jugadorAdicionadoParaJacobo.getNombre().value());
        Assertions.assertEquals("1234", jugadorAdicionadoParaJacobo.getJugadorId().value());

    }
}
