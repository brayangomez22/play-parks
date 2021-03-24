package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ficha implements ValueObject<String> {
    private String color;

    public Ficha(String color) {
        this.color = Objects.requireNonNull(color);
        if (color.isBlank()){
            throw new IllegalArgumentException("El color de la ficha no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return color;
    }
}
