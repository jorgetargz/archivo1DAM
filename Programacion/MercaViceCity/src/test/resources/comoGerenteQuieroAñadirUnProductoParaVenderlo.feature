Feature: Como gerente quiero añadir un producto al inventario para venderlo

  Scenario: Gerente quiere añadir un producto ya existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 3
    Then Solicitar un nombre de producto
    And Mostrar mensaje de error
    And volver al menu

  Scenario: Gerente quiere añadir un producto nuevo
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 3
    Then Solicitar un nombre de producto
    And Solocitar precio de venta
    And Solicitar stock disponible
    And Registrar producto en el inventario
    And Volver al menu