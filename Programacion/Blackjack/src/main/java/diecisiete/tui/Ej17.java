package diecisiete.tui;

import diecisiete.services.GenerateDeck;

import java.util.Random;

public class Ej17 {

    public static void main(String[] args) {
        Random r = new Random();
        GenerateDeck newDeck = new GenerateDeck();
        int[] deck1 = newDeck.generateShuffledDeck(r);
        int[] deck2 = newDeck.generateShuffledDeck(r);
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < deck1.length; i++) {
            if (deck1[i] > deck2[i]) {
                score1++;
            } else if (deck1[i] < deck2[i]) {
                score2++;
            }
        }
        System.out.println("Baraja 1 tiene "+score1+" puntos");
        System.out.println("Baraja 2 tiene "+score2+" puntos");

        if (score1 > score2) {
            System.out.println("Gana la baraja 1");
        } else if (score1 < score2) {
            System.out.println("Gana la baraja 2");
        } else {
            System.out.println("Empate");
        }
    }
}
