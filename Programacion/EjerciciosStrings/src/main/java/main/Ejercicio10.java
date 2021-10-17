package main;

import java.util.Scanner;

public class Ejercicio10 {
    public void ejercicio10(Scanner sc){
        System.out.println("Introduce una palabra: ");
        String texto = sc.nextLine();
        StringBuilder alReves = new StringBuilder();
        alReves.append(texto).reverse();
        if (texto.equalsIgnoreCase(alReves.toString())){
            System.out.println("Es un palindromo");
        } else {
            System.out.println("No es un palindromo");
        }
    }
}
