package main;

import java.util.Random;

public class Ejercicio2 {
    public void ejercicio2(Random r) {
        int[] valores = new int[5];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9) + 1;
        }
        for (int i = valores.length - 1; i >= 0; i--) {
            System.out.print(valores[i] + " ");
        }
    }
}
