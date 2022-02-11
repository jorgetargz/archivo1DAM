package services;

import dao.DaoCompras;
import dao.DaoMonederos;
import modelo.Producto;

import java.util.List;

public class ServicesCompras {

    public boolean scAddProductoCompraCliente(String dni, int idProducto, int cantidad) {
        DaoCompras daoCompras = new DaoCompras();
        ServicesProductos scProductos = new ServicesProductos();
        if (scProductos.scExisteProducto(idProducto )
                && scProductos.scGetProductStock(idProducto) >= cantidad) {
            scProductos.scDisminuirStock(idProducto, cantidad);
            String nombreProducto = scProductos.scGetProductName(idProducto);
            double precioProducto = scProductos.scGetProductPrize(idProducto);
            return daoCompras.addProductoCompra(new Producto(idProducto, nombreProducto, precioProducto, cantidad), dni);
        }
        return false;
    }

    public boolean scPagarCompra(String dni) {
        DaoCompras daoCompras = new DaoCompras();
        DaoMonederos daoMonederos = new DaoMonederos();
        if (daoMonederos.restarDineroMonederos(dni,daoCompras.getCosteCompra(dni))) {
            return daoCompras.realizarCompra(dni);
        }
        return false;
    }

    public List<Producto> scGetCarrito(String dni) {
        DaoCompras daoCompras = new DaoCompras();
        return daoCompras.getCarrito(dni);
    }
}
