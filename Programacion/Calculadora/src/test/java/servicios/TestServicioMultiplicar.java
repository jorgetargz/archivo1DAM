package servicios;

import modelo.NumeroEntero;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import servicios.ServiviosOperaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestServicioMultiplicar {

    @Test
    @DisplayName("Multiplicar con numeros enteros positivos")
    void testMultiplicarArgValidos() {
        //Given
        NumeroEntero operando1 = new NumeroEntero(1);
        NumeroEntero operando2 = new NumeroEntero(0);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.multiplicar(operando1,operando2);
        //Then
        NumeroEntero resultadoEsperado = new NumeroEntero(0);
        assertEquals(resultadoEsperado.getNumero(),resultadoObtenido.getNumero());
    }

    @Test
    @DisplayName("Multiplicar con numeros enteros negativos")
    void testsumaArgNegativos() {
        //Given
        NumeroEntero operando1 = new NumeroEntero(-1);
        NumeroEntero operando2 = new NumeroEntero(1);
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        NumeroEntero resultadoObtenido = serviviosOperaciones.multiplicar(operando1,operando2);
        //Then
        assertNull(resultadoObtenido);
    }

}
