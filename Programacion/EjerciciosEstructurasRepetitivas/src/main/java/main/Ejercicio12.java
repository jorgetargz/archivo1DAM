package main;

import java.util.Scanner;

public class Ejercicio12 {
    public void ejercicio12(Scanner sc) {
        int ahorroTotal = 0;
        //int mes = 1;
        for (int i = 0; i < 12; i++) {
        //while( mes <= 12) {
            System.out.println("Indica el ahorro del mes "+(i+1)+" :");
            int ahorroMes = sc.nextInt();
            ahorroTotal += ahorroMes;
            System.out.println("Llevas ahorrado: "+ahorroTotal);
            i++;
        }
        System.out.println("Este año has ahorrado: "+ahorroTotal);
    }
}
