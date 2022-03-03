package services;

import dao.DaoClientes;
import modelo.Cliente;

public class ServiciosClientes {

    public boolean existeCliente(Cliente c){
        DaoClientes daoClientes = new DaoClientes();
        return daoClientes.existeCliente(c);
    }
}
