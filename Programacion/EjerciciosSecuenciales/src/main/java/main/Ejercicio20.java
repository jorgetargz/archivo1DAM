package main;

import java.util.Scanner;

public class Ejercicio20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuantas monedas tienes de 2e? ");
        int monedas2e = sc.nextInt();
        System.out.print("¿Cuantas monedas tienes de 1e? ");
        int monedas1e = sc.nextInt();
        System.out.print("¿Cuantas monedas tienes de 50c? ");
        int monedas50c = sc.nextInt();
        System.out.print("¿Cuantas monedas tienes de 20c? ");
        int monedas20c = sc.nextInt();
        System.out.print("¿Cuantas monedas tienes de 10c? ");
        int monedas10c = sc.nextInt();
        int totalCent = monedas2e*200+monedas1e*100+monedas50c*50+monedas20c*20+monedas10c*10;
        int euros = totalCent/100;
        int centimos  = (totalCent-(euros*100));
        System.out.println("Dispones de un total de "+euros+" euros y "+centimos+" centimos");
    }
}