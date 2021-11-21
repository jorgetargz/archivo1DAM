package main;

import java.util.Random;

public class Ejercicio1_1 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = new int[10];
        int[] repeticiones = new int[10];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9)+1;
        }
        for (int i = 0; i < repeticiones.length; i++) {
            repeticiones[i] = r.nextInt(3)+1;
        }
        int posiciones = 0;
        for (int i = 0; i < repeticiones.length; i++) {
            posiciones += repeticiones[i];
        }
        int[] resultados = new int[posiciones];
        for (int i = 0, j = 0 ; i < resultados.length; j++) {
            while (repeticiones[j] >= 1) {
                resultados[i] = valores[j];
                i++;
                repeticiones[j] -= 1;
            }
        }
        for (int i = 0; i < resultados.length; i++) {
            System.out.print(resultados[i] + " ");
        }
    }
}

