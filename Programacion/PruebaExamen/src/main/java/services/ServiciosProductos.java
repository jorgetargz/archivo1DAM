package services;

import dao.DaoProductos;
import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ServiciosProductos {

    public List<Producto> getListaProductosDisponibles() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getListaProductosClonada().stream()
                .filter(producto -> producto.getStock() > 0)
                .filter(producto -> {
                    boolean valido;
                    if (producto instanceof ProductoCaducable) {
                        valido = ((ProductoCaducable) producto).getCaducidad().isAfter(LocalDateTime.now());
                    } else {
                        valido = true;
                    }
                    return valido;
                }).collect(Collectors.toList());
    }

    public boolean existeProducto(Producto producto) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.existeProducto(producto);
    }

    public int getProductStock(Producto producto) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getStockProduct(producto);
    }

    public boolean disminuirStock(Producto producto, int unidadesAEliminar) {
        DaoProductos daoProductos = new DaoProductos();
        if (daoProductos.existeProducto(producto)) {
            int stockActual = daoProductos.getStockProduct(producto);
            boolean criteriosCorrectos = (unidadesAEliminar > 0 &&
                    unidadesAEliminar <= stockActual);
            return (criteriosCorrectos &&
                    daoProductos.disminuirProductStock(producto, unidadesAEliminar));
        }
        return false;
    }

    public boolean productoCaducado(ProductoCaducable perecedero) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getCaducidad(perecedero).isBefore(LocalDateTime.now());
    }

    public boolean scExisteProducto(Producto producto) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.existeProducto(producto);
    }
}
