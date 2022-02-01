package services;

import common.Constantes;
import dao.DaoClientes;
import modelo.Cliente;
import ui.UIAdmin;

import java.util.List;


public class ServicesClientes {

    private final DaoClientes daoClientes = new DaoClientes();


    public boolean registrarCliente(String dni){
        if (dni.equals(Constantes.ADMIN)) {
            UIAdmin uiAdmin = new UIAdmin();
            uiAdmin.menuAdmin();
        } else {
            Cliente cliente = new Cliente(dni);
            return daoClientes.addCliente(cliente);
        }
        return false;
    }

    public void setNombre(String dni, String nombre){
        Cliente cliente = new Cliente(dni);
        daoClientes.setNombreCliente(cliente,nombre);
    }

    public List<Cliente> getClientList(){
        return daoClientes.getClientList();
    }

    public boolean eliminarCliente(String dni){
        Cliente c = new Cliente(dni);
        return daoClientes.deleteCLiente(c);
    }
}
