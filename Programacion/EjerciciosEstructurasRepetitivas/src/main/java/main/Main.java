package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("Ejercicios de Estructuras repetitivas");
            System.out.println("1. Calcula el factorial. ");
            System.out.println("2. Adivina el numero aleatorio.");
            System.out.println("3. Es un numero primo?");
            System.out.println("4. Calcular el ahorro");
            System.out.println("5. Calcular salario semanal");
            System.out.println("6. Calcular punto de encuentro");
            System.out.println("7. Calcular cuanto debe pagar");
            System.out.println("8. Sueldo semanal");
            System.out.println("9. Sueldo semanal y coste aempresa");
            System.out.println("10. Cronometro");
            System.out.println("11. Menu con salida");
            System.out.println("12. Mostrar numeros primos");
            System.out.println("0. Salir. ");
            System.out.print("Introduce el ejercicio a realizar: ");
            menu = sc.nextInt();
            switch (menu) {
                case 0:
                    System.out.println("Programa finalizado, adios.");
                    break;
                case 1:
                    Ejercicio1 ejercicio1 = new Ejercicio1();
                    ejercicio1.ejercicio1(sc);
                    break;
                case 2:
                    Ejercicio2 ejercicio2 = new Ejercicio2();
                    ejercicio2.ejercicio2(sc);
                    break;
                case 3:
                    Ejercicio11 ejercicio11 = new Ejercicio11();
                    ejercicio11.ejercicio11(sc);
                    break;
                case 4:
                    Ejercicio12 ejercicio12 = new Ejercicio12();
                    ejercicio12.ejercicio12(sc);
                    break;
                case 5:
                    Ejercicio13 ejercicio13 = new Ejercicio13();
                    ejercicio13.ejercicio13(sc);
                    break;
                case 6:
                    Ejercicio14 ejercicio14 = new Ejercicio14();
                    ejercicio14.ejercicio14();
                    break;
                case 7:
                    Ejercicio15 ejercicio15 = new Ejercicio15();
                    ejercicio15.ejercicio15();
                    break;
                case 8:
                    Ejercicio16 ejercicio16 = new Ejercicio16();
                    ejercicio16.ejercicio16(sc);
                    break;
                case 9:
                    Ejercicio17 ejercicio17 = new Ejercicio17();
                    ejercicio17.ejercicio17(sc);
                    break;
                case 10:
                    Ejercicio18 ejercicio18 = new Ejercicio18();
                    ejercicio18.ejercicio18();
                    break;
                case 11:
                    Ejercicio19 ejercicio19 = new Ejercicio19();
                    ejercicio19.ejercicio19(sc);
                    break;
                case 12:
                    Ejercicio20 ejercicio20 = new Ejercicio20();
                    ejercicio20.ejercicio20(sc);
                    break;
                default:
                    System.out.print("Introduce un numero del 1 al 12: ");
                    menu = sc.nextInt();
                    break;
            }
        } while (menu != 0);

    }
}