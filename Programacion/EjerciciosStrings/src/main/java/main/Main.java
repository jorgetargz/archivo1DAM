package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("Ejercicios de Strings");
            System.out.println("1.  ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. ");
            System.out.println("6. ");
            System.out.println("7. ");
            System.out.println("8. ");
            System.out.println("9. ");
            System.out.println("10. ");
            System.out.println("0. Salir. ");
            System.out.print("Introduce el ejercicio a realizar: ");
            menu = sc.nextInt();
            sc.nextLine();
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
                    Ejercicio3 ejercicio3 = new Ejercicio3();
                    ejercicio3.ejercicio3(sc);
                    break;
                case 4:
                    Ejercicio4 ejercicio4 = new Ejercicio4();
                    ejercicio4.ejercicio4(sc);
                    break;
                case 5:
                    Ejercicio5 ejercicio5 = new Ejercicio5();
                    ejercicio5.ejercicio5(sc);
                    break;
                case 6:
                    Ejercicio6 ejercicio6 = new Ejercicio6();
                    ejercicio6.ejercicio6(sc);
                    break;
                case 7:
                    Ejercicio7 ejercicio7 = new Ejercicio7();
                    ejercicio7.ejercicio7(sc);
                    break;
                case 8:
                    Ejercicio8 ejercicio8 = new Ejercicio8();
                    ejercicio8.ejercicio8(sc);
                    break;
                case 9:
                    Ejercicio9 ejercicio9 = new Ejercicio9();
                    ejercicio9.ejercicio9(sc);
                    break;
                case 10:
                    Ejercicio10 ejercicio10 = new Ejercicio10();
                    ejercicio10.ejercicio10(sc);
                    break;
                default:
                    System.out.print("Introduce un numero del 1 al 10: ");
                    menu = sc.nextInt();
                    break;
            }
        } while (menu != 0);
    }
}
