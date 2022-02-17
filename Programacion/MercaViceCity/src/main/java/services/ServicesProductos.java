package services;

import dao.DaoProductos;
import modelo.Producto;
import modelo.ProductoPerecedero;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ServicesProductos {

    public boolean scAnadirProducto(Producto p) {
        DaoProductos daoProductos = new DaoProductos();
        ServicesProductosPerecederos scProductosPerecederos = new ServicesProductosPerecederos();
        boolean caducado = false;
        if (p instanceof ProductoPerecedero){
            caducado = scProductosPerecederos.productoCaducado((ProductoPerecedero) p);
        }
        if (p.getPrecio() > 0 &&
                p.getStock() > 0 &&
                !daoProductos.existeProducto(p) &&
                !caducado
        ) {
            return DaoProductos.addProduct(p);
        }
        return false;
    }

    public String scGetProductName(int idProduct) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductName(idProduct);
    }

    public double scGetProductPrize(int idProduct) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductPrize(idProduct);
    }

    public boolean scEliminarProducto(Producto p) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.deleteProduct(p);
    }

    public boolean scExisteProducto(Producto producto) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.existeProducto(producto);
    }

    public int scGetProductStock(Producto producto) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getStockProduct(producto);
    }

    public boolean scSetPrecioProducto(Producto p, double precioProducto) {
        DaoProductos daoProductos = new DaoProductos();
        boolean criteriosCorrectos = (precioProducto > 0 &&
                daoProductos.existeProducto(p));
        return criteriosCorrectos &&
                daoProductos.setProductPrize(p, precioProducto);
    }

    public boolean scAumentarStock(Producto p, int nuevasUnidades) {
        DaoProductos daoProductos = new DaoProductos();
        boolean criteriosCorrectos = (nuevasUnidades > 0 &&
                daoProductos.existeProducto(p));
        return (criteriosCorrectos &&
                daoProductos.addProductStock(p, nuevasUnidades));
    }

    public boolean scDisminuirStock(Producto producto, int unidadesAEliminar) {
        DaoProductos daoProductos = new DaoProductos();
        if (daoProductos.existeProducto(producto)) {
            int stockActual = daoProductos.getStockProduct(producto);
            boolean criteriosCorrectos = (unidadesAEliminar > 0 &&
                    unidadesAEliminar <= stockActual);
            return (criteriosCorrectos &&
                    daoProductos.reduceProductStock(producto, unidadesAEliminar));
        }
        return false;
    }

    public List<Producto> scGetProductList() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductList();
    }

    public List<Producto> scGetProductosDisponiblesNoCaducados() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductList().stream()
                .filter(producto -> {
                    boolean valido;
                    if (producto instanceof ProductoPerecedero) {
                        valido = ((ProductoPerecedero) producto).getCaducidad().isAfter(LocalDateTime.now());
                    } else {
                        valido = true;
                    }
                    return valido;
                })
                .filter(producto -> producto.getStock() > 0)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Producto> scBuscarProducto(String nombre) {
        DaoProductos daoProductos = new DaoProductos();
        nombre = nombre.trim();
        String finalNombre = nombre;
        return daoProductos.getProductList().stream()
                .filter(producto -> producto.getNombre().contains(finalNombre.toUpperCase()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Producto> scBuscarProductoDisponiblesNoCaducados(String nombre) {
        DaoProductos daoProductos = new DaoProductos();
        nombre = nombre.trim();
        String finalNombre = nombre;
        return daoProductos.getProductList().stream()
                .filter(producto -> {
                    boolean valido;
                    if (producto instanceof ProductoPerecedero) {
                        valido = ((ProductoPerecedero) producto).getCaducidad().isAfter(LocalDateTime.now());
                    } else {
                        valido = true;
                    }
                    return valido;
                })
                .filter(producto -> producto.getNombre().contains(finalNombre.toUpperCase()) && producto.getStock() > 0)
                .collect(Collectors.toUnmodifiableList());
    }

}
