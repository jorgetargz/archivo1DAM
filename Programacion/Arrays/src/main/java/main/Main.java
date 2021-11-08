package main;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int menu;
        do {
            System.out.println("Ejercicios de Arrays");
            System.out.println("0. Salir. ");
            System.out.print("Introduce el ejercicio a realizar (1-16): ");
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 0:
                    System.out.println("Programa finalizado, adios.");
                    break;
                case 1:
                    Ejercicio1 ejercicio1 = new Ejercicio1();
                    ejercicio1.ejercicio1(r);
                    break;
                case 2:
                    Ejercicio2 ejercicio2 = new Ejercicio2();
                    ejercicio2.ejercicio2(r);
                    break;
                case 3:
                    Ejercicio3 ejercicio3 = new Ejercicio3();
                    ejercicio3.ejercicio3(r);
                    break;
                case 4:
                    Ejercicio4 ejercicio4 = new Ejercicio4();
                    ejercicio4.ejercicio4(r);
                    break;
                case 5:
                    Ejercicio5 ejercicio5 = new Ejercicio5();
                    ejercicio5.ejercicio5(r);
                    break;
                case 6:
                    Ejercicio6 ejercicio6 = new Ejercicio6();
                    ejercicio6.ejercicio6(r);
                    break;
                case 7:
                    Ejercicio7 ejercicio7 = new Ejercicio7();
                    ejercicio7.ejercicio7(r);
                    break;
                case 8:
                    Ejercicio8 ejercicio8 = new Ejercicio8();
                    ejercicio8.ejercicio8(r);
                    break;
                case 9:
                    Ejercicio9 ejercicio9 = new Ejercicio9();
                    ejercicio9.ejercicio9(r);
                    break;
                case 10:
                    Ejercicio10 ejercicio10 = new Ejercicio10();
                    ejercicio10.ejercicio10(r);
                    break;
                case 11:
                    Ejercicio11 ejercicio11 = new Ejercicio11();
                    ejercicio11.ejercicio11(r);
                    break;
                case 12:
                    Ejercicio12 ejercicio12 = new Ejercicio12();
                    ejercicio12.ejercicio12(r);
                    break;
                case 13:
                    System.out.println("Ejercicio 13 Indices");
                    Ejercicio13Indices ejercicio13Indices = new Ejercicio13Indices();
                    ejercicio13Indices.ejercicio13Indices(r);
                    System.out.println("Ejercicio 13 Valores");
                    Ejercicio13Valores ejercicio13Valores = new Ejercicio13Valores();
                    ejercicio13Valores.ejercicio13Valores(r);
                    break;
                case 14:
                    Ejercicio14 ejercicio14 = new Ejercicio14();
                    ejercicio14.ejercicio14();
                    break;
                case 15:
                    Ejercicio15 ejercicio15 = new Ejercicio15();
                    ejercicio15.ejercicio15(r);
                    break;
                case 16:
                    Ejercicio16 ejercicio16 = new Ejercicio16();
                    ejercicio16.ejercicio16(r);
                    break;
                default:
                    System.out.print("Introduce un numero del 1 al 16: ");
                    menu = sc.nextInt();
                    break;
            }
        } while (menu != 0);
    }
}
