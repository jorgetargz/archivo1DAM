package modelo;

import java.util.Random;

public class Tablero {
    private final Carta[][] tablero;

    public Tablero(int tamX, int tamY) {
        int valor;
        int aux = 0;
        tablero = new Carta[tamX][tamY];
        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                valor = aux % ((tamX * tamY) / 2);
                tablero[i][j] = new Carta(valor);
                aux++;
            }
        }
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int pos1X = r.nextInt(tamX);
            int pos1Y = r.nextInt(tamY);
            int pos2X = r.nextInt(tamX);
            int pos2Y = r.nextInt(tamY);
            Carta cartaAux = tablero[pos1X][pos1Y];
            tablero[pos1X][pos1Y] = tablero[pos2X][pos2Y];
            tablero[pos2X][pos2Y] = cartaAux;
        }
    }

    public int getValor(int x, int y){
        return tablero[x][y].getValor();
    }

    public void levantarCarta(int x, int y){
        tablero[x][y].setLevantada(true);
    }

    public void ocultarCarta(int x, int y){
        tablero[x][y].setLevantada(false);
    }

    public String imprimirCarta(int x, int y) {
        return tablero[x][y].toString();
    }

    public boolean quedanCartasOcultas(){
        boolean quedanCartas = false;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (!tablero[j][i].isLevantada()) {
                    quedanCartas = true;
                    break;
                }
            }
        }
        return quedanCartas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                sb.append(" ").append(imprimirCarta(j,i)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
