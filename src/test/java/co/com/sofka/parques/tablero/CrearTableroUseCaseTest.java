package co.com.sofka.parques.tablero;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.tablero.command.CrearTablero;
import co.com.sofka.parques.domain.tablero.entity.BaseTablero;
import co.com.sofka.parques.domain.tablero.event.BaseAñadida;
import co.com.sofka.parques.domain.tablero.event.TableroCreado;
import co.com.sofka.parques.domain.tablero.valueObject.BaseId;
import co.com.sofka.parques.domain.tablero.valueObject.Casillas;
import co.com.sofka.parques.domain.tablero.valueObject.Colorsito;
import co.com.sofka.parques.usecase.tablero.CrearTableroUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CrearTableroUseCaseTest {

    @Test
    void crearTablero(){
        var fichasList = List.of(
                Map.of(
                        BaseId.from("xxx"), List.of("1", "2", "3", "4"),
                        BaseId.from("fff"), List.of("1", "2", "3", "4")
                )
        );

        var casillas = Set.of(
                new Casillas(1),
                new Casillas(2),
                new Casillas(2),
                new Casillas(1),
                new Casillas(1)
        );

        var bases = List.of(
                new BaseTablero(BaseId.from("xxx"), fichasList, new Colorsito("rojo"), JugadorId.of("pp"), casillas),
                new BaseTablero(BaseId.from("fff"), fichasList, new Colorsito("verde"), JugadorId.of("aa"), casillas)
        );

        var command = new CrearTablero(bases, new JuegoId());
        var useCase = new CrearTableroUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var tableroCreado = (TableroCreado) events.get(0);
        var baseRojaAñadida = (BaseAñadida) events.get(1);

        Assertions.assertTrue(Objects.nonNull(tableroCreado.getJuegoId().value()));

        Assertions.assertEquals("xxx", baseRojaAñadida.getBaseId().value());
        Assertions.assertEquals("rojo", baseRojaAñadida.getBaseTablero().getColor().value());

        Assertions.assertEquals("fff", baseRojaAñadida.getBaseId().value());
        Assertions.assertEquals("fff", baseRojaAñadida.getBaseTablero().getColor().value());
    }
}
