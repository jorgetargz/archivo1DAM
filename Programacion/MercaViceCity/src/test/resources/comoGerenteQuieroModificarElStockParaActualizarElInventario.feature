Feature: Como gerente quiero modifiacr el stock de un producto para actualizar el inventario

  Scenario: Gerente quiere añadir stock de un producto existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 6
    Then Solicitar un ID de producto
    And Cliente elige añadir stock
    And Solicitar cantidad de uevas unidades
    And Modificar el stock en el inventario
    And Volver al menu

  Scenario: Gerente quiere añadir stock de un producto no existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 6
    Then Solicitar un ID de producto
    And Mostrar mensaje de error producto no existente
    And Volver al menu

  Scenario: Gerente quiere reducir stock de un producto existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 6
    Then Solicitar un ID de producto
    And Cliente elige reducir stock
    And Solicitar cantidad de unidades a eliminnar
    And Modificar el stock en el inventario
    And Volver al menu

  Scenario: Gerente quiere reducir stock de un producto no existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 6
    Then Solicitar un ID de producto
    And Mostrar mensaje de error producto no existente
    And Volver al menu