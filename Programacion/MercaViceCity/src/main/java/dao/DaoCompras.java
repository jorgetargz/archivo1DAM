package dao;

import modelo.Cliente;
import modelo.LineaCompra;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaoCompras {

    private Map<String, Cliente> clientes;

    public DaoCompras(Map<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean addProductoCompra(LineaCompra lineaCompra, Cliente cliente) {
        return BD.clientes.get(cliente.getDni()).getCompraActual().add(lineaCompra);
    }

    public double getCosteCompra(Cliente cliente) {
        return BD.clientes.get(cliente.getDni()).getCompraActual().
                stream().mapToDouble(this::getCosteLineaCompra).sum();
    }

    public Double getCosteLineaCompra(LineaCompra lineaCompra) {
        return lineaCompra.getProducto().getPrecio() * lineaCompra.getCantidad();
    }

    public boolean guardarCompraLimpiarCarrito(Cliente cliente) {
        List<LineaCompra> ticket = getCarrito(cliente);
        BD.clientes.get(cliente.getDni()).getCompraActual().clear();
        return cliente.getComprasCliente().add(ticket);
    }

    public List<LineaCompra> getCarrito(Cliente cliente) {
        return BD.clientes.get(cliente.getDni()).getCompraActual().stream()
                .map(LineaCompra::clonar)
                .collect(Collectors.toUnmodifiableList());
    }


}
