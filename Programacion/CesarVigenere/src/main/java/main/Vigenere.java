package main;

import java.util.Scanner;

public class Vigenere {
    public void cifrarVigenere(Scanner sc) {
        System.out.println("Introduce el texto a cifrar:");
        String texto = sc.nextLine();
        System.out.println("Introduce la clave:");
        String clave = sc.nextLine();
        StringBuilder cifrado = new StringBuilder();
        int caracteresNoCifrables = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caraterTexto = texto.charAt(i);
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                char caracterClaveMinus = clave.toLowerCase().charAt((i + caracteresNoCifrables) % clave.length());
                char caracterCifrado = (char) (((caraterTexto - 'a') + (caracterClaveMinus - 'a')) % 26 + 'a');
                cifrado.append(caracterCifrado);
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                char caracterClaveMayus = clave.toUpperCase().charAt((i + caracteresNoCifrables) % clave.length());
                char caracterCifrado = (char) (((caraterTexto - 'A') + (caracterClaveMayus - 'A')) % 26 + 'A');
                cifrado.append(caracterCifrado);
            } else {
                cifrado.append(texto.charAt(i));
                caracteresNoCifrables++;
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
        StringBuilder descifrado = new StringBuilder();
        int caracteresNoCifrables = 0;
        for (int i = 0; i < texto.length(); i++) {
            char caraterTexto = texto.charAt(i);
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                char caracterClaveMinus = clave.toLowerCase().charAt((i + caracteresNoCifrables) % clave.length());
                char caracterCifrado = (char) (((caraterTexto - 'a') - (caracterClaveMinus - 'a') + 26) % 26 + 'a');
                descifrado.append(caracterCifrado);
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                char caracterClaveMayus = clave.toUpperCase().charAt((i + caracteresNoCifrables) % clave.length());
                char caracterCifrado = (char) (((caraterTexto - 'A') - (caracterClaveMayus - 'A') + 26) % 26 + 'A');
                descifrado.append(caracterCifrado);
            } else {
                descifrado.append(texto.charAt(i));
                caracteresNoCifrables++;
            }
        }
        System.out.println("El mensaje descifrado es: ");
        System.out.println(descifrado);
    }
}
