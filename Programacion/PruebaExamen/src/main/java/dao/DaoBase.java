package dao;

import modelo.Clonable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DaoBase {

    protected <T> List<T> getListaInmutableClonada(Collection<? extends Clonable<T>> collection) {
        return collection.stream()
                .map(Clonable::clonar)
                .collect(Collectors.toUnmodifiableList());
    }


}
