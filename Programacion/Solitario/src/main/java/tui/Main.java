package tui;

import dao.DaoCartas;
import modelo.Carta;
import modelo.Palos;
import utils.Constantes;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DaoCartas dao = new DaoCartas();
        dao.createBaraja();
        Carta[] espadas = new Carta[Constantes.CARTAS_PALO];
        int posEspadas = 0;
        Carta[] oros = new Carta[Constantes.CARTAS_PALO];
        int posOros = 0;
        Carta[] bastos = new Carta[Constantes.CARTAS_PALO];
        int posBastos = 0;
        Carta[] copas = new Carta[Constantes.CARTAS_PALO];
        int posCopas = 0;
        Carta[] mesa = new Carta[Constantes.TOTAL_CARTAS];
        int posMesa = 0;
        boolean cartaColocada;
        boolean vueltaSinColocar;
        boolean seguir = true;

        while (seguir) {
            vueltaSinColocar = true;
            System.out.println("Se recoge la mesa");
            while (dao.getPosBaraja() + 1 < (Constantes.TOTAL_CARTAS - dao.getCartasColocadas())) {
                mesa[posMesa] = dao.siguienteCarta();
                posMesa++;
                mesa[posMesa] = dao.siguienteCarta();
                posMesa++;

                do {
                    System.out.println("Carta visible " + mesa[posMesa - 1].toString());
                    if ((mesa[posMesa - 1].getPalo() == Palos.ESPADAS)
                            && (mesa[posMesa - 1].getNumero() == posEspadas + 1)) {
                        cartaColocada = true;
                        vueltaSinColocar = false;
                        espadas[posEspadas] = mesa[posMesa - 1];
                        dao.sacarCarta(dao.getPosBaraja() - 1);
                        System.out.println(Arrays.toString(espadas));
                        posEspadas++;
                        mesa[posMesa - 1] = null;
                        if (posMesa != 1) {
                            posMesa--;
                        }
                    } else if ((mesa[posMesa - 1].getPalo() == Palos.OROS)
                            && (mesa[posMesa - 1].getNumero() == posOros + 1)) {
                        cartaColocada = true;
                        vueltaSinColocar = false;
                        oros[posOros] = mesa[posMesa - 1];
                        dao.sacarCarta(dao.getPosBaraja() - 1);
                        System.out.println(Arrays.toString(oros));
                        posOros++;
                        mesa[posMesa - 1] = null;
                        if (posMesa != 1) {
                            posMesa--;
                        }
                    } else if ((mesa[posMesa - 1].getPalo() == Palos.BASTOS)
                            && (mesa[posMesa - 1].getNumero() == posBastos + 1)) {
                        cartaColocada = true;
                        vueltaSinColocar = false;
                        bastos[posBastos] = mesa[posMesa - 1];
                        dao.sacarCarta(dao.getPosBaraja() - 1);
                        System.out.println(Arrays.toString(bastos));
                        posBastos++;
                        mesa[posMesa - 1] = null;
                        if (posMesa != 1) {
                            posMesa--;
                        }
                    } else if ((mesa[posMesa - 1].getPalo() == Palos.COPAS)
                            && (mesa[posMesa - 1].getNumero() == posCopas + 1)) {
                        cartaColocada = true;
                        vueltaSinColocar = false;
                        copas[posCopas] = mesa[posMesa - 1];
                        posCopas++;
                        dao.sacarCarta(dao.getPosBaraja() - 1);
                        System.out.println(Arrays.toString(copas));
                        mesa[posMesa - 1] = null;
                        if (posMesa != 1) {
                            posMesa--;
                        }
                    } else {
                        cartaColocada = false;
                    }
                } while (cartaColocada && mesa[posMesa - 1] != null);
            }
            if (posCopas == Constantes.CARTAS_PALO && posBastos == Constantes.CARTAS_PALO && posEspadas == Constantes.CARTAS_PALO && posOros == Constantes.CARTAS_PALO) {
                System.out.println("Has ganado");
                seguir = false;
            } else if (vueltaSinColocar) {
                System.out.println("Has perdido");
                seguir = false;
            } else {
                dao.setPosBaraja(0);
                Arrays.fill(mesa, null);
                posMesa = 0;
            }
        }
    }
}
