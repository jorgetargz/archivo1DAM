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
        boolean caducado = lineaCompra.getProducto() instanceof ProductoPerecedero
                && scProductosPerecederos.productoCaducado((ProductoPerecedero) lineaCompra.getProducto());
        if (scProductos.scExisteProducto(lineaCompra.getProducto())
                && scProductos.scGetProductStock(lineaCompra.getProducto()) >= lineaCompra.getCantidad()
                && !scProductos.scContieneAlergenos(lineaCompra.getProducto(),cliente)
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
        return (scMonederos.scGetSaldoTotal(cliente) > daoCompras.getCosteCompra(cliente))
                && daoMonederos.restarDineroMonederos(cliente, daoCompras.getCosteCompra(cliente))
                && daoCompras.realizarCompra(cliente);
    }


    public List<LineaCompra> scGetCarrito(Cliente cliente) {
        DaoCompras daoCompras = new DaoCompras();
        return daoCompras.getCarrito(cliente);
    }
}
