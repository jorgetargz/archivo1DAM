package services;

import dao.DaoClientes;

public class ServicesClientesEspaciales {

    public boolean scSetDescuentoClientesEspaciales(int porcentajeDescuento) {
        DaoClientes daoClientes = new DaoClientes();
        if (porcentajeDescuento < 90 && porcentajeDescuento > 5) {
            daoClientes.setDescuento(porcentajeDescuento);
            return true;
        } else {
            return false;
        }
    }
}
