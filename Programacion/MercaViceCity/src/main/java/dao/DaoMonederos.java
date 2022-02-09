package dao;

import modelo.Cliente;
import modelo.Monedero;

import java.util.List;
import java.util.stream.Collectors;

public class DaoMonederos {

    public boolean addMonederoCliente(Monedero monedero, String dni) {
        return BD.clientes.get(dni).getMonederosCliente().add(monedero);
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

    public double getSaldoTotal(String dni) {
        return BD.clientes.get(dni).getMonederosCliente().stream().mapToDouble(Monedero::getImporte).sum();
    }

    public List<Monedero> getMonederosClienteList(String dni) {
        return BD.clientes.get(dni).getMonederosCliente().stream()
                .map(monedero -> new Monedero(monedero.getNumeroMonedero(), monedero.getImporte()))
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean restarDineroMonederos(String dni, double importe) {
        Cliente cliente = BD.clientes.get(dni);
        if (getSaldoTotal(dni) >= importe) {
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
