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

        //Generar baraja
        int[] deck = cardActions.generateShuffledDeck(r);
        int posDeck = 0;

        //Dinero jugadores
        int moneyP1 = 200;
        int moneyP2 = 200;

        while (moneyP1 > 0 || moneyP2 > 0) {
            //Mazos de juego
            int[] player1 = new int[4];
            int[] player2 = new int[4];
            int[] crupier = new int[4];
            int posDeckP1 = 0;
            int posDeckP2 = 0;
            int posDeckCp = 0;

            //Variables de juego
            boolean p1Stands = false;
            boolean p1Lose = false;
            boolean p2Stands = false;
            boolean p2Lose = false;
            boolean cpLose = false;

            //Apostar
            int bidP1 = 0;
            int bidP2 = 0;
            if (moneyP1 == 0) {
                p1Lose = true;
            } else {
                System.out.println(Constants.PLAYER_1);
                System.out.print(Constants.MONEY);
                System.out.println(moneyP1);
                System.out.print(Constants.PLACE_YOUR_BID);
                bidP1 = sc.nextInt();
                if (bidP1 > moneyP1) {
                    System.out.println(Constants.YOU_DON_T_HAVE_ENOUGH_MONEY);
                    bidP1 = moneyP1;
                }
            }

            if (moneyP2 == 0) {
                p2Lose = true;
            } else {
                System.out.println(Constants.PLAYER_2);
                System.out.print(Constants.MONEY);
                System.out.println(moneyP2);
                System.out.print(Constants.PLACE_YOUR_BID);
                bidP2 = sc.nextInt();
                if (bidP2 > moneyP1) {
                    System.out.println(Constants.YOU_DON_T_HAVE_ENOUGH_MONEY);
                    bidP2 = moneyP2;
                }
            }
            System.out.println(Constants.LINE);

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
            int scoreCp = 0;

            while ((!blackjackCp && !cpLose) && ((!p1Stands && !p1Lose) || (!p2Stands && !p2Lose))) {
                //Comprobar si el crupier tiene blackjack
                scoreCp = cardActions.getScore(crupier);
                if (scoreCp == 21 && posDeckCp == 2) {
                    blackjackCp = true;
                }
                //Turno Jugador 1
                if (scoreP1 <= 21 && !p1Stands && !blackjackP1 && !p1Lose) {
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
                if (scoreP2 <= 21 && !p2Stands && !blackjackP2 && !p2Lose) {
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
            }

            //Sacar ganadores
            boolean[] results = getWinners.getWinners(blackjackP1, blackjackP2, blackjackCp, scoreP1, scoreP2, scoreCp, p1Lose, p2Lose, cpLose);
            boolean p1Wins = results[0];
            boolean p1Ties = results[1];
            boolean p2Wins = results[2];
            boolean p2Ties = results[3];
            System.out.println(Constants.LINE);
            showWinners.showWinners(p1Wins, p1Ties, p2Wins, p2Ties);

            //Calcular dinero jugadores
            if (blackjackP1) {
                moneyP1 += bidP1 * 1.5;
            } else if (p1Wins) {
                moneyP1 += bidP1;
            } else if (p1Lose) {
                moneyP1 -= bidP1;
            }
            if (blackjackP2) {
                moneyP2 += bidP2 * 1.5;
            } else if (p2Wins) {
                moneyP2 += bidP2;
            } else if (p2Lose) {
                moneyP2 -= bidP2;
            }
            System.out.println(Constants.LINE);
        }
    }
}