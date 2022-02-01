package ui;

import ui.common.Constantes;
import services.ServicesClientes;
import services.ServicesProductos;

import java.util.Scanner;

public class UIAdmin {

    private final ServicesProductos scProductos = new ServicesProductos();
    private final ServicesClientes scClientes = new ServicesClientes();

    public void menuAdmin() {
        Scanner sc = new Scanner(System.in);
        int opAdmin;
        do {
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
                    this.uiSetPreciProducto(sc);
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

    public void uiAnadirProducto(Scanner sc) {
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
            productoAnadido = scProductos.anadirProducto(nombre, precio, stock);
            if (!productoAnadido)
                System.out.println(Constantes.PRODUCTO_NO_ANADIDO_REVISA_LOS_DATOS);
        } while (!productoAnadido);
    }

    public void uiEliminarProducto(Scanner sc) {
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        if (scProductos.eliminarProducto(sc, idProducto)) {
            System.out.println(Constantes.PRODUCTO_ELIMINADO);
        } else {
            System.out.println(Constantes.PRODUCTO_NO_ENCONTRADO);
        }
    }

    public void uiMostrarProductos() {
        System.out.println(scProductos.getProductList());
    }

    public void uiBuscarProducto(Scanner sc) {
        System.out.print(Constantes.INTRODUCE_UN_NOMBRE_DE_PRODUCTO);
        String nombre = sc.nextLine();
        System.out.println(scProductos.buscarProducto(nombre));
    }

    public void uiAumentarStock(Scanner sc) {
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

    public void uiDisminuirStock(Scanner sc) {
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

    public void uiSetPreciProducto(Scanner sc) {
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

    public void uiClientList() {
        StringBuilder listaCLientes = new StringBuilder();
        scClientes.getClientList().forEach(cliente -> listaCLientes.append(cliente.toString()).append("\n"));
        System.out.println(listaCLientes);
    }

    private void uiRegistrarCliente(Scanner sc) {
        String dni;
        System.out.println(Constantes.REGISTRAR_NUEVO_CLIENTE);
        System.out.print(Constantes.INDICA_DNI_DEL_CLIENTE);
        dni = sc.nextLine();
        if (scClientes.registrarCliente(dni)) {
            System.out.print(Constantes.INDICA_EL_NOMBRE_DEL_CLIENTE);
            String nombre = sc.nextLine();
            scClientes.setNombre(dni, nombre);
        } else System.out.println(Constantes.DNI_YA_REGISTRADO);
    }

    public void uiEliminarCliente(Scanner sc) {
        System.out.print(Constantes.INTRODUCE_EL_DNI_DEL_CLIENTE_A_ELIMINAR);
        String dni = sc.nextLine();
        if (scClientes.eliminarCliente(dni)) {
            System.out.println(Constantes.CLIENTE_ELIMINADO);
        } else {
            System.out.println(Constantes.CLIENTE_NO_ENCONTRADO);
        }
    }
}
