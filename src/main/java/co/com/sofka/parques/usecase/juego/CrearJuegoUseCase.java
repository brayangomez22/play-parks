package co.com.sofka.parques.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.parques.domain.juego.command.CrearJuego;
import co.com.sofka.parques.domain.juego.factory.JugadorFactory;

public class CrearJuegoUseCase extends UseCase<RequestCommand<CrearJuego>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearJuego> input) {
        var command = input.getCommand();

        var factory = JugadorFactory.builder();
        command.getNombres()
                .forEach((jugadorId, nombre) ->
                        factory.nuevoJugador(jugadorId, nombre));


    }
}
