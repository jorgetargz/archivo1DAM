package services;

import dao.DaoMonederos;
import modelo.Monedero;

import java.util.List;

public class ServicesMonederos {

    public boolean scExisteMonedero(Monedero monedero) {
        DaoMonederos daoMonederos = new DaoMonederos();
        return daoMonederos.existeMonedero(monedero);
    }

    public boolean scAnadirMonedero(Monedero monedero, String dni) {
        DaoMonederos daoMonederos = new DaoMonederos();
        if (!daoMonederos.existeMonedero(monedero)
                && monedero.getNumeroMonedero() > 0
                && monedero.getImporte() > 0) {
            return daoMonederos.addMonederoCliente(monedero, dni);
        }
        return false;
    }

    public double scGetSaldoTotal(String dni){
        DaoMonederos daoMonederos = new DaoMonederos();
        return daoMonederos.getSaldoTotal(dni);
    }

    public List<Monedero> scGetListaMonederosCliente(String dni) {
        DaoMonederos daoMonederos = new DaoMonederos();
        return daoMonederos.getMonederosClienteList(dni);
    }
}
