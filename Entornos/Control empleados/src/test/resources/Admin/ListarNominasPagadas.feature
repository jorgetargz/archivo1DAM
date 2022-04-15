Feature: Como administrador quiero ver las nominas pagadas para tener una contabilidad

  Background:
    Given Sesion de administracion iniciada
    Given Lista nominas
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{Segovia I},2022-02-15,2022-03-15,P1M,PT150H40M,1508,true
    #26122403S,{Avila II},2022-02-15,2022-03-15,P1M,PT150H40M,1206.4,true
    #70271249Q,{null},2022-03-16,null,null,null,null,false
    #26122403S,{null},2022-03-16,null,null,null,null,false
    #27500613L,{null},2022-03-25,null,null,null,null,false

  Scenario: Lista nominas pagadas
    When Lista nominas pagadas
    Then Mostrar las nominas abonadas formateando los campos de esta manera
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{Segovia I},2022/02/15,2022/03/15,1 Mes,150H 40M,1508,true
    #26122403S,{Avila II},2022/02/15,2022/03/15,1 Mes,150H 40M,1206.4,true
