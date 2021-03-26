package co.com.sofka.parques.domain.tablero.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.parques.domain.juego.valueObject.JuegoId;
import co.com.sofka.parques.domain.tablero.valueObject.Cara;
import co.com.sofka.parques.domain.tablero.valueObject.DadoId;

import java.util.List;
import java.util.Map;

public class LanzarDados extends DomainEvent {
    private final JuegoId juegoId;
    private final List<Map<DadoId, Cara>> cara1;
    private final List<Map<DadoId, Cara>> cara2;

    public LanzarDados(JuegoId juegoId, List<Map<DadoId, Cara>> cara1, List<Map<DadoId, Cara>> cara2) {
        super("parques.tablero.lanzardados");
        this.juegoId = juegoId;
        this.cara1 = cara1;
        this.cara2 = cara2;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

    public List<Map<DadoId, Cara>> getCara1() {
        return cara1;
    }

    public List<Map<DadoId, Cara>> getCara2() {
        return cara2;
    }
}
