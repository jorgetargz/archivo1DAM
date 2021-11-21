package main;

import utils.Constantes;

import java.util.Random;


public class Ejercicio1 {

    public static void main(String[] args) {
        Random r = new Random();
        int jugadores = r.nextInt(2) + 3;
        int[] baraja = generateShuffledDeck(r);
        int indiceBaraja;
        int[] cartas = new int[jugadores];
        int[] vecesPerdidas = new int[jugadores];
        int posDarth = (r.nextInt(jugadores) + 1);
        int[] vectoresMentales = new int[jugadores];
        for (int i = 0; i < vectoresMentales.length; i++) {
            vectoresMentales[i] = r.nextInt(101);
        }
        System.out.println(Constantes.DARTH_JUEGA_EN_LA_POSICION + (posDarth));
        for (int j = 0; j < jugadores; j++) {
            System.out.println();
            System.out.println(Constantes.LINE);
            System.out.println(Constantes.JUGADOR + (j + 1) + Constantes.REPARTE);
            shuffle(r, baraja);
            indiceBaraja = 0;
            for (int i = 0; i < jugadores; i++) {
                cartas[i] = baraja[indiceBaraja];
                indiceBaraja++;
            }
            for (int i = j; i < (jugadores - 1 + j); i++) {
                System.out.println();
                int jugador = ((i + 1) % jugadores + 1);
                System.out.println(Constantes.JUGADOR + (jugador));
                System.out.println(Constantes.TU_CARTA_ES + mostrarCarta(cartas, jugador));
                if (cartas[jugador % jugadores] == 10) {
                    System.out.println(Constantes.NO_PUEDES_CAMBIAR_LA_CARTA_EL_SIGUIENTE_JUGADOR_TIENE_UN_REY);
                }
                if (cartas[jugador - 1] != 10 && cartas[jugador % jugadores] != 10) {
                    System.out.println(Constantes.QUIERES_CAMBIARLA_1_SI_0_NO);
                    int decision = r.nextInt(2);
                    if (jugador != posDarth) {
                        int poderDart = r.nextInt(101);
                        if (vectoresMentales[jugador - 1] < poderDart) {
                            System.out.println(Constantes.DARTH_SE_PARTE_LA_CAJA);
                            if (decision == 0) {
                                decision = 1;
                            } else {
                                decision = 0;
                            }
                        }
                    }
                    switch (decision) {
                        case 0:
                            System.out.println(Constantes.NO);
                            break;
                        case 1:
                            System.out.println(Constantes.SI);
                            int swap = cartas[jugador % jugadores];
                            cartas[jugador % jugadores] = cartas[jugador - 1];
                            cartas[jugador - 1] = swap;
                            System.out.println(Constantes.TU_CARTA_ES + mostrarCarta(cartas, jugador));
                            break;
                        default:
                            System.out.println(Constantes.ERROR);
                            break;
                    }
                }
            }
            System.out.println();
            System.out.println(Constantes.JUGADOR + (j + 1));
            System.out.println(Constantes.TU_CARTA_ES + mostrarCarta(cartas, (j + 1)));
            if (cartas[j] != 10) {
                System.out.println(Constantes.QUIERES_COGER_UNA_CARTA_DE_LA_BARAJA_1_SI_0_NO);
                int decision = r.nextInt(2);
                if (j != posDarth) {
                    int poderDart = r.nextInt(101);
                    if (vectoresMentales[j] < poderDart) {
                        System.out.println(Constantes.DARTH_SE_PARTE_LA_CAJA);
                        if (decision == 0) {
                            decision = 1;
                        } else {
                            decision = 0;
                        }
                    }
                }
                switch (decision) {
                    case 0:
                        System.out.println(Constantes.NO);
                        break;
                    case 1:
                        if (j == posDarth) {
                            cartas[j] = 9;
                        } else {
                            System.out.println(Constantes.SI);
                            cartas[j] = baraja[indiceBaraja];
                        }
                        System.out.println(Constantes.TU_CARTA_ES + mostrarCarta(cartas, (j + 1)));
                        break;
                    default:
                        System.out.println(Constantes.ERROR);
                        break;
                }
                if (cartas[j] == 10) {
                    cartas[j] = 0;
                }
            }
            int posValorMenor = 0;
            for (int i = 0; i < cartas.length; i++) {
                if (cartas[i] < cartas[posValorMenor]) {
                    posValorMenor = i;
                }
            }
            for (int i = 0; i < cartas.length; i++) {
                if (cartas[i] == cartas[posValorMenor]) {
                    System.out.println();
                    System.out.println(Constantes.JUGADOR + (i + 1) + Constantes.HA_PERDIDO_ESTA_RONDA);
                    vecesPerdidas[i] += 1;
                }
            }
        }
        System.out.println();
        int posValorMenor = 0;
        for (int i = 0; i < vecesPerdidas.length; i++) {
            if (vecesPerdidas[i] < vecesPerdidas[posValorMenor]) {
                posValorMenor = i;
            }
        }
        for (int i = 0; i < vecesPerdidas.length; i++) {
            if (vecesPerdidas[i] == vecesPerdidas[posValorMenor]) {
                System.out.println(Constantes.JUGADOR + (i + 1) + Constantes.HA_GANADO);
                System.out.println(Constantes.JUGADOR + (i + 1) + Constantes.HURRA);
                System.out.println(Constantes.JUGADOR + (i + 1) + Constantes.HURRA);
                System.out.println(Constantes.JUGADOR + (i + 1) + Constantes.HURRA);
            }
        }
    }


    public static String mostrarCarta(int[] cartas, int jugador) {
        String carta = "";
        if (cartas[jugador - 1] > 1 && cartas[jugador - 1] < 8) {
            carta = cartas[jugador - 1] + "";
        } else if (cartas[jugador - 1] == 1) {
            carta = "As";
        } else if (cartas[jugador - 1] == 8) {
            carta = "Sota";
        } else if (cartas[jugador - 1] == 9) {
            carta = "Caballo";
        } else if (cartas[jugador - 1] == 10) {
            carta = "Rey";
        }
        return carta;
    }

    public static int[] generateShuffledDeck(Random r) {
        int[] deck = new int[40];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = (i % 10) + 1;
        }
        shuffle(r, deck);
        return deck;
    }

    private static void shuffle(Random r, int[] deck) {
        for (int i = 0; i < 100; i++) {
            int pos1 = r.nextInt(39);
            int pos2 = r.nextInt(39);
            int aux = deck[pos1];
            deck[pos1] = deck[pos2];
            deck[pos2] = aux;
        }
    }
}
