package dao;

import modelo.Cliente;
import modelo.ClienteEspecial;
import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BD {

    public static final ArrayList<Cliente> clientes = new ArrayList<>();
    public static final ArrayList<Producto> inventario = new ArrayList<>();

    static {
        inventario.add(new Producto("Jabon",2.5,5));
        inventario.add(new Producto("Champu",3.5,15));
        inventario.add(new Producto("Gel",1.5,12));

        inventario.add(new ProductoCaducable("Chocolate",2.3,2, LocalDateTime.now().plusMinutes(5)));
        inventario.add(new ProductoCaducable("Tacos",1.3,12, LocalDateTime.now().minusMinutes(30)));
        inventario.add(new ProductoCaducable("Pizza",3.3,22, LocalDateTime.now().plusMinutes(30)));

        clientes.add(new Cliente("123","Jaime",100));
        clientes.add(new Cliente("124","Jorge",150));
        clientes.add(new Cliente("125","Juan",200));
        clientes.add(new ClienteEspecial("126","Margarita",250,10));
    }
}
