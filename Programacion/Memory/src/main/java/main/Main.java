package main;

import dao.DaoTablero;
import utils.Constantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al memory. ");
        System.out.print("Selecciona dificultad [1(4X4), 2(6X6), 3(8X8)]: ");
        int dificultad = sc.nextInt();
        sc.nextLine();
        System.out.print("Selecciona el numero de jugadores: ");
        int jugadores = sc.nextInt();
        sc.nextLine();
        int turno = 0;
        int[] puntuacionJugadores = new int[jugadores];
        DaoTablero dao = new DaoTablero(dificultad);
        System.out.println(dao.getTablero());
        do {
            System.out.println("Jugador " + (turno + 1));
            int[] corCarta1 = elegirCarta(sc, dao);
            int[] corCarta2 = elegirCarta(sc, dao);
            if (!dao.compararCartas(corCarta1[0], corCarta1[1], corCarta2[0], corCarta2[1])) {
                System.out.println("Has fallado");
                dao.ocultarCarta(corCarta1[0], corCarta1[1]);
                dao.ocultarCarta(corCarta2[0], corCarta2[1]);
            } else {
                System.out.println("Has acertado");
                puntuacionJugadores[turno]++;
                turno--;
            }
            turno = (++turno) % jugadores;
        } while (dao.quedanCartasOcultas());
        for (int i = 0; i < jugadores; i++) {
            System.out.println("Jugador " + (i + 1) + " puntuación: " + puntuacionJugadores[i]);
        }
    }

    private static int[] elegirCarta(Scanner sc, DaoTablero dao) {
        int corX;
        int corY;
        boolean estabaLevantada = false;
        boolean coordenadaIncorrecta;
        do {
            coordenadaIncorrecta = false;
            System.out.println("Elige una carta :");
            System.out.print(Constantes.COORDENADA_X);
            corX = sc.nextInt();
            sc.nextLine();
            System.out.print(Constantes.COORDENADA_Y);
            corY = sc.nextInt();
            sc.nextLine();
            if (corX < 0 || corX > (dao.getTamanoTablero() - 1) || corY < 0 || corY > (dao.getTamanoTablero() - 1)) {
                System.out.println("Coordenada incorrecta se empieza desde 0");
                coordenadaIncorrecta = true;
            } else {
                if (dao.isLevantada(corX, corY)) {
                    System.out.println("Carta levantada elige otra. ");
                    estabaLevantada = true;
                } else {
                    dao.levantarCarta(corX, corY);
                    System.out.println(dao.getTablero());
                }
            }
        } while (estabaLevantada || coordenadaIncorrecta);
        return new int[]{corX, corY};
    }
}
