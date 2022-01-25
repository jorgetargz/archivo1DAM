Feature: Como cliente quiero registrar un nombre para poder iniciar sesion

  Scenario: Registrar nombre nuevo
    Given Lista de usuarios: jaime, lucas, rodrigo.
    And Solicitar un nombre de registro.
    When Usuario elige registrar francisco
    Then Crear nuevo cliente francisco

  Scenario: Registrar nombre ya existente
    Given Lista de usuarios: jaime, lucas, rodrigo.
    And Solicitar un nombre de registro.
    When Usuario elige registrar jaime
    Then Mostrar mensaje usuario ya existente
    And Solicitar otro nombre

  Scenario: Registrar nombre admin
    Given Lista de usuarios: jaime, lucas, rodrigo.
    And Solicitar un nombre de registro.
    When Usuario elige registrar admin
    Then Mostrar mensaje de error no puedes registrar ese nombre
    And Solicitar otro nombreorrecta se inicia sesion como gerente de la tienda
