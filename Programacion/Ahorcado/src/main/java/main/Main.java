package main;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("es"));
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Nombres de pokemon");
        System.out.println("2. Colores");
        System.out.println("3. Nombres de animales");
        System.out.println("4. Ingredientes");
        System.out.println("0. Salir");
        System.out.println("Elige un tema para el ahorcado: ");
        int tema = sc.nextInt();
        String palabra = "";
        switch (tema) {
            case 0:
                System.out.println("Gracias por jugar");
                break;
            case 1:
                palabra = faker.pokemon().name().toUpperCase();
                break;
            case 2:
                palabra = faker.color().name().toUpperCase();
                break;
            case 3:
                palabra = faker.animal().name().toUpperCase();
                break;
            case 4:
                palabra = faker.food().ingredient().toUpperCase();

        }
        System.out.println(palabra);

        }
    }

