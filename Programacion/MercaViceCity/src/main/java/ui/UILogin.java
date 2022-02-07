package ui;

import modelo.Cliente;
import services.ServicesClientes;
import ui.common.Constantes;

import java.util.Scanner;

public class UILogin {


    public void menuLogin(Scanner sc) {
        int opLogin;
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
        ServicesClientes scClientes = new ServicesClientes();
        String dni;
        System.out.println();
        System.out.print(Constantes.INDICA_TU_DNI);
        dni = sc.nextLine();
        Cliente cliente = new Cliente(dni);
        if (scClientes.registrarCliente(cliente)) {
            uiSetNombreCliente(sc, dni);
        } else System.out.println(Constantes.DNI_YA_REGISTRADO);
    }

    public void uiIniciarCliente(Scanner sc) {
        ServicesClientes scClientes = new ServicesClientes();
        System.out.println();
        System.out.print(Constantes.INDICA_TU_DNI);
        String dni = sc.nextLine();
        Cliente cliente = new Cliente(dni);
        if (scClientes.registrarCliente(cliente)) {
            System.out.println(Constantes.REGISTRARSE_COMO_CLIENTE);
            uiSetNombreCliente(sc, dni);
        }
        System.out.println(Constantes.SESION_INICIADA);
        UICliente uiCliente = new UICliente();
        uiCliente.menuCliente(dni);
    }

    private void uiSetNombreCliente(Scanner sc, String dni) {
        ServicesClientes scClientes = new ServicesClientes();
        String nombre;
        System.out.print(Constantes.PORFAVOR_INDICA_TU_NOMBRE);
        nombre = sc.nextLine();
        if (scClientes.setNombre(dni, nombre)){
            System.out.println(Constantes.REGISTRADO_CORRECTAMENTE);
        }
    }
}
