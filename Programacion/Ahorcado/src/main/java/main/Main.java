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
        System.out.println("5. Introducir tu propia palabra");
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
            case 5:
                System.out.print("Introduce una palabra: ");
                palabra = sc.nextLine();
                break;
            default:
                palabra = faker.pokemon().name();
                break;
        }
        palabra = palabra.toUpperCase();
        for (int i = 0; i < palabra.length(); i++) {
            if ((palabra.charAt(i) >= 'A' && palabra.charAt(i) <= 'Z' ) || palabra.charAt(i) == 'Ñ'){
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
            if (letrasProbadas.length() > 0) {
                System.out.println("Letras probadas");
                System.out.println(letrasProbadas);
            }
            System.out.print("Introduce una letra o adivina el ahorcado: ");
            String entrada = sc.nextLine().toUpperCase();
            if (entrada.length() == 1) {
                char letra = entrada.charAt(0);
                if (letrasProbadas.toString().contains("" + letra)) {
                    System.out.println("Ya has probado esa letra presta mas atencion");
                } else if (palabra.indexOf(letra) >= 0) {
                    System.out.println("Acertaste, la letra " + letra + " esta");
                    for (int i = 0; i < palabra.length(); i++) {
                        i = palabra.indexOf(letra, i);
                        if (i >= 0) {
                            mostrar.replace(palabra.indexOf(letra, i), palabra.indexOf(letra, i) + 1, "" + letra);
                        } else {
                            i = palabra.length();
                        }
                    }
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
        if (mostrar.indexOf("_") < 0) {
            intentos = 10;
        }
        dibujarAhorcado.dibujarAhorcado(intentos);
    }
}
