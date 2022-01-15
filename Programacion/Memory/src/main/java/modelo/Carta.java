package modelo;

public class Carta {
    private final int valor;
    private boolean levantada;

    public Carta(int valor) {
        this.valor = valor;
        this.levantada = false;
    }

    public boolean isLevantada() {
        return levantada;
    }

    public void setLevantada(boolean levantada) {
        this.levantada = levantada;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        if (levantada) {
            return String.valueOf(valor);
        } else {
            return "-";
        }
    }
}
