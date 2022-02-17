package services;

import dao.DaoCompras;
import dao.DaoMonederos;
import modelo.Cliente;
import modelo.LineaCompra;
import modelo.ProductoPerecedero;

import java.util.List;

public class ServicesCompras {

    public boolean scAddProductoCompraCliente(Cliente cliente, LineaCompra lineaCompra) {
        DaoCompras daoCompras = new DaoCompras();
        ServicesProductos scProductos = new ServicesProductos();
        ServicesProductosPerecederos scProductosPerecederos = new ServicesProductosPerecederos();
        boolean caducado = false;
        if (lineaCompra.getProducto() instanceof ProductoPerecedero
                && scProductosPerecederos.productoCaducado((ProductoPerecedero) lineaCompra.getProducto())) {
            caducado = true;
        }
        if (scProductos.scExisteProducto(lineaCompra.getProducto())
                && scProductos.scGetProductStock(lineaCompra.getProducto()) >= lineaCompra.getCantidad()
                && !caducado) {
            scProductos.scDisminuirStock(lineaCompra.getProducto(), lineaCompra.getCantidad());
            return daoCompras.addProductoCompra(lineaCompra, cliente);
        }
        return false;
    }

    public boolean scPagarCompra(Cliente cliente) {
        DaoCompras daoCompras = new DaoCompras();
        DaoMonederos daoMonederos = new DaoMonederos();
        ServicesMonederos scMonederos = new ServicesMonederos();
        if (scMonederos.scGetSaldoTotal(cliente) > daoCompras.getCosteCompra(cliente)) {
            daoMonederos.restarDineroMonederos(cliente, daoCompras.getCosteCompra(cliente));
            return daoCompras.realizarCompra(cliente);
        }
        return false;
    }

    public List<LineaCompra> scGetCarrito(Cliente cliente) {
        DaoCompras daoCompras = new DaoCompras();
        return daoCompras.getCarrito(cliente);
    }
}
