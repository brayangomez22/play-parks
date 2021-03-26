package co.com.sofka.parques.usecase.tablero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.parques.domain.tablero.event.AsignarJugadorABase;

public class AsignarJugadorABaseUseCase extends UseCase<TriggeredEvent<AsignarJugadorABase>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<AsignarJugadorABase> input) {
        var event = input.getDomainEvent();


    }
}
