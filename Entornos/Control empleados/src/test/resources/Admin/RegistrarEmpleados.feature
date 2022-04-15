Feature: Como administrador quiero registrar empleados para que puedan fichar

  Background:
    Given Sesion de administración iniciada
    Given Dia actual: 16/04/2022
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid I
    Given Lista nominas
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #70271249Q,{Segovia I},2022-02-15,2022-03-15,P1M,PT150H40M,1508,true
    #26122403S,{Avila II},2022-02-15,2022-03-15,P1M,PT150H40M,1206.4,true
    #70271249Q,{null},2022-03-16,null,null,null,null,false
    #26122403S,{null},2022-03-16,null,null,null,null,false
    #27500613L,{null},2022-03-25,null,null,null,null,false

  Scenario: Registrar un empleado nuevo con DNI correcto
    Given DNI: 75726984J
    Given Nombre: Juan
    Given Apellido: García
    When Registra empleado
    Then Añadir empleado a la lista de empleados con un cod acceso unico autogenerado
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #75726984J,Juan,Garcia,47623,null,null
    And Añade nomina al empleado usando la fecha actual como fecha inicio
    #Empleado,UbicacionesTrabajadas,FechaInicio,FechaFin,ComputoDias,TiempoTrabajado,Sueldo,Abonada
    #75726984J,{null},2022-04-16,null,null,null,null,false
    And Mostrar mensaje Codigo de acceso generado, recuerda modificar el sueldo del empleado y suscribirlo a una franquicia

  Scenario: Registrar un empleado nuevo con DNI incorrecto
    Given DNI: 75726984B
    Given Nombre: Juan
    Given Apellido: García
    When Registra empleado
    Then Mostrar mensaje La letra de control del DNI no es correcta, empleado no registrado

  Scenario: Registrar un empleado con DNI ya registrado
    Given DNI: 70271249Q
    Given Nombre: Juan
    Given Apellido: García
    When Registra empleado
    Then Mostrar mensaje El DNI ya se encuentra registrado en el empleado Jorge Martin