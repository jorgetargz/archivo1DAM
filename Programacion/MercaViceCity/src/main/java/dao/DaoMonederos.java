package dao;

import modelo.Cliente;
import modelo.Monedero;

import java.util.List;
import java.util.stream.Collectors;

public class DaoMonederos {

    public boolean addMonederoCliente(Monedero monedero, Cliente cliente) {
        return cliente.getMonederosCliente().add(monedero);
    }

    public boolean existeMonedero(Monedero monedero) {
        boolean existeMonedero = false;
        for (Cliente cliente : BD.clientes.values()) {
            if (cliente.getMonederosCliente().contains(monedero)) {
                existeMonedero = true;
                break;
            }
        }
        return existeMonedero;
    }

    public double getSaldoTotal(Cliente cliente) {
        return cliente.getMonederosCliente().stream().mapToDouble(Monedero::getImporte).sum();
    }

    public List<Monedero> getMonederosClienteList(Cliente cliente) {
        return cliente.getMonederosCliente().stream()
                .map(Monedero::clonar)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean restarDineroMonederos(Cliente cliente, double importe) {
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
