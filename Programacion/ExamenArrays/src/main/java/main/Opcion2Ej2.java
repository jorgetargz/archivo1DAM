package main;

import java.util.Random;

public class Opcion2Ej2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = new int[10];
        int[] operaciones = new int[9];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(10) + 1;
            System.out.print(valores[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < operaciones.length; i++) {
            operaciones[i] = r.nextInt(4) + 1;
            System.out.print(operaciones[i] + " ");
        }
        System.out.println();
        int resultado = valores[0];
        for (int i = 0; i < operaciones.length; i++) {
            switch (operaciones[i]) {
                case 1:
                    resultado += valores[i + 1];
                    break;
                case 2:
                    resultado -= valores[i + 1];
                    break;
                case 3:
                    resultado *= valores[i + 1];
                    break;
                case 4:
                    resultado /= valores[i + 1];
                    break;
                default:
                    System.out.println("Error digito de operación fuera de rango");
                    break;
            }
        }
        System.out.println("Resultado: " + resultado);
    }
}
