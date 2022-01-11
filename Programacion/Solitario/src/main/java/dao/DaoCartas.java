package dao;

import modelo.Carta;
import modelo.Palos;
import utils.Constantes;

import java.util.Random;

public class DaoCartas {

    private Carta[] baraja;
    private int posBaraja = 0;
    private int cartasColocadas = 0;

    public void createBaraja() {
        this.baraja = new Carta[Constantes.TOTAL_CARTAS];
        this.posBaraja = 0;
        generarBaraja();
        barajear();
    }

    public int getCartasColocadas() {
        return cartasColocadas;
    }

    public int getPosBaraja() {
        return posBaraja;
    }

    public void setPosBaraja(int posBaraja) {
        this.posBaraja = posBaraja;
    }

    private void generarBaraja() {
        int pos = 0;
        for (int i = 0; i < Palos.values().length; i++) {
            for (int j = 1; j <= Constantes.CARTAS_PALO; j++) {
                baraja[pos] = new Carta(j, Palos.values()[i]);
                pos++;
            }
        }
    }

    private void barajear() {
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            Carta aux;
            int pos1 = r.nextInt(40);
            int pos2 = r.nextInt(40);
            aux = baraja[pos1];
            baraja[pos1] = baraja[pos2];
            baraja[pos2] = aux;
        }
    }

    public Carta siguienteCarta() {
        Carta c = baraja[posBaraja];
        posBaraja++;
        return c;
    }

    public void sacarCarta(int pos) {
        for (int i = pos; i < baraja.length - 1; i++) {
            baraja[i] = baraja[i + 1];
        }
        cartasColocadas++;
        for (int i = baraja.length - cartasColocadas; i < baraja.length; i++) {
            baraja[i] = null;
        }
        if (posBaraja >= 1) {
            posBaraja--;
        }
    }
}
