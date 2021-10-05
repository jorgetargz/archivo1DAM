package main;

import java.util.Scanner;

public class Ejercicio1 {
    public void ejercicio1(Scanner sc) {
        System.out.println("Indica un numero para calcular su factorial: ");
        int n = sc.nextInt();
        int factorial = 1;
        for (int multiplicador = 2; multiplicador <= n; multiplicador++) {
            factorial = multiplicador * factorial;
        }
        System.out.println("El factorial de " + n + " es " + factorial);
    }
}
