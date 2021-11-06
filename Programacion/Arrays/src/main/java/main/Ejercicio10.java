package main;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[10];
//        for (int i = 0; i < valores.length; i++) {
//            System.out.print("Introduce un numero: ");
//            valores[i] = sc.nextInt();
//        }
        valores = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Introduce un desplazamiento: ");
        int desplazamiento = sc.nextInt();

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
