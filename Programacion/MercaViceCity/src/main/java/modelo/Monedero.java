package modelo;

import java.util.Objects;

public class Monedero {

    private final int numeroMonedero;
    private double importe;

    public Monedero(int numeroMonedero, double importe) {
        this.numeroMonedero = numeroMonedero;
        this.importe = importe;
    }

    public int getNumeroMonedero() {
        return numeroMonedero;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monedero monedero = (Monedero) o;
        return numeroMonedero == monedero.numeroMonedero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroMonedero);
    }
}
