Feature: Como administrador quiero ver la lista de empleados para realizar un control de personal

  Background:
    Given Sesion de administración iniciada
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid

  Scenario: Listar empleados
    When Listar empleados
    Then Mostrar tabla con todos los datos de los empleados
