package main;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tabla1 = new int[12];
        int[] tabla2 = new int[12];
        int[] tabla3 = new int[24];
        {
//        for (int i = 0; i < tabla1.length; i++) {
//            System.out.print("Introduce un numero: ");
//            tabla1[i] = sc.nextInt();
//        }
//        for (int i = 0; i < tabla2.length; i++) {
//            System.out.print("Introduce un numero: ");
//            tabla2[i] = sc.nextInt();
//        }
            tabla1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            tabla2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            int indiceTabla3 = 0;
            int indiceAuxiliar = 0;
            while (indiceAuxiliar < 12) {
                for (int i = 0; i < 3; i++) {
                    tabla3[indiceTabla3] = tabla1[i + indiceAuxiliar];
                    indiceTabla3++;
                }
                for (int i = 0; i < 3; i++) {
                    tabla3[indiceTabla3] = tabla2[i + indiceAuxiliar];
                    indiceTabla3++;
                }
                indiceAuxiliar += 3;
            }
            for (int i = 0; i < tabla3.length; i++) {
                System.out.print(tabla3[i] + " ");
            }
        }
    }
}
