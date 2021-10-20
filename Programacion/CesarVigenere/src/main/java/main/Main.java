package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1. Cesar");
            System.out.println("2. Vigenere");
            System.out.println("0. Salir");
            System.out.print("Introduce un numero: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Salir");
                    break;
                case 1:
                    int opcionCesar = 0;
                    do {
                    System.out.println("1. Cifrar en Cesar");
                    System.out.println("2. Descifrar Cesar");
                    System.out.println("0. Salir");
                    System.out.print("Introduce un numero: ");
                    opcionCesar = sc.nextInt();
                    sc.nextLine();
                    switch (opcionCesar) {
                        case 0:
                            System.out.println("Salir");
                            break;
                        case 1:
                            Cesar cifrarCesar = new Cesar();
                            cifrarCesar.cifrarCesar(sc);
                            break;
                        case 2:
                            Cesar descifrarCesar = new Cesar();
                            descifrarCesar.descifrarCesar(sc);
                            break;
                    }
                    } while (opcionCesar != 0);
                    break;
                case 2:
                    int opcionVigenere = 0;
                    do {
                        System.out.println("1. Cifrar en Vigenere");
                        System.out.println("2. Descifrar Vigenere");
                        System.out.println("0. Salir");
                        System.out.print("Introduce un numero: ");
                        opcionVigenere = sc.nextInt();
                        sc.nextLine();
                        switch (opcionVigenere) {
                            case 0:
                                System.out.println("Salir");
                                break;
                            case 1:
                                Vigenere cifrarVigenere = new Vigenere();
                               cifrarVigenere.cifrarVigenere(sc);
                                break;
                            case 2:
                                Vigenere descifrarVigenere = new Vigenere();
                                descifrarVigenere.descifrarVigenere(sc);
                                break;
                        }
                    }while (opcionVigenere != 0);
                    break;
                default:
                    System.out.print("Introduce un numero del 1 al 2: ");
                    opcion = sc.nextInt();
                    break;
            }
        } while (opcion != 0);
    }
}


