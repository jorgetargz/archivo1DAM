package main;

import java.util.Random;

public class Ejercicio6 {
    public void ejercicio6(Random r) {
        int[] tabla1 = new int[12];
        int[] tabla2 = new int[12];
        int[] tabla3 = new int[24];
        for (int i = 0; i < tabla1.length; i++) {
            tabla1[i] = r.nextInt(9)+1;
        }
        for (int i = 0; i < tabla2.length; i++) {
            tabla2[i] = r.nextInt(9)+1;
        }
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
