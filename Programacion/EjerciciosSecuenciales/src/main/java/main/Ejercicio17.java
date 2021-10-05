package main;

import java.util.Scanner;

public class Ejercicio17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que hora es?");
        System.out.print("Hora: ");
        int hh = sc.nextInt();
        System.out.print("Minutos: ");
        int mm = sc.nextInt();
        System.out.print("Segundos: ");
        int ss = sc.nextInt();
        System.out.print("¿Cuanto tiempo dura el viaje? ");
        int tt = sc.nextInt();
        int horaLlegadaSegundos = hh*3600 + mm*60 + ss +tt;
        int hhll = horaLlegadaSegundos/3600;
        int mmll = (horaLlegadaSegundos-(hhll*3600))/60;
        int ssll = horaLlegadaSegundos - (hhll*3600+mmll*60);
        System.out.println(hhll+":"+mmll+":"+ssll);
    }
}