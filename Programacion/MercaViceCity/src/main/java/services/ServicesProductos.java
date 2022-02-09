package services;

import dao.DaoProductos;
import modelo.Producto;

import java.util.List;

public class ServicesProductos {

    public boolean scAnadirProducto(Producto p) {
        DaoProductos daoProductos = new DaoProductos();
        if (p.getPrecio() > 0 &&
                p.getStock() > 0 &&
                !daoProductos.existeProducto(p)
        ) {
            return DaoProductos.addProduct(p);
        }
        return false;
    }

    public String scGetProductName(int idProduct){
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductName(idProduct);
    }

    public double scGetProductPrize(int idProduct){
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductPrize(idProduct);
    }

    public boolean scEliminarProducto(int idProducto) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.deleteProduct(idProducto);
    }

    public boolean scExisteProducto(int idProducto){
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.existeProducto(new Producto(idProducto));
    }

    public int scGetProductStock(int idProducto){
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getStockProduct(idProducto);
    }

    public boolean scSetPrecioProducto(int idProducto, double precioProducto) {
        DaoProductos daoProductos = new DaoProductos();
        boolean criteriosCorrectos = (precioProducto > 0 &&
                daoProductos.existeProducto(new Producto(idProducto)));
        return criteriosCorrectos &&
                daoProductos.setProductPrize(idProducto, precioProducto);
    }

    public boolean scAumentarStock(int idProducto, int nuevasUnidades) {
        DaoProductos daoProductos = new DaoProductos();
        boolean criteriosCorrectos = (nuevasUnidades > 0 &&
                daoProductos.existeProducto(new Producto(idProducto)));
        return (criteriosCorrectos &&
                daoProductos.addProductStock(idProducto, nuevasUnidades));
    }

    public boolean scDisminuirStock(int idProducto, int unidadesAEliminar) {
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

    public List<Producto> scGetProductList() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductList();
    }

    public String scGetProductosDisponibles() {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.getProductosDisponibles();
    }

    public String scBuscarProductoDisponibles(String nombre) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.buscarProductoDisponible(nombre);
    }

    public String scBuscarProducto(String nombre) {
        DaoProductos daoProductos = new DaoProductos();
        return daoProductos.buscarProducto(nombre);
    }
}
