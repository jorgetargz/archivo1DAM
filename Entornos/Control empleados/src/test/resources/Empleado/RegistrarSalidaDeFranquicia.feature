Feature: Como empleado quiero registrar mi salida en una franquicia para computar horas

  Background:
    Given Sesion del empleado 70271249Q iniciada
    Given Hora actual: 2022-04-15T17:45:00

  Scenario: Registra salida teniendo un registro sin cerrar
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true
    #70271249Q,Segovia I,2022-04-15T13:45:00,null,null,false
    When Registra salida
    Then Modifica el registro sin cerrar añadiendo la hora actual como hora de salida
    #70271249Q,Segovia I,2022-04-15T13:45:00,2022-04-15T18:45:00,null,false
    And Se computan las horas del registro
    #70271249Q,Segovia I,2022-04-15T13:45:00,2022-04-15T18:45:00,PT5H,false
    And Se valida el registro
    #70271249Q,Segovia I,2022-04-15T13:45:00,2022-04-15T18:45:00,PT5H,true

  Scenario: Registra salida sin tener registro sin cerrar
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true
    When Registra salida
    Then Mostrar mensaje registra la entrada para poder registrar la salida
