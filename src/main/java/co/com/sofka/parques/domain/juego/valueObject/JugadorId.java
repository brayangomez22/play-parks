package co.com.sofka.parques.domain.juego.valueObject;

import co.com.sofka.domain.generic.Identity;

public class JugadorId extends Identity {
    private JugadorId(String uid) {
        super(uid);
    }

    public JugadorId() {
    }

    public static JugadorId of(String uid) {
        return new JugadorId(uid);
    }
}
