package main;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[10];
        for (int i = 0; i < valores.length; i++) {
            System.out.print("Introduce un numero: ");
            valores[i] = sc.nextInt();
        }
        for (int i = 0; i < valores.length / 2; i++) {
            System.out.print(valores[i] + " " + valores[valores.length - 1 - i] + " ");
        }
    }
}
