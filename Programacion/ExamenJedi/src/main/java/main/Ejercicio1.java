package main;

import utils.Constantes;

import java.util.Random;

public class Ejercicio1 {

    public static void main(String[] args) {
        Random r = new Random();
        int jugadores = r.nextInt(2) + 3;
        int[] baraja = nuevaBaraja(r);
        int indiceBaraja;
        int[] cartas = new int[jugadores];
        int[] jugadoresMuertos = new int[jugadores];
        int[] vecesPerdidas = new int[jugadores];
        int bote = 0;
        int apuesta = 0;
        int posChiu = (r.nextInt(jugadores));
        System.out.println(Constantes.CHEWBACCA_JUEGA_EN_LA_POSICION + (posChiu + 1));
        for (int i = 0; i < jugadores; i++) {
            if (i == posChiu) {
                System.out.print(Constantes.CHEWBACCA + Constantes.HAZ_UNA_APUESTA_MAYOR_DE + apuesta + ": ");
            } else {
                System.out.print(Constantes.JUGADOR + (i + 1) + Constantes.HAZ_UNA_APUESTA_MAYOR_DE + apuesta + ": ");
            }
            apuesta = r.nextInt(100) + 1 + apuesta;
            System.out.println(apuesta);
            bote += apuesta;
        }
        for (int j = 0; j < jugadores; j++) {
            System.out.println();
            System.out.println(Constantes.LINE);
            if (jugadoresMuertos[j] != 1) {
                if (j == posChiu) {
                    System.out.println(Constantes.CHEWBACCA + Constantes.REPARTE);
                } else {
                    System.out.println(Constantes.JUGADOR + (j + 1) + Constantes.REPARTE);
                }
                barajear(r, baraja);
                indiceBaraja = 0;
                for (int i = 0; i < jugadores; i++) {
                    cartas[i] = baraja[indiceBaraja];
                    indiceBaraja++;
                }
                for (int i = j; i < (jugadores - 1 + j); i++) {
                    System.out.println();
                    int jugador = ((i + 1) % jugadores + 1);
                    if (jugador == (posChiu+1)) {
                        System.out.println(Constantes.CHEWBACCA);
                    } else {
                        System.out.println(Constantes.JUGADOR + (jugador));
                    }
                    if (jugadoresMuertos[jugador - 1] != 1) {
                        System.out.println(Constantes.TU_CARTA_ES + mostrarCarta(cartas, jugador));
                        if (cartas[jugador % jugadores] == 10) {
                            System.out.println(Constantes.NO_PUEDES_CAMBIAR_LA_CARTA_EL_SIGUIENTE_JUGADOR_TIENE_UN_REY);
                        }
                        if (cartas[jugador % jugadores] == 0) {
                            System.out.println(Constantes.NO_PUEDES_CAMBIARLA_EL_SIGUIENTE_JUGADOR_A_MUERTO);
                        }
                        if (cartas[jugador - 1] != 10 && cartas[jugador % jugadores] != 10 && cartas[jugador % jugadores] != 0) {
                            System.out.print(Constantes.QUIERES_CAMBIARLA_1_SI_0_NO);
                            int decision = r.nextInt(2);
                            switch (decision) {
                                case 0:
                                    System.out.println(Constantes.NO);
                                    break;
                                case 1:
                                    System.out.println(Constantes.SI);
                                    boolean esChiuSiguiente = false;
                                    if (((i + 2) % jugadores + 1) == (posChiu+1)) {
                                        esChiuSiguiente = true;
                                    }
                                    int swap = cartas[jugador % jugadores];
                                    cartas[jugador % jugadores] = cartas[jugador - 1];
                                    cartas[jugador - 1] = swap;
                                    System.out.println(Constantes.TU_CARTA_ES + mostrarCarta(cartas, jugador));
                                    if (cartas[jugador - 1] > cartas[jugador % jugadores] && esChiuSiguiente) {
                                        jugadoresMuertos[jugador - 1] = 1;
                                        cartas[jugador - 1] = 0;
                                        System.out.println(Constantes.HAS_MUERTO);
                                    }
                                    break;
                                default:
                                    System.out.println(Constantes.ERROR);
                                    break;
                            }
                        }
                    } else {
                        System.out.println(Constantes.HAS_MUERTO);
                    }
                }
                System.out.println();
                if (j == posChiu) {
                    System.out.println(Constantes.CHEWBACCA);
                } else {
                    System.out.println(Constantes.JUGADOR + (j + 1));
                }
                System.out.println(Constantes.TU_CARTA_ES + mostrarCarta(cartas, (j + 1)));
                if (cartas[j] != 10) {
                    System.out.print(Constantes.QUIERES_COGER_UNA_CARTA_DE_LA_BARAJA_1_SI_0_NO);
                    int decision = r.nextInt(2);
                    switch (decision) {
                        case 0:
                            System.out.println(Constantes.NO);
                            break;
                        case 1:
                            System.out.println(Constantes.SI);
                            cartas[j] = baraja[indiceBaraja];
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
                        if (i == posChiu) {
                            System.out.println(Constantes.CHEWBACCA + Constantes.HA_PERDIDO_ESTA_RONDA);
                        } else {
                            System.out.println(Constantes.JUGADOR + (i + 1) + Constantes.HA_PERDIDO_ESTA_RONDA);
                        }
                        vecesPerdidas[i] += 1;
                    }
                }
            } else {
                System.out.println(Constantes.JUGADOR + (j + 1) + Constantes.HAS_MUERTO);
            }
        }
        int posValorMenor = 0;
        for (int i = 0; i < vecesPerdidas.length; i++) {
            if (vecesPerdidas[i] < vecesPerdidas[posValorMenor]) {
                posValorMenor = i;
            }
        }
        System.out.println();
        int ganadores = 1;
        for (int i = 0; i < vecesPerdidas.length; i++) {
            if (vecesPerdidas[i] == vecesPerdidas[posValorMenor]) {
                if (i == posChiu) {
                    System.out.println(Constantes.CHEWBACCA + Constantes.HA_GANADO);
                } else {
                    System.out.println(Constantes.JUGADOR + (i + 1) + Constantes.HA_GANADO);
                }
                ganadores++;
            }
        }
        System.out.println(Constantes.EL_GANADOR_ES_HAN_GANADO + (bote / (ganadores - 1)) + Constantes.CADA_UNO);
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

    public static int[] nuevaBaraja(Random r) {
        int[] baraja = new int[40];
        for (int i = 0; i < baraja.length; i++) {
            baraja[i] = (i % 10) + 1;
        }
        barajear(r, baraja);
        return baraja;
    }

    private static void barajear(Random r, int[] deck) {
        for (int i = 0; i < 100; i++) {
            int pos1 = r.nextInt(40);
            int pos2 = r.nextInt(40);
            int aux = deck[pos1];
            deck[pos1] = deck[pos2];
            deck[pos2] = aux;
        }
    }
}