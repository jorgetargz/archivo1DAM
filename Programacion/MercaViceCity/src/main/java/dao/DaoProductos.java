package dao;

import dao.common.Constantes;
import modelo.Producto;
import modelo.ProductoPerecedero;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DaoProductos {

    public static boolean addProduct(Producto p) {
        boolean operacionRealizada = false;
        if (!BD.inventario.contains(p)) {
            BD.idProduct++;
            p.setId(BD.idProduct);
            BD.inventario.add(p);
            operacionRealizada = true;
        }
        return operacionRealizada;
    }

    public boolean deleteProduct(int id) {
        Producto p = new Producto(id);
        return BD.inventario.remove(p);
    }

    public boolean existeProducto(Producto p) {
        return BD.inventario.contains(p);
    }

    public boolean setProductPrize(int id, double precio) {
        int productIndex = BD.inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            p.setPrecio(precio);
        }
        return productoEncontardo;
    }

    public boolean addProductStock(int id, int stock) {
        int productIndex = BD.inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            p.setStock(p.getStock() + stock);
        }
        return productoEncontardo;
    }

    public boolean reduceProductStock(int id, int stock) {
        int productIndex = BD.inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            p.setStock(p.getStock() - stock);
        }
        return productoEncontardo;
    }

    public int getStockProduct(int id) {
        int productIndex = BD.inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            return p.getStock();
        }
        return 0;
    }

    public String getProductName(int id) {
        int productIndex = BD.inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            return p.getNombre();
        }
        return Constantes.NULL;
    }

    public double getProductPrize(int id) {
        int productIndex = BD.inventario.indexOf(new Producto(id));
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            return p.getPrecio();
        }
        return 0;
    }

    public List<Producto> getProductList() {
        return BD.inventario.stream()
                .map(producto -> new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }


    public List<Producto> getProductosDisponiblesNoCaducados() {
        return BD.inventario.stream()
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
                .map(producto -> new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Producto> buscarProductoDisponible(String nombre) {
        nombre = nombre.trim();
        String finalNombre = nombre;
        return BD.inventario.stream()
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
                .map(producto -> new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Producto> buscarProducto(String nombre) {
        nombre = nombre.trim();
        String finalNombre = nombre;
        return BD.inventario.stream()
                .filter(producto -> producto.getNombre().contains(finalNombre.toUpperCase()))
                .map(producto -> new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }
}
