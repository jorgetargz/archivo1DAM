Feature: Como cliente quiero recargar mi monedero para tener dinero disponible

  Background:
    Given Monedero cliente logueado contiene 100€


  Scenario: Cliente quiere recargar monedero
    When Cliente introduce una tarjeta bancaria
    And Cliente introduce cantidad de dinero a recargar 50
    Then Aumentar en 50€ el saldo del monedero


  Scenario: Cliente quiere recargar monedero con una cantidad negativa
    When Cliente introduce una tarjeta bancaria
    And Cliente introduce cantidad de dinero a recargar -50
    Then Mostrar mensaje de error debe introducir una cantidad positiva