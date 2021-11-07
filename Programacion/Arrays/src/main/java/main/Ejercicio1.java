package main;

import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = new int[5];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9)+1;
        }
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i]+" ");
        }
    }
}