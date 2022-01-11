package modelo;

public class Carta {

    private final int numero;
    private final Palos palo;

    public Carta(int numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public Palos getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return "{" +
                 numero +
                " de " + palo +
                '}';
    }
}
