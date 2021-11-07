package main;

import java.util.Random;

public class Ejercicio13Indices {
    public void ejercicio13Indices(Random r) {
        int[] valores = new int[10];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9)+1;
        }
        int indiceOrdenado = 0;
        int[] valoresOrdenados = new int[10];
        for (int i = 0; i < valores.length; i++) {
            if (i % 2 == 0) {
                valoresOrdenados[indiceOrdenado] = valores[i];
                indiceOrdenado++;
            }
        }
        for (int i = 0; i < valores.length; i++) {
            if (i % 2 != 0) {
                valoresOrdenados[indiceOrdenado] = valores[i];
                indiceOrdenado++;
            }
        }
        for (int i = 0; i < valoresOrdenados.length; i++) {
            System.out.print(valoresOrdenados[i] + " ");
        }
    }
}
