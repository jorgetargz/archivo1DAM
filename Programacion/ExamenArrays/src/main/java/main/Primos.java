package main;

import java.util.Scanner;

public class Primos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esPrimo = true;
        int numero = sc.nextInt();
        for (int i = 3; i < numero; i++) {
            if (numero % i == 0){
                esPrimo = false;
            }
        }
        if (esPrimo){
            System.out.println("Numero primo");
        } else {
            System.out.println("Numero no primo");
        }
    }
}

