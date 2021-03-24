package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.Identity;

public class BaseId extends Identity {
    public BaseId(String uuid) {
        super(uuid);
    }

    public BaseId() {
    }

    public static BaseId from(String uuid){
        return new BaseId(uuid);
    }
}
