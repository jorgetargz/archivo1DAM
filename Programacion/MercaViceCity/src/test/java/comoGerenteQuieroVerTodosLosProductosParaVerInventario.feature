Feature: Como gerente quiero buscar un producto por nombre para filtrar
  Scenario: Gerente quiere buscar un producto existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 2
    Then Solicitar un nombre
    And Mostrar todos los productos disponibles que contengan ese nombre ignorando mayusculas ordenados por id
    And Volver al menu

  Scenario: Cliente quiere buscar un producto no existente
  Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 2
    Then Solicitar un nombre
    And Mostrar mensaje el nombre introducido no coincide con ningun producto
    And Volver al menu