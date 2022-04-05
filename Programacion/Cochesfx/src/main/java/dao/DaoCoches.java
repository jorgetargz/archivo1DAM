package dao;

import domain.modelo.Coche;

import java.util.List;

public class DaoCoches {

    private Database db;

    public DaoCoches() {
        this.db = new Database();
    }

    public boolean insertarCoche(Coche coche) {
        if (!this.existeCoche(coche)) {
            List<Coche> inventario = db.readJSONCoches();
            inventario.add(coche);
            return db.writeJSONCoches(inventario);
        }
        return false;
    }

    public boolean modificarCoche(Coche coche) {
        if (this.existeCoche(coche)) {
            List<Coche> inventario = db.readJSONCoches();
            inventario.remove(coche);
            inventario.add(coche);
            return db.writeJSONCoches(inventario);
        }
        return false;
    }

    public boolean borrarCoche(Coche coche) {
        if (this.existeCoche(coche)) {
            List<Coche> inventario = db.readJSONCoches();
            inventario.remove(coche);
            return db.writeJSONCoches(inventario);
        }
        return false;
    }

    public List<Coche> getListaCoches() {
        return db.readJSONCoches();
    }

    public boolean existeCoche(Coche coche) {
        return db.readJSONCoches().contains(coche);
    }

}