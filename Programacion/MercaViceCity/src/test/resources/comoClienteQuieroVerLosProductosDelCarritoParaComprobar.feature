Feature: Como cliente quiero ver los productos añadidos al carrito para comprobar si son correctos

  Scenario: Cliente quiere ver los productos añadidos al carrito de compra y seguir comprando
  Given
    # Menu
    # Saldo: 100€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra
    When Cliente elige la opcion 5
    Then Mostrar todos los productos que han sido añadidos a la compra en esta sesion
    And Cliente elige seguir comprando
    And Volver al menu

  Scenario: Cliente quiere ver los productos añadidos al carrito de compra y pagar
  Given
    # Menu
    # Saldo: 100€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra
    When Cliente elige la opcion 5
    Then Mostrar todos los productos que han sido añadidos a la compra en esta sesion
    And Cliente elige pagar
    And Restar monto del monedero
    And Vaciar carrito
    And Mostrar mensaje compra realizada
    And Añadir ticket al usuario
    And Volver al menu