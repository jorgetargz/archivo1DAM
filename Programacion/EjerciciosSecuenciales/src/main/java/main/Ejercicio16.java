package main;

import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la velocidad del primer vehiculo (Km/h): ");
        double velocidad1 = sc.nextDouble();
        System.out.print("Introduce la velocidad del segundo vehiculo (Km/h): ");
        double velocidad2 = sc.nextDouble();
        System.out.print("Introduce la distancia entre vehículos (Km): ");
        double distancia = sc.nextDouble();
        double diferenciaVelocidad = velocidad1-velocidad2;
        double tiempo = distancia/diferenciaVelocidad;
        tiempo = tiempo*60;
        System.out.print("Los vehículos tardaran "+tiempo+" minutos en alcanzarse");
    }
}