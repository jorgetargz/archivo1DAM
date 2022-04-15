Feature: Como empleado quiero modificar un registro para corregir un olvido

  Background:
    Given Sesion del empleado 70271249Q iniciada
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true

  Scenario: Modificar un registro con datos validos
    Given Registro: 70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    Given HoraEntrada(Anterior a la horaSalida): 2022-04-14T10:00:00
    Given HoraSalida(Posterior a la horaEntrada): 2022-04-14T16:00:00
    When Modifica registro
    Then Se crea nuevo registro sin validar realizando el nuevo computo de horas
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:00:00,2022-04-14T16:00:00,PT6H,false
    And Se invalida el registro modificado
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,false

  Scenario: Modificar un registro con datos invalidos
    Given Registro: 70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    Given HoraEntrada(Posterior a la horaSalida): 2022-04-14T16:00:00
    Given HoraSalida(Anterior a la horaEntrada): 2022-04-14T10:00:00
    When Modifica registro
    Then Mostrar mensaje la hora de entrada no puede ser posterior a la hora de salida