package main;

import java.util.Scanner;

public class Ejercicio2 {
    public void ejercicio2(Scanner sc){
        System.out.println("Introduce una cadena de caracteres: ");
        sc.nextLine();
        String texto = sc.nextLine();
        System.out.println("Introduce una subcadena de caracteres: ");
        String inicioTexto = sc.nextLine();
        if (texto.substring(0,inicioTexto.length()).equalsIgnoreCase(inicioTexto)){
            System.out.println("La cadena empieza por la subcadena");
        } else {
            System.out.println("La cadena no empieza por la subcadena");
        }
    }
}
