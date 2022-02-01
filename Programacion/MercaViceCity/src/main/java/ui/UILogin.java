package ui;

import ui.common.Constantes;
import services.ServicesClientes;

import java.util.Scanner;

public class UILogin {

    private final ServicesClientes scClientes = new ServicesClientes();

    public void menuLogin(Scanner sc) {
        System.out.println(Constantes.REGISTRARSE);
        System.out.println(Constantes.INICIAR_SESION);
        System.out.print(Constantes.ELIGE_UNA_OPCION);
        int opLogin = sc.nextInt();
        sc.nextLine();
        if (opLogin == 1) this.uiRegistrarCliente(sc);
        if (opLogin == 2) this.uiIniciarCliente(sc);
    }

    public void uiRegistrarCliente(Scanner sc) {
        String dni;
        System.out.println();
        System.out.println(Constantes.INDICA_TU_DNI);
        dni = sc.nextLine();
        if (scClientes.registrarCliente(dni)) {
            uiSetNombreCliente(sc, dni);
        } else System.out.println(Constantes.DNI_YA_REGISTRADO);
    }

    public void uiIniciarCliente(Scanner sc) {
        System.out.println();
        System.out.println(Constantes.INDICA_TU_DNI);
        String dni = sc.nextLine();
        if (scClientes.registrarCliente(dni)) {
            System.out.println(Constantes.REGISTRARSE_COMO_CLIENTE);
            uiSetNombreCliente(sc, dni);
        }
        UICliente uiCliente = new UICliente();
        uiCliente.menuCliente();
    }

    private void uiSetNombreCliente(Scanner sc, String dni) {
        String nombre;
        System.out.println(Constantes.PORFAVOR_INDICA_TU_NOMBRE);
        nombre = sc.nextLine();
        scClientes.setNombre(dni, nombre);
    }
}
