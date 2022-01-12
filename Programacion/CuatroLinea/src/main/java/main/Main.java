package main;

import dao.DaoTablero;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaoTablero dao = new DaoTablero();
        System.out.println("Bienvenido al 4 en linea");
        System.out.println(dao.getTablero());
        String valor = "";
        do {
            for (int i = 0; i < 2 && !dao.cuatroLinea(); i++) {
                dao.nuevaJugada();
                if (i == 0) {
                    System.out.println("Jugador 1 (X)");
                    valor = "X";
                } else {
                    System.out.println("Jugador 2 (O)");
                    valor = "O";
                }
                System.out.print("Columna (0-6): ");
                int corY = sc.nextInt();
                sc.nextLine();
                while (!dao.setCelda(corY, valor)) {
                    System.out.println("Columna llena indica otra. ");
                    System.out.print("Columna (0-6): ");
                    corY = sc.nextInt();
                    sc.nextLine();
                }
                System.out.println(dao.getTablero());
            }
        } while (dao.getJugadas() < 42 && !dao.cuatroLinea());
        if (dao.cuatroLinea()) {
            System.out.println("Gana "+valor);
        }
        System.out.println("Game over");
    }
}