package main;

import java.util.Random;

public class Opcion2Ej1 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] baraja = generateShuffledDeck(r);
        int[] posiciones = new int[10];
        for (int j = 1; j <= 10; j++) {
            for (int i = 0; i < baraja.length; i++) {
                if (baraja[i] == j) {
                    posiciones[j - 1] = i + 1;
                }
            }
        }
        for (int i = 0; i < baraja.length; i++) {
            System.out.print(baraja[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < posiciones.length; i++) {
            System.out.print(posiciones[i] + " ");
        }
    }

    public static int[] generateShuffledDeck(Random r) {
        int[] deck = new int[40];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = (i % 10) + 1;
        }
        shuffle(r, deck);
        return deck;
    }

    private static void shuffle(Random r, int[] deck) {
        for (int i = 0; i < 100; i++) {
            int pos1 = r.nextInt(40);
            int pos2 = r.nextInt(40);
            int aux = deck[pos1];
            deck[pos1] = deck[pos2];
            deck[pos2] = aux;
        }
    }
}
