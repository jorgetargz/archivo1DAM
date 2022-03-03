package main;

import dao.BD;
import modelo.Cliente;
import services.ServiciosClientes;

import java.util.Scanner;

public class UILogin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opLogin;
        do {
            System.out.println("0.Salir");
            System.out.println("1.Iniciar sesión");
            System.out.println("2.Ver calculo dinero gastado por cliente y producto");
            System.out.print("Indica una opción: ");
            opLogin = sc.nextInt();
            sc.nextLine();
            if (opLogin == 1) {
                UICliente uiCliente = new UICliente();
                ServiciosClientes scClientes = new ServiciosClientes();
                System.out.println("Indica tu dni: ");
                String dni = sc.nextLine();
                Cliente cliente = new Cliente(dni);
                if (scClientes.existeCliente(cliente)){
                    Cliente clienteBD = BD.clientes.get(BD.clientes.indexOf(new Cliente(dni)));
                    uiCliente.menuCliente(clienteBD);
                }
            }
            if (opLogin == 2) {
                UIEstadisticas uiEstadisticas = new UIEstadisticas();
                uiEstadisticas.uiVerGastoEnProductoPorCliente();
            }
        } while (opLogin != 0);
    }
}
