package blackjack.tui;

import blackjack.utils.Constants;

public class ShowCards {
    public void showCardsCrupierLastHide(int[] crupier) {
        for (int i = 0; i < crupier.length; i++) {
            if (i == 1) {
                System.out.print("*");
            } else if (crupier[i] > 1 && crupier[i] <= 10) {
                System.out.print(crupier[i] + " ");
            } else if (crupier[i] == 1) {
                System.out.print(Constants.ACE);
            } else if (crupier[i] == 11) {
                System.out.print(Constants.JACK);
            } else if (crupier[i] == 12) {
                System.out.print(Constants.QUEEN);
            } else if (crupier[i] == 13) {
                System.out.print(Constants.KING);
            }
        }
        System.out.println();
    }

    public void showCardsCrupier(int[] crupier) {
        for (int i = 0; i < crupier.length; i++) {
            if (crupier[i] > 1 && crupier[i] <= 10) {
                System.out.print(crupier[i] + " ");
            } else if (crupier[i] == 1) {
                System.out.print(Constants.ACE);
            } else if (crupier[i] == 11) {
                System.out.print(Constants.JACK);
            } else if (crupier[i] == 12) {
                System.out.print(Constants.QUEEN);
            } else if (crupier[i] == 13) {
                System.out.print(Constants.KING);
            }
        }
        System.out.println();
    }

    public void showCards(int player, int[][][] players) {
        for (int k = 0; k < 6; k++) {
            if (players[player][0][k] > 1 && players[player][0][k] <= 10) {
                System.out.print(players[player][0][k] + " ");
            } else if (players[player][0][k] == 1) {
                System.out.print(Constants.ACE);
            } else if (players[player][0][k] == 11) {
                System.out.print(Constants.JACK);
            } else if (players[player][0][k] == 12) {
                System.out.print(Constants.QUEEN);
            } else if (players[player][0][k] == 13) {
                System.out.print(Constants.KING);
            }
        }
        System.out.println();
    }
}