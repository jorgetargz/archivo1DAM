package main;

import java.util.Scanner;

public class Ejercicio9 {
    public void ejercicio9(Scanner sc) {
        System.out.println("Introduce una cadena de caracteres: ");
        String texto = sc.nextLine();
        System.out.println("Introduce otra cadena de caracteres: ");
        String texto2 = sc.nextLine();
        if (texto.contains(texto2)) {
            System.out.println("La segunda cadena es parte de la primera");
        } else {
            System.out.println("La segunda cadena no es parte de la primera");
        }
    }
}
