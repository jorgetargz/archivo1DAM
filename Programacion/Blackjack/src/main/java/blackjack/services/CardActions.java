package blackjack.services;

import java.util.Random;

public class CardActions {

    public int[] generateShuffledDeck(Random r) {
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = (i % 13) + 1;
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

    public int getScore(int[] player) {
        int score = 0;
        for (int i = 0; i < player.length; i++) {
            if (player[i] == 11 || player[i] == 12 || player[i] == 13) {
                score += 10;
            } else {
                score += player[i];
            }
        }
        for (int i = 0; i < player.length; i++) {
            if (player[i] == 1 && score + 10 <= 21) {
                    score += 10;
                }
            }
        return score;
    }

    public int giveCards(int[] deck, int[] player, int posDeck, int posPlayerDeck, int numCards) {
        while (numCards > 0) {
            player[posPlayerDeck] = deck[posDeck];
            posDeck++;
            posPlayerDeck++;
            numCards--;
        }
        return posDeck;
    }
}
