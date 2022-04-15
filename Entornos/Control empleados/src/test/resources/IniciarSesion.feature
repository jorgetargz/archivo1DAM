Feature: Como empleado o admin quiero iniciar sesion en la aplicacion

  Background:
    Given Lista de empleados
    #DNI,Nombre,Apellido,Cod_Acceso,Sueldo/Hora,Franquicia
    #70271249Q,Jorge,Martin,12345,10,Segovia I
    #26122403S,Pedro,Diaz,43210,8,Avila II
    #27500613L,Jaime,Lopez,98765,9,Madrid
    Given Codigo Admin: 69420

  Scenario: Iniciar sesion con un codigo registrado
    Given Codigo de acceso 12345
    When Usuario inicie sesion
    Then Iniciar sesion empleado 70271249Q

  Scenario: Iniciar sesion con un codigo no registrado
    Given Codigo de acceso 67543
    When Usuario inicia sesion
    Then Mostrar mensaje codigo no registrado, puedes recuperar tu codigo

  Scenario: Iniciar sesion con codigo Admin
    Given Codigo de acceso 69420
    When Usuario inicie sesion
    Then Iniciar sesion administración