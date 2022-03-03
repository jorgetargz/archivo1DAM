package dao;

import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.List;

public class DaoProductos extends DaoBase{

    public List<Producto> getListaProductosClonada(){
        return getListaInmutableClonada(BD.inventario);
    }

    public LocalDateTime getCaducidad(ProductoCaducable perecedero) {
        int productIndex = BD.inventario.indexOf(perecedero);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            ProductoCaducable p = (ProductoCaducable) BD.inventario.get(productIndex);
            return p.getCaducidad();
        }
        return null;
    }

    public boolean existeProducto(Producto producto) {
        return BD.inventario.contains(producto);
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

    public boolean disminuirProductStock(Producto producto, int unidadesAEliminar) {
        int productIndex = BD.inventario.indexOf(producto);
        boolean productoEncontardo = productIndex != -1;
        if (productoEncontardo) {
            Producto p = BD.inventario.get(productIndex);
            p.setStock(this.getStockProduct(p) - unidadesAEliminar);
        }
        return productoEncontardo;
    }
}
