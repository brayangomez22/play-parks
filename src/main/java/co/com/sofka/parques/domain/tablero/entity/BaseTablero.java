package co.com.sofka.parques.domain.tablero.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.parques.domain.juego.valueObject.JugadorId;
import co.com.sofka.parques.domain.tablero.valueObject.BaseId;
import co.com.sofka.parques.domain.tablero.valueObject.Casillas;
import co.com.sofka.parques.domain.tablero.valueObject.Colorsito;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseTablero extends Entity<BaseId> {
    private final List<Map<BaseId, List<String>>> fichasList;
    private final Colorsito color;
    private final JugadorId jugadorId;
    private final Set<Casillas> casillas;

    public BaseTablero(BaseId entityId, List<Map<BaseId, List<String>>> fichasList, Colorsito color, JugadorId jugadorId, Set<Casillas>  casillas) {
        super(entityId);
        this.color = color;
        this.fichasList = fichasList;
        this.jugadorId = jugadorId;
        this.casillas = casillas;
    }

    public List<Map<BaseId, List<String>>> getFichasList() {
        return fichasList;
    }

    public Colorsito getColor() {
        return color;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public Set<Casillas>  getCasillas() {
        return casillas;
    }
}
