package main;

import java.util.Scanner;

public class Ej {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for (int i = 8; i >= 1 ; i--) {
             int valor = sc.nextInt();
             total += valor;
        }
        System.out.println(total);
    }
}
