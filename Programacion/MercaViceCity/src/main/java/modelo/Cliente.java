package modelo;

import modelo.common.Constantes;

import java.util.*;

public class Cliente {

    private final String dni;
    private final Set<Monedero> monederoCliente;
    private final List<Producto> compraActual;
    private final List<List<Producto>> comprasCliente;
    private String nombre;

    public Cliente(String dni) {
        this.dni = dni;
        monederoCliente = new HashSet<>();
        compraActual = new ArrayList<>();
        comprasCliente = new ArrayList<>();
    }

    public Cliente(String dni, String nombre, Set<Monedero> monederoCliente, List<Producto> compraActual, List<List<Producto>> comprasCliente) {
        this.dni = dni;
        this.monederoCliente = monederoCliente;
        this.compraActual = compraActual;
        this.comprasCliente = comprasCliente;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Monedero> getMonederosCliente() {
        return monederoCliente;
    }

    public List<Producto> getCompraActual() {
        return compraActual;
    }

    public List<List<Producto>> getComprasCliente() {
        return comprasCliente;
    }

    @Override
    public String toString() {
        return Constantes.NOMBRE + nombre +
                Constantes.DNI + dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
