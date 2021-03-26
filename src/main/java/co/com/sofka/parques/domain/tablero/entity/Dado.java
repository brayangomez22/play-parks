package co.com.sofka.parques.domain.tablero.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.parques.domain.tablero.valueObject.Cara;
import co.com.sofka.parques.domain.tablero.valueObject.DadoId;

import java.util.List;

public class Dado extends Entity<DadoId> {
    private Cara carasDado1;
    private Cara carasDado2;

    public Dado(DadoId entityId, Cara carasDado1, Cara carasDado2) {
        super(entityId);
        this.carasDado1 = carasDado1;
        this.carasDado2 = carasDado2;
    }

    public void lanzarDado() {
        var numero = (int) ((Math.random() * 6) + 1);
        this.carasDado1 = new Cara(numero);

        var numero2 = (int) ((Math.random() * 6) + 1);
        this.carasDado2 = new Cara(numero2);

    }

    public Cara getCarasDado1() {
        return carasDado1;
    }

    public Cara getCarasDado2() {
        return carasDado2;
    }
}
