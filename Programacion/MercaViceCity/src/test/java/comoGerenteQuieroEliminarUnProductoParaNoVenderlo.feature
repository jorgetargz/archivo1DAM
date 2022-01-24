Feature: Como gerente quiero eliminar un producto para dejar de venderlo

  Scenario: Gerente quiere eliminar un producto existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 4
    Then Solicitar un ID de producto
    And Mostrar los datos del producto con el ID seleccionado
    And Solicitar confirmacion para borrado
    And Eliminar producto del inventario
    And Volver al menu

  Scenario: Gerente quiere eliminar un producto no existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 4
    Then Solicitar un ID de producto
    And Mostrar mensaje producto no existente no se puede eliminar
    And Volver al menu
