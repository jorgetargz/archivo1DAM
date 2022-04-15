package com.example.ctrempleados.domain.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
    private Empleado empleado;
    private Franquicia franquicia;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private Duration computoTiempo;
    private boolean validado;
}
