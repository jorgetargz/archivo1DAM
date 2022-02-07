package dao;

import modelo.Cliente;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;


public class DaoClientes {

    private static final LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

    public boolean addCliente(Cliente cliente) {
        return clientes.put(cliente.getDni(), cliente) == null;
    }

    public boolean deleteCLiente(String dni) {
        return clientes.remove(dni) == null;
    }

    public boolean existeCliente(Cliente c) {
        return clientes.containsValue(c);
    }

    public boolean setNombreCliente(Cliente c, String nombre) {
        boolean clienteEncontrado = clientes.containsValue(c);
        clientes.values().forEach(cliente -> {
            if (cliente.getDni().equalsIgnoreCase(c.getDni())) {
                cliente.setNombre(nombre);
            }
        });
        return clienteEncontrado;
    }

    public List<Cliente> getClientList() {
        return clientes.values().stream().
                map(cliente -> new Cliente(cliente.getDni(), cliente.getNombre())).
                collect(Collectors.toUnmodifiableList());
    }
}
