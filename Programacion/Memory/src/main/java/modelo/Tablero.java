package modelo;

import java.util.Random;

public class Tablero {
    private final Carta[][] matrizTablero;

    public Tablero(int tamX, int tamY) {
        int valor;
        int aux = 0;
        matrizTablero = new Carta[tamX][tamY];
        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                valor = aux % ((tamX * tamY) / 2);
                matrizTablero[i][j] = new Carta(valor);
                aux++;
            }
        }
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            int pos1X = r.nextInt(tamX);
            int pos1Y = r.nextInt(tamY);
            int pos2X = r.nextInt(tamX);
            int pos2Y = r.nextInt(tamY);
            Carta cartaAux = matrizTablero[pos1X][pos1Y];
            matrizTablero[pos1X][pos1Y] = matrizTablero[pos2X][pos2Y];
            matrizTablero[pos2X][pos2Y] = cartaAux;
        }
    }

    public int getValor(int x, int y){
        return matrizTablero[x][y].getValor();
    }

    public boolean isLevantada(int x, int y) {
        return matrizTablero[x][y].isLevantada();
    }

    public void levantarCarta(int x, int y){
        matrizTablero[x][y].setLevantada(true);
    }

    public void ocultarCarta(int x, int y){
        matrizTablero[x][y].setLevantada(false);
    }

    public String imprimirCarta(int x, int y) {
        return matrizTablero[x][y].toString();
    }

    public boolean quedanCartasOcultas(){
        boolean quedanCartas = false;
        for (int i = 0; i < matrizTablero.length; i++) {
            for (int j = 0; j < matrizTablero[i].length; j++) {
                if (!matrizTablero[j][i].isLevantada()) {
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
        for (int i = 0; i < matrizTablero.length; i++) {
            for (int j = 0; j < matrizTablero[i].length; j++) {
                sb.append(" ").append(imprimirCarta(j,i)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
