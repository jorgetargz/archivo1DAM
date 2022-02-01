package ui;


import common.Constantes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UILogin uiLogin = new UILogin();

        System.out.println(Constantes.ASCII_ART);
        System.out.println(Constantes.BIENVENIDO_A_MERCA_VICE_CITY);
        uiLogin.menuLogin(sc);
    }
}
