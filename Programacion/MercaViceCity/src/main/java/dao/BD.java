package dao;

import modelo.Cliente;
import modelo.Ingrediente;
import modelo.Producto;
import modelo.ProductoPerecedero;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BD {

    private BD() {
    }

    public static final LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
    public static final ArrayList<Producto> inventario = new ArrayList<>();
    private static int idProduct = 0;

    public static void incrementarId() {
        idProduct++;
    }

    public static int getIdBD() {
        return idProduct;
    }


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
        inventario.add(new ProductoPerecedero(idProduct, "LACASITOS", 12, 11, List.of(new Ingrediente("CACAO")), LocalDateTime.parse("2023-02-16T16:40:00")));
        idProduct++;
        inventario.add(new ProductoPerecedero(idProduct, "HARINA", 25, 100, List.of(new Ingrediente("HARINA")), LocalDateTime.parse("2021-02-13T16:30:00")));
        idProduct++;
        inventario.add(new Producto(idProduct, "HIERBA BUENA", 1.3, 10, List.of(new Ingrediente("HIERBA BUENA"))));
        idProduct++;
        inventario.add(new Producto(idProduct, "CHOCOLATE", 2.5, 15, List.of(new Ingrediente("CACAO"))));
        idProduct++;
        inventario.add(new Producto(idProduct, "AVION TELEDIRIGIDO", 20.5, 15, new ArrayList<>()));

    }

}
