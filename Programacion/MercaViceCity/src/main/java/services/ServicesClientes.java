package services;

import dao.DaoClientes;
import modelo.Cliente;
import ui.UIAdmin;
import ui.common.Constantes;

import java.util.List;


public class ServicesClientes {

    public boolean registrarCliente(Cliente cliente) {
        DaoClientes daoClientes = new DaoClientes();
        if (cliente.getDni().equals(Constantes.ADMIN)) {
            UIAdmin uiAdmin = new UIAdmin();
            uiAdmin.menuAdmin();
        } else return !daoClientes.existeCliente(cliente) &&
                daoClientes.addCliente(cliente);
        return false;
    }

    public boolean setNombre(String dni, String nombre) {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.setNombreCliente(new Cliente(dni), nombre);
    }

    public boolean eliminarCliente(String dni) {
        DaoClientes daoClientes = new DaoClientes();
        boolean criteriosCorrectos = daoClientes.existeCliente(new Cliente(dni));
        return  (criteriosCorrectos &&
                daoClientes.deleteCLiente(dni));
    }

    public List<Cliente> getClientList() {
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.getClientList();
    }

}
