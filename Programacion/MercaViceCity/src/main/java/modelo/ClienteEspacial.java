package modelo;

import java.util.List;
import java.util.Set;

public class ClienteEspacial extends Cliente {

    private int porcentajeDescuento;

    public ClienteEspacial(String dni) {
        super(dni);
    }

    public ClienteEspacial(String dni, String nombre, Set<Monedero> monederoCliente,
                           List<LineaCompra> compraActual,
                           List<List<LineaCompra>> comprasCliente,
                           List<Ingrediente> alergenos,
                           int porcentajeDescuento) {
        super(dni, nombre, monederoCliente, compraActual, comprasCliente, alergenos);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public ClienteEspacial clonar() {
        return new ClienteEspacial(super.getDni(), super.getNombre(), super.getMonederosCliente(),
                super.getCompraActual(), super.getComprasCliente(),
                super.getAlergenos(), this.porcentajeDescuento);
    }
}
