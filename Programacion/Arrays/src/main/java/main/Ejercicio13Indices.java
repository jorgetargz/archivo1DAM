package main;

import java.util.Scanner;

public class Ejercicio13Indices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[10];
        for (int i = 0; i < valores.length; i++) {
            System.out.print("Introduce un numero: ");
            valores[i] = sc.nextInt();
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
