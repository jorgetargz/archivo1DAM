package modelo;

import modelo.common.Constantes;

import java.util.*;
import java.util.stream.Collectors;

public class Cliente implements Clonable<Cliente> {

    private final String dni;
    private String nombre;
    private final Set<Monedero> monederoCliente;
    private final List<LineaCompra> compraActual;
    private final List<List<LineaCompra>> comprasCliente;
    private final List<Ingrediente> alergenos;

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

    public Set<Monedero> listaMonederosClonada(){
        return this.monederoCliente.stream().map(Monedero::clonar)
                .collect(Collectors.toUnmodifiableSet());
    }

    public List<LineaCompra> listaCompraClonada(){
        return this.compraActual.stream().map(LineaCompra::clonar)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<List<LineaCompra>> listaComprasClonada(){
        List<List<LineaCompra>> listaComprasClonada = new ArrayList<>();
        this.comprasCliente
                .forEach(lineaCompras -> listaComprasClonada.add(lineaCompras.stream()
                        .map(LineaCompra::clonar)
                        .collect(Collectors.toList())));
        return listaComprasClonada;
    }

    public List<Ingrediente> listaAlergenos(){
        return this.alergenos.stream().map(Ingrediente::clonar)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Cliente clonar() {
        return new Cliente(this.dni, this.nombre, this.listaMonederosClonada(),
                this.listaCompraClonada(), this.listaComprasClonada(), this.listaAlergenos());
    }
}
