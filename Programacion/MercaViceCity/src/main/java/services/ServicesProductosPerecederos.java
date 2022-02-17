package services;

import modelo.ProductoPerecedero;

import java.time.LocalDateTime;

public class ServicesProductosPerecederos {

    public boolean productoCaducado(ProductoPerecedero perecedero) {
        return perecedero.getCaducidad().isBefore(LocalDateTime.now());
    }

}
