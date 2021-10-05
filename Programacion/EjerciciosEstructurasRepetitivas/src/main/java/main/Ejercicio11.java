package main;

import java.util.Scanner;

public class Ejercicio11 {
    public void ejercicio11(Scanner sc) {
        System.out.println("Indica un numero para comprobar si es primo: ");
        double numero = sc.nextDouble();
        boolean esPrimo = true;
        int divisor = 2;
        while (divisor < numero) {
            if (numero % divisor == 0) {
                esPrimo = false;
            }
            divisor++;
        }
        if (esPrimo == true){
            System.out.println("El numero "+numero+" es primo");
        } else {
            System.out.println("El numero "+numero+" no es primo");
        }
    }
}