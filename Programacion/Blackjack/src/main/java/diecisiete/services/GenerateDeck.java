package diecisiete.services;

import java.util.Random;

public class GenerateDeck {
    public int[] generateShuffledDeck(Random r) {
        int[] deck = new int[10];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i + 1;
        }
        shuffle(r, deck);
        return deck;
    }
    private void shuffle(Random r, int[] deck) {
        for (int i = 0; i < 100; i++) {
            int pos1 = r.nextInt(51);
            int pos2 = r.nextInt(51);
            int aux = deck[pos1];
            deck[pos1] = deck[pos2];
            deck[pos2] = aux;
        }
    }
}
