package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.Identity;

public class TableroId extends Identity {
    public TableroId(String uuid) {
        super(uuid);
    }

    public TableroId() {
    }

    public static TableroId of(String uuid){
        return new TableroId(uuid);
    }
}
