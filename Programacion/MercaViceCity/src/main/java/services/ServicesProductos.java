package services;


import dao.DaoProductos;
import modelo.Producto;

import java.util.List;
import java.util.Scanner;


public class ServicesProductos {


    private final DaoProductos daoProductos = new DaoProductos();;


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

    public boolean eliminarProducto(Scanner sc, int idProducto) {
        return daoProductos.deleteProduct(idProducto);
    }

    public List<Producto> getProductList() {
        return daoProductos.getProductList();
    }

    public String getProductosDisponibles(){
        List<Producto> inventario = daoProductos.getProductList();
        StringBuilder productListFiltered = new StringBuilder();
        for (Producto producto : inventario) {
            if (producto.getStock() > 0) {
                productListFiltered.append(producto).append("\n");
            }
        }
        return productListFiltered.toString();
    }

    public String buscarProducto(String nombre) {
        nombre = nombre.trim();
        StringBuilder productListFiltered = new StringBuilder();
        for (Producto producto : daoProductos.getProductList()) {
            if (producto.getNombre().contains(nombre.toUpperCase())) {
                productListFiltered.append(producto).append("\n");
            }
        }
        return productListFiltered.toString();
    }

    public boolean aumentarStock(int idProducto, int nuevasUnidades) {
        if (nuevasUnidades > 0)
            return daoProductos.addProductStock(idProducto, nuevasUnidades);
        return false;
    }

    public boolean disminuirStock(int idProducto, int unidadesAEliminar) {
        if (unidadesAEliminar > 0)
            return daoProductos.deleteProductStock(idProducto, unidadesAEliminar);
        return false;
    }

    public boolean setPrecioProducto(int idProducto, double precioProducto){
        if (precioProducto > 0)
            return daoProductos.setProductPrize(idProducto, precioProducto);
        return false;
    }
}
