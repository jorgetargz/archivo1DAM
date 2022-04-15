package com.example.ctrempleados.domain.modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Nomina {
    private Empleado empleado;
    private List<Franquicia> lugaresDeTrabajo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Period computoDias;
    private Duration tiempoTrabajado;
    private double sueldo;
    private boolean pendienteDeAbonar;
}
