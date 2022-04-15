Feature: Como administrador quiero indicar a que franquicia pertenece cada empleado para que puedan fichar

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

  Scenario: Vincular un empleado sin franquicia a una franquicia registrada
    Given Empleado: 27500613L
    Given Franquicia: Madrid I
    When Vincula empleado a franquicia
    Then Asignar Madrid I al registro del empleado
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid I
    And Incrementar el numero en el registro de la franquicia
    #Nombre,Ubicacion,NumeroEmpleados
    #Segovia I,Avenida Acueducto 22,1
    #Avila II,Calle muralla 12,1
    #Madrid I,Plaza Mayor 5,1

  Scenario: Vincular un empleado sin franquicia a una franquicia no registrada
    Given Empleado: 27500613L
    Given Franquicia: Albacete I
    When Vincula empleado a franquicia
    Then Mostrar mensaje Albacete I franquicia no registrada

  Scenario: Vincular un empleado con franquicia a una franquicia registrada
    Given Empleado: 70271249Q
    Given Franquicia: Madird I
    When Vincula empleado a franquicia
    Then Mostrar mensaje 70271249Q esta suscrito a Segovia I

  Scenario: Vincular un empleado con franquicia a una franquicia no registrada
    Given Empleado: 70271249Q
    Given Franquicia: Albacete I
    When Vincula empleado a franquicia
    Then Mostrar mensaje 70271249Q esta suscrito a Segovia I
    And Mostrar mensaje Albacete I franquicia no registrada

  Scenario: Vincular un empleado no registrado a una franquicia registrada
    Given Empleado: 61271249Q
    Given Franquicia: Madrid I
    When Vincula empleado a franquicia
    Then Mostrar mensaje 61271249Q no esta registrado

  Scenario: Vincular un empleado no registrado a una franquicia no registrada
    Given Empleado: 61271249Q
    Given Franquicia: Albacete I
    When Vincula empleado a franquicia
    Then Mostrar mensaje 61271249Q no esta registrado
    And Mostrar mensaje Albacete I franquicia no registrada