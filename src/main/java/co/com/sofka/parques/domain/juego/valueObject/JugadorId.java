package co.com.sofka.parques.domain.juego.valueObject;

import co.com.sofka.domain.generic.Identity;

public class JugadorId extends Identity {
    public JugadorId(String uuid) {
        super(uuid);
    }

    public JugadorId() {
    }

    public static JuegoId of(String uuid){
        return new JuegoId(uuid);
    }
}
