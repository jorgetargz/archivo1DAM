package dao;

import modelo.Cliente;
import modelo.Producto;

import java.util.List;
import java.util.stream.Collectors;

public class DaoCompras {

    public boolean addProductoCompra(Producto producto, String dni) {
        Cliente cliente = BD.clientes.get(dni);
        return cliente.getCompraActual().add(producto);
    }

    public double getCosteCompra(String dni) {
        Cliente cliente = BD.clientes.get(dni);
        return cliente.getCompraActual().
                stream().mapToDouble(producto -> (producto.getPrecio() * producto.getStock())).sum();
    }

    public boolean pagarCompra(String dni) {
        DaoMonederos daoMonederos = new DaoMonederos();
        Cliente cliente = BD.clientes.get(dni);
        if (daoMonederos.restarDineroMonederos(dni, getCosteCompra(dni))) {
            List<Producto> ticket = cliente.getCompraActual().stream()
                    .map(producto -> new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock()))
                    .collect(Collectors.toUnmodifiableList());
            cliente.getCompraActual().clear();
            return cliente.getComprasCliente().add(ticket);
        }
        return false;
    }

    public List<Producto> getCarrito(String dni){
        Cliente cliente = BD.clientes.get(dni);
        return cliente.getCompraActual().stream()
                .map(producto -> new Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }

}
