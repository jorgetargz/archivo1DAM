package dao;

import modelo.Cliente;

import java.util.HashSet;;
import java.util.List;
import java.util.stream.Collectors;

public class DaoClientes {
    private final HashSet<Cliente> clientes = new HashSet<>();

    public boolean addCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    public void setNombreCliente(Cliente cliente, String nombre) {
        cliente.setNombre(nombre);
    }

    public boolean deleteCLiente(Cliente cliente) {
        return clientes.remove(cliente);
    }

    public List<Cliente> getClientList() {
        return clientes.stream().collect(Collectors.toUnmodifiableList());
    }
}
