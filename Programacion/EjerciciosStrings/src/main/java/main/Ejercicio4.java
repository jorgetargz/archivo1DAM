package main;

import java.util.Scanner;

public class Ejercicio4 {
    public void ejercicio4(Scanner sc) {
        System.out.println("Introduce un texto: ");
        String texto = sc.nextLine();
        String espacio = " ";
        int contador = 1;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.trim().indexOf(espacio, i) == -1) {
                i = texto.length();
            } else {
                i = (texto.trim().indexOf(espacio, i));
                contador++;
            }
        }
        System.out.println("Hay " + contador + " palabras.");
    }
}
