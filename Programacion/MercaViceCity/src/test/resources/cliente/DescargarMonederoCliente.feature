Feature: Como cliente quiero descargar mi monedero para sacarlo de la app

  Background:
    Given Monedero cliente logueado contiene 100€


  Scenario: Cliente quiere descargar cantidad disponible del monedero
    When Cliente introduce una tarjeta bancaria
    And Cliente introduce cantidad de dinero a descargar 50
    Then Disminuir en 50€ el saldo del monedero


  Scenario: Cliente quiere descargar cantidad no disponible del monedero
    When Cliente introduce una tarjeta bancaria
    And Cliente introduce cantidad de dinero a descargar 150
    Then Mostrar mensaje de error no dispones de esa cantidad en el monedero


  Scenario: Cliente quiere descargar monedero con una cantidad negativa
    When Cliente introduce una tarjeta bancaria
    And Cliente introduce cantidad de dinero a descargar -50
    Then Mostrar mensaje de error debe introducir una cantidad positiva