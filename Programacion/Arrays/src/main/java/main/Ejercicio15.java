package main;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[10];
//        for (int i = 0; i < valores.length; i++) {
//            System.out.print("Introduce un numero: ");
//            valores[i] = sc.nextInt();
//        }
        valores = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numeroABuscar = sc.nextInt();
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
