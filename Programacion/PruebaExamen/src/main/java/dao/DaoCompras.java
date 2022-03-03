package dao;

import modelo.Cliente;
import modelo.LineaCompra;

import java.util.List;

public class DaoCompras {

    public boolean addProductoCompra(LineaCompra lineaCompra, Cliente clienteBD) {
            return clienteBD.getCarrito().add(lineaCompra);
    }

    public Double getCosteLineaCompra(LineaCompra lineaCompra) {
        return lineaCompra.getProducto().getPrecio() * lineaCompra.getCantidad();
    }

    public double getCosteCompra(Cliente clienteBD) {
        return clienteBD.getCarrito().
                stream().mapToDouble(this::getCosteLineaCompra).sum();
    }

    public boolean guardarCompraLimpiarCarrito(Cliente clienteBD) {
        List<LineaCompra> ticket = clienteBD.getCarritoClonado();
        clienteBD.getCarrito().clear();
        return clienteBD.getComprasRealizadas().add(ticket);
    }


}
