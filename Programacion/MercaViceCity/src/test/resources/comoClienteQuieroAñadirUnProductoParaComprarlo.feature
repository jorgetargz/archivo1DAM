Feature: Como cliente quiero añadir un producto al carrito para comprarlo
  Background:
    Given Lista de productos
    #Id 1, Nombre Kitkat normal, Precio 1, Stock 2;
    #Id 1, Nombre Kitkat blanco, Precio 1.2, Stock 3;
    #Id 1, Nombre Kitkat negro, Precio 1.4, Stock 5;


  Scenario: Cliente quiere añadir un producto existente al carrito
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

  Scenario: Cliente quiere añadir un producto no existente al carrito
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
    And Mostrar mensaje ID no relaccionado con ningun producto
    And Volver al menu