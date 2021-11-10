package services;

import java.util.Random;

public class CardActions {

    public int[] generarBarajaBarajeada(Random r) {
        int[] baraja = new int[52];
        for (int i = 0; i < baraja.length; i++) {
            baraja[i] = (i % 13) + 1;
        }
        barajear(r, baraja);
        return baraja;
    }

    private void barajear(Random r, int[] baraja) {
        for (int i = 0; i < 100; i++) {
            int pos1 = r.nextInt(51);
            int pos2 = r.nextInt(51);
            int aux = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = aux;
        }
    }

    public int sumarCartas(int[] jugador) {
        boolean blackjack = false;
        int suma = 0;
        for (int i = 0; i < jugador.length; i++) {
            if (jugador[i] == 11 || jugador[i] == 12 || jugador[i] == 13) {
                suma += 10;
            } else {
                suma += jugador[i];
            }
        }
        for (int i = 0; i < jugador.length; i++) {
            if (jugador[i] == 1) {
                if (suma + 10 <= 21) {
                    suma += 10;
                }
            }
        }
        return suma;
    }

    public int repartirCartas(int[] baraja, int[] jugador, int posicionBaraja, int posicionMazo, int numeroCartas) {
        while (numeroCartas > 0){
            jugador[posicionMazo] = baraja[posicionBaraja];
            posicionBaraja++;
            posicionMazo++;
            numeroCartas--;
        }
        return posicionBaraja;
    }

}
