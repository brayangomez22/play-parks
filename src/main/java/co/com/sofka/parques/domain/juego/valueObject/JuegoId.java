package co.com.sofka.parques.domain.juego.valueObject;

import co.com.sofka.domain.generic.Identity;

public class JuegoId extends Identity {
    private JuegoId(String uuid) {
        super(uuid);
    }

    public JuegoId() {
    }

    public static JuegoId of(String uuid){
        return new JuegoId(uuid);
    }
}
