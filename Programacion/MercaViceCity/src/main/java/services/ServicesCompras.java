package services;

import dao.BD;
import dao.DaoClientes;
import dao.DaoCompras;
import dao.DaoMonederos;
import modelo.Cliente;
import modelo.ClienteEspacial;
import modelo.LineaCompra;
import modelo.ProductoPerecedero;

import java.util.List;

public class ServicesCompras {

    public boolean scAddProductoCompraCliente(Cliente cliente, LineaCompra lineaCompra) {
        DaoCompras daoCompras = new DaoCompras(BD.clientes);
        ServicesProductos scProductos = new ServicesProductos();
        ServicesProductosPerecederos scProductosPerecederos = new ServicesProductosPerecederos();
        boolean caducado = lineaCompra.getProducto() instanceof ProductoPerecedero
                && scProductosPerecederos.productoCaducado((ProductoPerecedero) lineaCompra.getProducto());
        if (scProductos.scExisteProducto(lineaCompra.getProducto())
                && scProductos.scGetProductStock(lineaCompra.getProducto()) >= lineaCompra.getCantidad()
                && !scProductos.scContieneAlergenos(lineaCompra.getProducto(), cliente)
                && !caducado) {
            scProductos.scDisminuirStock(lineaCompra.getProducto(), lineaCompra.getCantidad());
            return daoCompras.addProductoCompra(lineaCompra, cliente);
        }
        return false;
    }

    public boolean scPagarCompra(Cliente cliente) {
        DaoCompras daoCompras = new DaoCompras(BD.clientes);
        DaoMonederos daoMonederos = new DaoMonederos();
        DaoClientes daoClientes = new DaoClientes();
        ServicesMonederos scMonederos = new ServicesMonederos();
        double costeCompra;
        if (cliente instanceof ClienteEspacial) {
            costeCompra = daoCompras.getCosteCompra(cliente)
                    - (((double) daoClientes.getDescuento() / 100) * daoCompras.getCosteCompra(cliente));
        } else {
            costeCompra = daoCompras.getCosteCompra(cliente);
        }
        return (scMonederos.scGetSaldoTotal(cliente) > costeCompra)
                && daoMonederos.restarDineroMonederos(cliente, costeCompra)
                && daoCompras.guardarCompraLimpiarCarrito(cliente);
    }

    public List<LineaCompra> scGetCarrito(Cliente cliente) {
        DaoCompras daoCompras = new DaoCompras(BD.clientes);
        return daoCompras.getCarrito(cliente);
    }

}
