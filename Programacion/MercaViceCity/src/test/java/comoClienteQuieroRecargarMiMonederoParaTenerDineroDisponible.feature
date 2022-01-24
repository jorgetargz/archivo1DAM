Feature: Como cliente quiero recargar mi monedero para tener dinero disponible

  Scenario: Cliente quiere recargar monedero
    Given
    # Menu
    # Saldo: 100€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra
    When Cliente elige la opcion 1
    And Cliente introduce una tarjeta bancaria
    And Cliente introduce cantidad de dinero a recargar 50€
    Then Sumar la cantidad recargada al saldo
    And Volver al menu
    # Menu
    # Saldo: 150€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra