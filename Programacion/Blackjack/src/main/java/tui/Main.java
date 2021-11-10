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
        int[] jugador1 = new int[4];
        int[] jugador2 = new int[4];
        int[] crupier = new int[4];
        int posicionMazoJ1 = 0;
        int posicionMazoJ2 = 0;
        int posicionMazoCp = 0;

        //Generar baraja
        int[] baraja = cardActions.generarBarajaBarajeada(r);
        int posicionBaraja = 0;

        //Repartir 2 cartas
        posicionBaraja = cardActions.repartirCartas(baraja, jugador1, posicionBaraja, posicionMazoJ1, 2);
        posicionBaraja = cardActions.repartirCartas(baraja, jugador2, posicionBaraja, posicionMazoJ2, 2);
        posicionBaraja = cardActions.repartirCartas(baraja, crupier, posicionBaraja, posicionMazoCp, 2);
        posicionMazoJ1 += 2;
        posicionMazoJ2 += 2;
        posicionMazoCp += 2;

        //Mostrar cartas repartidas ronda 0
        System.out.println(Constants.PLAYER_1);
        showCards.mostrarCartas(jugador1);
        System.out.println(Constants.PLAYER_2);
        showCards.mostrarCartas(jugador2);
        System.out.println(Constants.CRUPIER);
        showCards.mostrarCartasUltimaOculta(crupier);
        System.out.println(Constants.LINE);

        //Comprobar si los jugadores tienen blackjack
        boolean blackjackJ1 = false;
        boolean blackjackJ2 = false;
        boolean blackjackCp = false;
        int sumaJ1 = cardActions.sumarCartas(jugador1);
        if (sumaJ1 == 21) {
            blackjackJ1 = true;
            System.out.println(Constants.PLAYER_1_HAVE_BLACKJACK);
        }
        int sumaJ2 = cardActions.sumarCartas(jugador2);
        if (sumaJ2 == 21) {
            blackjackJ2 = true;
            System.out.println(Constants.PLAYER_2_HAVE_BLACKJACK);
        }
        int sumaCp = cardActions.sumarCartas(crupier);
        if (sumaCp == 21) {
            blackjackCp = true;
        }

        //Variables de juego
        boolean j1Plantado = false;
        boolean j1Perdio = false;

        boolean j2Plantado = false;
        boolean j2Perdio = false;

        boolean cpLose = false;

        do {
            //Turno Jugador 1
            if (sumaJ1 <= 21 && !j1Plantado && !blackjackJ1) {
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER_1);
                showCards.mostrarCartas(jugador1);
                System.out.print(Constants.HIT_OR_STAND);
                int decision = sc.nextInt();
                sc.nextLine();
                switch (decision) {
                    case 0:
                        sumaJ1 = cardActions.sumarCartas(jugador1);
                        System.out.print(Constants.SCORE);
                        System.out.println(sumaJ1);
                        j1Plantado = true;
                        break;
                    case 1:
                        posicionBaraja = cardActions.repartirCartas(baraja, jugador1, posicionBaraja, posicionMazoJ1, 1);
                        posicionMazoJ1++;
                        sumaJ1 = cardActions.sumarCartas(jugador1);
                        showCards.mostrarCartas(jugador1);
                        break;
                    default:
                        System.out.println(Constants.ERROR);
                        break;
                }
            }
            if (sumaJ1 > 21) {
                j1Perdio = true;
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER_1);
                System.out.print(Constants.YOU_LOSE_THE_GAME);
                sumaJ1 = cardActions.sumarCartas(jugador1);
                System.out.println(sumaJ1);
            }

            //Turno Jugador 2
            if (sumaJ2 <= 21 && !j2Plantado && !blackjackJ2) {
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER_2);
                showCards.mostrarCartas(jugador2);
                System.out.print(Constants.HIT_OR_STAND);
                int decision = sc.nextInt();
                sc.nextLine();
                switch (decision) {
                    case 0:
                        sumaJ2 = cardActions.sumarCartas(jugador2);
                        System.out.print(Constants.SCORE);
                        System.out.println(sumaJ2);
                        j2Plantado = true;
                        break;
                    case 1:
                        posicionBaraja = cardActions.repartirCartas(baraja, jugador2, posicionBaraja, posicionMazoJ2, 1);
                        posicionMazoJ2++;
                        sumaJ2 = cardActions.sumarCartas(jugador2);
                        showCards.mostrarCartas(jugador2);
                        break;
                    default:
                        System.out.println(Constants.ERROR);
                        break;
                }
            }
            if (sumaJ2 > 21) {
                j2Perdio = true;
                System.out.println(Constants.LINE);
                System.out.println(Constants.PLAYER_2);
                System.out.print(Constants.YOU_LOSE_THE_GAME);
                sumaJ2 = cardActions.sumarCartas(jugador2);
                System.out.println(sumaJ2);
            }

            //Turno Crupier
            System.out.println(Constants.LINE);
            System.out.println(Constants.CRUPIER);
            if (sumaCp < 17) {
                posicionBaraja = cardActions.repartirCartas(baraja, crupier, posicionBaraja, posicionMazoCp, 1);
                posicionMazoCp++;
                sumaCp = cardActions.sumarCartas(crupier);
                showCards.mostrarCartas(crupier);
            } else if (blackjackCp) {
                System.out.println(Constants.CRUPIER_HAVE_BLACKJACK);
                showCards.mostrarCartas(crupier);
            } else {
                showCards.mostrarCartas(crupier);
                sumaCp = cardActions.sumarCartas(crupier);
                System.out.print(Constants.SCORE);
                System.out.println(sumaCp);
            }
            if (sumaCp > 21) {
                System.out.println(Constants.LINE);
                System.out.println(Constants.CRUPIER_LOSE);
                cpLose = true;
            }
        } while ((!blackjackCp && !cpLose) && ((!j1Plantado && !j1Perdio) || (!j2Plantado && !j2Perdio)));

        //Sacar ganadores
        boolean[] results = getWinners.getWinners(blackjackJ1, blackjackJ2, blackjackCp, sumaJ1, sumaJ2, sumaCp, j1Perdio, j2Perdio, cpLose);
        boolean j1Gana =  results[0];
        boolean j1Empata = results[1];
        boolean j2Gana = results[2];
        boolean j2Empata = results[3];
        System.out.println(Constants.LINE);
        showWinners.mostrarPuntuaciones(j1Gana, j1Empata, j2Gana, j2Empata);


    }
}