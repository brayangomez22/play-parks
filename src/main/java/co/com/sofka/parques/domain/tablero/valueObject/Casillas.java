package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.ValueObject;

public class Casillas implements ValueObject<Integer> {
    private final Integer value;

    public Casillas(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
