package main;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Pintar dibujarAhorcado = new Pintar();
        Faker faker = new Faker(new Locale("es"));
        Scanner sc = new Scanner(System.in);
        StringBuilder mostrar = new StringBuilder();
        StringBuilder letrasProbadas = new StringBuilder();
        String palabra;
        int intentos = 9;
        int tema;
        System.out.println("1. Nombres de pokemon");
        System.out.println("2. Colores");
        System.out.println("3. Nombres de animales");
        System.out.println("4. Ingredientes");
        System.out.print("Elige un tema para el ahorcado: ");
        tema = sc.nextInt();
        sc.nextLine();
        switch (tema) {
            case 2:
                palabra = faker.color().name();
                break;
            case 3:
                palabra = faker.animal().name();
                break;
            case 4:
                palabra = faker.food().ingredient();
                break;
            default:
                palabra = faker.pokemon().name();
                break;
        }
        palabra = palabra.toUpperCase();
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) >= 'A' && palabra.charAt(i) <= 'Z') {
                mostrar.append("_");
            } else {
                mostrar.append(palabra.charAt(i));
            }
        }
        do {
            dibujarAhorcado.dibujarAhorcado(intentos);
            System.out.println("Ahorcado: ");
            System.out.println(mostrar);
            System.out.println();
            System.out.println("1. Pedir letra.");
            System.out.println("2. Adivinar el ahorcado.");
            System.out.println("0. Salir");
            System.out.print("¿Que quieres hacer?: ");
            int juego = sc.nextInt();
            sc.nextLine();
            switch (juego) {
                case 0:
                    intentos = 0;
                    dibujarAhorcado.dibujarAhorcado(intentos);
                    break;
                case 2:
                    System.out.print("¿Cual es?: ");
                    String respuesta = sc.nextLine();
                    if (palabra.equalsIgnoreCase(respuesta)) {
                        mostrar.replace(0, mostrar.length(), respuesta.toUpperCase());
                    } else {
                        System.out.println("Fallaste, no es la respuesta correcta");
                        intentos--;
                    }
                    break;
                default:
                    if (letrasProbadas.length() > 0) {
                        System.out.println("Letras probadas");
                        System.out.println(letrasProbadas);
                    }
                    System.out.print("Introduce una letra: ");
                    char letra = sc.nextLine().toUpperCase().charAt(0);
                    letrasProbadas.append(letra).append(" ");
                    if (palabra.indexOf(letra) >= 0) {
                        System.out.println("Acertaste, la letra " + letra + " esta");
                        for (int i = 0; i < palabra.length(); i++) {
                            i = palabra.indexOf(letra, i);
                            if (i >= 0) {
                                mostrar.replace(palabra.indexOf(letra, i), palabra.indexOf(letra, i) + 1, "" + letra);
                            } else {
                                i = palabra.length();
                            }
                        }
                    } else {
                        System.out.println("Fallaste, la letra " + letra + " no esta");
                        intentos--;
                    }
                    break;
            }
        } while (intentos > 0 && (mostrar.indexOf("_") >= 0));
        if (mostrar.indexOf("_") < 0) {
            intentos = 10;
            dibujarAhorcado.dibujarAhorcado(intentos);
        }
    }
}