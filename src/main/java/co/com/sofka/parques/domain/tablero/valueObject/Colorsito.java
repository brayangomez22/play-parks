package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Colorsito implements ValueObject<String> {
    private final String color;

    public Colorsito(String color) {
        this.color = Objects.requireNonNull(color);
        if (color.isBlank()){
            throw new IllegalArgumentException("El color no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return color;
    }
}
