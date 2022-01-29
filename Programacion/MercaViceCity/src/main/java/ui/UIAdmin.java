package ui;

import common.Constantes;
import dao.DaoClientes;
import dao.DaoProductos;
import modelo.Cliente;
import modelo.Producto;

import java.util.Scanner;

public class UIAdmin {

    public void menuAdmin(Scanner sc, DaoClientes daoClientes, DaoProductos daoProductos) {
        int opAdmin;
        do {
            System.out.println(Constantes.SALIR);
            System.out.println(Constantes.AÑADIR_PRODUCTO);
            System.out.println(Constantes.ELIMINAR_PRODUCTO);
            System.out.println(Constantes.VER_PRODUCTOS);
            System.out.println(Constantes.AUMENTAR_STOCK_PRODUCTO_POR_ID);
            System.out.println(Constantes.DISMINUIR_STOCK_PRODUCTO_POR_ID);
            System.out.println(Constantes.CAMBIAR_PRECIO_PRODUCTO_POR_ID);
            System.out.println(Constantes.VER_LISTA_CLIENTES);
            System.out.println(Constantes.ELIMINAR_CLIENTE_POR_DNI);
            System.out.println(Constantes.INGRESAR_DINERO_A_CLIENTE);
            System.out.println(Constantes.RETIRAR_DINERO_CLIENTE);
            opAdmin = sc.nextInt();
            sc.nextLine();
            if (opAdmin == 1) this.uiAnadirProducto(sc, daoProductos);
            if (opAdmin == 2) this.uiEliminarProducto(sc, daoProductos);
            if (opAdmin == 3) this.uiMostrarProductos(daoProductos);
            if (opAdmin == 4) this.uiAumentarStock(sc, daoProductos);
            if (opAdmin == 5) this.uiDisminuirStock(sc, daoProductos);
            if (opAdmin == 6) this.uiSetPreciProducto(sc, daoProductos);
            if (opAdmin == 7) daoClientes.getClientList();
            if (opAdmin == 8) this.uiEliminarCliente(sc, daoClientes);
        } while (opAdmin != 0);
    }

    public void uiAnadirProducto(Scanner sc, DaoProductos daoProductos) {
        System.out.print(Constantes.INTRODUCE_UN_NOMBRE_DE_PRODUCTO);
        String nombre = sc.nextLine();
        Producto p = new Producto(nombre);
        if (daoProductos.addProduct(p)) {
            System.out.print(Constantes.INTRODUCE_EL_PRECIO);
            double precio = sc.nextDouble();
            sc.nextLine();
            daoProductos.setProductPrize(p.getId(), precio);
            System.out.println(Constantes.INTRODUCE_EL_STOCK);
            int stock = sc.nextInt();
            sc.nextLine();
            daoProductos.addProductStock(p.getId(), stock);
        } else {
            System.out.println(Constantes.PRODUCTO_YA_EXISTENTE);
        }
    }

    public void uiEliminarProducto(Scanner sc, DaoProductos daoProductos) {
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        if (daoProductos.deleteProduct(idProducto)) {
            System.out.println(Constantes.PRODUCTO_ELIMINADO);
        } else {
            System.out.println(Constantes.PRODUCTO_NO_ENCONTRADO);
        }
    }

    public void uiMostrarProductos(DaoProductos daoProductos) {
        System.out.println(daoProductos.getProductListAdmin());
    }

    public void uiAumentarStock(Scanner sc, DaoProductos daoProductos) {
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        System.out.print(Constantes.INDICAR_EL_NUMERO_DE_NUEVAS_UNIDADES);
        int nuevasUnidades = sc.nextInt();
        sc.nextLine();
        if (daoProductos.addProductStock(idProducto, nuevasUnidades)) {
            System.out.println(Constantes.UNIDADES_AÑADIDAS);
        } else {
            System.out.println(Constantes.CANTIDAD_DE_UNIDADES_O_ID_NO_VALIDO);
        }
    }

    public void uiDisminuirStock(Scanner sc, DaoProductos daoProductos) {
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        System.out.print(Constantes.INTRODUCE_EL_NUMERO_DE_UNIDADES_A_RETIRAR);
        int nuevasUnidades = sc.nextInt();
        sc.nextLine();
        if (daoProductos.deleteProductStock(idProducto, nuevasUnidades)) {
            System.out.println(Constantes.UNIDADES_RETIRADAS);
        } else {
            System.out.println(Constantes.CANTIDAD_DE_UNIDADES_O_ID_NO_VALIDO);
        }
    }

    public void uiSetPreciProducto(Scanner sc, DaoProductos daoProductos) {
        System.out.print(Constantes.INTRODUCE_UN_ID_DE_PRODUCTO);
        int idProducto = sc.nextInt();
        sc.nextLine();
        System.out.print(Constantes.INTRODUCE_EL_NUEVO_PRECIO);
        double precio = sc.nextDouble();
        sc.nextLine();
        if (daoProductos.setProductPrize(idProducto, precio)) {
            System.out.println(Constantes.PRECIO_MODIFICADO);
        } else {
            System.out.println(Constantes.PRECIO_O_ID_INVALIDO);
        }
    }
     public void uiEliminarCliente(Scanner sc, DaoClientes daoClientes){
         System.out.print(Constantes.INTRODUCE_EL_DNI_DEL_CLIENTE_A_ELIMINAR);
         String dni = sc.nextLine();
         Cliente c = new Cliente(dni);
         if (daoClientes.deleteDatosCLiente(c)){
             System.out.println(Constantes.CLIENTE_ELIMINADO);
         } else {
             System.out.println(Constantes.RETIRA_EL_DINERO_DEL_MONEDERO_ANTES_DE_ELIMINAR_CLIENTE);
         }
     }

}
