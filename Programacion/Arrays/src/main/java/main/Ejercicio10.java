package main;

import java.util.Random;

public class Ejercicio10 {
    public void ejercicio10(Random r) {
        int[] valores = new int[10];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9)+1;
        }
        System.out.println("Introduce un desplazamiento: ");
        int desplazamiento = r.nextInt(9)+1;

        do {
            int ultimoValor = valores[9];
            for (int i = 8; i >= 0; i--) {
                valores[i + 1] = valores[i];
            }
            valores[0] = ultimoValor;
            desplazamiento--;
        } while (desplazamiento > 0);

        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }
    }
}
