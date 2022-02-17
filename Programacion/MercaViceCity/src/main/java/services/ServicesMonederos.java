package services;

import dao.DaoMonederos;
import modelo.Cliente;
import modelo.Monedero;

import java.util.List;

public class ServicesMonederos {

    public boolean scExisteMonedero(Monedero monedero) {
        DaoMonederos daoMonederos = new DaoMonederos();
        return daoMonederos.existeMonedero(monedero);
    }

    public boolean scAnadirMonedero(Monedero monedero, Cliente cliente) {
        DaoMonederos daoMonederos = new DaoMonederos();
        if (!daoMonederos.existeMonedero(monedero)
                && monedero.getNumeroMonedero() > 0
                && monedero.getImporte() > 0) {
            return daoMonederos.addMonederoCliente(monedero, cliente);
        }
        return false;
    }

    public double scGetSaldoTotal(Cliente cliente) {
        DaoMonederos daoMonederos = new DaoMonederos();
        return daoMonederos.getSaldoTotal(cliente);
    }

    public List<Monedero> scGetListaMonederosCliente(Cliente cliente) {
        DaoMonederos daoMonederos = new DaoMonederos();
        return daoMonederos.getMonederosClienteList(cliente);
    }
}
