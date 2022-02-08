package services;

import dao.DaoProductos;
import modelo.Producto;

import java.util.List;

public class ServicesProductos {

    public boolean anadirProducto(Producto p) {
        DaoProductos daoProductos = new DaoProductos();
        if (p.getPrecio() > 0 &&
                p.getStock() > 0 &&
                daoProductos.existeProducto(p)
        ) {
            return (daoProductos.addProduct(p) &&
                    daoProductos.setProductPrize(p.getId(), p.getPrecio()) &&
                    daoProductos.addProductStock(p.getId(), p.getStock()));
        }
        return false;
    }

    public boolean eliminarProducto(int idProducto) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.deleteProduct(idProducto);
    }

    public boolean setPrecioProducto(int idProducto, double precioProducto) {
        DaoProductos daoProductos = new DaoProductos();
        boolean criteriosCorrectos = (precioProducto > 0 &&
                daoProductos.existeProducto(new Producto(idProducto)));
        return criteriosCorrectos &&
                daoProductos.setProductPrize(idProducto, precioProducto);
    }

    public boolean aumentarStock(int idProducto, int nuevasUnidades) {
        DaoProductos daoProductos = new DaoProductos();
        boolean criteriosCorrectos = (nuevasUnidades > 0 &&
                daoProductos.existeProducto(new Producto(idProducto)));
        return (criteriosCorrectos &&
                daoProductos.addProductStock(idProducto, nuevasUnidades));
    }

    public boolean disminuirStock(int idProducto, int unidadesAEliminar) {
        DaoProductos daoProductos = new DaoProductos();
        Producto p = new Producto(idProducto);
        if (daoProductos.existeProducto(p)) {
            int stockActual = daoProductos.getStockProduct(idProducto);
            boolean criteriosCorrectos = (unidadesAEliminar > 0 &&
                    unidadesAEliminar <= stockActual);
            return (criteriosCorrectos &&
                    daoProductos.reduceProductStock(idProducto, unidadesAEliminar));
        }
        return false;
    }

    public List<Producto> getProductList() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductList();
    }

    public String getProductosDisponibles() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductosDisponibles();
    }

    public String buscarProductoDisponibles(String nombre) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.buscarProductoDisponible(nombre);
    }

    public String buscarProducto(String nombre) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.buscarProducto(nombre);
    }
}
