package main;

import java.util.Scanner;

public class Ejercicio7 {
    public void ejercicio7(Scanner sc) {
        System.out.println("Introduce una cadena de caracteres: ");
        String texto = sc.nextLine();
        System.out.println("Introduce un caracter a remplazar: ");
        String caracter1 = sc.nextLine();
        while (caracter1.length() != 1) {
            System.out.println("Introduce un caracter a remplazar");
            caracter1 = sc.nextLine();
        }
        System.out.println("Introduce un caracter para remplazar: ");
        String caracter2 = sc.nextLine();
        while (caracter2.length() != 1) {
            System.out.println("Introduce un caracter para remplazar");
            caracter2 = sc.nextLine();
        }
        System.out.println(texto.replace(caracter1,caracter2));
    }
}
