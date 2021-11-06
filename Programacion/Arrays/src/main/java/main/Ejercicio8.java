package main;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[10];
//        for (int i = 0; i < 8; i++) {
//            System.out.print("Introduce un numero: ");
//            valores[i] = sc.nextInt();
//        }
        valores = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0, 0};
        System.out.println("Introduce un valor para añadir");
        int valorNuevo = sc.nextInt();
        System.out.println("Indica en que posicion se ha de añadir");
        int posValorNuevo = sc.nextInt();
        int[] valoresDesplazados = new int[10];
        for (int i = 0; i < 9; i++) {
            if (i > posValorNuevo) {
                valoresDesplazados[i] = valores[i-1];
            } else {
                valoresDesplazados[i] = valores[i];
            }
        }
        valoresDesplazados[posValorNuevo] = valorNuevo;
        for (int i = 0; i < valoresDesplazados.length; i++) {
            System.out.print(valoresDesplazados[i] + " ");
        }
    }
}
