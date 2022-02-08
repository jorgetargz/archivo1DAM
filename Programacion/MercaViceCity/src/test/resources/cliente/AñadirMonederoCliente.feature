Feature: Como cliente quiero añadir monedero para tener dinero disponible

  Background:
    Given Lista monederos cliente
    #NULL
    And Cliente logueado

  Scenario: Cliente quiere añadir monedero con datos validos
    When Cliente introduce un numero de tarjeta 25 (>0)
    And Cliente introduce cantidad de dinero a recargar 50 (>0)
    Then Lista monederos cliente
    #Numero 25, Importe 50

  Scenario: Cliente quiere añadir monedero con datos invalidos
    When Cliente introduce un numero de tarjeta -1 (<0)
    And Cliente introduce cantidad de dinero a recargar -50 (<0)
    Then Mostrar mensaje datos de monedero no validos