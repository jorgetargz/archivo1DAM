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
        palabra = generarPalabra(faker, sc);
        ocultarPalabra(mostrar, palabra);
        bucleJuego(dibujarAhorcado, sc, mostrar, letrasProbadas, palabra, intentos);
        if (mostrar.indexOf("_") < 0) {
            intentos = 10;
        }
        dibujarAhorcado.dibujarAhorcado(intentos);
    }

    private static void ocultarPalabra(StringBuilder mostrar, String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            if ((palabra.charAt(i) >= 'A' && palabra.charAt(i) <= 'Z') || palabra.charAt(i) == 'Ñ') {
                mostrar.append("_");
            } else {
                mostrar.append(palabra.charAt(i));
            }
        }
    }

    private static String generarPalabra(Faker faker, Scanner sc) {
        String palabra;
        int tema;
        System.out.println("1. Nombres de pokemon");
        System.out.println("2. Colores");
        System.out.println("3. Nombres de animales");
        System.out.println("4. Ingredientes");
        System.out.println("5. Introducir tu propia palabra");
        System.out.print("Elige un tema para el ahorcado: ");
        tema = sc.nextInt();
        sc.nextLine();
        switch (tema) {
            case 1:
                palabra = faker.pokemon().name();
                break;
            case 2:
                palabra = faker.color().name();
                break;
            case 3:
                palabra = faker.animal().name();
                break;
            case 4:
                palabra = faker.food().ingredient();
                break;
            case 5:
                System.out.print("Introduce una palabra: ");
                palabra = sc.nextLine();
                break;
            default:
                System.out.println("Ese tema no existe introduce una palabra para jugar");
                palabra = sc.nextLine();
                break;
        }
        palabra = palabra.toUpperCase();
        return palabra;
    }

    private static void bucleJuego(Pintar dibujarAhorcado, Scanner sc, StringBuilder mostrar, StringBuilder letrasProbadas, String palabra, int intentos) {
        do {
            dibujarAhorcado.dibujarAhorcado(intentos);
            System.out.println("Ahorcado: ");
            System.out.println(mostrar);
            System.out.println();
            if (letrasProbadas.length() > 0) {
                System.out.println("Letras probadas");
                System.out.println(letrasProbadas);
            }
            System.out.print("Introduce una letra o adivina el ahorcado: ");
            String entrada = sc.nextLine().toUpperCase();
            if (entrada.length() == 1) {
                char letra = entrada.charAt(0);
                if (letrasProbadas.toString().contains("" + letra)) {
                    System.out.println("Ya has probado esa letra presta mas atención");
                } else if (palabra.indexOf(letra) >= 0) {
                    jugarLetra(mostrar, palabra, letra);
                    letrasProbadas.append(letra).append(" ");
                } else {
                    System.out.println("Fallaste, la letra " + letra + " no esta");
                    letrasProbadas.append(letra).append(" ");
                    intentos--;
                }
            } else if (palabra.equalsIgnoreCase(entrada)) {
                mostrar.replace(0, mostrar.length(), entrada.toUpperCase());
            } else {
                System.out.println("Fallaste, no es la respuesta correcta");
                intentos--;
            }
        } while (intentos > 0 && (mostrar.indexOf("_") >= 0));
    }

    private static void jugarLetra(StringBuilder mostrar, String palabra, char letra) {
        System.out.println("Acertaste, la letra " + letra + " esta");
        boolean hayMas = true;
        for (int i = 0; hayMas; i++) {
            if (palabra.indexOf(letra, i) >= 0) {
                mostrar.replace(palabra.indexOf(letra, i), palabra.indexOf(letra, i) + 1, "" + letra);
            } else {
                hayMas = false;
            }
        }
    }
}