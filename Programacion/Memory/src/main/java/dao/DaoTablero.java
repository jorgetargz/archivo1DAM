package dao;

import modelo.Tablero;

public class DaoTablero {
    private final Tablero tablero;

    public DaoTablero(int dificultad) {
        switch (dificultad) {
            case 2:
                tablero = new Tablero(6, 6);
                break;
            case 3:
                tablero = new Tablero(8, 8);
                break;
            case 1:
            default:
                tablero = new Tablero(4, 4);
                break;
        }
    }

    public String getTablero() {
        return tablero.toString();
    }

    public boolean quedanCartasOcultas(){
        return tablero.quedanCartasOcultas();
    }

    public void levantarCarta(int x, int y) {
        tablero.levantarCarta(x,y);
    }

    public void ocultarCarta(int x, int y) {
        tablero.ocultarCarta(x,y);
    }

    public boolean compararCartas(int x1, int y1, int x2, int y2){
        return tablero.getValor(x1, y1) == tablero.getValor(x2, y2);
    }
}
