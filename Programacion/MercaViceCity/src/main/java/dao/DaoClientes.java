package dao;

import modelo.Cliente;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;


public class DaoClientes {

    private static final LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();

    public void addCliente(Cliente cliente) {
        clientes.put(cliente.getDni(),cliente);
    }

    public void deleteCLiente(String dni) {
        clientes.remove(dni);
    }

    public void setNombreCliente(Cliente c, String nombre) {
        clientes.values().forEach(cliente -> {
            if (cliente.getDni().equalsIgnoreCase(c.getDni())) {
                cliente.setNombre(nombre);
            }
        });
    }

    public List<Cliente> getClientList() {
        return clientes.values().stream().
                map(cliente -> new Cliente(cliente.getDni(),cliente.getNombre())).
                collect(Collectors.toUnmodifiableList());
    }
}
