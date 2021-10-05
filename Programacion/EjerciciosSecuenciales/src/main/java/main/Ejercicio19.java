package main;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el numero de respuestas correctas: ");
        double correctas = sc.nextInt();
        System.out.print("Introduce el numero de respuestas incorrectas: ");
        double incorrectas = sc.nextInt();
        System.out.print("Introduce el numero de respuestas sin responder: ");
        double noRespondido = sc.nextInt();
        double resultado = ((correctas*5)+(incorrectas*(-1)));
        double perfecto = (correctas+incorrectas+noRespondido)*5;
        System.out.println("El alumno ha obtenido "+resultado+" sobre "+perfecto);
        double sobre10 = (resultado*10)/perfecto;
        System.out.println("El alumno ha obtenido "+sobre10+" /10");
    }
}