package main;

import java.util.Random;

public class Ejercicio5 {
    public void ejercicio5(Random r) {
        int[] tabla1 = new int[10];
        int[] tabla2 = new int[10];
        int[] tabla3 = new int[20];
        for (int i = 0; i < tabla1.length; i++) {
            tabla1[i] = r.nextInt(9)+1;
        }
        for (int i = 0; i < tabla2.length; i++) {
            tabla2[i] = r.nextInt(9)+1;
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
