package co.com.sofka.parques.domain.juego.valueObject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String name;

    public Nombre(String name) {
        this.name = Objects.requireNonNull(name);
        if (name.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return name;
    }
}
