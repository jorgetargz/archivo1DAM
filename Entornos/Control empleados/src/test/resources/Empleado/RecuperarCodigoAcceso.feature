Feature: Como empleado quiero recuperar mi código de fichaje mediante mi apellido y dni para recordarlo

  Background:
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid

  Scenario: Recuperar codigo usando DNI y apellido registrados
    Given DNI: 70271249Q
    Given Apellido: Martin
    When Recupera codigo
    Then Mostrar mensaje tu codigo de acceso es 12345

  Scenario: Recuperaar codigo usando DNI no registrado y apellido registrado
    Given DNI: 70271247Q
    Given Apellido: Martin
    When Recupera codigo
    Then Mostrar mensaje revisa los datos

  Scenario: Recuperaar codigo usando DNI registrado y apellido no registrado
    Given DNI: 70271249Q
    Given Apellido: Martinez
    When Recupera codigo
    Then Mostrar mensaje revisa los datos

