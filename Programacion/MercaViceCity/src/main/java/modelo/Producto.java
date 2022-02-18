package modelo;

import modelo.common.Constantes;

import java.util.List;
import java.util.Objects;

public class Producto implements Clonable<Producto> {

    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private List<Ingrediente> ingredientes;

    public Producto(int id) {
        this.id = id;
    }

    public Producto(String nombre, double precio, int stock, List<Ingrediente> ingredientes) {
        this.nombre = nombre.toUpperCase();
        this.precio = precio;
        this.stock = stock;
        this.ingredientes = ingredientes;
    }

    public Producto(int id, String nombre, double precio, int stock, List<Ingrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre.toUpperCase();
        this.precio = precio;
        this.stock = stock;
        this.ingredientes = ingredientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return (id == producto.getId()) || Objects.equals(nombre, producto.nombre);
    }

    @Override
    public String toString() {
        String nombreMostrar = nombre.toLowerCase();
        nombreMostrar = nombreMostrar.substring(0, 1).toUpperCase().concat(nombreMostrar.substring(1));
        return id + Constantes.PUNTO +
                nombreMostrar +
                Constantes.PRECIO + precio +
                Constantes.STOCK + stock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public Producto clonar() {
        return new Producto(this.id, this.nombre, this.precio, this.stock, this.ingredientes);
    }
}
