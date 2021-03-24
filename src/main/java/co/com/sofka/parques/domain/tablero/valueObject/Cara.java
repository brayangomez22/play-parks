package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cara implements ValueObject<Integer> {
    private final Integer value;

    public Cara(Integer value) {
        this.value = Objects.requireNonNull(value, "El valor de la cara es requerida");
        if (value <= 0 || 6 < value) {
            throw new IllegalArgumentException("Es necesario que el valor de la cara este entre 1-6");
        }
    }

    @Override
    public Integer value() {
        return value;
    }
}
