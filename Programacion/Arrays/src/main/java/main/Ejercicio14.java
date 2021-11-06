package main;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores1 = new int[10];
        for (int i = 0; i < valores1.length; i++) {
            System.out.print("Introduce un numero: ");
            valores1[i] = sc.nextInt();
        }
        int[] valores2 = new int[10];
        for (int i = 0; i < valores2.length; i++) {
            System.out.print("Introduce un numero: ");
            valores2[i] = sc.nextInt();
        }
        int[] valores3 = new int[20];
        int indiceValores1 = 0;
        int indiceValores2 = 0;
        int indiceValores3 = 0;
        while (indiceValores1 < 10 && indiceValores2 < 10) {
            if (valores1[indiceValores1] < valores2[indiceValores2]) {
                valores3[indiceValores3] = valores1[indiceValores1];
                indiceValores1++;
            } else {
                valores3[indiceValores3] = valores2[indiceValores2];
                indiceValores2++;
            }
            indiceValores3++;
        }
        if (indiceValores1 == 10) {
            while (indiceValores2 < 10) {
                valores3[indiceValores3] = valores2[indiceValores2];
                indiceValores2++;
                indiceValores3++;
            }
        } else {
            while (indiceValores1 < 10) {
                valores3[indiceValores3] = valores1[indiceValores1];
                indiceValores1++;
                indiceValores3++;
            }
        }
        for (int i = 0; i < valores3.length; i++) {
            System.out.print(valores3[i] + " ");
        }
    }
}
