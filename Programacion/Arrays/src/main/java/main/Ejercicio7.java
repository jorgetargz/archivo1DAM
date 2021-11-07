package main;

import java.util.Random;

public class Ejercicio7 {
    public void ejercicio7(Random r) {
        int[] valores = new int[10];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = r.nextInt(9)+1;
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
