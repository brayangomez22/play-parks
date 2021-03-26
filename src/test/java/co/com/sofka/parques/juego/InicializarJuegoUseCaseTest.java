package co.com.sofka.parques.juego;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.command.InicializarJuego;
import co.com.sofka.parques.domain.juego.event.JuegoCreado;
import co.com.sofka.parques.domain.juego.event.JuegoInicializado;
import co.com.sofka.parques.domain.juego.event.JugadorAdicionado;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.juego.valueObject.Nombre;
import co.com.sofka.parques.usecase.juego.InicializarJuegoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InicializarJuegoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void inicializaJuego(){
        var id = JuegoId.of("xxxx");
        var command = new InicializarJuego(id);
        var useCase = new InicializarJuegoUseCase();

        when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var juegoInicializado = (JuegoInicializado) events.get(0);
        Assertions.assertEquals(2, juegoInicializado.getJugadoresIds().size());
    }

    private List<DomainEvent> eventStored(JuegoId id) {
        return List.of(
                new JuegoCreado(id),
                new JugadorAdicionado(JugadorId.of("ffff"), new Nombre("Brayan Gómez")),
                new JugadorAdicionado(JugadorId.of("gggg"), new Nombre("Jacobo Garces"))
        );
    }
}
