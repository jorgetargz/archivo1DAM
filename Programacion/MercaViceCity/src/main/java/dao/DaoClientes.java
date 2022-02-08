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

    public boolean setNombreCliente(Cliente c, String nombre) {
        boolean clienteEncontrado = BD.clientes.containsValue(c);
        BD.clientes.values().forEach(cliente -> {
            if (cliente.getDni().equalsIgnoreCase(c.getDni())) {
                cliente.setNombre(nombre);
            }
        });
        return clienteEncontrado;
    }

    public List<Cliente> getClientList() {
        return BD.clientes.values().stream().
                map(cliente -> new Cliente(cliente.getDni(), cliente.getNombre(),cliente.getMonederosCliente(),cliente.getCompraActual(),cliente.getComprasCliente())).
                collect(Collectors.toUnmodifiableList());
    }
}
