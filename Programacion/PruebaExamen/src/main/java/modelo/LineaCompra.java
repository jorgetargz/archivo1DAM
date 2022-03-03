package modelo;

public class LineaCompra implements Clonable<LineaCompra> {

    private Producto producto;
    private int cantidad;

    public LineaCompra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public LineaCompra clonar() {
        return new LineaCompra(this.producto,this.cantidad);
    }
}
