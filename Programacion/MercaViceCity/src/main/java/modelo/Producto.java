package modelo;

import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id) {
        this.id = id;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, double precio, int stock) {
        this.id = 0;
        this.nombre = nombre.toUpperCase();
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return (id == producto.getId()) || Objects.equals(nombre,producto.nombre);
    }

    @Override
    public String toString() {
        String nombreMostrar = nombre.toLowerCase();
        nombreMostrar = nombreMostrar.substring(0,1).toUpperCase().concat(nombreMostrar.substring(1));
        return id + ". " +
                nombreMostrar + " " +
                "(" + precio +
                "€)" + " Cantidad disponible: " + stock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
