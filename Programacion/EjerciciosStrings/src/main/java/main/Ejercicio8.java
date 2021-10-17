package main;

import java.util.Scanner;

public class Ejercicio8 {
    public void ejercicio8(Scanner sc) {
        System.out.println("Introduce una cadena de caracteres: ");
        String texto = sc.nextLine();
        StringBuilder textoAlterado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra >= 65 && letra <= 90) {
                letra += 32;
            } else if (letra >= 97 && letra <= 122) {
                letra -= 32;
            }
            textoAlterado.append(letra);
        }
        System.out.println(textoAlterado);
    }
}
