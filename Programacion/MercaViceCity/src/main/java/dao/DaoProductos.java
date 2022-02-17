package dao;

import dao.common.Constantes;
import modelo.Producto;

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
                .map(Producto::clonar)
                .collect(Collectors.toUnmodifiableList());
    }

}
