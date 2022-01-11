package main;

import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {
        Random r = new Random();
        int intentos = 10000;
        int[] array = new int[20];
        boolean cumple;
        do {
            double sumaDivisibles5 = 0;
            int cantDivisibles5 = 0;
            double mediaDivisibles5;
            int sumaDivisibles2 = 0;
            double sumaTodos = 0;
            int cantTodos = 0;
            double mediaTodos;
            int valoresMayorMedia = 0;
            int numerosPrimos = 0;
            cumple = true;
            for (int i = 0; i < array.length; i++) {
                array[i] = r.nextInt(101);
            }
            for (int i = 0; i < array.length; i++) {
                sumaTodos += array[i];
                cantTodos++;
                if (array[i] % 2 == 0) {
                    sumaDivisibles2 += array[i];
                }
                if (array[i] % 5 == 0) {
                    sumaDivisibles5 += array[i];
                    cantDivisibles5++;
                }
            }
            if (cantDivisibles5 != 0) {
                mediaDivisibles5 = sumaDivisibles5 / cantDivisibles5;
            } else {
                mediaDivisibles5 = 0;
            }
            mediaTodos = sumaTodos / cantTodos;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > mediaTodos) {
                    valoresMayorMedia++;
                }
                boolean esPrimo = true;
                for (int j = 3; j < array[i]; j++) {
                    if (array[i] % j == 0) {
                        esPrimo = false;
                    }
                }
                if (esPrimo) {
                    numerosPrimos++;
                }
            }

            if (mediaDivisibles5 > sumaDivisibles2) {
                cumple = false;
            }
            if (valoresMayorMedia > 15) {
                cumple = false;
            }
            if (numerosPrimos > 7) {
                cumple = false;
            }

            intentos--;

        } while (intentos > 0 && !cumple);
        if (cumple) {
            System.out.println("Este array cumple las condiciones");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        } else {
            System.out.println("Se han acabado los intentos sin encontrar un array");
        }
    }
}