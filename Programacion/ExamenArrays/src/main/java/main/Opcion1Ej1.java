package main;

import java.util.Random;

public class Opcion1Ej1 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = new int[10];
        int[] repeticiones = new int[10];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(10)+1;
            System.out.print(valores[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < repeticiones.length; i++) {
            repeticiones[i] = r.nextInt(2)+1;
            System.out.print(repeticiones[i]+ " ");
        }
        System.out.println();
        int posiciones = 0;
        for (int i = 0; i < repeticiones.length; i++) {
            posiciones += repeticiones[i];
        }
        int[] resultados = new int[posiciones];
        int indiceResultados = 0;
        for (int j = 0 ; indiceResultados < resultados.length; j++) {
            while (repeticiones[j] >= 1) {
                resultados[indiceResultados] = valores[j];
                indiceResultados++;
                repeticiones[j] -= 1;
            }
        }
        for (int i = 0; i < resultados.length; i++) {
            System.out.print(resultados[i] + " ");
        }
    }
}

