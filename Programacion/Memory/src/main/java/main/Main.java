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
        DaoTablero dao = new DaoTablero(dificultad);
        System.out.println(dao.getTablero());
        do {
            int[] corCarta1 = elegirCarta(sc, dao);
            int[] corCarta2 = elegirCarta(sc, dao);
            if (!dao.compararCartas(corCarta1[0],corCarta1[1],corCarta2[0],corCarta2[1])){
                dao.ocultarCarta(corCarta1[0],corCarta1[1]);
                dao.ocultarCarta(corCarta2[0],corCarta2[1]);
            }
        } while (dao.quedanCartasOcultas());
    }

    private static int[] elegirCarta(Scanner sc, DaoTablero dao) {
        System.out.println("Elige una carta :");
        System.out.print(Constantes.COORDENADA_X);
        int corX = sc.nextInt();
        sc.nextLine();
        System.out.print(Constantes.COORDENADA_Y);
        int corY = sc.nextInt();
        sc.nextLine();
        dao.levantarCarta(corX, corY);
        System.out.println(dao.getTablero());
        return new int[]{corX, corY};
    }
}
