package ui;

import modelo.*;
import services.ServicesClientes;
import services.ServicesCompras;
import services.ServicesMonederos;
import services.ServicesProductos;
import ui.common.Constantes;

import java.util.List;
import java.util.Scanner;

public class UICliente {


    public void menuCliente(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print(Constantes.BIENVENIDO_DE_NUEVO);
        uiClientName(cliente);
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
            System.out.println(Constantes.ANADIR_ALERGENO);
            System.out.print(Constantes.ELIGE_UNA_OPCION);
            opCliente = sc.nextInt();
            sc.nextLine();
            switch (opCliente) {
                case 0:
                    break;
                case 1:
                    this.uiAnadirMonedero(sc, cliente);
                    break;
                case 2:
                    this.uiAnadirProductoCarrito(sc, cliente);
                    break;
                case 3:
                    this.uiMostrarProductosDisponibles(cliente);
                    break;
                case 4:
                    this.uiBuscarProductoDisponible(cliente, sc);
                    break;
                case 5:
                    this.uiVerCarrito(cliente);
                    break;
                case 6:
                    this.uiMostrarMonederosCliente(cliente);
                    break;
                case 7:
                    this.uiPagarCompra(cliente);
                    break;
                case 8:
                    this.uiCambiarNombre(sc, cliente);
                    break;
                case 9:
                    this.uiAnadirAlergeno(sc, cliente);
                    break;
                default:
                    System.out.println(Constantes.ERROR_ENTRADA_DE_MENU_NO_VALIDA);
            }
        } while (opCliente != 0);
    }

    private void uiClientName(Cliente c) {
        ServicesClientes scClientes = new ServicesClientes();
        System.out.println(scClientes.scGetNombre(c));
    }

    private void uiMostrarProductosDisponibles(Cliente c) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.println(Constantes.LISTA_DE_PRODUCTOS);
        scProductos.scGetProductosDisponiblesNoCaducados(c).forEach(System.out::println);
    }

    private void uiBuscarProductoDisponible(Cliente cliente, Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.print(Constantes.INTRODUCE_UN_NOMBRE_DE_PRODUCTO);
        String nombre = sc.nextLine();
        scProductos.scBuscarProductoDisponiblesNoCaducados(cliente, nombre).forEach(System.out::println);
    }

    private void uiAnadirMonedero(Scanner sc, Cliente cliente) {
        ServicesMonederos scMonederos = new ServicesMonederos();
        System.out.print(Constantes.INTRODUCE_EL_NUMERO_DEL_MONEDERO);
        int codMonedero = sc.nextInt();
        sc.nextLine();
        if (!scMonederos.scExisteMonedero(new Monedero(codMonedero))) {
            System.out.print(Constantes.INTRODUCE_EL_IMPORTE_DEL_MONEDERO);
            double importeMonedero = sc.nextDouble();
            if (scMonederos.scAnadirMonedero(new Monedero(codMonedero, importeMonedero), cliente)) {
                System.out.println(Constantes.MONEDERO_ANADIDO);
            } else {
                System.out.println(Constantes.MONEDRO_NO_ANADIDO);
            }
        } else {
            System.out.println(Constantes.MONEDRO_NO_ANADIDO);
        }
    }

    private void uiMostrarMonederosCliente(Cliente cliente) {
        ServicesMonederos scMonederos = new ServicesMonederos();
        scMonederos.scGetListaMonederosCliente(cliente).forEach(System.out::println);
    }

    private void uiAnadirProductoCarrito(Scanner sc, Cliente cliente) {
        ServicesProductos scProductos = new ServicesProductos();
        ServicesCompras scCompras = new ServicesCompras();
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        if (scProductos.scExisteProducto(new Producto(idProducto))) {
            System.out.println(Constantes.CANTIDAD_DISPONIBLE + scProductos.scGetProductStock(new Producto(idProducto)));
            System.out.print(Constantes.INTRODUCE_CANTIDAD);
            int cantidad = sc.nextInt();
            sc.nextLine();
            LineaCompra lineaCompra = new LineaCompra(new Producto(idProducto), cantidad);
            if (scCompras.scAddProductoCompraCliente(cliente, lineaCompra)) {
                System.out.println(Constantes.PRODUCTO_ANADIDO_AL_CARRITO);
            } else {
                System.out.println(Constantes.PRODUCTO_NO_ANADIDO_AL_CARRITO);
            }
        } else {
            System.out.println(Constantes.PRODUCTO_NO_ANADIDO_AL_CARRITO);
        }
    }

    private void uiVerCarrito(Cliente cliente) {
        ServicesCompras scCompras = new ServicesCompras();
        scCompras.scGetCarrito(cliente).forEach(System.out::println);
    }

    private void uiPagarCompra(Cliente cliente) {
        ServicesCompras scCompras = new ServicesCompras();
        System.out.println(Constantes.INICIANDO_PROCESO_DE_PAGO);
        if (scCompras.scPagarCompra(cliente)) {
            System.out.println(Constantes.COMPRA_REALIZADA);
        } else {
            System.out.println(Constantes.NO_SE_HA_PODIDO_REALIZAR_LA_COMPRA);
        }
    }

    private void uiCambiarNombre(Scanner sc, Cliente cliente) {
        ServicesClientes scClientes = new ServicesClientes();
        System.out.print(Constantes.PORFAVOR_INDICA_TU_NOMBRE);
        String nombre = sc.nextLine();
        if (scClientes.scSetNombre(cliente, nombre)) {
            System.out.println(Constantes.NOMBRE_CAMBIADO_CORRECTAMENTE);
        } else {
            System.out.println(Constantes.NO_SE_HA_PODIDO_CAMBIAR_EL_NOMBRE);
        }
    }

    private void uiAnadirAlergeno(Scanner sc, Cliente cliente) {
        ServicesClientes scClientes = new ServicesClientes();
        UIIngredientes uiIngredientes = new UIIngredientes();
        List<Ingrediente> alergenos = uiIngredientes.uiListaIngredientes(sc);
        alergenos.forEach(ingrediente -> {
            if (scClientes.scAnadirAlergeno(ingrediente, cliente)) {
                System.out.println(Constantes.ALERGENO + ingrediente + Constantes.ANADIDO);
            }
        });
    }

}
