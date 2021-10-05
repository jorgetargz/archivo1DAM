package main;

import java.util.Scanner;

public class Ejercicio20 {
    public void ejercicio20(Scanner sc) {
        System.out.println("Indica cuantos numeros primos quieres ver: ");
        int numeroDePrimos = sc.nextInt();
        int contador = 0;
        int numero = 2;
        while (contador <= numeroDePrimos) {
            boolean esPrimo = true;
            int divisor = 2;
            while (divisor < numero) {
                if (numero % divisor == 0) {
                    esPrimo = false;
                }
                divisor++;
            }
            if (numero == 2) {
                esPrimo = true;
            }
            if (esPrimo == true) {
                System.out.println("El numero " + numero + " es primo");
                contador++;
            }
            numero++;
        }
    }
}
