package main;

import dao.DaoTablero;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaoTablero dao = new DaoTablero();
        System.out.println("Bienvenido al 3 en Raya");
        System.out.println(dao.getTablero().toString());
        do {
            String valor;
            for (int i = 0; i < 2 && !dao.tresLinea(); i++) {
                dao.nuevaJugada();
                if (i == 0) {
                    System.out.println("Jugador 1 (X)");
                    valor = "X";
                } else {
                    System.out.println("Jugador 2 (O)");
                    valor = "O";
                }
                System.out.print("Coordenada X: ");
                int corX = sc.nextInt();
                sc.nextLine();
                System.out.print("Coordenada Y: ");
                int corY = sc.nextInt();
                sc.nextLine();
                while (!dao.setCelda(corX, corY, valor)) {
                    System.out.println("Celda ocupada indica otra. ");
                    System.out.print("Coordenada X: ");
                    corX = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Coordenada Y: ");
                    corY = sc.nextInt();
                    sc.nextLine();
                }
                System.out.println(dao.getTablero().toString());
            }
        } while (dao.getJugadas() < 9 && !dao.tresLinea());
    }
}