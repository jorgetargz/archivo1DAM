package services;

import dao.DaoClientes;
import modelo.Cliente;
import ui.UIAdmin;
import ui.common.Constantes;

import java.util.List;


public class ServicesClientes {

    private final DaoClientes daoClientes = new DaoClientes();


    public boolean registrarCliente(String dni) {
        Cliente cliente = new Cliente(dni);
        if (dni.equals(Constantes.ADMIN)) {
            UIAdmin uiAdmin = new UIAdmin();
            uiAdmin.menuAdmin();
        } else if (!this.existeCliente(cliente)) {
            daoClientes.addCliente(cliente);
            return true;
        }
        return false;
    }

    public void setNombre(String dni, String nombre) {
        daoClientes.setNombreCliente(new Cliente(dni), nombre);
    }

    public boolean eliminarCliente(String dni) {
        boolean criteriosCorrectos = this.existeCliente(new Cliente(dni));
        if (criteriosCorrectos) {
            daoClientes.deleteCLiente(dni);
        }
        return criteriosCorrectos;
    }

    public List<Cliente> getClientList() {
        return daoClientes.getClientList();
    }

    public boolean existeCliente(Cliente c) {
        return daoClientes.getClientList().contains(c);
    }
}
