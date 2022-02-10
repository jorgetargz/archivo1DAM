package services;

import dao.DaoClientes;
import modelo.Cliente;
import ui.common.Constantes;

import java.util.List;


public class ServicesClientes {

    public boolean scRegistrarCliente(Cliente cliente) {
        DaoClientes daoClientes = new DaoClientes();
        if (!cliente.getDni().equals(Constantes.ADMIN)) {
            return !daoClientes.existeCliente(cliente) &&
                    daoClientes.addCliente(cliente);
        }
        return false;
    }

    public boolean scExisteCliente(String dni){
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.existeCliente(new Cliente(dni));
    }

    public boolean scIsAdmin(Cliente cliente) {
        return cliente.getDni().equals(Constantes.ADMIN);
    }

    public boolean scSetNombre(String dni, String nombre) {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.setNombreCliente(dni, nombre);
    }

    public boolean scEliminarCliente(String dni) {
        DaoClientes daoClientes = new DaoClientes();
        boolean criteriosCorrectos = daoClientes.existeCliente(new Cliente(dni));
        return (criteriosCorrectos &&
                daoClientes.deleteCLiente(dni));
    }

    public List<Cliente> scGetClientList() {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.getClientList();
    }

}
