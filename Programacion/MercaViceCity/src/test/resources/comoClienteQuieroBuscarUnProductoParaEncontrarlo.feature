Feature: Como cliente quiero buscar un producto por nombre para filtrar
  Scenario: Cliente quiere buscar un producto existente
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
    And Mostrar todos los productos disponibles que contengan ese nombre ignorando mayusculas ordenados por id
    And Volver al menu

  Scenario: Cliente quiere buscar un producto no existente
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
    And Mostrar mensaje el nombre introducido no coincide con ningun producto
    And Volver al menu