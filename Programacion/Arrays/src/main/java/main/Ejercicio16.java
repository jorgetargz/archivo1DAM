package main;

import java.util.Random;

public class Ejercicio16 {
    public void ejercicio16(Random r) {
        int[] notas1Evaluacion = new int[5];
        for (int i = 0; i < notas1Evaluacion.length; i++) {
            notas1Evaluacion[i] = r.nextInt(9)+1;
        }
        int[] notas2Evaluacion = new int[5];
        for (int i = 0; i < notas2Evaluacion.length; i++) {
            notas2Evaluacion[i] = r.nextInt(9)+1;
        }
        int[] notas3Evaluacion = new int[5];
        for (int i = 0; i < notas3Evaluacion.length; i++) {
            notas3Evaluacion[i] = r.nextInt(9)+1;
        }

        double suma1Evaluacion = 0;
        for (int i = 0; i < notas1Evaluacion.length; i++) {
            suma1Evaluacion += notas1Evaluacion[i];
        }
        double media1Evaluacion = suma1Evaluacion / notas1Evaluacion.length;

        double suma2Evaluacion = 0;
        for (int i = 0; i < notas2Evaluacion.length; i++) {
            suma2Evaluacion += notas2Evaluacion[i];
        }
        double media2Evaluacion = suma2Evaluacion / notas2Evaluacion.length;

        double suma3Evaluacion = 0;
        for (int i = 0; i < notas3Evaluacion.length; i++) {
            suma1Evaluacion += notas1Evaluacion[i];
        }
        double media3Evaluacion = suma3Evaluacion / notas3Evaluacion.length;

        System.out.print("La posicion de un alumno: ");
        int posAlumno = r.nextInt(9);
        System.out.println(posAlumno);
        int sumaAlumno = notas1Evaluacion[posAlumno] + notas2Evaluacion[posAlumno] + notas3Evaluacion[posAlumno];
        int mediaAlumno = sumaAlumno / 3;

        System.out.println("La media del grupo en la 1 evaluacion: " + media1Evaluacion);
        System.out.println("La media del grupo en la 2 evaluacion: " + media2Evaluacion);
        System.out.println("La media del grupo en la 3 evaluacion: " + media3Evaluacion);

        System.out.println("La media anual del alumno " + posAlumno + " es: " + mediaAlumno);
    }
}
