package main;

import java.util.Scanner;

public class Ejercicio2 {
    public void ejercicio2 (Scanner sc){
        int numeroAleatorio = (int) (Math.random() * 100 + 1);
        int numeroUsuario;
        int intentos = 10;
        System.out.println("Adivina el numero entre 1 y 100. ");
        do {
            System.out.println("Tienes " + intentos + " intentos");
            System.out.print("¿Cúal es el numero? ");
            numeroUsuario = sc.nextInt();
            if (numeroUsuario == numeroAleatorio) {
                System.out.println("Enhorabuena has acertado");
            } else if (numeroUsuario < numeroAleatorio) {
                System.out.print("No has acertado, el número es mayor. ");
                intentos = intentos - 1;
            } else {
                System.out.print("No has acertado, el número es menor. ");
                intentos = intentos - 1;
            }
        } while (numeroUsuario != numeroAleatorio && intentos > 0);
        if (numeroUsuario == numeroAleatorio) {
            System.out.println("Te han sobrado " + intentos + " intentos");
        } else {
            System.out.println("Has perdido el numero era " + numeroAleatorio);
        }
    }
}

