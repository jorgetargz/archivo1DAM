package ui;

import modelo.NumeroEntero;
import servicios.ServiviosOperaciones;
import ui.common.Constantes;

import java.util.Scanner;

public class UIOperaciones {

    public void uiSumar() {
        ServiviosOperaciones scOperaciones = new ServiviosOperaciones();
        System.out.println(Constantes.SUMANDO);
        NumeroEntero operando1 = uiPedirNumero();
        NumeroEntero operando2 = uiPedirNumero();
        NumeroEntero resultado = scOperaciones.sumar(operando1, operando2);
        mostrarResultado(resultado);
    }

    public void uiRestar() {
        ServiviosOperaciones scOperaciones = new ServiviosOperaciones();
        System.out.println(Constantes.RESTANDO);
        NumeroEntero operando1 = uiPedirNumero();
        NumeroEntero operando2 = uiPedirNumero();
        NumeroEntero resultado = scOperaciones.restar(operando1, operando2);
        mostrarResultado(resultado);
    }

    public void uiMultiplicar() {
        ServiviosOperaciones scOperaciones = new ServiviosOperaciones();
        System.out.println(Constantes.MULTIPLICANDO);
        NumeroEntero operando1 = uiPedirNumero();
        NumeroEntero operando2 = uiPedirNumero();
        NumeroEntero resultado = scOperaciones.multiplicar(operando1, operando2);
        mostrarResultado(resultado);
    }

    public void uiDividir() {
        ServiviosOperaciones scOperaciones = new ServiviosOperaciones();
        System.out.println(Constantes.DIVIDIENDO);
        NumeroEntero dividendo = uiPedirNumero();
        NumeroEntero divisor = uiPedirNumero();
        NumeroEntero resultado = scOperaciones.dividir(dividendo, divisor);
        mostrarResultado(resultado);
    }

    private NumeroEntero uiPedirNumero() {
        ServiviosOperaciones scOperaciones = new ServiviosOperaciones();
        Scanner sc = new Scanner(System.in);
        boolean numeroValido;
        String operando;
        do {
            System.out.print(Constantes.INTRODUCE_UN_NUMERO);
            operando = sc.nextLine();
            numeroValido = scOperaciones.isStringAPositiveNumber(operando);
            if (!numeroValido) System.out.println(Constantes.CALCULADORA_SOLO_ADMITE_NUMEROS_ENTEROS);
        } while (!numeroValido);
        return new NumeroEntero(Integer.parseInt(operando));
    }

    private void mostrarResultado(NumeroEntero resultado) {
        if (resultado != null) System.out.println(Constantes.RESULTADO_ES + resultado.getNumero());
        else System.out.println(Constantes.OPERACION_NO_PERMITIDA);
    }
}
