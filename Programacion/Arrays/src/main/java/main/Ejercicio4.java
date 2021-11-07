package main;

import java.util.Random;

public class Ejercicio4 {
    public void ejercicio4(Random r) {
        int[] valores = new int[10];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9)+1;
        }
        for (int i = 0; i < valores.length / 2; i++) {
            System.out.print(valores[i] + " " + valores[valores.length - 1 - i] + " ");
        }
    }
}
