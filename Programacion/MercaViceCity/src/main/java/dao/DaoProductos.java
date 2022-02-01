package dao;

import modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoProductos {
    private final ArrayList<Producto> inventario = new ArrayList<>();
    private int idProduct;

    public boolean addProduct(Producto p) {
        boolean operacionRealizada = false;
        if (!inventario.contains(new Producto(p.getNombre()))) {
            idProduct++;
            p.setId(idProduct);
            inventario.add(p);
            operacionRealizada = true;}
        return operacionRealizada;
    }

    public boolean deleteProduct(int id) {
        Producto p = new Producto(id);
        return inventario.remove(p);
    }

    public List<Producto> getProductList() {
        return inventario.stream().collect(Collectors.toUnmodifiableList());
    }


    public boolean setProductPrize(int id, double precio) {
        boolean operacionRealizada = false;
        int posicion = inventario.indexOf(new Producto(id));
        if (posicion >= 0 && precio > 0) {
            Producto p = inventario.get(posicion);
            p.setPrecio(precio);
            operacionRealizada = true;
        }
        return operacionRealizada;
    }


    public boolean addProductStock(int id, int stock) {
        boolean operacionRealizada = false;
        int posicion = inventario.indexOf(new Producto(id));
        if (posicion >= 0) {
            Producto p = inventario.get(posicion);
            p.setStock(p.getStock() + stock);
            operacionRealizada = true;
        }
        return operacionRealizada;
    }

    public boolean deleteProductStock(int id, int stock) {
        boolean operacionRealizada = false;
        int posicion = inventario.indexOf(new Producto(id));
        if (posicion >= 0) {
            Producto p = inventario.get(posicion);
            int nuevoStock = p.getStock() - stock;
            if (nuevoStock >= 0) {
                p.setStock(nuevoStock);
                operacionRealizada = true;
            }
        }
        return operacionRealizada;
    }
}
