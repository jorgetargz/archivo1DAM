package dao;

import modelo.Producto;
import services.common.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoProductos {
    private static final ArrayList<Producto> inventario = new ArrayList<>();
    private int idProduct;

    public boolean addProduct(Producto p) {
        boolean operacionRealizada = false;
        if (!inventario.contains(new Producto(p.getNombre()))) {
            idProduct++;
            p.setId(idProduct);
            inventario.add(p);
            operacionRealizada = true;
        }
        return operacionRealizada;
    }

    public boolean deleteProduct(int id) {
        Producto p = new Producto(id);
        return inventario.remove(p);
    }

    public boolean existeProducto(Producto p) {
        return inventario.contains(p);
    }

    public boolean setProductPrize(int id, double precio) {
        int productIndex = inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = inventario.get(productIndex);
            p.setPrecio(precio);
        }
        return productoEncontardo;
    }

    public boolean addProductStock(int id, int stock) {
        int productIndex = inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = inventario.get(productIndex);
            p.setStock(p.getStock() + stock);
        }
        return productoEncontardo;
    }

    public boolean reduceProductStock(int id, int stock) {
        int productIndex = inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = inventario.get(productIndex);
            p.setStock(p.getStock() - stock);
        }
        return productoEncontardo;
    }

    public int getStockProduct(int id) {
        int productIndex = inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = inventario.get(productIndex);
            return p.getStock();
        }
        return 0;
    }

    public List<Producto> getProductList() {
        return inventario.stream()
                .map(producto -> new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }

    public String getProductosDisponibles() {
        StringBuilder productListFiltered = new StringBuilder();
        for (Producto producto : inventario) {
            if (producto.getStock() > 0) {
                productListFiltered.append(producto).append(Constantes.SALTO_LINEA);
            }
        }
        return productListFiltered.toString();
    }

    public String buscarProductoDisponible(String nombre) {
        nombre = nombre.trim();
        StringBuilder productListFiltered = new StringBuilder();
        for (Producto producto : inventario) {
            if (producto.getNombre().contains(nombre.toUpperCase()) && producto.getStock() > 0) {
                productListFiltered.append(producto).append(Constantes.SALTO_LINEA);
            }
        }
        return productListFiltered.toString();
    }

    public String buscarProducto(String nombre) {
        nombre = nombre.trim();
        StringBuilder productListFiltered = new StringBuilder();
        for (Producto producto : inventario) {
            if (producto.getNombre().contains(nombre.toUpperCase())) {
                productListFiltered.append(producto).append(Constantes.SALTO_LINEA);
            }
        }
        return productListFiltered.toString();
    }
}
