Feature: Elegir entre registrar o loguear nombre
  Scenario: Usuario quiere registrarse
    Given
    # Menu
    #1. Registrar nuevo usuario.
    #2. Iniciar sesión.
  When Se elige la opcion 1
  Then Se inicia el proceso de registro
  Scenario: Usuario quiere iniciar sesión
    Given
    # Menu
    #1. Registrar nuevo usuario.
    #2. Iniciar sesión.
    When Se elige la opcion 2
    Then Se inicia el proceso de login