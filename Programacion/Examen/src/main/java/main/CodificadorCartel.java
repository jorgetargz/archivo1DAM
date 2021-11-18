package main;

import java.util.Scanner;

public class CodificadorCartel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] codigo = new int[10];
        for (int i = 0; i < codigo.length; i++) {
            System.out.print("Introduce un numero, posicion: " + (i + 1));
            int num = sc.nextInt();
            sc.nextLine();
            codigo[i] = num;
        }
        boolean comprobarArray = comprobarArray(codigo);
        System.out.println("1.Encriptar");
        System.out.println("2.Desencriptar");
        System.out.println("0.Salir");
        codigo = encriptarSecuencia(codigo, comprobarArray);
        mostrarCodigo(codigo);
    }

    private static int[] encriptarSecuencia(int[] codigo, boolean comprobarArray) {
        if (comprobarArray) {
            for (int i = 0; i < codigo.length - 1; i++) {
                int valorMin = codigo[i];
                int positivoVm = valorMin;
                if (valorMin < 0) {
                    positivoVm = valorMin * -1;
                }
                int posMin = i;
                for (int j = i + 1; j < codigo.length; j++) {
                    int positivoCj = codigo[j];
                    if (codigo[j] < 0) {
                        positivoCj = codigo[j] * -1;
                    }
                    if (positivoVm > positivoCj) {
                        valorMin = codigo[j];
                        posMin = j;
                    }
                }
                if (posMin != i) {
                    codigo[posMin] = codigo[i];
                    codigo[i] = valorMin;
                }
            }
        }
        return codigo;
    }

    private static void mostrarCodigo(int[] codigo) {
        for (int i = 0; i < codigo.length; i++) {
            if (i == (codigo.length - 1)) {
                System.out.print(codigo[i]);
            } else {
                System.out.print(codigo[i] + ",");
            }
        }
        System.out.println();
    }

    private static boolean comprobarArray(int[] codigo) {
        boolean arrayValido = false;
        boolean numPositivo = false;
        boolean numFueraRango = false;
        for (int i = 0; i < codigo.length; i++) {
            if (codigo[i] > 0) {
                numPositivo = true;
            }
            if (codigo[i] > 10 || codigo[i] < -10) {
                numFueraRango = true;
            }
        }
        if (numPositivo && !numFueraRango) {
            arrayValido = true;
        }
        return arrayValido;
    }
}
