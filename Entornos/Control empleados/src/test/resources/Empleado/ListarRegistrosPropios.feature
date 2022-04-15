Feature: Como empleado quiero ver mis registros para saber lo que he trabajado

  Background:
    Given Sesion del empleado 70271249Q iniciada
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true

  Scenario: Listar registros
    When Lista registros
    Then Mostrar tabla con los registros del empleado con las fechas y horas parseadas de esta forma
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022/04/14 10:15:00,2022/04/14 15:30:00,5H 15M,true