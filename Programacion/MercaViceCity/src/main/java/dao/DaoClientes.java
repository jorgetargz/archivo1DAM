package dao;

import modelo.Cliente;

import java.util.LinkedHashSet;

public class DaoClientes {
    private LinkedHashSet<Cliente> clientes;

    public DaoClientes() {
        clientes = new LinkedHashSet<>();
    }

    public boolean addCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    public void setNombreCliente(Cliente cliente, String nombre) {
        cliente.setNombre(nombre);
    }

    public boolean deleteDatosCLiente(Cliente cliente) {
        if (cliente.getMonedero() == 0) {
            cliente.deleteDni();
            cliente.setNombre(null);
            cliente.setMonedero(0);
            return true;
        }
        return false;
    }

    public String getClientList() {
        StringBuilder listaCLientes = new StringBuilder();
        clientes.forEach(cliente -> listaCLientes.append(cliente.toString()).append("\n"));
        return listaCLientes.toString();
    }

    public boolean addDinero(Cliente cliente, double cantidad) {
        boolean cantidadCorrecta = cantidad > 0;
        if (cantidadCorrecta) cliente.setMonedero(cliente.getMonedero() + cantidad);
        return cantidadCorrecta;
    }

    public boolean restarDinero(Cliente cliente, double cantidad) {
        double saldoFinal = cliente.getMonedero() - cantidad;
        boolean cantidadCorrecta = cantidad > 0 && saldoFinal >= 0;
        if (cantidadCorrecta) cliente.setMonedero(saldoFinal);
        return cantidadCorrecta;
    }


}
