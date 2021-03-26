package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ficha implements ValueObject<String> {
    private String value;

    public Ficha(String value) {
        this.value = Objects.requireNonNull(value);
        if (value.isBlank()){
            throw new IllegalArgumentException("El color de la ficha no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
