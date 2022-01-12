package dao;

import modelo.Tablero;

public class DaoTablero {
    private final Tablero tablero;
    private int jugadas;

    public DaoTablero() {
        tablero = new Tablero(6, 7);
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

    public boolean setCelda(int y, String valor) {
        boolean operacionRealizada = false;
        int x = 0;
        while (celdaVacia(x, y) && x < 5) {
            x++;
        }
        if (celdaVacia(x, y)) {
            tablero.setCelda(x, y, valor);
            operacionRealizada = true;
        } else if (x > 0 && celdaVacia(x - 1, y)) {
            tablero.setCelda(x - 1, y, valor);
            operacionRealizada = true;
        }
        return operacionRealizada;
    }


    public boolean cuatroLinea() {
        String valor;
        boolean cuatroLinea = false;

        boolean coincidenciaLineas;
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 4; k++) {
                valor = tablero.getCelda(i, k);
                if (!valor.equals("-")) {
                    coincidenciaLineas = true;
                    for (int j = k + 1; j < k + 4; j++) {
                        if (!valor.equals(tablero.getCelda(i, j))) {
                            coincidenciaLineas = false;
                        }
                    }
                    if (coincidenciaLineas)
                        cuatroLinea = true;
                }
            }
        }

        boolean coincidenciaColumnas;
        for (int i = 0; i < 7; i++) {
            for (int k = 0; k < 3; k++) {
                valor = tablero.getCelda(k, i);
                if (!valor.equals("-")) {
                    coincidenciaColumnas = true;
                    for (int j = k + 1; j < k + 4; j++) {
                        if (!valor.equals(tablero.getCelda(j, i))) {
                            coincidenciaColumnas = false;
                        }
                    }
                    if (coincidenciaColumnas)
                        cuatroLinea = true;
                }
            }
        }
        return cuatroLinea;
    }

    public String getTablero() {
        return tablero.toString();
    }
}