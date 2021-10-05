package main;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indica el primer número: ");
        double n1 = sc.nextDouble();
        System.out.print("Indica el segundo número: ");
        double n2 = sc.nextDouble();
        if (n1 == n2) {
            System.out.println("Los números son iguales");
        } else if (n1 > n2) {
            System.out.println(n1 + " es mayor que " + n2);
        } else {
            System.out.println(n2 + " es mayor que " + n1);
        }
    }
}