Feature: Como administrador quiero desvincular un empleado de una franuqicia para trasladarle

  Background:
    Given Sesion de administración iniciada
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,null
    Given Lista de franquicias
    #Nombre,Ubicacion,NumeroEmpleados
    #Segovia I,Avenida Acueducto 22,1
    #Avila II,Calle muralla 12,1
    #Madrid I,Plaza Mayor 5,0

  Scenario: Desvincular empleado registrado con franquicia asignada
    Given Empleado: 26122403S
    When Desvincula franquicia
    Then Anular vinculo en el registro del empleado
    #Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,null
    #27500613L,Jaime,Lopez,98765,9,null
    And Disminuir numero de empleados en el registro de la franquicia
    #Lista de franquicias
    #Nombre,Ubicacion,NumeroEmpleados
    #Segovia I,Avenida Acueducto 22,1
    #Avila II,Calle muralla 12,0
    #Madrid I,Plaza Mayor 5,0

  Scenario: Desvincular empleado registrado sin franquicia asignada
    Given Empleado: 27500613L
    When Desvincula franquicia
    Then Mostrar mensaje este empleado no esta vinculado a ninguna franquicia

  Scenario: Desvincular empleado no registrado
    Given Empleado: 36500613L
    When Desvincula franquicia
    Then Mostrar mensaje este empleado no esta registrado

