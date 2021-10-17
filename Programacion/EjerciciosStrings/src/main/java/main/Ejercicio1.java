package main;

import java.util.Scanner;

public class Ejercicio1 {
    public void ejercicio1(Scanner sc){
        System.out.print("Introduce una cadena de caraacteres: ");
        String texto = sc.nextLine();
        for (int i = 0; i < texto.length(); i++) {
            System.out.println(texto.charAt(i));
        }
    }
}
