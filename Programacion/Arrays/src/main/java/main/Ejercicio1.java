package main;

import java.util.Random;

public class Ejercicio1 {
    public void ejercicio1(Random r) {
        int[] valores = new int[5];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9) + 1;
        }
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }
    }
}