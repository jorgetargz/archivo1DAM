package main;

import java.util.Random;

public class Ejercicio12 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = new int[10];
        int posicion;
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9)+1;
        }
        System.out.println("Introduce la posicion para eliminar: ");
        posicion = r.nextInt(9);
        for (int i = posicion; i < 9; i++) {
            valores[i] = valores[i + 1];
        }
        valores[9]= 0;
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }
    }
}
