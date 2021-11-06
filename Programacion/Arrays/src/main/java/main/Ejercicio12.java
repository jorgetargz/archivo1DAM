package main;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[10];
        int posicion;
        for (int i = 0; i < valores.length; i++) {
            System.out.print("Introduce un numero: ");
            valores[i] = sc.nextInt();
        }
        System.out.println("Introduce la posicion para eliminar: ");
        posicion = sc.nextInt();
        for (int i = posicion; i < 9; i++) {
            valores[i] = valores[i + 1];
        }
        valores[9]= 0;
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }
    }
}
