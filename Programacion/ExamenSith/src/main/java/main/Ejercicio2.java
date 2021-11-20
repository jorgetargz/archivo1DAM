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
                vector[i] = r.nextInt(201) - 100;
            }
            valido = true;
            int suma = 0;
            double sumaNegativos = 0;
            int sumaPositivos = 0;
            int cantNegativos = 0;
            int cantPositivos = 0;
            double mediaNegativos;
            int negativoMayor = 0;
            int cuadradoMayorNegativo = 0;
            int sumaPosImparesAbs = 0;

            for (int i = 0; i < vector.length; i++) {
                suma += vector[i];
                if (i%2 != 0){
                    sumaPosImparesAbs += (Math.abs(vector[i]));
                }
                if (vector[i] < 0) {
                    negativoMayor = vector[i];
                    sumaNegativos += vector[i];
                    cantNegativos++;
                } else if (vector[i] > 0) {
                    sumaPositivos += vector[i];
                    cantPositivos++;
                }
            }
            for (int i = 0; i < vector.length; i++) {
                if (vector[i] < 0 && vector[i] > negativoMayor) {
                    negativoMayor = vector[i];
                }
            }
            cuadradoMayorNegativo = negativoMayor*negativoMayor;
            mediaNegativos = sumaNegativos/cantNegativos;
            boolean esPrimo = true;
            int divisor = 2;
            while (divisor < sumaPosImparesAbs && esPrimo) {
                if (sumaPosImparesAbs % divisor == 0) {
                    esPrimo = false;
                }
                divisor++;
            }

            if (suma < mediaNegativos){
                valido = false;
            }
            if (cantPositivos < cantNegativos){
                valido = false;
            }
            if (sumaPositivos < cuadradoMayorNegativo){
                valido = false;
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
            System.out.println("Vector valido para destruir la fragata");
        } else {
            System.out.println("La fragata ha escapado");
        }
    }
}
