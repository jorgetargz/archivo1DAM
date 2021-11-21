package main;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2_2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = new int[10];
        int[] operaciones = new int[9];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9)+1;
        }
        for (int i = 0; i < operaciones.length; i++) {
            operaciones[i] = r.nextInt(3)+1;
        }
        int resultado = valores[0];
        for (int i = 0; i < operaciones.length; i++) {
            switch (operaciones[i]) {
                case 1:
                    resultado += valores[i+1];
                    break;
                case 2:
                    resultado -= valores[i+1];
                    break;
                case 3:
                    resultado *= valores[i+1];
                    break;
                case 4:
                    resultado /= valores[i+1];
                    break;
                default:
                    System.out.println("Error digito de operación fuera de rango");
                    break;
            }
        }
        System.out.println(resultado);
    }
}
