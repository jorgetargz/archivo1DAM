package dao;

import modelo.Cliente;
import modelo.LineaCompra;

import java.util.List;
import java.util.stream.Collectors;

public class DaoCompras {

    public boolean addProductoCompra(LineaCompra lineaCompra, Cliente cliente) {
        return BD.clientes.get(cliente.getDni()).getCompraActual().add(lineaCompra);
    }

    public double getCosteCompra(Cliente cliente) {
        return BD.clientes.get(cliente.getDni()).getCompraActual().
                stream().mapToDouble(lineaCompra -> lineaCompra.getProducto().getPrecio() * lineaCompra.getCantidad()).sum();
    }

    public boolean realizarCompra(Cliente cliente) {
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
