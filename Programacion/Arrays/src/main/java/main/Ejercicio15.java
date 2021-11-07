package main;

import java.util.Random;

public class Ejercicio15 {
    public void ejercicio15(Random r) {
        int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numeroABuscar = r.nextInt(9) + 1;
        int i = 0;
        while (i < valores.length && valores[i] < numeroABuscar) {
            i++;
        }
        if (valores[i] == numeroABuscar) {
            System.out.println("El numero " + numeroABuscar + " se encuentra en la posicion " + (i + 1));
        } else {
            System.out.println("El numero " + numeroABuscar + " no esta en el array");
        }
    }
}
