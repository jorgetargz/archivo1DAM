package modelo;

public class ClienteEspacial extends Cliente {

    private int porcentajeDescuento;

    public ClienteEspacial(String dni) {
        super(dni);
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
