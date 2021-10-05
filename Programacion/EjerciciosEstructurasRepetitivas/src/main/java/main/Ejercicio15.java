package main;

public class Ejercicio15 {
    public void ejercicio15(){
        int mes = 2;
        int pagoTotal = 10;
        System.out.println("El primer mes se paga 10€");
        while (mes <= 20) {
            pagoTotal *= 2;
            System.out.println("El mes "+mes+" se paga "+pagoTotal);
            mes++;
        }
        System.out.println("En total se paga "+pagoTotal);
    }
}
