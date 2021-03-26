package co.com.sofka.parques.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.parques.domain.juego.Juego;
import co.com.sofka.parques.domain.juego.command.InicializarJuego;

public class InicializarJuegoUseCase extends UseCase<RequestCommand<InicializarJuego>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<InicializarJuego> input) {
        var command = input.getCommand();

        var juego = Juego.from(command.getJuegoId(), retrieveEvents());

        juego.iniciarJuego();

        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
    }
}
