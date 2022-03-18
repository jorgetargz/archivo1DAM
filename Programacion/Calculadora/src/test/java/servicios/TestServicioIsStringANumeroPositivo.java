package servicios;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import servicios.ServiviosOperaciones;
import static org.junit.jupiter.api.Assertions.*;

class TestServicioIsStringANumeroPositivo {

    @Test
    @DisplayName("String contiene numero positivo")
    void stringIsAPositiveNumber() {
        //Given
        String numeroPostivo = "0";
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        boolean isPositiveNumber = serviviosOperaciones.isStringAPositiveNumber(numeroPostivo);
        //Then
        assertTrue(isPositiveNumber);
    }

    @Test
    @DisplayName("String contiene numero negativo")
    void stringIsANegativeNumber() {
        //Given
        String numeroNegativo = "-1";
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        boolean isPositiveNumber = serviviosOperaciones.isStringAPositiveNumber(numeroNegativo);
        //Then
        assertFalse(isPositiveNumber);
    }

    @Test
    @DisplayName("String contiene letras")
    void stringIsAText() {
        //Given
        String texto = "numeroUno";
        //When
        ServiviosOperaciones serviviosOperaciones = new ServiviosOperaciones();
        boolean isPositiveNumber = serviviosOperaciones.isStringAPositiveNumber(texto);
        //Then
        assertFalse(isPositiveNumber);
    }
}
