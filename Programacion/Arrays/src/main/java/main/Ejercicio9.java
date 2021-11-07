package main;

import java.util.Random;

public class Ejercicio9 {
    public void ejercicio9(Random r) {
        int[] valores = new int[10];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9) + 1;
        }
        int ultimoValor = valores[9];
        for (int i = 8; i >= 0; i--) {
            valores[i + 1] = valores[i];
        }
        valores[0] = ultimoValor;
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }
    }
}
