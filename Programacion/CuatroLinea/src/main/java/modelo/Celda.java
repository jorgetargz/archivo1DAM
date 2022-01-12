package modelo;

public class Celda {
    private final int x;
    private final int y;
    private String valor;

    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
        this.valor = "-";
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
