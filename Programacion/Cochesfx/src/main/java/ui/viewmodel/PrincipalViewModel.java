package ui.viewmodel;

import domain.ServiciosCoches;
import domain.modelo.Coche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

@Getter
public class PrincipalViewModel {

    private final ServiciosCoches serviciosCoches = new ServiciosCoches();
    private final ObservableList<Coche> observableCoches;

    public PrincipalViewModel() {
        observableCoches = FXCollections.observableArrayList(serviciosCoches.listarCoches());
    }

    public ObservableList<Coche> getCoches() {
        return FXCollections.unmodifiableObservableList(observableCoches);
    }

    public boolean addCoche(Coche coche) {
        boolean anadido = serviciosCoches.insertarCoche(coche);
        if (anadido) {
            observableCoches.clear();
            observableCoches.addAll(serviciosCoches.listarCoches());
        }
        return anadido;
    }

    public boolean updateCoche(Coche coche) {
        boolean actualizado = serviciosCoches.modificarCoche(coche);
        if (actualizado) {
            observableCoches.clear();
            observableCoches.addAll(serviciosCoches.listarCoches());
        }
        return actualizado;
    }

    public boolean removeCoche(Coche coche) {
        boolean eliminado = serviciosCoches.eliminarCoche(coche);
        if (eliminado) {
            observableCoches.clear();
            observableCoches.addAll(serviciosCoches.listarCoches());
        }
        return eliminado;
    }

}
