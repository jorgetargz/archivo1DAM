package domain;

import dao.DaoCoches;
import domain.modelo.Coche;

import java.util.List;

public class ServiciosCoches {

    private final DaoCoches daoCoches;

    public ServiciosCoches() {
        daoCoches = new DaoCoches();
    }

    public boolean insertarCoche(Coche coche) {
        if (!daoCoches.existeCoche(coche)) {
            return daoCoches.insertarCoche(coche);
        }
        return false;
    }

    public boolean eliminarCoche(Coche coche) {
        if (daoCoches.existeCoche(coche)) {
            return daoCoches.borrarCoche(coche);
        }
        return false;
    }

    public boolean modificarCoche(Coche coche) {
        if (daoCoches.existeCoche(coche)) {
            return daoCoches.modificarCoche(coche);
        }
        return false;
    }

    public List<Coche> listarCoches() {
        return daoCoches.getListaCoches();
    }
}
