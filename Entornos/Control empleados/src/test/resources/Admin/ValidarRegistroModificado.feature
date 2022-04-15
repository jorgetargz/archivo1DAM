Feature: Como administrador quiero validar los turnos modificados de forma manual para asegurar que son correctos

  Background:
    Given Sesion de administracion iniciada
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,false
    #70271249Q,Segovia I,2022-04-14T10:00:00,2022-04-14T16:00:00,PT6H,false
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true

  Scenario: Validar registro no validado
    Given Registro: 70271249Q,Segovia I,2022-04-14T10:00:00,2022-04-14T16:00:00,PT6H,false
    When Valida registro
    Then Se marca el registro como validado
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-04-14T10:00:00,2022-04-14T16:00:00,PT6H,true

  Scenario: Validar registro validado
    Given Registro: 26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    When Valida registro
    Then Mostrar mensaje este registro ya estaba validado