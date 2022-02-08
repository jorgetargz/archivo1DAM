package ui;

import services.ServicesClientes;
import services.ServicesProductos;
import ui.common.Constantes;

import java.util.Scanner;

public class UICliente {


    public void menuCliente(String dni) {
        System.out.print(Constantes.BIENVENIDO_DE_NUEVO);
        uiClientName(dni);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int opCliente;
        do {
            System.out.println();
            System.out.println(Constantes.SALIR);
            System.out.println("1. Añadir monedero");
            System.out.println("2. Añadir producto a compra");
            System.out.println(Constantes.VER_PRODUCTOS_DISPONIBLES);
            System.out.println(Constantes.BUSCAR_PRODUCTOS_DISPONIBLES_POR_NOMBRE);
            System.out.println("5. Ver lista de la compra");
            System.out.println("6. Realizar compra");
            System.out.print(Constantes.ELIGE_UNA_OPCION);
            opCliente = sc.nextInt();
            sc.nextLine();
            switch (opCliente) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    this.uiMostrarProductosDisponibles();
                    break;
                case 4:
                    this.uiBuscarProductoDisponible(sc);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println(Constantes.ERROR_ENTRADA_DE_MENU_NO_VALIDA);
            }
        } while (opCliente != 0);
    }

    private void uiClientName(String dni) {
        ServicesClientes scClientes = new ServicesClientes();
        scClientes.getClientList().forEach(cliente -> {
            if (cliente.getDni().equals(dni)) {
                System.out.print(cliente.getNombre());
            }
        });
    }

    private void uiMostrarProductosDisponibles() {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.println(Constantes.LISTA_DE_PRODUCTOS);
        System.out.println(scProductos.getProductosDisponibles());
    }

    private void uiBuscarProductoDisponible(Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.print(Constantes.INTRODUCE_UN_NOMBRE_DE_PRODUCTO);
        String nombre = sc.nextLine();
        System.out.println(scProductos.buscarProducto(nombre));
    }

}
