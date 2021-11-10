package tui;

import utils.Constants;

public class ShowCards {
    public void showCardsLastHide(int[] crupier) {
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

    public void showCards(int[] player) {
        for (int i = 0; i < player.length; i++) {
            if (player[i] > 1 && player[i] <= 10) {
                System.out.print(player[i] + " ");
            } else if (player[i] == 1) {
                System.out.print(Constants.ACE);
            } else if (player[i] == 11) {
                System.out.print(Constants.JACK);
            } else if (player[i] == 12) {
                System.out.print(Constants.QUEEN);
            } else if (player[i] == 13) {
                System.out.print(Constants.KING);
            }
        }
        System.out.println();
    }
}
