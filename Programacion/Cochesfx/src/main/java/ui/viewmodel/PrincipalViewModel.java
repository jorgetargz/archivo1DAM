package ui.viewmodel;

import domain.ServiciosCoches;
import domain.modelo.Coche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

@Getter
public class PrincipalViewModel {

    private ServiciosCoches serviciosCoches = new ServiciosCoches();
    private ObservableList<Coche> _coches;

    public PrincipalViewModel() {
        _coches = FXCollections.observableArrayList(serviciosCoches.listarCoches());
    }

    public ObservableList<Coche> getCoches() {
        return FXCollections.unmodifiableObservableList(_coches);
    }

    public boolean addCoche(Coche coche) {
        boolean anadido = serviciosCoches.insertarCoche(coche);
        if (anadido) {
            _coches.clear();
            _coches.addAll(serviciosCoches.listarCoches());
        }
        return anadido;
    }

    public boolean updateCoche(Coche coche) {
        boolean actualizado = serviciosCoches.modificarCoche(coche);
        if (actualizado) {
            _coches.clear();
            _coches.addAll(serviciosCoches.listarCoches());
        }
        return actualizado;
    }

    public boolean removeCoche(Coche coche) {
        boolean eliminado = serviciosCoches.eliminarCoche(coche);
        if (eliminado) {
            _coches.clear();
            _coches.addAll(serviciosCoches.listarCoches());
        }
        return eliminado;
    }

}
