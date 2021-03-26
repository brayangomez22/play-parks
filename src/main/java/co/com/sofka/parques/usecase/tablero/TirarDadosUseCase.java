package co.com.sofka.parques.usecase.tablero;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.tablero.Tablero;
import co.com.sofka.parques.domain.tablero.event.LanzarDados;
import co.com.sofka.parques.domain.tablero.valueObject.TableroId;

public class TirarDadosUseCase extends UseCase<TriggeredEvent<LanzarDados>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<LanzarDados> input) {
        var event = input.getDomainEvent();

        var tablero = new Tablero(TableroId.of("pepe"), JuegoId.of("pepa"));

        var cara1 = event.getCara1();
        var cara2 = event.getCara2();

        if (cara1.equals(cara2)){
            System.out.println("Vuelve a tirar los dados");
            tablero.tirarDados();
        }
    }
}
