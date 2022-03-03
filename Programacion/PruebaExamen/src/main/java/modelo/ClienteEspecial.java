package modelo;

public class ClienteEspecial extends Cliente{

    private int porcentajeDescuento;

    public ClienteEspecial(String dni, String nombre, double monedero, int porcentajeDescuento) {
        super(dni, nombre, monedero);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
}
