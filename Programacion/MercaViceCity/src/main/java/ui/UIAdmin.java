package ui;

import modelo.Cliente;
import modelo.Producto;
import services.ServicesClientes;
import services.ServicesProductos;
import ui.common.Constantes;

import java.util.Scanner;

public class UIAdmin {


    public void menuAdmin() {
        Scanner sc = new Scanner(System.in);
        int opAdmin;
        do {
            System.out.println();
            System.out.println(Constantes.SALIR);
            System.out.println(Constantes.ANADIR_PRODUCTO);
            System.out.println(Constantes.ELIMINAR_PRODUCTO);
            System.out.println(Constantes.VER_PRODUCTOS);
            System.out.println(Constantes.BUSCAR_UN_PRODUCTO);
            System.out.println(Constantes.AUMENTAR_STOCK_PRODUCTO_POR_ID);
            System.out.println(Constantes.DISMINUIR_STOCK_PRODUCTO_POR_ID);
            System.out.println(Constantes.CAMBIAR_PRECIO_PRODUCTO_POR_ID);
            System.out.println(Constantes.ANADIR_CLIENTE);
            System.out.println(Constantes.VER_LISTA_CLIENTES);
            System.out.println(Constantes.ELIMINAR_CLIENTE_POR_DNI);
            System.out.print(Constantes.ELIGE_UNA_OPCION);
            opAdmin = sc.nextInt();
            sc.nextLine();
            switch (opAdmin) {
                case 0:
                    break;
                case 1:
                    this.uiAnadirProducto(sc);
                    break;
                case 2:
                    this.uiEliminarProducto(sc);
                    break;
                case 3:
                    this.uiMostrarProductos();
                    break;
                case 4:
                    this.uiBuscarProducto(sc);
                    break;
                case 5:
                    this.uiAumentarStock(sc);
                    break;
                case 6:
                    this.uiDisminuirStock(sc);
                    break;
                case 7:
                    this.uiSetPrecioProducto(sc);
                    break;
                case 8:
                    this.uiRegistrarCliente(sc);
                    break;
                case 9:
                    this.uiClientList();
                    break;
                case 10:
                    this.uiEliminarCliente(sc);
                    break;
                default:
                    System.out.println(Constantes.ERROR_ENTRADA_DE_MENU_NO_VALIDA);
            }
        } while (opAdmin != 0);
    }

    private void uiAnadirProducto(Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        boolean productoAnadido;
        do {
            System.out.print(Constantes.INTRODUCE_UN_NOMBRE_DE_PRODUCTO);
            String nombre = sc.nextLine();
            System.out.print(Constantes.INTRODUCE_EL_PRECIO);
            double precio = sc.nextDouble();
            sc.nextLine();
            System.out.print(Constantes.INTRODUCE_EL_STOCK);
            int stock = sc.nextInt();
            sc.nextLine();
            Producto producto = new Producto(nombre, precio, stock);
            productoAnadido = scProductos.anadirProducto(producto);
            if (productoAnadido) System.out.println(Constantes.PRODUCTO_ANADIDO);
            else System.out.println(Constantes.PRODUCTO_NO_ANADIDO_REVISA_LOS_DATOS);
        } while (!productoAnadido);
    }

    private void uiEliminarProducto(Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        if (scProductos.eliminarProducto(idProducto)) {
            System.out.println(Constantes.PRODUCTO_ELIMINADO);
        } else {
            System.out.println(Constantes.PRODUCTO_NO_ENCONTRADO);
        }
    }

    private void uiMostrarProductos() {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.println(Constantes.LISTA_DE_PRODUCTOS);
        scProductos.getProductList().forEach(System.out::println);
    }

    private void uiBuscarProducto(Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.print(Constantes.INTRODUCE_UN_NOMBRE_DE_PRODUCTO);
        String nombre = sc.nextLine();
        System.out.println(scProductos.buscarProducto(nombre));
    }

    private void uiAumentarStock(Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        System.out.print(Constantes.INDICAR_EL_NUMERO_DE_NUEVAS_UNIDADES);
        int nuevasUnidades = sc.nextInt();
        sc.nextLine();
        if (scProductos.aumentarStock(idProducto, nuevasUnidades)) {
            System.out.println(Constantes.UNIDADES_ANADIDAS);
        } else {
            System.out.println(Constantes.CANTIDAD_DE_UNIDADES_O_ID_NO_VALIDO);
        }
    }

    private void uiDisminuirStock(Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        System.out.print(Constantes.INTRODUCE_EL_NUMERO_DE_UNIDADES_A_RETIRAR);
        int unidadesAEliminar = sc.nextInt();
        sc.nextLine();
        if (scProductos.disminuirStock(idProducto, unidadesAEliminar)) {
            System.out.println(Constantes.UNIDADES_RETIRADAS);
        } else {
            System.out.println(Constantes.CANTIDAD_DE_UNIDADES_O_ID_NO_VALIDO);
        }
    }

    private void uiSetPrecioProducto(Scanner sc) {
        ServicesProductos scProductos = new ServicesProductos();
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        System.out.print(Constantes.INTRODUCE_EL_NUEVO_PRECIO);
        double precio = sc.nextDouble();
        sc.nextLine();
        if (scProductos.setPrecioProducto(idProducto, precio)) {
            System.out.println(Constantes.PRECIO_MODIFICADO);
        } else {
            System.out.println(Constantes.PRECIO_O_ID_INVALIDO);
        }
    }

    private void uiClientList() {
        ServicesClientes scClientes = new ServicesClientes();
        scClientes.getClientList().forEach(System.out::println);
    }


    private void uiRegistrarCliente(Scanner sc) {
        ServicesClientes scClientes = new ServicesClientes();
        String dni;
        System.out.println(Constantes.REGISTRAR_NUEVO_CLIENTE);
        System.out.print(Constantes.INDICA_DNI_DEL_CLIENTE);
        dni = sc.nextLine();
        Cliente cliente = new Cliente(dni);
        if (scClientes.registrarCliente(cliente)) {
            System.out.print(Constantes.INDICA_EL_NOMBRE_DEL_CLIENTE);
            String nombre = sc.nextLine();
            if (scClientes.setNombre(dni, nombre)) {
                System.out.println(Constantes.REGISTRADO_CORRECTAMENTE);
            }
        } else System.out.println(Constantes.DNI_YA_REGISTRADO);
    }

    private void uiEliminarCliente(Scanner sc) {
        ServicesClientes scClientes = new ServicesClientes();
        System.out.print(Constantes.INTRODUCE_EL_DNI_DEL_CLIENTE_A_ELIMINAR);
        String dni = sc.nextLine();
        if (scClientes.eliminarCliente(dni)) {
            System.out.println(Constantes.CLIENTE_ELIMINADO);
        } else {
            System.out.println(Constantes.CLIENTE_NO_ENCONTRADO);
        }
    }
}
