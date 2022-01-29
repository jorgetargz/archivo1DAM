package ui;

import dao.DaoClientes;
import dao.DaoProductos;
import modelo.Cliente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UILogin uiLogin = new UILogin();
        DaoClientes daoClientes = new DaoClientes();
        DaoProductos daoProductos = new DaoProductos();

        Cliente usuario = uiLogin.menuLogin(sc, daoClientes);

        if (uiLogin.isAdmin(usuario)) {
            UIAdmin uiAdmin = new UIAdmin();
            uiAdmin.menuAdmin(sc, daoClientes, daoProductos);
        } else {
            UICliente uiCliente = new UICliente();
        }

    }
}
