package main;

import java.util.Scanner;

public class Ejercicio5 {
    public void ejercicio5(Scanner sc){
        System.out.println("Introduce un nombre completo: ");
        String texto = sc.nextLine();
        String espacio = " ";
        StringBuilder iniciales = new StringBuilder();
        iniciales.append(texto.charAt(0)).append(".");
        for (int i = 0; i < texto.length(); i++) {
            if (texto.trim().indexOf(espacio, i) == -1) {
                i = texto.length();
            } else {
                i = (texto.trim().indexOf(espacio, i));
                iniciales.append(texto.toUpperCase().charAt(i + 1)).append(".");
            }
        }
        System.out.println(iniciales.toString().toUpperCase());
    }
}
