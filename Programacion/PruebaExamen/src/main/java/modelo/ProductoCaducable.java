package modelo;

import java.time.LocalDateTime;

public class ProductoCaducable extends Producto{

    private LocalDateTime caducidad;

    public ProductoCaducable(String nombre, double precio, int stock, LocalDateTime caducidad) {
        super(nombre, precio, stock);
        this.caducidad = caducidad;
    }

    public LocalDateTime getCaducidad() {
        return caducidad;
    }

    @Override
    public Producto clonar() {
        return new ProductoCaducable(super.getNombre(),super.getPrecio(),super.getStock(),this.caducidad);
    }
}
