package main;

import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] notas1Evaluacion = new int[5];
        for (int i = 0; i < notas1Evaluacion.length; i++) {
            System.out.print("Introduce un numero: ");
            notas1Evaluacion[i] = sc.nextInt();
        }
        int[] notas2Evaluacion = new int[5];
        for (int i = 0; i < notas2Evaluacion.length; i++) {
            System.out.print("Introduce un numero: ");
            notas2Evaluacion[i] = sc.nextInt();
        }
        int[] notas3Evaluacion = new int[5];
        for (int i = 0; i < notas3Evaluacion.length; i++) {
            System.out.print("Introduce un numero: ");
            notas3Evaluacion[i] = sc.nextInt();
        }

        System.out.println("Nota media 1 evaluacion del grupo");
        double suma1Evaluacion = 0;
        for (int i = 0; i < notas1Evaluacion.length; i++) {
            suma1Evaluacion += notas1Evaluacion[i];
        }
        double media1Evaluacion = suma1Evaluacion/notas1Evaluacion.length;
        System.out.println("Nota media 2 evaluacion del grupo");
        double suma2Evaluacion = 0;
        for (int i = 0; i < notas2Evaluacion.length; i++) {
            suma2Evaluacion += notas2Evaluacion[i];
        }
        double media2Evaluacion = suma2Evaluacion/notas2Evaluacion.length;
        System.out.println("Nota media 3 evaluacion del grupo");
        double suma3Evaluacion = 0;
        for (int i = 0; i < notas3Evaluacion.length; i++) {
            suma1Evaluacion += notas1Evaluacion[i];
        }
        double media3Evaluacion = suma3Evaluacion/notas3Evaluacion.length;

        System.out.println("Introduce la posicion de un alumno: ");
        int posAlumno = sc.nextInt();
        int sumaAlumno = notas1Evaluacion[posAlumno] + notas2Evaluacion[posAlumno] + notas3Evaluacion[posAlumno];
        int mediaAlumno = sumaAlumno/3;

        System.out.println("La media del grupo en la 1 evaluacion: "+media1Evaluacion);
        System.out.println("La media del grupo en la 2 evaluacion: "+media2Evaluacion);
        System.out.println("La media del grupo en la 3 evaluacion: "+media3Evaluacion);

        System.out.println("La media del alumno "+ posAlumno +" es: "+mediaAlumno);
    }
}
