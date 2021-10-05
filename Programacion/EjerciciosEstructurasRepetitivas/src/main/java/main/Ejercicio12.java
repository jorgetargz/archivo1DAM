package main;

import java.util.Scanner;

public class Ejercicio12 {
    public void ejercicio12(Scanner sc) {
        int ahorroTotal = 0;
        int mes = 1;
        while( mes <= 12) {
            System.out.println("Indica el ahorro del mes "+mes+" :");
            int ahorroMes = sc.nextInt();
            ahorroTotal += ahorroMes;
            System.out.println("Llevas ahorrado: "+ahorroTotal);
            mes++;
        }
        System.out.println("Este año has ahorrado: "+ahorroTotal);
    }
}
