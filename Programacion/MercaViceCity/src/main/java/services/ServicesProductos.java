package services;


import dao.DaoProductos;
import modelo.Producto;
import services.common.Constantes;

import java.util.List;


public class ServicesProductos {


    private final DaoProductos daoProductos = new DaoProductos();


    public boolean anadirProducto(String nombre, double precio, int stock) {
        Producto p = new Producto(nombre.toUpperCase());
        boolean operacionRealizada = false;
        if (daoProductos.addProduct(p) &&
                precio > 0 &&
                stock > 0) {
            daoProductos.setProductPrize(p.getId(), precio);
            daoProductos.addProductStock(p.getId(), stock);
            operacionRealizada = true;
        }
        return operacionRealizada;
    }

    public boolean eliminarProducto(int idProducto) {
        return daoProductos.deleteProduct(idProducto);
    }

    public List<Producto> getProductList() {
        return daoProductos.getProductList();
    }

    public String getProductosDisponibles() {
        List<Producto> inventario = daoProductos.getProductList();
        StringBuilder productListFiltered = new StringBuilder();
        for (Producto producto : inventario) {
            if (producto.getStock() > 0) {
                productListFiltered.append(producto).append(Constantes.SALTO_LINEA);
            }
        }
        return productListFiltered.toString();
    }

    public String buscarProducto(String nombre) {
        nombre = nombre.trim();
        StringBuilder productListFiltered = new StringBuilder();
        for (Producto producto : daoProductos.getProductList()) {
            if (producto.getNombre().contains(nombre.toUpperCase())) {
                productListFiltered.append(producto).append(Constantes.SALTO_LINEA);
            }
        }
        return productListFiltered.toString();
    }

    public boolean aumentarStock(int idProducto, int nuevasUnidades) {
        boolean criteriosCorrectos = (nuevasUnidades > 0 && this.existeProducto(new Producto(idProducto)));
        if (criteriosCorrectos) {
            daoProductos.addProductStock(idProducto, nuevasUnidades);
        }
        return criteriosCorrectos;
    }

    public boolean disminuirStock(int idProducto, int unidadesAEliminar) {
        boolean criteriosCorrectos = (unidadesAEliminar > 0 && this.existeProducto(new Producto(idProducto)));
        if (criteriosCorrectos) {
            daoProductos.reduceProductStock(idProducto, unidadesAEliminar);
        }
        return criteriosCorrectos;
    }

    public boolean setPrecioProducto(int idProducto, double precioProducto) {
        boolean criteriosCorrectos = (precioProducto > 0 && this.existeProducto(new Producto(idProducto)));
        if (criteriosCorrectos) {
            daoProductos.setProductPrize(idProducto, precioProducto);
        }
        return criteriosCorrectos;
    }

    public boolean existeProducto(Producto p) {
        return daoProductos.getProductList().contains(p);
    }
}
