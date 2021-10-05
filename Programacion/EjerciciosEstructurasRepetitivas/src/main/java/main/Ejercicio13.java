package main;

import java.util.Scanner;

public class Ejercicio13 {
    public void ejercicio13(Scanner sc){
        System.out.print("Indica a cuanto se paga la hora trabajada: ");
        double salarioHora = sc.nextDouble();
        int dia = 1;
        int horasTotal = 0;
        while (dia <=6){
            System.out.print("Indica las horas trabajdas el dia "+dia+" :");
            int horasDia = sc.nextInt();
            horasTotal += horasDia;
            dia++;
        }
        System.out.println("Esta semana se ha realizado "+horasTotal);
        double salarrioTotal = horasTotal * salarioHora;
        System.out.println("El salario semanal es : "+salarrioTotal+"€");
    }
}
