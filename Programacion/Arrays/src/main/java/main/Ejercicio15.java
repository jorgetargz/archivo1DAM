package main;

import java.util.Random;

public class Ejercicio15 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = {1,2,3,4,5,6,7,8,9,10};
        int numeroABuscar = r.nextInt(9)+1;
        int i = 0;
        while (i < valores.length && valores[i] < numeroABuscar) {
            i++;
        }
        if (valores[i]==numeroABuscar){
            System.out.println("El numero se encuentra en la posicion "+(i+1));
        } else {
            System.out.println("El numero no esta en el array");
        }
    }
}
