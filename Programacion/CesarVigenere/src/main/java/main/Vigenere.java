package main;

import java.util.Scanner;

public class Vigenere {
    public void cifrarVigenere(Scanner sc) {
        System.out.println("Introduce el texto a cifrar:");
        String texto = sc.nextLine();
        System.out.println("Introduce la clave:");
        String clave = sc.nextLine();
        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caraterTexto = texto.charAt(i);
            char caracterClave = clave.charAt((i) % clave.length());
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                cifrado.append((char) ((caraterTexto + caracterClave) % 26 + 'a'));
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                cifrado.append((char) ((caraterTexto + caracterClave - 2 * 'A') % 26 + 'A'));
            } else {
                cifrado.append(texto.charAt(i));
            }
        }
        System.out.println("El mensaje cifrado es: ");
        System.out.println(cifrado);
    }

    public void descifrarVigenere(Scanner sc) {
        System.out.println("Introduce el texto a descifrar:");
        String texto = sc.nextLine();
        System.out.println("Introduce la clave:");
        String clave = sc.nextLine();
        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caraterTexto = texto.charAt(i);
            char caracterClave = clave.charAt((i) % clave.length());
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                cifrado.append((char) ((caraterTexto + caracterClave) % 26 + 'a'));
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                cifrado.append((char) ((caraterTexto + caracterClave) % 26 + 'A'));
            } else {
                cifrado.append(texto.charAt(i));
            }
        }
        System.out.println("El mensaje cifrado es: ");
        System.out.println(cifrado);
    }
}
