package dao;

import modelo.Producto;

import java.util.ArrayList;

public class DaoProductos {
    private final ArrayList<Producto> inventario = new ArrayList<>();
    private int idProduct;

    public boolean addProduct(String nombre, double precio, int stock) {
        boolean operacionRealizada = false;
        boolean nombreRepetido = false;
        for (int i = 0; i < inventario.size() && !nombreRepetido; i++) {
            if (inventario.get(i).getNombre().equalsIgnoreCase(nombre)) {
                nombreRepetido = true;
            }
        }
        if (!nombreRepetido) {
            idProduct++;
            inventario.add(new Producto(idProduct, nombre, precio, stock));
            operacionRealizada = true;
        }
        return operacionRealizada;
    }

    public boolean deleteProduct(int id) {
        boolean operacionRealizada = false;
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                inventario.remove(producto);
                operacionRealizada = true;
                break;
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
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto.getPrecio();
            }
        }
        return -1;
    }

    public int getProductStock(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto.getStock();
            }
        }
        return -1;
    }

    public boolean setProductPrize(int id, double precio) {
        boolean operacionRealizada = false;
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                producto.setPrecio(precio);
                operacionRealizada = true;
                break;
            }
        }
        return operacionRealizada;
    }

    public boolean setProductStock(int id, int stock) {
        boolean operacionRealizada = false;
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                producto.setStock(stock);
                operacionRealizada = true;
                break;
            }
        }
        return operacionRealizada;
    }
}
