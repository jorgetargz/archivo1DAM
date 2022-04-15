Feature: Como administrador quiero modificar el sueldo/hora de cada empleado para pagarles

  Background:
    Given Sesion de administración iniciada
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid

  Scenario: Modificar sueldo/hora(correcto) de un empleado registrado
    Given Empleado: 70271249Q
    Given Sueldo/hora (>= 8 && <=20) Ejemplos:8,10.5,20
    When Modifica sueldo
    Then Modificar el sueldo/hora en el registro del empleado
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,8,Segovia I

  Scenario: Modificar sueldo/hora(incorrecto) de un empleado registrado
    Given Empleado: 70271249Q
    Given Sueldo/hora (< 8 || >20) Ejemplos:7.99,20.01
    When Modifica sueldo
    Then Mostrar mensaje el sueldo asignado esta fuera del rango admitido por la empresa (8-20)

  Scenario: Modificar sueldo/hora(correcto) de un empleado no registrado
    Given Empleado: 61271249Q
    Given Sueldo/hora (>= 8 && <=20) Ejemplos:8,10.5,20
    When Modifica sueldo
    Then Mostrar mensaje empleado no registrado

  Scenario: Modificar sueldo/hora(incorrecto) de un empleado no registrado
    Given Empleado: 61271249Q
    Given Sueldo/hora (< 8 || >20) Ejemplos:7.99,20.01
    When Modifica sueldo
    Then Mostrar mensaje empleado no registrado
    And El sueldo asignado esta fuera del rango admitido por la empresa (8-20)

