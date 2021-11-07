package main;

import java.util.Random;

public class Ejercicio11 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = {1,2,3,4,5,0,0,0,0,0};
        int nuevoValor = r.nextInt(9)+1;
        int posicionNuevoValor = 0;
        int j = 0;
        while (valores[j] < nuevoValor && j <= 4) {
            posicionNuevoValor++;
            j++;
        }

        for (int i = 4; i >= posicionNuevoValor; i--) {
            valores[i + 1] = valores[i];
        }
        valores[posicionNuevoValor] = nuevoValor;

        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }
    }
}
