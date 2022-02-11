package ui;

import modelo.Monedero;
import services.ServicesClientes;
import services.ServicesCompras;
import services.ServicesMonederos;
import services.ServicesProductos;
import ui.common.Constantes;

import java.util.Scanner;

public class UICliente {


    public void menuCliente(String dni) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print(Constantes.BIENVENIDO_DE_NUEVO);
        uiClientName(dni);
        int opCliente;
        do {
            System.out.println();
            System.out.println(Constantes.SALIR);
            System.out.println(Constantes.ANADIR_MONEDERO);
            System.out.println(Constantes.ANADIR_PRODUCTO_AL_CARRITO_POR_ID);
            System.out.println(Constantes.VER_PRODUCTOS_DISPONIBLES);
            System.out.println(Constantes.BUSCAR_PRODUCTOS_DISPONIBLES_POR_NOMBRE);
            System.out.println(Constantes.VER_LISTA_DE_LA_COMPRA);
            System.out.println(Constantes.VER_MONEDEROS);
            System.out.println(Constantes.REALIZAR_COMPRA);
            System.out.println(Constantes.CAMBIAR_NOMBRE);
            System.out.print(Constantes.ELIGE_UNA_OPCION);
            opCliente = sc.nextInt();
            sc.nextLine();
            switch (opCliente) {
                case 0:
                    break;
                case 1:
                    this.uiAnadirMonedero(sc, dni);
                    break;
                case 2:
                    this.uiAnadirProductoCarrito(sc, dni);
                    break;
                case 3:
                    this.uiMostrarProductosDisponibles();
                    break;
                case 4:
                    this.uiBuscarProductoDisponible(sc);
                    break;
                case 5:
                    this.uiVerCarrito(dni);
                    break;
                case 6:
                    this.uiMostrarMonederosCliente(dni);
                    break;
                case 7:
                    this.uiPagarCompra(dni);
                    break;
                case 8:
                    this.uiCambiarNombre(sc, dni);
                    break;
                default:
                    System.out.println(Constantes.ERROR_ENTRADA_DE_MENU_NO_VALIDA);
            }
        } while (opCliente != 0);
    }

    private void uiClientName(String dni) {
        ServicesClientes scClientes = new ServicesClientes();
        System.out.println(scClientes.scGetNombre(dni));
    }

    private void uiMostrarProductosDisponibles() {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.println(Constantes.LISTA_DE_PRODUCTOS);
        scProductos.scGetProductosDisponibles().forEach(System.out::println);
    }

    private void uiBuscarProductoDisponible(Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.print(Constantes.INTRODUCE_UN_NOMBRE_DE_PRODUCTO);
        String nombre = sc.nextLine();
        scProductos.scBuscarProductoDisponibles(nombre).forEach(System.out::println);
    }

    private void uiAnadirMonedero(Scanner sc, String dni) {
        ServicesMonederos scMonederos = new ServicesMonederos();
        System.out.print(Constantes.INTRODUCE_EL_NUMERO_DEL_MONEDERO);
        int codMonedero = sc.nextInt();
        sc.nextLine();
        if (!scMonederos.scExisteMonedero(new Monedero(codMonedero))) {
            System.out.print(Constantes.INTRODUCE_EL_IMPORTE_DEL_MONEDERO);
            double importeMonedero = sc.nextDouble();
            if (scMonederos.scAnadirMonedero(new Monedero(codMonedero, importeMonedero), dni)) {
                System.out.println(Constantes.MONEDERO_ANADIDO);
            } else {
                System.out.println(Constantes.MONEDRO_NO_ANADIDO);
            }
        } else {
            System.out.println(Constantes.MONEDRO_NO_ANADIDO);
        }
    }

    private void uiMostrarMonederosCliente(String dni) {
        ServicesMonederos scMonederos = new ServicesMonederos();
        scMonederos.scGetListaMonederosCliente(dni).forEach(System.out::println);
    }

    private void uiAnadirProductoCarrito(Scanner sc, String dni) {
        ServicesProductos scProductos = new ServicesProductos();
        ServicesCompras scCompras = new ServicesCompras();
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        if (scProductos.scExisteProducto(idProducto)) {
            System.out.println(Constantes.CANTIDAD_DISPONIBLE + scProductos.scGetProductStock(idProducto));
            System.out.print(Constantes.INTRODUCE_CANTIDAD);
            int cantidad = sc.nextInt();
            sc.nextLine();
            if (scCompras.scAddProductoCompraCliente(dni, idProducto, cantidad)) {
                System.out.println(Constantes.PRODUCTO_ANADIDO_AL_CARRITO);
            }
        } else {
            System.out.println(Constantes.PRODUCTO_NO_ANADIDO_AL_CARRITO);
        }
    }

    private void uiVerCarrito(String dni) {
        ServicesCompras scCompras = new ServicesCompras();
        scCompras.scGetCarrito(dni).forEach(System.out::println);
    }

    private void uiPagarCompra(String dni) {
        ServicesCompras scCompras = new ServicesCompras();
        System.out.println(Constantes.INICIANDO_PROCESO_DE_PAGO);
        if (scCompras.scPagarCompra(dni)) {
            System.out.println(Constantes.COMPRA_REALIZADA);
        } else {
            System.out.println(Constantes.NO_SE_HA_PODIDO_REALIZAR_LA_COMPRA);
        }
    }

    private void uiCambiarNombre(Scanner sc, String dni) {
        ServicesClientes scClientes = new ServicesClientes();
        System.out.print(Constantes.PORFAVOR_INDICA_TU_NOMBRE);
        String nombre = sc.nextLine();
        scClientes.scSetNombre(dni, nombre);
    }

}
