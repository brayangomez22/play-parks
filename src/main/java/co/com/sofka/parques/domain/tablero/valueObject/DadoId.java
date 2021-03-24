package co.com.sofka.parques.domain.tablero.valueObject;

import co.com.sofka.domain.generic.Identity;

public class DadoId extends Identity {
    public DadoId(String uuid) {
        super(uuid);
    }

    public DadoId() {
    }

    public static DadoId of(String uuid){
        return new DadoId(uuid);
    }
}
