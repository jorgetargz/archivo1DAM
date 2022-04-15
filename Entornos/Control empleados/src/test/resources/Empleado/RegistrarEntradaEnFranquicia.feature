Feature: Como empleado quiero registrar mi entrada en una franquicia para computar horas

  Background:
    Given Sesion del empleado 70271249Q iniciada
    Given Hora actual: 2022-04-15T13:45:00
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid

  Scenario: Registra entrada sin tener ninguna entrada sin cerrar
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true
    When Registra entrada
    Then Crear registro con DNI y franquicia del empleado con sesion iniciada y hora actual como hora de entrada
    #70271249Q,Segovia I,2022-04-15T13:45:00,null,null,false

  Scenario: Registra entrada teniendo un registro sin cerrar
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true
    #70271249Q,Segovia I,2022-04-15T13:45:00,null,null,false
    When Registra entrada
    Then Mostrar mensaje registra salida antes de registrar una nueva entrada
