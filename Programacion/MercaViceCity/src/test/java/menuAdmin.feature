Feature: Elegir entre las opciones disponibles al inicar sesión con rol gerente de tienda

  Scenario: Gerente quiere ver todos los productos
    Given
    # Menu
    # 1. Ver inventario
    # 2. Buscar un producto
    # 3. Añadir un producto
    # 4. Eliminar un producto mediante ID
    # 5. Modificar precio mediante ID
    # 6. Modificar stock mediante ID
    When Gerente elige la opcion 1
    Then Mostrar todos los productos ordenados por id
    And Volver al menu

  Scenario: Gerente quiere buscar un producto
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
    And Mostrar todos los productos que contengam ese nombre ignorando mayusculas ordenados por id
    And Volver al menu

  Scenario: Gerente quiere añadir un producto
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
    And Si el producto ya esta registrado mostrar mensaje de error
    And volver al menu

  Scenario: Gerente quiere añadir un producto
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
    And Si el producto no esta registrado pedir precio de venta
    And Solicitar stock disponible
    And Registrar producto en el inventario
    And Volver al menu

  Scenario: Gerente quiere eliminar un producto
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

  Scenario: Gerente quiere modificar el precio de un producto
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

  Scenario: Gerente quiere modificar el stock de un producto
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
    And Mostrar los datos del producto con el ID seleccionado
    And Solicitar nuevo stock disponible
    And Modificar el stock en el inventario




