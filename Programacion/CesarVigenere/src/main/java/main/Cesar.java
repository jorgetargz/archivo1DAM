package main;

import java.util.Scanner;

public class Cesar {
    public void cifrarCesar(Scanner sc) {
        System.out.println("Introduce el texto a cifrar:");
        String texto = sc.nextLine();
        System.out.println("Introduce la clave:");
        int clave = sc.nextInt();
        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                char caracterCifrado = (char) (((texto.charAt(i) - 'a') + clave) % 26 + 'a');
                cifrado.append(caracterCifrado);
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                char caracterCifrado = (char) (((texto.charAt(i) - 'A') + clave) % 26 + 'A');
                cifrado.append(caracterCifrado);
            } else {
                cifrado.append(texto.charAt(i));
            }
        }
        System.out.println("El mensaje cifrado es: ");
        System.out.println(cifrado);
    }

    public void descifrarCesar(Scanner sc) {
        System.out.println("Introduce el texto a cifrar:");
        String texto = sc.nextLine();
        System.out.println("Introduce la clave:");
        int clave = sc.nextInt();
        StringBuilder descifrado = new StringBuilder();
        clave = clave % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                char caracterCifrado = (char) (((texto.charAt(i) - 'a') - clave) % 26 + 'a');
                descifrado.append(caracterCifrado);
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                char caracterCifrado = (char) (((texto.charAt(i) - 'A') - clave) % 26 + 'A');
                descifrado.append(caracterCifrado);
            } else {
                descifrado.append(texto.charAt(i));
            }
        }
        System.out.println("El mensaje descifrado es: ");
        System.out.println(descifrado);
    }
}
