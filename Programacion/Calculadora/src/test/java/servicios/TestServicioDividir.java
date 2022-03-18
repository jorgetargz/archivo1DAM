package servicios;

import modelo.NumeroEntero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestServicioDividir {

    @Test
    @DisplayName("Dividir con numeros enteros positivos, divisor y dividendo mayor de 0")
    void testDividirArgValidos() {
        //Given
        NumeroEntero dividendo = new NumeroEntero(10);
        NumeroEntero divisor = new NumeroEntero(2);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.dividir(dividendo,divisor);
        //Then
        NumeroEntero resultadoEsperado = new NumeroEntero(5);
        assertEquals(resultadoEsperado.getNumero(),resultadoObtenido.getNumero());
    }

    @Test
    @DisplayName("Dividir con numeros enteros positivos, dividendo 0")
    void testDividirArgValidosDividendo0() {
        //Given
        NumeroEntero dividendo = new NumeroEntero(0);
        NumeroEntero divisor = new NumeroEntero(2);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.dividir(dividendo,divisor);
        //Then
        NumeroEntero resultadoEsperado = new NumeroEntero(0);
        assertEquals(resultadoEsperado.getNumero(),resultadoObtenido.getNumero());
    }

    @Test
    @DisplayName("Dividir con numeros enteros positivos, divisor 0")
    void testDividirDivisor0() {
        //Given
        NumeroEntero dividendo = new NumeroEntero(10);
        NumeroEntero divisor = new NumeroEntero(0);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.dividir(dividendo,divisor);
        //Then
        assertNull(resultadoObtenido);
    }

    @Test
    @DisplayName("Dividir con numeros enteros negativos")
    void testDividirArgNegativos() {
        //Given
        NumeroEntero dividendo = new NumeroEntero(10);
        NumeroEntero divisor = new NumeroEntero(-2);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.dividir(dividendo,divisor);
        //Then
        assertNull(resultadoObtenido);
    }
}
