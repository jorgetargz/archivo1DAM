package pruebas;

import dao.DaoProductos;

public class Prueba {
    public static void main(String[] args) {
        DaoProductos daoProductos = new DaoProductos();
        //Datos de producto 1
        String nombre = "Kitkat normal";
        int precio = 1;
        int stock = 3;

        System.out.println("Prueba añadir producto nuevo");
        if (daoProductos.addProduct(nombre, precio, stock)) {
            System.out.println("Prueba correcta producto añadido");
        }
        System.out.println();

        System.out.println("Prueba añadir producto ya existente");
        if (!daoProductos.addProduct(nombre, precio, stock)) {
            System.out.println("Prueba correcta producto no añadido");
        }
        System.out.println();

        System.out.println("Prueba mostrar todos los productos");
        //Añadimos mas productos
        daoProductos.addProduct("Kitkat rojo", 1.2, 4);
        daoProductos.addProduct("Kitkat azul", 1.4, 6);
        daoProductos.addProduct("manzanilla", 1.4, 6);
        daoProductos.addProduct("chocolates valor", 3, 0);
        //Mostramos los productos
        System.out.println("Subprueba motrar todos los productos para la gestion");
        System.out.println(daoProductos.getProductListAdmin());
        System.out.println("Subprueba motrar todos los productos disponibles");
        System.out.println(daoProductos.getProductListClient());

        System.out.println("Prueba mostrar todos los kitkat");
        System.out.println(daoProductos.buscarProducto("kItKaT  "));

        System.out.println("Prueba obtener precio");
        if (daoProductos.getProductPrize(1) == 1) {
            System.out.println("Prueba correcta");
        }
        System.out.println();

        System.out.println("Prueba obtener stock");
        if (daoProductos.getProductStock(1) == 3) {
            System.out.println("Prueba correcta");
        }
        System.out.println();

        System.out.println("Prueba modificar precio");
        double nuevoPrecio = 4.2;
        if (daoProductos.setProductPrize(1, nuevoPrecio)) {
            if (daoProductos.getProductPrize(1) == 4.2) {
                System.out.println("Prueba correcta");
            }
        }
        System.out.println();

        System.out.println("Prueba modificar stock");
        int nuevoStock = 4;
        if (daoProductos.setProductStock(1, nuevoStock)) {
            if (daoProductos.getProductStock(1) == 4) {
                System.out.println("Prueba correcta");
            }
        }
        System.out.println();

        System.out.println("Prueba eliminar producto 4");
        if (daoProductos.deleteProduct(4)) {
            System.out.println(daoProductos.getProductListAdmin());
            System.out.println("Prueba correcta");
        }
    }
}

