package main;

import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] vector = new int[10];
        int intentos = 1000000;
        boolean valido;
        do {
            for (int i = 0; i < vector.length; i++) {
                vector[i] = r.nextInt(27) - 3;
            }
            valido = true;

            int suma = 0;
            int pares = 0;
            int impares = 0;
            int sumaImpares = 0;
            double sumaPosPares = 0;
            for (int i = 0; i < vector.length; i++) {
                suma += vector[i];
                if (i%2 == 0){
                    sumaPosPares += vector[i];
                }
                if (vector[i] % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                    sumaImpares += vector[i];
                }
            }
            if (suma <= 0) {
                valido = false;
            }
            if (pares < impares) {
                valido = false;
            }
            if (sumaImpares % 3 != 0) {
                valido = false;
            }

            boolean esPrimo = true;
            int divisor = 2;
            while (divisor < sumaPosPares && esPrimo) {
                if (sumaPosPares % divisor == 0) {
                    esPrimo = false;
                }
                divisor++;
            }
            if (!esPrimo){
                valido = false;
            }

            intentos--;
        } while (!valido && intentos > 0);
        if (valido) {
            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i] + " ");
            }
            System.out.println("Vector valido para salir al hiperespacio");
        } else {
            System.out.println("El destructor ha destruido nuestra fragata");
        }
    }
}