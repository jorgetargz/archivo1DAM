package main;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[10];
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce un numero: ");
            valores[i] = sc.nextInt();
        }

        System.out.print("Introduce un nuevo valor: ");
        int nuevoValor = sc.nextInt();
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
