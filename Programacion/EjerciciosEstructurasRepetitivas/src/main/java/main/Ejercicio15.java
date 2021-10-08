package main;

public class Ejercicio15 {
    public void ejercicio15(){
        int mes = 2;
        int pago = 10;
        System.out.println("El primer mes se paga 10€");
        while (mes <= 20) {
            int pagoMenusal = pago*2;
            pago += pagoMenusal;
            System.out.println("El mes "+mes+" se paga "+pagoMenusal);
            mes++;
        }
        System.out.println("En total se paga "+pago);
    }
}
