Feature: Iniciar sesion
  Scenario: Usuario inicia sesion con un nombre registrado
    Given Lista de usuarios: jaime, lucas, rodrigo.
    And Solicitar un nombre de inicio.
    When Usuario elige iniciar sesion como jaime
    Then Se inicia la sesion como jaime rol cliente

  Scenario: Usuario inicia sesion con un nombre no registrado
    Given Lista de usuarios: jaime, lucas, rodrigo.
    And Solicitar un nombre de inicio.
    When Usuario elige iniciar sesion como francisco
    Then Mostrar mensaje de error usuario no registrado
    And Se pregunta si se desea registrar nuevo usuario

  Scenario: Usuario inicia sesion con admin
    Given Lista de usuarios: jaime, lucas, rodrigo.
    And Solicitar un nombre de inicio.
    When Usuario elige registrar admin
    Then Se solicita una contraseñas
    And Si la contraseña es correcta se inicia sesion como gerente de la tienda

