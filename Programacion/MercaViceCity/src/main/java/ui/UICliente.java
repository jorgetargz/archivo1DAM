package ui;

import services.ServicesClientes;
import ui.common.Constantes;

import java.util.Scanner;

public class UICliente {

    private final ServicesClientes scClientes = new ServicesClientes();

    public void menuCliente(String dni) {
        System.out.print(Constantes.BIENVENIDO_DE_NUEVO);
        uiClientName(dni);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int opCliente;
        do {
            System.out.println();
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ELIGE_UNA_OPCION);
            opCliente = sc.nextInt();
            sc.nextLine();
            switch (opCliente) {
                case 0:
                    break;
                default:
                    System.out.println(Constantes.ERROR_ENTRADA_DE_MENU_NO_VALIDA);
            }
        } while (opCliente != 0);
    }

    private void uiClientName(String dni) {
        scClientes.getClientList().forEach(cliente -> {
            if (cliente.getDni().equals(dni)) {
                System.out.print(cliente.getNombre());
            }
        });
    }

}
