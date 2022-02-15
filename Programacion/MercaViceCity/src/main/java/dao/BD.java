package dao;

import modelo.Cliente;
import modelo.Producto;
import modelo.ProductoPerecedero;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BD {

    private BD() {
    }

    static final LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
    static final ArrayList<Producto> inventario = new ArrayList<>();
    static int idProduct = 0;


    static {

        clientes.put("123", new Cliente("123"));
        clientes.get("123").setNombre("Javier");
        clientes.put("124", new Cliente("124"));
        clientes.get("124").setNombre("Francisco");
        clientes.put("125", new Cliente("125"));
        clientes.get("125").setNombre("Lucas");
        clientes.put("126", new Cliente("126"));
        clientes.get("126").setNombre("Federico García Lorca");

        idProduct++;
        inventario.add(new ProductoPerecedero(idProduct, "LACASITOS", 12, 11, LocalDateTime.parse("2022-02-16T16:40:00")));
        idProduct++;
        inventario.add(new ProductoPerecedero(idProduct, "HARINA", 25, 100, LocalDateTime.parse("2021-02-13T16:30:00")));
        idProduct++;
        inventario.add(new Producto(idProduct, "HIERBA BUENA", 1.3, 10));
        idProduct++;
        inventario.add(new Producto(idProduct, "CHOCOLATE", 2.5, 15));

    }

}
