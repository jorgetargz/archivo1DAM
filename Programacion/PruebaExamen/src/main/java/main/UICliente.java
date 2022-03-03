package main;

import modelo.Cliente;
import modelo.LineaCompra;
import modelo.Producto;
import services.ServiciosCompras;
import services.ServiciosProductos;

import java.util.Scanner;

public class UICliente {

    public void menuCliente(Cliente clienteBD) {
        Scanner sc = new Scanner(System.in);
        int opCliente;
        do {
            System.out.println();
            System.out.println("Bienvenido " + clienteBD.getNombre());
            System.out.println("Menu");
            System.out.println("0.Salir.");
            System.out.println("1.Ver lista de productos.");
            System.out.println("2.Añadir producto al carrito.");
            System.out.println("3.Pagar compra.");
            System.out.println("4.Ver fondos");
            System.out.print("Indica una opción: ");
            opCliente = sc.nextInt();
            sc.nextLine();
            switch (opCliente) {
                case 1:
                    this.uiVerListaProductosDisponibles();
                    break;
                case 2:
                    this.uiAnadirProductoCarrito(clienteBD);
                    break;
                case 3:
                    this.uiPagarCompra(clienteBD);
                    break;
                case 4:
                    System.out.println(clienteBD.getMonedero());
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opCliente != 0);

    }

    private void uiVerListaProductosDisponibles() {
        ServiciosProductos scProductos = new ServiciosProductos();
        scProductos.getListaProductosDisponibles().forEach(System.out::println);
    }

    private void uiAnadirProductoCarrito(Cliente clienteBD) {
        Scanner sc = new Scanner(System.in);
        ServiciosProductos scProductos = new ServiciosProductos();
        ServiciosCompras scCompras = new ServiciosCompras();
        System.out.print("Introduce nombre de producto ");
        String nombreProducto = sc.nextLine();
        Producto producto = new Producto(nombreProducto);
        if (scProductos.scExisteProducto(producto)) {
            System.out.println("Cantidad disponible: " + scProductos.getProductStock(producto));
            System.out.print("Introduce cantidad a comprar: ");
            int cantidad = sc.nextInt();
            sc.nextLine();
            LineaCompra lineaCompra = new LineaCompra(producto, cantidad);
            if (scCompras.addProductoCompraCliente(clienteBD, lineaCompra)) {
                System.out.println("Producto añadido al carrito.");
            } else {
                System.out.println("Producto no añadido al carrito cantidad no disponible o caducado.");
            }
        } else {
            System.out.println("Producto no añadido, producto no encontrado.");
        }
    }

    private void uiPagarCompra(Cliente clienteBD) {
        ServiciosCompras scCompras = new ServiciosCompras();
        if (scCompras.realizarCompra(clienteBD)) {
            System.out.println("Compra realizada.");
        } else {
            System.out.println("No hay dinero suficiente para realizar la compra.");
        }
    }

}

