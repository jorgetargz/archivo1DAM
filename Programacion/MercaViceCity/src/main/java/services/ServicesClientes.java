package services;

import dao.DaoClientes;
import modelo.Cliente;
import modelo.Ingrediente;
import ui.common.Constantes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ServicesClientes {

    public boolean scRegistrarCliente(Cliente cliente) {
        DaoClientes daoClientes = new DaoClientes();
        if (!cliente.getDni().equals(Constantes.ADMIN)) {
            return !daoClientes.existeCliente(cliente) &&
                    daoClientes.addCliente(cliente);
        }
        return false;
    }

    public boolean scExisteCliente(Cliente cliente) {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.existeCliente(cliente);
    }

    public boolean scIsAdmin(Cliente cliente) {
        return cliente.getDni().equals(Constantes.ADMIN);
    }

    public boolean scSetNombre(Cliente cliente, String nombre) {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.setNombreCliente(cliente, nombre);
    }

    public String scGetNombre(Cliente cliente) {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.getNombreCliente(cliente);
    }

    public boolean scEliminarCliente(Cliente cliente) {
        DaoClientes daoClientes = new DaoClientes();
        boolean criteriosCorrectos = daoClientes.existeCliente(cliente);
        return (criteriosCorrectos &&
                daoClientes.deleteCLiente(cliente));
    }

    public List<Cliente> scGetClientList() {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.getClientList()
                .stream().sorted(Comparator.comparing(Cliente::getDni))
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean scAnadirAlergeno(Ingrediente alergeno, Cliente cliente) {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.anadirAlergeno(alergeno, cliente);
    }
}
