package dao;

import modelo.Clonable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

abstract class DaoBase {

    protected  <T> List<T> dameListaInmutableClonada(Collection<? extends Clonable<T>> collection)
    {
        return collection.stream()
                .map(Clonable::clonar)
                .collect(Collectors.toUnmodifiableList());
    }

}