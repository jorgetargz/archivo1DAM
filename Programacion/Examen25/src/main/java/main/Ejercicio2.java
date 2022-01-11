package main;

import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        Random r = new Random();
        int jugadores = r.nextInt(3) + 2;
        int[] baraja = nuevaBaraja(r);
        int indiceBaraja = 0;
        int numeroCartasJugador = 3;
        int[][] cartasJugadores = new int[jugadores][numeroCartasJugador];
        int[] cartasGanadasJugadores = new int[jugadores];
        while (baraja.length - indiceBaraja > jugadores * numeroCartasJugador) {
            int[] cartasMesa = new int[jugadores];
            for (int i = 0; i < jugadores; i++) {
                for (int j = 0; j < 3; j++) {
                    cartasJugadores[i][j] = baraja[indiceBaraja];
                    indiceBaraja++;
                }
            }
            for (int i = 0; i < jugadores; i++) {
                System.out.println("Jugador " + (i + 1) + " tus cartas son:");
                for (int j = 0; j < numeroCartasJugador; j++) {
                    System.out.println("Carta " + (j + 1) + " es " + cartasJugadores[i][j]);
                }
                System.out.print("¿Que cartas quieres descartar?[1-3]: ");
                int cartaElegida = r.nextInt(numeroCartasJugador) + 1;
                System.out.println(cartaElegida);
                cartasMesa[i] = cartasJugadores[i][cartaElegida-1];
                System.out.println("Cartas en la mesa: ");
                for (int j = 0; j < cartasMesa.length; j++) {
                    if (cartasMesa[j] != 0) {
                        System.out.print(cartasMesa[j] + " ");
                    }
                }
                System.out.println();
                System.out.println();
            }
            int cartaMesaMayor = cartasMesa[0];
            for (int i = 0; i < jugadores; i++) {
                if (cartasMesa[i] > cartaMesaMayor) {
                    cartaMesaMayor = cartasMesa[i];
                }
            }
            int[] ganadoresBaza = new int[jugadores];
            int numeroGanadoresBaza = 0;
            for (int i = 0; i < jugadores; i++) {
                if (cartasMesa[i] == cartaMesaMayor) {
                    ganadoresBaza[i] = 1;
                    numeroGanadoresBaza++;
                }
            }
            int[] cartasDesempate = new int[jugadores];
            for (int i = 0; i < jugadores; i++) {
                if (numeroGanadoresBaza == 1 && ganadoresBaza[i] == 1) {
                    System.out.println("Jugador " + (i + 1) + " ha ganado esta baza");
                    cartasGanadasJugadores[i] += jugadores;
                    System.out.println("---------------------");
                    System.out.println();
                } else {
                    if (ganadoresBaza[i] == 1) {
                        System.out.println("Jugador " + (i + 1) + " ha empatado en esta baza sacas carta de la baraja");
                        if (indiceBaraja == baraja.length) {
                            System.out.println("No hay suficientes cartas para desempatar todos ganan");
                            for (int j = 0; j < cartasDesempate.length; j++) {
                                cartasDesempate[j] = 0;
                            }
                        } else {
                            cartasDesempate[i] = baraja[indiceBaraja];
                            indiceBaraja++;
                            System.out.println("Cartas en la mesa para el desempate: ");
                            for (int j = 0; j < cartasDesempate.length; j++) {
                                if (cartasDesempate[j] != 0) {
                                    System.out.print(cartasDesempate[j] + " ");
                                }
                            }
                            System.out.println();
                            System.out.println();
                        }
                    }
                }
            }
            if (numeroGanadoresBaza > 1) {
                int cartaDesempateMayor = cartasDesempate[0];
                for (int i = 0; i < jugadores; i++) {
                    if (cartasDesempate[i] > cartaDesempateMayor) {
                        cartaDesempateMayor = cartasDesempate[i];
                    }
                }
                for (int i = 0; i < jugadores; i++) {
                    if (cartasDesempate[i] == cartaDesempateMayor) {
                        System.out.println("Jugador " + (i + 1) + " ha ganado esta baza");
                        cartasGanadasJugadores[i] += (jugadores + numeroGanadoresBaza);
                    }
                }
                System.out.println("---------------------");
                System.out.println();
            }
        }
        int puntuacionMayor = cartasGanadasJugadores[0];
        for (int i = 0; i < jugadores; i++) {
            if (cartasGanadasJugadores[i] > puntuacionMayor) {
                puntuacionMayor = cartasGanadasJugadores[i];
            }
        }
        System.out.println("---------------------");
        for (int i = 0; i < jugadores; i++) {
            if (cartasGanadasJugadores[i] == puntuacionMayor) {
                System.out.println("Jugador " + (i + 1) + " ha ganado el juego");
            }
        }
        System.out.println("---------------------");
        System.out.println("Game over");
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
        for (int i = 0; i < 1000; i++) {
            int pos1 = r.nextInt(40);
            int pos2 = r.nextInt(40);
            int aux = deck[pos1];
            deck[pos1] = deck[pos2];
            deck[pos2] = aux;
        }
    }
}