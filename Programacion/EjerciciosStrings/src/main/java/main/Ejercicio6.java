package main;

import java.util.Scanner;

public class Ejercicio6 {
    public void ejercicio6(Scanner sc) {
        System.out.println("Introduce una cadena de caracteres: ");
        String texto = sc.nextLine();
        StringBuilder alReves = new StringBuilder();
        System.out.println(alReves.append(texto).reverse());
    }
}
