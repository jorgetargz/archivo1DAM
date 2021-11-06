package main;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] valores = new int[5];
        for (int i = 0; i < valores.length; i++) {
            System.out.print("Introduce un numero: ");
            valores[i] = sc.nextInt();
        }
        for (int i = valores.length-1; i >= 0; i--) {
            System.out.print(valores[i]+" ");
        }
    }
}
