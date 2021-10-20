package main;

import java.util.Scanner;

public class Cesar {
    public void cifrarCesar(Scanner sc) {
        System.out.println("Introduce el texto a cifrar:");
        String texto = sc.nextLine();
        System.out.println("Introduce la clave:");
        int clave = sc.nextInt();
        StringBuilder cifrado = new StringBuilder();
        clave = clave % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + clave) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + clave - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + clave));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + clave) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + clave - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + clave));
                }
            } else {
                cifrado.append((char) texto.charAt(i));
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
                if ((texto.charAt(i) - clave) < 'a') {
                    descifrado.append((char) (texto.charAt(i) - clave + 26));
                } else {
                    descifrado.append((char) (texto.charAt(i) - clave));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - clave) < 'A') {
                    descifrado.append((char) (texto.charAt(i) - clave + 26));
                } else {
                    descifrado.append((char) (texto.charAt(i) - clave));
                }
            } else {
                descifrado.append((char) texto.charAt(i));
            }
        }
        System.out.println("El mensaje descifrado es: ");
        System.out.println(descifrado);
    }
}
