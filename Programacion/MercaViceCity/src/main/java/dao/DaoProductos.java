package dao;

import modelo.Cliente;
import modelo.Producto;

import java.util.List;
import java.util.stream.Collectors;

public class DaoProductos {

    public static boolean addProduct(Producto p) {
        boolean operacionRealizada = false;
        if (!BD.inventario.contains(p)) {
            BD.incrementarId();
            p.setId(BD.getIdBD());
            BD.inventario.add(p);
            operacionRealizada = true;
        }
        return operacionRealizada;
    }

    public boolean deleteProduct(Producto p) {
        return BD.inventario.remove(p);
    }

    public boolean existeProducto(Producto p) {
        return BD.inventario.contains(p);
    }

    public boolean setProductPrize(Producto p, double precio) {
        int productIndex = BD.inventario.indexOf(p);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            p.setPrecio(precio);
        }
        return productoEncontardo;
    }

    public boolean addProductStock(Producto p, int stock) {
        int productIndex = BD.inventario.indexOf(p);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            p.setStock(p.getStock() + stock);
        }
        return productoEncontardo;
    }

    public boolean reduceProductStock(Producto producto, int stock) {
        int productIndex = BD.inventario.indexOf(producto);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            p.setStock(p.getStock() - stock);
        }
        return productoEncontardo;
    }

    public int getStockProduct(Producto producto) {
        int productIndex = BD.inventario.indexOf(producto);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            return p.getStock();
        }
        return 0;
    }

    public List<Producto> getProductList(Cliente cliente) {
        return BD.inventario.stream()
                .filter(producto -> producto.getIngredientes().stream()
                        .anyMatch(ingrediente -> cliente.getAlergenos().contains(ingrediente)))
                .map(Producto::clonar)
                .collect(Collectors.toUnmodifiableList());
    }

}
