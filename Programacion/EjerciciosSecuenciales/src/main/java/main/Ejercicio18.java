package main;

import java.util.Scanner;

public class Ejercicio18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cual es tu nombre? ");
        String nombre = sc.nextLine();
        System.out.print("¿Cual es tu primer apellido? ");
        String apellido1 = sc.nextLine();
        System.out.print("¿Cual es tu segundo apellido? ");
        String apellido2 = sc.nextLine();
        System.out.println("Tus iniciales son: "+nombre.toUpperCase().charAt(0)+"."+apellido1.charAt(0)+"."+apellido2.charAt(0)+".");
    }
}