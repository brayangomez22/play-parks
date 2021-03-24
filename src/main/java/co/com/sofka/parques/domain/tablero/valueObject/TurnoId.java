package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.Identity;

public class TurnoId extends Identity {
    public TurnoId(String uuid) {
        super(uuid);
    }

    public TurnoId() {
    }

    public static TurnoId of(String uuid){
        return new TurnoId(uuid);
    }
}
