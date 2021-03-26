package co.com.sofka.parques.usecase.tablero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.parques.domain.tablero.Tablero;
import co.com.sofka.parques.domain.tablero.command.CrearTablero;
import co.com.sofka.parques.domain.tablero.valueObject.TableroId;

public class CrearTableroUseCase extends UseCase<RequestCommand<CrearTablero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTablero> input) {
        var command = input.getCommand();
        var tableroId = new TableroId();

        var tablero = new Tablero(tableroId, command.getJuegoId());

        emit().onResponse(new ResponseEvents(tablero.getUncommittedChanges()));
    }
}
