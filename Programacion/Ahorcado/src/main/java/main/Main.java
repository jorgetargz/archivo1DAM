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
        System.out.print("Elige un tema para el ahorcado: ");
        int tema = sc.nextInt();
        sc.nextLine();
        String palabra = "";
        StringBuilder mostrar = new StringBuilder();
        StringBuilder letrasProbadas = new StringBuilder();
        int intentos = 9;
        switch (tema) {
            case 0:
                System.out.println("Gracias por jugar");
                break;
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
            default:
                System.out.print("Introduce 1-4, 0 para salir:");
                tema = sc.nextInt();
        }
        palabra = palabra.toUpperCase();
        palabra = "DEDEDDE";
        System.out.println(palabra);
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == ' ') {
                mostrar.append(" ");
            } else if (palabra.charAt(i) >= 'A' && palabra.charAt(i) <= 'Z') {
                mostrar.append("_");
            }
        }
        System.out.println(mostrar);
        Pintar DibujarAhorcado = new Pintar();
        do {
            System.out.println("1. Pedir letra.");
            System.out.println("2. Adivinar el ahorcado.");
            System.out.println("0. Salir");
            System.out.print("¿Que quieres hacer?: ");
            int juego = sc.nextInt();
            sc.nextLine();

            switch (juego) {
                case 0:
                    intentos = 0;
                    DibujarAhorcado.DibujarAhorcado(intentos);
                    break;
                case 1:
                    System.out.println("Letras probadas");
                    System.out.println(letrasProbadas);
                    System.out.print("Introduce una letra: ");
                    char letra = sc.nextLine().toUpperCase().charAt(0);
                    letrasProbadas.append(letra).append(" ");
                    if (palabra.indexOf(letra) >= 0) {
                        System.out.println("Acertaste, la letra "+letra+" esta");
                        for (int i = 0; i < palabra.length(); i++) {
                            i = palabra.indexOf(letra, i);
                            if (i != -1){
                                mostrar.replace(palabra.indexOf(letra,i),palabra.indexOf(letra,i)+1,""+letra);
                            } else {
                                i = palabra.length();
                            }
                        }
                        System.out.println(mostrar);
                    } else {
                        System.out.println("Fallaste, la letra "+letra+" no esta");
                        if (letrasProbadas.indexOf(""+letra) != -1)
                        intentos--;
                        DibujarAhorcado.DibujarAhorcado(intentos);
                        System.out.println(mostrar);
                        System.out.println();
                    }
                    break;
                case 2:
                    break;
            }

        } while (intentos > 0 && (mostrar.indexOf("_") >= 0));
        if (mostrar.indexOf("_") < 0) {
            intentos = 10;
            DibujarAhorcado.DibujarAhorcado(intentos);
        }

    }
}

