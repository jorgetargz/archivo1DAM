package main;

import services.GenerarBaraja;

import java.util.Random;

public class JuegoBaraja {
    public static void main(String[] args) {
        Random r = new Random();
        GenerarBaraja genBaraja = new GenerarBaraja();
        int[] baraja1 = genBaraja.generateShuffledDeck(r);
        int[] posiciones1 = new int[10];
        int pos1 = 0;
        int puntuacion1 = 0;
        mostrarBaraja(baraja1);
        int[] baraja2 = genBaraja.generateShuffledDeck(r);
        int[] posiciones2 = new int[10];
        int pos2 = 0;
        int puntuacion2 = 0;
        mostrarBaraja(baraja2);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < baraja1.length; j++) {
                if (baraja1[j] == i) {
                    posiciones1[i-1] += j;
                }
            }
            for (int j = 0; j < baraja2.length; j++) {
                if (baraja2[j] == i) {
                    posiciones2[i-1] += j;
                }
            }
        }
        for (int i = 0; i < posiciones1.length; i++) {
            if (posiciones1[i] > posiciones2[i]) {
                puntuacion1++;
            } else if (posiciones1[i] < posiciones2[i]) {
                puntuacion2++;
            }
        }
        if (puntuacion1 > puntuacion2) {
            System.out.println("La baraja 1 gana");
        } else if (puntuacion1 < puntuacion2) {
            System.out.println("La baraja 2 gana");
        }
    }

    private static void mostrarBaraja(int[] baraja) {
        for (int i = 0; i < baraja.length; i++) {
            if (i == (baraja.length - 1)) {
                System.out.print(baraja[i]);
            } else {
                System.out.print(baraja[i] + "-");
            }
        }
        System.out.println();
    }
}

