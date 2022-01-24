Feature: Como gerente quiero modificar el precio de un producto para cambiar su precio de venta

  Scenario: Gerente quiere modificar el precio de un producto existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 5
    Then Solicitar un ID de producto
    And Mostrar los datos del producto con el ID seleccionado
    And Solicitar nuevo precio de venta
    And Modificar precio de venta en el inventario
    And Volver al menu

  Scenario: Gerente quiere modificar el precio de un producto no existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 5
    Then Solicitar un ID de producto
    And Mostrar mensaje de error producto no existe
    And Volver al menu