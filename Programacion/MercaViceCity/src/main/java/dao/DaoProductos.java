package dao;

import modelo.Producto;
import modelo.ProductoPerecedero;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
            Producto productoBD = BD.inventario.get(productIndex);
            productoBD.setPrecio(precio);
        }
        return productoEncontardo;
    }

    public boolean addProductStock(Producto p, int stock) {
        int productIndex = BD.inventario.indexOf(p);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto productoBD = BD.inventario.get(productIndex);
            productoBD.setStock(this.getStockProduct(p) + stock);
        }
        return productoEncontardo;
    }

    public boolean reduceProductStock(Producto producto, int stock) {
        int productIndex = BD.inventario.indexOf(producto);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            p.setStock(this.getStockProduct(p) - stock);
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

    public List<Producto> getProductList() {
        List<Producto> productos = new ArrayList<>();
        BD.inventario.stream().filter(producto -> !(producto instanceof ProductoPerecedero))
                .map(Producto::clonar).forEach(productos::add);
        BD.inventario.stream().filter(ProductoPerecedero.class::isInstance)
                .map(producto -> ((ProductoPerecedero) producto).clonar()).forEach(productos::add);
        return productos;
    }

    public LocalDateTime getCaducidad(ProductoPerecedero perecedero) {
        int productIndex = BD.inventario.indexOf(perecedero);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            ProductoPerecedero p = (ProductoPerecedero) BD.inventario.get(productIndex);
            return p.getCaducidad();
        }
        return null;
    }

}
