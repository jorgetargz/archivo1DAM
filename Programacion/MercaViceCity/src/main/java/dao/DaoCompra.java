package dao;

import modelo.Cliente;
import modelo.Producto;

public class DaoCompra {

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
        DaoMonedero daoMonedero = new DaoMonedero();
        Cliente cliente = BD.clientes.get(dni);
        if (daoMonedero.restarDineroMonederos(dni, getCosteCompra(dni))) {
            cliente.getComprasCliente().add(cliente.getCompraActual());
            return true;
        }
        return false;
    }
}
