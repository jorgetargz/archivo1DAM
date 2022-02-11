package dao;

import modelo.Cliente;

import java.util.List;
import java.util.stream.Collectors;


public class DaoClientes {

    public boolean addCliente(Cliente cliente) {
        return BD.clientes.put(cliente.getDni(), cliente) == null;
    }

    public boolean deleteCLiente(String dni) {
        return BD.clientes.remove(dni) == null;
    }

    public boolean existeCliente(Cliente c) {
        return BD.clientes.containsValue(c);
    }

    public boolean setNombreCliente(String dni, String nombre) {
        BD.clientes.get(dni).setNombre(nombre);
        return BD.clientes.get(dni) != null;
    }

    public String getNombreCliente(String dni) {
        return BD.clientes.get(dni).getNombre();
    }

    public List<Cliente> getClientList() {
        return BD.clientes.values().stream().
                map(cliente -> new Cliente(cliente.getDni(), cliente.getNombre())).
                collect(Collectors.toUnmodifiableList());
    }
}
