package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cliente implements Clonable<Cliente> {

    private final String dni;
    private String nombre;
    private double monedero;
    private List<LineaCompra> carrito;
    private List<List<LineaCompra>> comprasRealizadas;

    public Cliente(String dni, String nombre, double monedero) {
        this.dni = dni;
        this.nombre = nombre;
        this.monedero = monedero;
        this.carrito = new ArrayList<>();
        this.comprasRealizadas = new ArrayList<>();
    }

    public Cliente(String dni, String nombre, double monedero, List<LineaCompra> carrito, List<List<LineaCompra>> comprasRealizadas) {
        this.dni = dni;
        this.nombre = nombre;
        this.monedero = monedero;
        this.carrito = carrito;
        this.comprasRealizadas = comprasRealizadas;
    }

    public Cliente(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMonedero() {
        return monedero;
    }

    public void quitarDinero(double importe){
        monedero -= importe;
    }

    public List<LineaCompra> getCarrito() {
        return carrito;
    }

    public List<LineaCompra> getCarritoClonado(){
        return carrito.stream()
                .map(LineaCompra::clonar)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<List<LineaCompra>> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public List<List<LineaCompra>> getComprasRealizadasClonadas(){
        List<List<LineaCompra>> comprasAntiguasClonadas = new ArrayList<>();
        comprasRealizadas.forEach(lineaCompras -> comprasAntiguasClonadas
                .add(lineaCompras.stream().map(LineaCompra::clonar)
                        .collect(Collectors.toList())));
        return comprasAntiguasClonadas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni.equals(cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public Cliente clonar() {
        return new Cliente(this.dni,this.nombre,this.monedero,getCarritoClonado(), getComprasRealizadasClonadas());
    }
}
