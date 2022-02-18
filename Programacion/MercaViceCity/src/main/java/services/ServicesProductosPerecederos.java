package services;

import dao.DaoProductos;
import modelo.ProductoPerecedero;

import java.time.LocalDateTime;

public class ServicesProductosPerecederos {

    public boolean productoCaducado(ProductoPerecedero perecedero) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getCaducidad(perecedero).isBefore(LocalDateTime.now());
    }

}
