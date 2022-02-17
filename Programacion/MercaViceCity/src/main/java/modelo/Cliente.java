package modelo;

import modelo.common.Constantes;

import java.util.*;

public class Cliente implements Clonable<Cliente> {

    private final String dni;
    private Set<Monedero> monederoCliente = null;
    private List<LineaCompra> compraActual = null;
    private List<List<LineaCompra>> comprasCliente = null;
    private String nombre;

    public Cliente(String dni) {
        this.dni = dni;
        monederoCliente = new HashSet<>();
        compraActual = new ArrayList<>();
        comprasCliente = new ArrayList<>();
    }

    public Cliente(String dni, String nombre) {
        this.dni = dni;
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

    public List<LineaCompra> getCompraActual() {
        return compraActual;
    }

    public List<List<LineaCompra>> getComprasCliente() {
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

    @Override
    public Cliente clonar() {
        return new Cliente(this.dni,this.nombre);
    }
}
