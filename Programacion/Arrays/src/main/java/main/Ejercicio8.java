package main;

import java.util.Random;

public class Ejercicio8 {
    public void ejercicio8(Random r) {
        int[] valores = new int[10];
        for (int i = 0; i < 8; i++) {
            valores[i] = r.nextInt(9) + 1;
        }
        System.out.println("Introduce un valor para añadir");
        int valorNuevo = r.nextInt(9) + 1;
        System.out.println("Indica en que posicion se ha de añadir");
        int posValorNuevo = r.nextInt(7);
        int[] valoresDesplazados = new int[10];
        for (int i = 0; i < 9; i++) {
            if (i > posValorNuevo) {
                valoresDesplazados[i] = valores[i - 1];
            } else {
                valoresDesplazados[i] = valores[i];
            }
        }
        valoresDesplazados[posValorNuevo] = valorNuevo;
        for (int i = 0; i < valoresDesplazados.length; i++) {
            System.out.print(valoresDesplazados[i] + " ");
        }
    }
}
