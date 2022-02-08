package dao;

import modelo.Cliente;
import modelo.Monedero;

public class DaoMonedero {

    public boolean addMonederoCliente(Monedero monedero, String dni) {
        DaoClientes daoClientes = new DaoClientes();
        Cliente c = new Cliente(dni);
        if (daoClientes.existeCliente(c)) {
            BD.clientes.values().forEach(cliente -> {
                if (cliente.getDni().equals(dni)) {
                    cliente.getMonederosCliente().add(monedero);
                }
            });
            return true;
        }
        return false;
    }

    public double getSaldoTotal(Cliente cliente) {
        double saldoTotal = 0;
        for (Monedero monedero : cliente.getMonederosCliente()) {
            saldoTotal += monedero.getImporte();
        }
        return saldoTotal;
    }

    public boolean restarDineroMonederos(String dni, double importe) {
        Cliente cliente = BD.clientes.get(dni);
        if (getSaldoTotal(cliente) >= importe) {
            for (Monedero monedero : cliente.getMonederosCliente()) {
                if (monedero.getImporte() >= 0) {
                    monedero.setImporte(monedero.getImporte() - importe);
                }
                if (monedero.getImporte() < 0) {
                    importe = Math.abs(monedero.getImporte());
                    monedero.setImporte(0);
                } else {
                    importe = 0;
                }
            }
        }
        return importe == 0;
    }

}
