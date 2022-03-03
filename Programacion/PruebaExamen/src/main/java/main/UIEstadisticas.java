package main;

import dao.BD;
import modelo.Cliente;
import services.ServiciosCompras;

import java.util.Scanner;

public class UIEstadisticas {

    public void uiVerGastoEnProductoPorCliente(){
        ServiciosCompras scCompras = new ServiciosCompras();
        Scanner sc = new Scanner(System.in);
        System.out.print("Indica un nombre de producto:");
        String nombreProducto= sc.nextLine();
        System.out.print("Indica el dni de un cliente:");
        Cliente cliente = new Cliente(sc.nextLine());
        Cliente clienteBD = BD.clientes.get(BD.clientes.indexOf(cliente));
        System.out.println("El cliente con nombre: " + clienteBD.getNombre()
                + " ha gastado " + scCompras.getDineroGastadoEnUnProductoPorUnCliente(clienteBD,nombreProducto)
                + " en el producto " + nombreProducto);
    }
}
