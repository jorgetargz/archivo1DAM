package dao;

import modelo.Tablero;

public class DaoTablero {
    private final Tablero tablero;
    private final int dificultad;

    public DaoTablero(int dificultad) {
        switch (dificultad) {
            case 2:
                tablero = new Tablero(6, 6);
                this.dificultad = dificultad;
                break;
            case 3:
                tablero = new Tablero(8, 8);
                this.dificultad = dificultad;
                break;
            case 1:
            default:
                tablero = new Tablero(4, 4);
                this.dificultad = dificultad;
                break;
        }
    }

    public int getTamanoTablero() {
        int tamanoTablero;
        switch (dificultad) {
            case 2:
                tamanoTablero = 6;
                break;
            case 3:
                tamanoTablero = 8;
                break;
            case 1:
            default:
                tamanoTablero = 4;
                break;
        }
        return tamanoTablero;
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

    public boolean isLevantada(int corX, int corY) {
        return tablero.isLevantada(corX, corY);
    }
}
