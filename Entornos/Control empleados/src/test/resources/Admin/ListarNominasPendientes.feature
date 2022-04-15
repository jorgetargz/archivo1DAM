Feature: Como administrador quiero ver las nominas pendientes de pagar para revisarlas antes de abonarlas

  Background:
    Given Sesion de administracion iniciada
    Given Dia actual: 16/04/2022
    Given Lista nominas
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{Segovia I},2022-02-15,2022-03-15,P1M,PT150H40M,1508,true
    #26122403S,{Avila II},2022-02-15,2022-03-15,P1M,PT150H40M,1206.4,true
    #70271249Q,{null},2022-03-16,null,null,null,null,false
    #26122403S,{null},2022-03-16,null,null,null,null,false
    #27500613L,{null},2022-03-25,null,null,null,null,false
    Given Lista de registros
    #Empleado,Franquicia,HoraEntradad,HoraSalida,ComputoHoras,Validado
    #70271249Q,Segovia I,2022-02-13T10:15:00,2022-02-13T15:30:00,PT5H15M,true
    #70271249Q,Segovia I,2022-02-14T10:15:00,2022-02-14T15:30:00,PT5H15M,true
    #70271249Q,Segovia I,2022-04-13T10:15:00,2022-04-13T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-13T10:15:00,2022-04-13T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-13T10:15:00,2022-04-13T14:30:00,PT4H15M,true
    #70271249Q,Segovia I,2022-04-14T10:15:00,2022-04-14T15:30:00,PT5H15M,true
    #26122403S,Avila II,2022-04-14T10:15:00,2022-04-14T16:31:00,PT6H16M,true
    #27500613L,Madrid I,2022-04-14T10:15:00,2022-04-14T14:30:00,PT4H15M,true
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid

  Scenario: Mostrar nominas sin abonar
    When Lista nominas sin abonar
    Then Se registra la fecha actual como fecha fin en las nominas que no han sido abonadas
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{null},2022-03-16,2022-4-16,null,null,null,false
    #26122403S,{null},2022-03-16,2022-4-16,null,null,null,false
    #27500613L,{null},2022-03-25,2022-4-15,null,null,null,false
    And Se registra el computo de dias de cada nomina calculado usando fecha inicio y fecha fin
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{null},2022-03-16,2022-4-16,P1M,null,null,false
    #26122403S,{null},2022-03-16,2022-4-16,P1M,null,null,false
    #27500613L,{null},2022-03-25,2022-4-16,P21D,null,null,false
    And Se registra las franquicias que aparezcan en los registros validados del empleado que esten dentro del periodo de la nomina
    #70271249Q,{Segovia I},2022-03-16,2022-4-16,P1M,null,null,false
    #26122403S,{Avila II},2022-03-16,2022-4-16,P1M,null,null,false
    #27500613L,{Madrid I},2022-03-25,2022-4-16,P21D,null,null,false
    And Se calcula el computo de horas sumando los computos de los registros validados del empleado que esten dentro del periodo de la nomina
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{Segovia I},2022-03-16,2022-4-16,P1M,PT10H30M,null,false
    #26122403S,{Avila II},2022-03-16,2022-4-16,P1M,PT12H32M,null,false
    #27500613L,{Madrid I},2022-03-25,2022-4-16,P21D,PT8H30M,null,false
    And Se calcula el sueldo usando el sueldo/hora de cada empleado y el tiempo trabajado
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{Segovia I},2022-03-16,2022-4-16,P1M,PT10H30M,105,false
    #26122403S,{Avila II},2022-03-16,2022-4-16,P1M,PT12H32M,100.08,false
    #27500613L,{Madrid I},2022-03-25,2022-4-16,P21D,PT8H30M,76.5,false
    And Se muestran los registros en una tabla formateados de esta manera
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{Segovia I},2022/03/16,2022/4/16,1 Mes,10H 30M,105,false
    #26122403S,{Avila II},2022/03/16,2022/4/16,1 Mes,12H 32M,100.08,false
    #27500613L,{Madrid I},2022/03/25,2022/4/16,21 Dias,8H 30M,76.5,false