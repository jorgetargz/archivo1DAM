package modelo;

import modelo.common.Constantes;

import java.util.*;

public class Cliente implements Clonable<Cliente> {

    private final String dni;
    private final Set<Monedero> monederoCliente;
    private final List<LineaCompra> compraActual;
    private final List<List<LineaCompra>> comprasCliente;
    private final List<Ingrediente> alergenos;
    private String nombre;

    public Cliente(String dni) {
        this.dni = dni;
        monederoCliente = new HashSet<>();
        compraActual = new ArrayList<>();
        comprasCliente = new ArrayList<>();
        alergenos = new ArrayList<>();
    }

    public Cliente(String dni, String nombre, Set<Monedero> monederoCliente,
                   List<LineaCompra> compraActual,
                   List<List<LineaCompra>> comprasCliente, List<Ingrediente> alergenos) {
        this.dni = dni;
        this.nombre = nombre;
        this.monederoCliente = monederoCliente;
        this.compraActual = compraActual;
        this.comprasCliente = comprasCliente;
        this.alergenos = alergenos;
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

    public List<Ingrediente> getAlergenos() {
        return alergenos;
    }

    @Override
    public String toString() {
        return Constantes.NOMBRE + nombre +
                Constantes.DNI + dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public Cliente clonar() {
        return new Cliente(this.dni, this.nombre, this.monederoCliente, this.compraActual, this.comprasCliente, this.alergenos);
    }
}
