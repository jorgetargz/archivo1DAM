package modelo;

public class Tablero {
    private final Celda[][] celdas;

    public Tablero(int tamX, int tamY) {
        celdas = new Celda[tamX][tamY];
        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                celdas[i][j] = new Celda(i, j);
            }
        }
    }

    public String getCelda(int x, int y) {
        return celdas[x][y].toString();
    }

    public void setCelda(int x, int y, String valor) {
        celdas[x][y].setValor(valor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                sb.append(" ").append(getCelda(i, j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
