package main;

public class Ejercicio18 {
    public void ejercicio18(){
        for (int hora = 0; hora < 24; hora++){
            for (int minutos = 0; minutos < 60; minutos++){
                for (int segundos = 0; segundos < 60; segundos++){
                    System.out.print(hora+":"+minutos+":"+segundos);
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){}
                    System.out.print("\b\b\b\b\b\b\b");
                }
            }
        }
    }
}