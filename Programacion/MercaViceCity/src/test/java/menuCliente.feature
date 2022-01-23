Feature: Elegir entre las opciones disponibles al inicar sesión con rol cliente

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
    Then Pedir medio de pago y cantidad a recargar
    And Sumar la cantidad recargada al saldo
    And Volver al menu

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

  Scenario: Cliente quiere buscar un producto
    Given
    # Menu
    # Saldo: 100€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra
    When Cliente elige la opcion 3
    Then Solicitar un nombre
    And Mostrar todos los productos que contengam ese nombre ignorando mayusculas ordenados por id
    And Volver al menu

  Scenario: Cliente quiere añadir un producto al carrito
    Given
    # Menu
    # Saldo: 100€
    # 1.Recargar monedero virtual
    # 2.Mostrar productos disponibles
    # 3.Buscar producto por nombre
    # 4.Añadir producto al carrito
    # 5.Ver carrito
    # 6.Ver tickets de compra
    When Cliente elige la opcion 4
    Then Solicitar el id del producto ha añadir
    And Indicar nombre y precio del producto
    And Solicitar cantidad
    And Añadir el producto a la lista carrito de compra
    And Volver al menu

  Scenario: Cliente quiere ver los productos añadidos al carrito de compra
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
    And Preguntar si desea pagar o volver al menu

  Scenario: Cliente quiere ver los ticket de sus ultimas compras
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
    Then Mostrar todos los productos y la cantidad que se ha comprado anteriormente por este usuario
    And Volver al menu


