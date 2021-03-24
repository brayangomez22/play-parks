package co.com.sofka.parques.domain.tablero;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.parques.domain.tablero.valueObject.Cara;
import co.com.sofka.parques.domain.tablero.valueObject.DadoId;

import java.util.List;

public class Dado extends Entity<DadoId> {
    private final List<Cara> carasDado1;
    private final List<Cara> carasDado2;

    public Dado(DadoId entityId, List<Cara> carasDado1, List<Cara> carasDado2) {
        super(entityId);
        this.carasDado1 = carasDado1;
        this.carasDado2 = carasDado2;
    }

    public void lanzarDado() {
        for (var i = 1; i <= 6; i++) {
            var numero = (int) ((Math.random() * 6) + 1);
            carasDado1.add(new Cara(numero));
        }

        for (var i = 1; i <= 6; i++) {
            var numero = (int) ((Math.random() * 6) + 1);
            carasDado2.add(new Cara(numero));
        }
    }

    public List<Cara> getCarasDado1() {
        return carasDado1;
    }

    public List<Cara> getCarasDado2() {
        return carasDado2;
    }
}
