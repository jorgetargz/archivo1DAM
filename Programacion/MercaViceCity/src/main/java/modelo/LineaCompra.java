package modelo;

import dao.BD;
import modelo.common.Constantes;

public class LineaCompra implements Clonable<LineaCompra> {

    private Producto producto;
    private int cantidad;

    public LineaCompra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.producto.setId(BD.inventario.get(BD.inventario.indexOf(producto)).getId());
        this.producto.setNombre(BD.inventario.get(BD.inventario.indexOf(producto)).getNombre());
        this.producto.setPrecio(BD.inventario.get(BD.inventario.indexOf(producto)).getPrecio());
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        String nombreMostrar = producto.getNombre().toLowerCase();
        nombreMostrar = nombreMostrar.substring(0, 1).toUpperCase().concat(nombreMostrar.substring(1));
        return producto.getId() + Constantes.PUNTO +
                nombreMostrar +
                Constantes.PRECIO + producto.getPrecio() +
                Constantes.CANTIDAD + cantidad;
    }

    @Override
    public LineaCompra clonar() {
        return new LineaCompra(this.producto,this.cantidad);
    }
}
