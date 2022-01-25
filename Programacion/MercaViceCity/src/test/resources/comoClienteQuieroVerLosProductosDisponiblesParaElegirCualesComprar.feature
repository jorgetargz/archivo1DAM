Feature: Como cliente quiero ver los productos disponibles para elegir cuales comprar

  Scenario: Cliente quiere ver todos los productos disponibles
    Given
    # Menu
    # Saldo: 100€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra
    When Cliente elige la opcion 2
    Then Mostrar todos los productos con stock disponible ordenados por id
    And Volver al menu