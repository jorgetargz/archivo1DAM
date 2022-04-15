Feature: Como administrador quiero ver los registros para saber las horas de entrada, salida y el computo de horas

  Background:
    Given Sesion de administracion iniciada
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true

  Scenario: Listar registros
    When Lista registros
    Then Mostrar tabla con los datos de la lista de registros con las fechas y horas parseadas de esta forma
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022/04/14 10:15:00,2022/04/14 15:30:00,5H 15M,true
    #26122403S,Avila II,2022/04/14 10:15:00,2022/04/14 16:31:00,6H 16M,true
    #27500613L,Madrid I,2022/04/14 10:15:00,2022/04/14 14:30:00,4H 15M,true