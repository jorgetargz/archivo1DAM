package main;

import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] valores = new int[5];
        int sumaValoresPositivos = 0;
        int sumaValoresNegativos = 0;
        int contadorPositivos = 0;
        int contadorNegativos = 0;
        int mediaValoresPositivos;
        int mediaValoresNegativos;
        int contadorCeros = 0;
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(10);
        }
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] > 0) {
                sumaValoresPositivos += valores[i];
                contadorPositivos++;
            } else if (valores[i] < 0) {
                sumaValoresNegativos += valores[i];
                contadorNegativos++;
            } else if (valores[i] == 0) {
                contadorCeros++;
            }
        }
        if (contadorPositivos > 0) {
            mediaValoresPositivos = sumaValoresPositivos / contadorPositivos;
            System.out.print("La media de los numeros positivos: " + mediaValoresPositivos);
        }
        if (contadorNegativos > 0) {
            mediaValoresNegativos = sumaValoresNegativos / contadorNegativos;
            System.out.println("La media de los numeros negativos: " + mediaValoresNegativos);
        }
        System.out.print("Numero de ceros: " + contadorCeros);

    }
}
