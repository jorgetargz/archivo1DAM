package dao;

import modelo.Cliente;

import java.util.List;

public class DaoClientes extends DaoBase{

    public List<Cliente> getListaClientesClonada(){
        return getListaInmutableClonada(BD.clientes);
    }

    public boolean existeCliente(Cliente c) {
        return BD.clientes.contains(c);
    }
}
