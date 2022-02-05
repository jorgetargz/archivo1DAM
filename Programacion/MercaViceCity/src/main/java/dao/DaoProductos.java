package dao;

import modelo.Producto;

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

    public List<Producto> getProductList() {
        return inventario.stream()
                .map(producto -> new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }

    public void setProductPrize(int id, double precio) {
        Producto p = inventario.get(inventario.indexOf(new Producto(id)));
        p.setPrecio(precio);
    }

    public void addProductStock(int id, int stock) {
        Producto p = inventario.get(inventario.indexOf(new Producto(id)));
        p.setStock(p.getStock() + stock);
    }

    public void reduceProductStock(int id, int stock) {
        Producto p = inventario.get(inventario.indexOf(new Producto(id)));
        p.setStock(p.getStock() - stock);
    }
}
