package co.com.sofka.parques.domain.tablero.factory;

import co.com.sofka.parques.domain.tablero.BaseTablero;
import co.com.sofka.parques.domain.tablero.valueObject.BaseId;
import co.com.sofka.parques.domain.tablero.valueObject.Colorsito;

import java.util.HashSet;
import java.util.Set;

public class BaseFactory {
    private final Set<BaseTablero> bases;

    private BaseFactory(){
        bases = new HashSet<>();
    }

    public static BaseFactory builder(){
        return new BaseFactory();
    }

    public BaseFactory agregarBase(BaseId baseId, Colorsito color){
        bases.add(new BaseTablero(baseId, color));
        return this;
    }

    public BaseFactory(Set<BaseTablero> bases) {
        this.bases = bases;
    }
}
