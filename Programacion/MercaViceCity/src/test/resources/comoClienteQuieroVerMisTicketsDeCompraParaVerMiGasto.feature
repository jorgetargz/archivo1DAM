Feature: Como cliente quiero ver mis ticket de compra para controlar mi gasto

  Scenario: Cliente tiene tickets
  Given
    # Menu
    # Saldo: 100€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra
    When Cliente elige la opcion 6
    Then Mostrar todos los tickets de compra
    And Volver al menu

  Scenario: Cliente no tiene tickets
  Given
    # Menu
    # Saldo: 100€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra
    When Cliente elige la opcion 6
    Then Mostrar mensaje todavia no has realizado ninguna compra
    And Volver al menu