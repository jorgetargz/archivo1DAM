package services;

public class GetWinners {
    public boolean[] getWinners(boolean blackjackJ1, boolean blackjackJ2, boolean blackjackCp, int sumaJ1, int sumaJ2, int sumaCp, boolean j1Perdio, boolean j2Perdio, boolean cpLose) {
        boolean j1Gana = false;
        boolean j1Empata = false;
        boolean j2Gana = false;
        boolean j2Empata = false;
        boolean results[] = new boolean[4];
        if (cpLose) {
            if (!j1Perdio) {
                j1Gana = true;
            }
            if (!j2Perdio) {
                j2Gana = true;
            }
        } else if (blackjackCp) {
            if (blackjackJ1) {
                j1Gana = true;
            }
            if (blackjackJ2) {
                j2Gana = true;
            }
        } else {
            if (sumaJ1 > sumaCp) {
                j1Gana = true;
            } else if (sumaJ1 == sumaCp){
                j1Empata = true;
            }
            if (sumaJ2 > sumaCp) {
                j2Gana = true;
            } else if (sumaJ2 == sumaCp){
                j2Empata = true;
            }
        }

        //Agrupo resultados en un array para devolver multiples booleanos
        if (j1Gana){
            results[0] = true;
        } else if (j1Empata){
            results[1] = true;
        }
        if (j2Gana){
            results[2] = true;
        } else if (j2Empata){
            results[3] = true;
        }
        return results;
    }
}
