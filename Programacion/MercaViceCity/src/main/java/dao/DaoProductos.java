package dao;

import modelo.Producto;

import java.util.ArrayList;

public class DaoProductos {
    private final ArrayList<Producto> inventario = new ArrayList<>();
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
        boolean operacionRealizada = false;
        int posicion = inventario.indexOf(new Producto(id));
        if (posicion >= 0) {
            Producto p = inventario.get(posicion);
            if (inventario.remove(p)) {
                operacionRealizada = true;
            }
        }
        return operacionRealizada;
    }

    public String getProductListAdmin() {
        StringBuilder productList = new StringBuilder();
        for (Producto producto : inventario) {
            productList.append(producto).append("\n");
        }
        return productList.toString();
    }

    public String getProductListClient() {
        StringBuilder productList = new StringBuilder();
        for (Producto producto : inventario) {
            if (producto.getStock() > 0) {
                productList.append(producto).append("\n");
            }
        }
        return productList.toString();
    }

    public String buscarProducto(String nombre) {
        nombre = nombre.trim();
        StringBuilder productListFiltered = new StringBuilder();
        for (Producto producto : inventario) {
            if (producto.getNombre().contains(nombre.toUpperCase())) {
                productListFiltered.append(producto).append("\n");
            }
        }
        return productListFiltered.toString();
    }

    public double getProductPrize(int id) {
        int posicion = inventario.indexOf(new Producto(id));
        if (posicion >= 0) {
            Producto p = inventario.get(posicion);
            return p.getPrecio();
        }
        return -1;
    }

    public int getProductStock(int id) {
        int posicion = inventario.indexOf(new Producto(id));
        if (posicion >= 0) {
            Producto p = inventario.get(posicion);
            return p.getStock();
        }
        return -1;
    }

    public boolean setProductPrize(int id, double precio) {
        boolean operacionRealizada = false;
        int posicion = inventario.indexOf(new Producto(id));
        if (posicion >= 0) {
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
