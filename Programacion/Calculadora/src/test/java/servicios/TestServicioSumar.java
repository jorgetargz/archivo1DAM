package servicios;

import modelo.NumeroEntero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import servicios.ServiviosOperaciones;

class TestServicioSumar {

    @Test
    @DisplayName("Suma con numeros enteros positivos")
    void testSumarArgValidos() {

        //Given
        NumeroEntero operando1 = new NumeroEntero(1);
        NumeroEntero operando2 = new NumeroEntero(0);

        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.sumar(operando1,operando2);

        //Then
        NumeroEntero resultadoEsperado = new NumeroEntero(1);
        assertEquals(resultadoEsperado.getNumero(),resultadoObtenido.getNumero());
    }

    @Test
    @DisplayName("Suma con numeros enteros negativos")
    void testSumarArgNegativos() {

        //Given
        NumeroEntero operando1 = new NumeroEntero(-1);
        NumeroEntero operando2 = new NumeroEntero(1);

        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.sumar(operando1,operando2);

        //Then
        assertNull(resultadoObtenido);
    }

}
