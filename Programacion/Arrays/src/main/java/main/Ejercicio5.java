package main;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tabla1 = new int[10];
        int[] tabla2 = new int[10];
        int[] tabla3 = new int[20];
        for (int i = 0; i < tabla1.length; i++) {
            System.out.print("Introduce un numero: ");
            tabla1[i] = sc.nextInt();
        }
        for (int i = 0; i < tabla2.length; i++) {
            System.out.print("Introduce un numero: ");
            tabla2[i] = sc.nextInt();
        }
        for (int i = 0, j = 0, k = 0; i < tabla3.length; i++) {
            if (i % 2 == 0) {
                tabla3[i] = tabla1[j];
                j++;
            } else {
                tabla3[i] = tabla2[k];
                k++;
            }
        }
        for (int i = 0; i < tabla3.length; i++) {
            System.out.print(tabla3[i]+" ");
        }
    }
}
