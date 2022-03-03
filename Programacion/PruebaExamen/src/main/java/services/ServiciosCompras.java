package services;

import dao.DaoCompras;
import modelo.Cliente;
import modelo.ClienteEspecial;
import modelo.LineaCompra;
import modelo.ProductoCaducable;

import java.util.Collection;

public class ServiciosCompras {

    public boolean addProductoCompraCliente(Cliente cliente, LineaCompra lineaCompra) {
        DaoCompras daoCompras = new DaoCompras();
        ServiciosProductos scProductos = new ServiciosProductos();
        boolean caducado = lineaCompra.getProducto() instanceof ProductoCaducable
                && scProductos.productoCaducado((ProductoCaducable) lineaCompra.getProducto());
        if (scProductos.existeProducto(lineaCompra.getProducto())
                && scProductos.getProductStock(lineaCompra.getProducto()) >= lineaCompra.getCantidad()
                && !caducado) {
            scProductos.disminuirStock(lineaCompra.getProducto(), lineaCompra.getCantidad());
            return daoCompras.addProductoCompra(lineaCompra, cliente);
        }
        return false;
    }

    public boolean realizarCompra(Cliente clienteBD) {
        DaoCompras daoCompras = new DaoCompras();
        double costeCompra;
        if (clienteBD instanceof ClienteEspecial) {
            costeCompra = daoCompras.getCosteCompra(clienteBD)
                    - (((double) ((ClienteEspecial) clienteBD).getPorcentajeDescuento() / 100)
                        * daoCompras.getCosteCompra(clienteBD));
        } else {
            costeCompra = daoCompras.getCosteCompra(clienteBD);
        }
        if (clienteBD.getMonedero() > costeCompra && daoCompras.guardarCompraLimpiarCarrito(clienteBD)){
            clienteBD.quitarDinero(costeCompra);
            return true;
        } else {
            return false;
        }
    }

    public double getDineroGastadoEnUnProductoPorUnCliente(Cliente clienteBD, String nombreProducto){
        return clienteBD.getComprasRealizadas().stream().flatMap(Collection::stream)
                .filter(lineaCompra -> lineaCompra.getProducto().getNombre().equalsIgnoreCase(nombreProducto))
                .mapToDouble(lineaCompra -> lineaCompra.getProducto().getPrecio() * lineaCompra.getCantidad()).sum();
    }
}
