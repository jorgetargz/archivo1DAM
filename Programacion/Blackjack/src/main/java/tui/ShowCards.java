package tui;

import utils.Constants;

public class ShowCards {
    public void mostrarCartasUltimaOculta(int[] crupier) {
        for (int i = 0; i < crupier.length; i++) {
            if (i == 1) {
                System.out.print("*");
            } else if (crupier[i] > 1 && crupier[i] <= 10 && i != 1) {
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

    public void mostrarCartas(int[] jugador) {
        for (int i = 0; i < jugador.length; i++) {
            if (jugador[i] > 1 && jugador[i] <= 10) {
                System.out.print(jugador[i] + " ");
            } else if (jugador[i] == 1) {
                System.out.print(Constants.ACE);
            } else if (jugador[i] == 11) {
                System.out.print(Constants.JACK);
            } else if (jugador[i] == 12) {
                System.out.print(Constants.QUEEN);
            } else if (jugador[i] == 13) {
                System.out.print(Constants.KING);
            }
        }
        System.out.println();
    }
}
