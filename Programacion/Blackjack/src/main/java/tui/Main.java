package tui;

import services.CardActions;
import services.GetWinners;
import utils.Constants;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        CardActions cardActions = new CardActions();
        ShowCards showCards = new ShowCards();
        ShowWinners showWinners = new ShowWinners();
        GetWinners getWinners = new GetWinners();

        //Mazos de juego
        int[] player1 = new int[4];
        int[] player2 = new int[4];
        int[] crupier = new int[4];
        int posDeckP1 = 0;
        int posDeckP2 = 0;
        int posDeckCp = 0;

        //Generar baraja
        int[] deck = cardActions.generateShuffledDeck(r);
        int posDeck = 0;

        //Repartir 2 cartas
        posDeck = cardActions.giveCards(deck, player1, posDeck, posDeckP1, 2);
        posDeck = cardActions.giveCards(deck, player2, posDeck, posDeckP2, 2);
        posDeck = cardActions.giveCards(deck, crupier, posDeck, posDeckCp, 2);
        posDeckP1 += 2;
        posDeckP2 += 2;
        posDeckCp += 2;

        //Mostrar cartas repartidas ronda 0
        System.out.println(Constants.PLAYER_1);
        showCards.showCards(player1);
        System.out.println(Constants.PLAYER_2);
        showCards.showCards(player2);
        System.out.println(Constants.CRUPIER);
        showCards.showCardsLastHide(crupier);
        System.out.println(Constants.LINE);

        //Comprobar si los jugadores tienen blackjack
        boolean blackjackP1 = false;
        boolean blackjackP2 = false;
        boolean blackjackCp = false;
        int scoreP1 = cardActions.getScore(player1);
        if (scoreP1 == 21) {
            blackjackP1 = true;
            System.out.println(Constants.PLAYER_1_HAVE_BLACKJACK);
        }
        int scoreP2 = cardActions.getScore(player2);
        if (scoreP2 == 21) {
            blackjackP2 = true;
            System.out.println(Constants.PLAYER_2_HAVE_BLACKJACK);
        }
        int scoreCp = cardActions.getScore(crupier);
        if (scoreCp == 21) {
            blackjackCp = true;
        }

        //Variables de juego
        boolean p1Stands = false;
        boolean p1Lose = false;

        boolean p2Stands = false;
        boolean p2Lose = false;

        boolean cpLose = false;

        do {
            //Turno Jugador 1
            if (scoreP1 <= 21 && !p1Stands && !blackjackP1) {
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER_1);
                showCards.showCards(player1);
                System.out.print(Constants.HIT_OR_STAND);
                int decision = sc.nextInt();
                sc.nextLine();
                switch (decision) {
                    case 0:
                        scoreP1 = cardActions.getScore(player1);
                        System.out.print(Constants.SCORE);
                        System.out.println(scoreP1);
                        p1Stands = true;
                        break;
                    case 1:
                        posDeck = cardActions.giveCards(deck, player1, posDeck, posDeckP1, 1);
                        posDeckP1++;
                        scoreP1 = cardActions.getScore(player1);
                        showCards.showCards(player1);
                        break;
                    default:
                        System.out.println(Constants.ERROR);
                        break;
                }
            }
            if (scoreP1 > 21) {
                p1Lose = true;
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER_1);
                System.out.print(Constants.YOU_LOSE_THE_GAME);
                scoreP1 = cardActions.getScore(player1);
                System.out.println(scoreP1);
            }

            //Turno Jugador 2
            if (scoreP2 <= 21 && !p2Stands && !blackjackP2) {
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER_2);
                showCards.showCards(player2);
                System.out.print(Constants.HIT_OR_STAND);
                int decision = sc.nextInt();
                sc.nextLine();
                switch (decision) {
                    case 0:
                        scoreP2 = cardActions.getScore(player2);
                        System.out.print(Constants.SCORE);
                        System.out.println(scoreP2);
                        p2Stands = true;
                        break;
                    case 1:
                        posDeck = cardActions.giveCards(deck, player2, posDeck, posDeckP2, 1);
                        posDeckP2++;
                        scoreP2 = cardActions.getScore(player2);
                        showCards.showCards(player2);
                        break;
                    default:
                        System.out.println(Constants.ERROR);
                        break;
                }
            }
            if (scoreP2 > 21) {
                p2Lose = true;
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER_2);
                System.out.print(Constants.YOU_LOSE_THE_GAME);
                scoreP2 = cardActions.getScore(player2);
                System.out.println(scoreP2);
            }

            //Turno Crupier
            System.out.println(Constants.LINE);
            System.out.println(Constants.CRUPIER);
            if (scoreCp < 17) {
                posDeck = cardActions.giveCards(deck, crupier, posDeck, posDeckCp, 1);
                posDeckCp++;
                scoreCp = cardActions.getScore(crupier);
                showCards.showCards(crupier);
            } else if (blackjackCp) {
                System.out.println(Constants.CRUPIER_HAVE_BLACKJACK);
                showCards.showCards(crupier);
            } else {
                showCards.showCards(crupier);
                scoreCp = cardActions.getScore(crupier);
                System.out.print(Constants.SCORE);
                System.out.println(scoreCp);
            }
            if (scoreCp > 21) {
                System.out.println(Constants.LINE);
                System.out.println(Constants.CRUPIER_LOSE);
                cpLose = true;
            }
        } while ((!blackjackCp && !cpLose) && ((!p1Stands && !p1Lose) || (!p2Stands && !p2Lose)));

        //Sacar ganadores
        boolean[] results = getWinners.getWinners(blackjackP1, blackjackP2, blackjackCp, scoreP1, scoreP2, scoreCp, p1Lose, p2Lose, cpLose);
        boolean p1Wins =  results[0];
        boolean p1Ties = results[1];
        boolean p2Wins = results[2];
        boolean p2Ties = results[3];
        System.out.println(Constants.LINE);
        showWinners.showWinners(p1Wins, p1Ties, p2Wins, p2Ties);
    }
}