package main;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[10];
        for (int i = 0; i < valores.length; i++) {
            System.out.print("Introduce un numero: ");
            valores[i] = sc.nextInt();
        }
        boolean ordenadoAscendente = true;
        boolean ordenadoDescendente = true;
        for (int i = 0; i < (valores.length -1); i++) {
            if (valores[i] > valores[i+1]){
                ordenadoAscendente = false;
            }
            if (valores[i] < valores[i+1]){
                ordenadoDescendente = false;
            }
        }
        if (ordenadoAscendente){
            System.out.println("Los valores estan ordenados de menor a mayor");
        } else if (ordenadoDescendente){
            System.out.println("Los valores estan ordenados de mayor a menor");
        } else {
            System.out.println("Los valores no estan ordenados");
        }
    }
}
