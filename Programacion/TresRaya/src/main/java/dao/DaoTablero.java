package dao;

import modelo.Tablero;

public class DaoTablero {

    private final Tablero tablero;
    private int jugadas;

    public DaoTablero() {
        tablero = new Tablero(3, 3);
    }

    public void nuevaJugada() {
        jugadas++;
    }

    public int getJugadas() {
        return jugadas;
    }

    private boolean celdaVacia(int x, int y) {
        return tablero.getCelda(x, y).equals("-");
    }

    public boolean setCelda(int x, int y, String valor) {
        boolean operacionRealizada = false;

        if (celdaVacia(x, y)) {
            tablero.setCelda(x, y, valor);
            operacionRealizada = true;
        }

        return operacionRealizada;
    }


    public boolean tresLinea() {
        String valor;
        boolean tresRaya = false;

        boolean coincidenciaLineas;
        for (int i = 0; i < 3; i++) {
            valor = tablero.getCelda(i, 0);
            if (!valor.equals("-")) {
                coincidenciaLineas = true;
                for (int j = 1; j < 3; j++) {
                    if (!valor.equals(tablero.getCelda(i, j))) {
                        coincidenciaLineas = false;
                    }
                }
                if (coincidenciaLineas)
                    tresRaya = true;
            }
        }

        boolean coincidenciaColumnas;
        for (int i = 0; i < 3; i++) {
            valor = tablero.getCelda(0, i);
            if (!valor.equals("-")) {
                coincidenciaColumnas = true;
                for (int j = 1; j < 3; j++) {
                    if (!valor.equals(tablero.getCelda(j, i))) {
                        coincidenciaColumnas = false;
                    }
                }
                if (coincidenciaColumnas)
                    tresRaya = true;
            }
        }

        boolean coincidenciaDiagonal;
        valor = tablero.getCelda(0, 0);
        if (!valor.equals("-")) {
            coincidenciaDiagonal = true;
            for (int j = 1; j < 3; j++) {
                if (!valor.equals(tablero.getCelda(j, j))) {
                    coincidenciaDiagonal = false;
                }
            }
            if (coincidenciaDiagonal)
                tresRaya = true;
        }

        boolean coincidenciaDiagonalInversa;
        valor = tablero.getCelda(0, 2);
        if (!valor.equals("-")) {
            coincidenciaDiagonalInversa = true;
            for (int i = 1, j = 1; i < 3; i++, j--) {
                if (!valor.equals(tablero.getCelda(i, j))) {
                    coincidenciaDiagonalInversa = false;
                }
            }
            if (coincidenciaDiagonalInversa)
                tresRaya = true;
        }

        return tresRaya;
    }

    public String getTablero() {
        return tablero.toString();
    }
}
