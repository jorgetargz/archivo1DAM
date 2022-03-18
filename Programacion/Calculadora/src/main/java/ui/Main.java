package ui;

import ui.common.Constantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UIOperaciones uiOperaciones = new UIOperaciones();
        int operacion;
        do {
            System.out.println();
            System.out.println(Constantes.CALCULADORA);
            System.out.println(Constantes.SALIR);
            System.out.println(Constantes.SUMAR);
            System.out.println(Constantes.RESTAR);
            System.out.println(Constantes.MULTIPLICAR);
            System.out.println(Constantes.DIVIDIR);
            System.out.print(Constantes.INTRODUCE_NUMERO_DE_OPERACION);
            operacion = sc.nextInt();
            sc.nextLine();
            switch (operacion){
                case 0:
                    break;
                case 1:
                    uiOperaciones.uiSumar();
                    break;
                case 2:
                    uiOperaciones.uiRestar();
                    break;
                case 3:
                    uiOperaciones.uiMultiplicar();
                    break;
                case 4:
                    uiOperaciones.uiDividir();
                    break;
                default:
                    System.out.println(Constantes.ENTRADA_NO_VALIDA);
                    break;
            }
        } while (operacion != 0);
    }
}
