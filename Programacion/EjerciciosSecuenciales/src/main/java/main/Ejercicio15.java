package main;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce valor A: ");
        int a = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce valor B: ");
        int b = sc.nextInt();
        sc.nextLine();
        int aux=a;
        a=b;
        b=aux;
        System.out.println("El valor de A es: "+a);
        System.out.println("El valor de B es: "+b);
    }
}