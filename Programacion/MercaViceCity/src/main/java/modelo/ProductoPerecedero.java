package modelo;

import java.time.LocalDateTime;
import java.util.List;

public class ProductoPerecedero extends Producto  {

    private final LocalDateTime caducidad;

    public ProductoPerecedero(String nombre, double precio, int stock, List<Ingrediente> ingredientes, LocalDateTime caducidad) {
        super(nombre, precio, stock, ingredientes);
        this.caducidad = caducidad;
    }

    public ProductoPerecedero(int id, String nombre, double precio, int stock, List<Ingrediente> ingredientes, LocalDateTime caducidad) {
        super(id, nombre, precio, stock, ingredientes);
        this.caducidad = caducidad;
    }

    public LocalDateTime getCaducidad() {
        return caducidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Caducidad=" + caducidad;
    }

    @Override
    public ProductoPerecedero clonar() {
        return new ProductoPerecedero(super.getId(),super.getNombre(),super.getPrecio(),
                super.getStock(),super.getIngredientes(),this.caducidad);
    }
}
