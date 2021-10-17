package main;

import java.util.Scanner;

public class Ejercicio3 {
    public void ejercicio3(Scanner sc) {
        System.out.println("Introduce una cadena de caracteres: ");
        String texto = sc.nextLine();
        System.out.println("Introduce un caracter: ");
        String caracter = sc.nextLine();
        while (caracter.length() != 1) {
            System.out.println("Introduce un caracter");
            caracter = sc.nextLine();
        }
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.indexOf(caracter, i) == -1) {
                i=texto.length();
            } else {
                i=(texto.indexOf(caracter, i));
                contador++;
            }
        }
        System.out.println("El caracter "+caracter+" se repite "+contador+" veces.");
    }
}
