package servicios;

import modelo.NumeroEntero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import servicios.ServiviosOperaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestServicioRestar {

    @Test
    @DisplayName("Resta con numeros enteros positivos, resultado positivo")
    void testRestaArgValidos() {
        //Given
        NumeroEntero operando1 = new NumeroEntero(1);
        NumeroEntero operando2 = new NumeroEntero(1);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.restar(operando1,operando2);
        //Then
        NumeroEntero resultadoEsperado = new NumeroEntero(0);
        assertEquals(resultadoEsperado.getNumero(),resultadoObtenido.getNumero());
    }

    @Test
    @DisplayName("Resta con numeros enteros negativos")
    void testRestaArgNegativos() {
        //Given
        NumeroEntero operando1 = new NumeroEntero(-1);
        NumeroEntero operando2 = new NumeroEntero(1);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.restar(operando1,operando2);
        //Then
        assertNull(resultadoObtenido);
    }

    @Test
    @DisplayName("Resta con numeros enteros positivos, resultado negativo")
    void testRestaArgValidosInvalidResult() {
        //Given
        NumeroEntero operando1 = new NumeroEntero(0);
        NumeroEntero operando2 = new NumeroEntero(1);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.restar(operando1,operando2);
        //Then
        assertNull(resultadoObtenido);
    }

}
