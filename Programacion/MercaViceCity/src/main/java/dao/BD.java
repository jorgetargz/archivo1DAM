package dao;

import modelo.Cliente;
import modelo.Producto;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BD {

    public static final LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
    public static final ArrayList<Producto> inventario = new ArrayList<>();

}
