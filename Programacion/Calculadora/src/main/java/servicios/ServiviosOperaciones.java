package servicios;

import modelo.NumeroEntero;

public class ServiviosOperaciones {

    public NumeroEntero sumar(NumeroEntero operando1, NumeroEntero operando2) {
        if (operando1.getNumero() >= 0 && operando2.getNumero() >= 0) {
            return new NumeroEntero(operando1.getNumero() + operando2.getNumero());
        }
        return null;
    }

    public NumeroEntero restar(NumeroEntero operando1, NumeroEntero operando2) {
        if (operando1.getNumero() >= 0
                && operando2.getNumero() >= 0
                && operando1.getNumero() >= operando2.getNumero()) {
            return new NumeroEntero(operando1.getNumero() - operando2.getNumero());
        }
        return null;
    }

    public NumeroEntero multiplicar(NumeroEntero operando1, NumeroEntero operando2) {
        if (operando1.getNumero() >= 0 && operando2.getNumero() >= 0) {
            return new NumeroEntero(operando1.getNumero() * operando2.getNumero());
        }
        return null;
    }

    public NumeroEntero dividir(NumeroEntero dividendo, NumeroEntero divisor) {
        if (dividendo.getNumero() >= 0 && divisor.getNumero() > 0) {
            return new NumeroEntero(dividendo.getNumero() / divisor.getNumero());
        }
        return null;
    }

    public boolean isStringAPositiveNumber(String operando) {
        boolean isNumeric = true;
        for (int i = 0; i < operando.length(); i++) {
            if (!Character.isDigit(operando.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
    }

}
