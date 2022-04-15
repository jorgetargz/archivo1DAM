Feature: Como administrador quiero eliminar franquicias para cerrarlas

  Background:
    Given Sesion de administración iniciada
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid I
    Given Lista de franquicias
    #Nombre,Ubicacion,NumeroEmpleados
    #Segovia I,Avenida Acueducto 22,1
    #Avila II,Calle muralla 12,1
    #Madrid I,Plaza Mayor 5,1

  Scenario: Eliminar franquicia registrada
    Given Nombre: Avila II
    When Elimina franquicia
    Then Eliminar franquicia de la lista
    #Lista de franquicias
    #Nombre,Ubicacion,NumeroEmpleados
    #Segovia I,Avenida Acueducto 22,1
    #Madrid I,Plaza Mayor 5,1
    And Anular vinculo de empleados a la franquicia
    #Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,null
    #27500613L,Jaime,Lopez,98765,9,Madrid
    And Mostrar mensaje recuerda realocar o eliminar los empleados de esta franquicia

  Scenario: Eliminar franquicia no registrada
    Given Nombre: Toledo I
    When Elimina franquicia
    Then Mostrar mensaje franquicia no registrada


