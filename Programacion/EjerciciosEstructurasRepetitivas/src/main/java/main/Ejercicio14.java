package main;

import java.util.Scanner;

public class Ejercicio14 {
    public void ejercicio14() {
        int persona1 = 70;
        int persona2 = 150;
        int distancia = Math.abs(persona1 - persona2);
        while (distancia >= 0.5) {
            persona1 += 1;
            persona2 -= 1;
            distancia = Math.abs(persona1 - persona2);
        }
        System.out.println("Se han encontrado en el km " + persona1);

    }
}
