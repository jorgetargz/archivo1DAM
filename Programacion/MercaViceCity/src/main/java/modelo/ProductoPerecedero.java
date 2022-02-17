package modelo;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductoPerecedero extends Producto {

    private final LocalDateTime caducidad;

    public ProductoPerecedero(String nombre, double precio, int stock, LocalDateTime caducidad) {
        super(nombre,precio,stock);
        this.caducidad = caducidad;
    }

    public ProductoPerecedero(int id, String nombre, double precio, int stock, LocalDateTime caducidad) {
        super(id,nombre,precio,stock);
        this.caducidad = caducidad;
    }

    public LocalDateTime getCaducidad() {
        return caducidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( ( o == null || getClass() != o.getClass())
                &&  !(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return (super.getId() == producto.getId()) || Objects.equals(super.getNombre(), producto.getNombre());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString() {
        return super.toString() +
                " Caducidad=" + caducidad;
    }
}
