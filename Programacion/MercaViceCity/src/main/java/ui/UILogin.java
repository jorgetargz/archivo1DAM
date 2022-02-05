package ui;

import services.ServicesClientes;
import ui.common.Constantes;

import java.util.Scanner;

public class UILogin {

    private final ServicesClientes scClientes = new ServicesClientes();

    public void menuLogin(Scanner sc) {
        int opLogin = 0;
        do {
            System.out.println(Constantes.SALIR);
            System.out.println(Constantes.REGISTRARSE);
            System.out.println(Constantes.INICIAR_SESION);
            System.out.print(Constantes.ELIGE_UNA_OPCION);
            opLogin = sc.nextInt();
            sc.nextLine();
            if (opLogin == 1) this.uiRegistrarCliente(sc);
            if (opLogin == 2) this.uiIniciarCliente(sc);
        } while (opLogin != 0);
    }

    public void uiRegistrarCliente(Scanner sc) {
        String dni;
        System.out.println();
        System.out.print(Constantes.INDICA_TU_DNI);
        dni = sc.nextLine();
        if (scClientes.registrarCliente(dni)) {
            uiSetNombreCliente(sc, dni);
            System.out.println(Constantes.REGISTRADO_CORRECTAMENTE);
        } else System.out.println(Constantes.DNI_YA_REGISTRADO);
    }

    public void uiIniciarCliente(Scanner sc) {
        System.out.println();
        System.out.print(Constantes.INDICA_TU_DNI);
        String dni = sc.nextLine();
        if (scClientes.registrarCliente(dni)) {
            System.out.println(Constantes.REGISTRARSE_COMO_CLIENTE);
            uiSetNombreCliente(sc, dni);
            System.out.println(Constantes.REGISTRADO_CORRECTAMENTE);
        }
        System.out.println(Constantes.SESION_INICIADA);
        UICliente uiCliente = new UICliente();
        uiCliente.menuCliente(dni);
    }

    private void uiSetNombreCliente(Scanner sc, String dni) {
        String nombre;
        System.out.print(Constantes.PORFAVOR_INDICA_TU_NOMBRE);
        nombre = sc.nextLine();
        scClientes.setNombre(dni, nombre);
    }
}
