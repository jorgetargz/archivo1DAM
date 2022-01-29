package ui;

import common.Constantes;
import dao.DaoClientes;
import modelo.Cliente;

import java.util.Scanner;

public class UILogin {

    public Cliente menuLogin(Scanner sc, DaoClientes daoClientes) {
        System.out.println(Constantes.BIENVENIDO_A_MERCA_VICE_CITY);
        System.out.println(Constantes.ASCII_ART);
        int opLogin;
        Cliente cliente = null;
        do {
            System.out.println(Constantes.REGISTRARSE);
            System.out.println(Constantes.INICIAR_SESION);
            System.out.print(Constantes.ELIGE_UNA_OPCION);
            opLogin = sc.nextInt();
            sc.nextLine();
            if (opLogin == 1) cliente = this.registrarCliente(sc, daoClientes);
            if (opLogin == 2) cliente = this.iniciarCliente(sc, daoClientes);
        } while (cliente == null);
        return cliente;
    }

    public Cliente registrarCliente(Scanner sc, DaoClientes daoClientes) {
        boolean dniRegistrado;
        String dni;
        String nombre;
        Cliente cliente = null;
        System.out.println(Constantes.REGISTRARSE_COMO_CLIENTE);
        do {
            System.out.println(Constantes.INDICA_TU_DNI_O_REINICIA_PARA_VOLVER_AL_MENU_PRINCIPAL);
            dni = sc.nextLine();
            if (dni.equals(Constantes.ADMIN)) {
                dniRegistrado = false;
            } else {
                cliente = new Cliente(dni);
                dniRegistrado = daoClientes.addCliente(cliente);
            }
            if (dniRegistrado) {
                setNombreCliente(sc, daoClientes, cliente);
            } else System.out.println(Constantes.DNI_YA_REGISTRADO);
        } while (!dniRegistrado);
        return cliente;
    }

    public Cliente iniciarCliente(Scanner sc, DaoClientes daoClientes) {
        boolean dniRegistrado = true;
        String nombre;
        System.out.println(Constantes.INICIAR_SESIÓN);
        System.out.println(Constantes.INDICA_TU_DNI_O_REINICIA_PARA_VOLVER_AL_MENU_PRINCIPAL);
        String dni = sc.nextLine();
        Cliente cliente = new Cliente(dni);
        if (!dni.equals(Constantes.ADMIN)) {
            dniRegistrado = daoClientes.addCliente(cliente);
        }
        if (dniRegistrado) {
            System.out.println("DNI no registrado iniciando el proceso de registro. ");
            setNombreCliente(sc, daoClientes, cliente);
        }
        return cliente;
    }

    private void setNombreCliente(Scanner sc, DaoClientes daoClientes, Cliente cliente) {
        String nombre;
        System.out.println(Constantes.PORFAVOR_INDICA_TU_NOMBRE);
        nombre = sc.nextLine();
        daoClientes.setNombreCliente(cliente, nombre);
    }

    public boolean isAdmin(Cliente cliente) {
        return cliente.equals(new Cliente(Constantes.ADMIN));
    }
}
