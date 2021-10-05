package main;

import java.util.Scanner;

public class Ejercicio19 {
    public void ejercicio19(Scanner sc) {
        int menu2 = 0;
        do {
            System.out.println("1. Entrada de menu 1");
            System.out.println("2. Entrada de menu 2");
            System.out.println("3. Entrada de menu 3");
            System.out.println("4. Entrada de menu 4");
            System.out.println("0. Salir ");
            System.out.println("Indica la entrada a ejecutar: ");
            menu2 = sc.nextInt();
            switch (menu2) {
                case 1:
                    System.out.println("Primera entrada");
                    break;
                case 2:
                    System.out.println("Segunda entrada");
                    break;
                case 3:
                    System.out.println("Tercera entrada");
                    break;
                case 4:
                    System.out.println("Cuarta entarda");
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Introduce un numero de entrada valido");
                    break;
            }
        } while (menu2 != 0);
    }
}
