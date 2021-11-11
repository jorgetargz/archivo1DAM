package blackjack.tui;

import blackjack.services.CardActions;
import blackjack.utils.Constants;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        CardActions cardActions = new CardActions();
        ShowCards showCards = new ShowCards();

        //Generar baraja
        int[] deck = cardActions.generateShuffledDeck(r);
        int posDeck = 0;


        while (true) {
            //Array jugadores (jugador, variables/mazo, datos)
            int numPlayers = 2;
            int[][][] jugadores = new int[numPlayers][2][7];

            //Crupier
            int[] crupier = new int[7];
            int posDeckCrupier = 0;
            int scoreCrupier;

            System.out.println(Constants.LINE);
            System.out.println(Constants.NEW_GAME);

            //Repartir 2 cartas
            int posDeckPlayer = 0;
            for (int i = 0; i < numPlayers; i++) {
                posDeck = cardActions.giveCards(deck, i, jugadores, posDeck, posDeckPlayer, 2);
            }
            posDeckPlayer += 2;
            cardActions.giveCardsCrupier(deck, crupier, posDeck, posDeckCrupier, 2);
            posDeckCrupier += 2;

            //Mostrar cartas repartidas ronda 0
            for (int i = 0; i < numPlayers; i++) {
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER + (i + 1) + ":");
                showCards.showCards(i, jugadores);

            }
            System.out.println(Constants.LINE);
            System.out.println(Constants.CRUPIER);
            showCards.showCardsCrupierLastHide(crupier);

            //Comprobar si los jugadores tienen blackjack se guarda la puntuación en [i][1][2] y si hay blackjack en [i][1][3]
            for (int i = 0; i < numPlayers; i++) {
                int score = cardActions.getScore(i, jugadores);
                jugadores[i][1][2] = score;
                if (score == 21) {
                    jugadores[i][1][3] = 1;
                }
            }

            //Comprobar si el crupier tiene blackjack
            boolean blackjackCrupier = false;
            scoreCrupier = cardActions.getScoreCrupier(crupier);
            if (scoreCrupier == 21 && posDeckCrupier == 2) {
                blackjackCrupier = true;
            }

            //Turno Jugadores completan su juego y después pasa al siguiente si se planta se guarda en [i][1][4]
            for (int i = 0; i < numPlayers; i++) {
                int score = cardActions.getScore(i, jugadores);
                jugadores[i][1][2] = score;
                while (score < 21 && jugadores[i][1][4] != 1) {
                    System.out.println(Constants.LINE);
                    System.out.println(Constants.IT_S_THE_TURN_OF);
                    System.out.println(Constants.PLAYER + (i + 1));
                    showCards.showCards(i, jugadores);
                    System.out.print(Constants.HIT_OR_STAND);
                    int decision = sc.nextInt();
                    sc.nextLine();
                    switch (decision) {
                        case 0:
                            jugadores[i][1][4] = 1;
                            score = cardActions.getScore(i, jugadores);
                            jugadores[i][1][2] = score;
                            System.out.println(Constants.PLAYER + (i + 1) + Constants.SCORE + score);
                            break;
                        case 1:
                            posDeck = cardActions.giveCards(deck, i, jugadores, posDeck, posDeckPlayer, 1);
                            posDeckPlayer++;
                            showCards.showCards(i, jugadores);
                            score = cardActions.getScore(i, jugadores);
                            jugadores[i][1][2] = score;
                            break;
                        default:
                            System.out.println(Constants.ERROR);
                            break;
                    }
                }
                if (score > 21) {
                    System.out.println(Constants.PLAYER + (i + 1) + Constants.YOU_LOSE_THE_GAME + score);
                } else if (jugadores[i][1][3] == 1) {
                    System.out.println(Constants.LINE);
                    System.out.println(Constants.PLAYER + (i + 1) + Constants.HAVE_BLACKJACK);
                } else if (score == 21) {
                    //Tiene 21, pero no con 2 cartas, no es blackjack
                    System.out.println(Constants.PLAYER + (i + 1) + Constants.SCORE + score);
                }
            }

            //Turno Crupier
            boolean crupierLose = false;
            System.out.println(Constants.LINE);
            System.out.println(Constants.CRUPIER);
            while (scoreCrupier < 17) {
                posDeck = cardActions.giveCardsCrupier(deck, crupier, posDeck, posDeckCrupier, 1);
                posDeckCrupier++;
                scoreCrupier = cardActions.getScoreCrupier(crupier);
                showCards.showCardsCrupier(crupier);
            }
            if (blackjackCrupier) {
                System.out.println(Constants.CRUPIER_HAVE_BLACKJACK);
                showCards.showCardsCrupier(crupier);
            } else {
                showCards.showCardsCrupier(crupier);
                scoreCrupier = cardActions.getScoreCrupier(crupier);
                System.out.print(Constants.SCORE);
                System.out.println(scoreCrupier);
            }
            if (scoreCrupier > 21) {
                System.out.println(Constants.LINE);
                System.out.println(Constants.CRUPIER_LOSE);
                crupierLose = true;
            }

            //Sacar ganadores si gana se guarda en [i][1][5]
            for (int i = 0; i < numPlayers; i++) {
                if (crupierLose && jugadores[i][1][2] <= 21) {
                    jugadores[i][1][5] = 1;
                }
                if (blackjackCrupier && jugadores[i][1][3] == 1) {
                    jugadores[i][1][5] = 1;
                }
                if (jugadores[i][1][2] > scoreCrupier && jugadores[i][1][2] <= 21) {
                    jugadores[i][1][5] = 1;
                }
            }

            //Si ha perdido se guarda en [i][1][6]
            for (int i = 0; i < numPlayers; i++) {
                if (jugadores[i][1][5] == 1) {
                    System.out.println(Constants.LINE);
                    System.out.println(Constants.PLAYER + (i + 1) + Constants.WINS);
                } else if (jugadores[i][1][2] == scoreCrupier) {
                    System.out.println(Constants.LINE);
                    System.out.println(Constants.PLAYER + (i + 1) + Constants.TIES);
                } else {
                    jugadores[i][1][6] = 1;
                    System.out.println(Constants.LINE);
                    System.out.println(Constants.PLAYER + (i + 1) + Constants.LOSE);
                }
            }
        }
        //Fin
    }
}