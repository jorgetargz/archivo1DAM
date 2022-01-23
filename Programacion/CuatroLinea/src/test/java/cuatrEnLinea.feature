Feature: como usuario quiero poner una ficha para ganar

  Scenario: Columna llena
    Given Tablero
    # O - - - - - -
    # X - - - - - -
    # O - - - - - -
    # X - - - - - -
    # O - - - - - -
    # X - - - - - -
    And Es el turno de X
    When Elige la columna 0
    Then Mostrar mensaje columna ocupada
    And Pedir nueva columna

  Scenario: Columna incorrecta
    Given Tablero
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    And Es el turno de X
    When Elige la columna 7
    Then Mostrar mensaje columna incorrecta
    And Pedir nueva columna

  Scenario: Cuatro en linea vertical
    Given Tablero
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # X - - - - - -
    # X O - - - - -
    # X O O - - - -
    And Es el turno de X
    When Elige la columna 0
    Then Mostrar mensaje X gana
    And Game over

  Scenario: Cuatro en line horizontal
    Given Tablero
    # - - - - - - -
    # - - - - - - -
    # O - - - - - -
    # O - - - - - -
    # O - - - - - -
    # X X X - - - -
    And Es el turno de X
    When Elige la columna 3
    Then Mostrar mensaje X gana
    And Game over

  Scenario: Cuatro en linea diagonal
    Given Tablero
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # - - X O - - -
    # X X O X - - -
    # X O O O - - -
    And Es el turno de X
    When Elige la columna 3
    Then Mostrar mensaje X gana
    And Game over

  Scenario: Cuatro en linea diagonal inversa
    Given Tablero
    # - - - - - - -
    # - - - - - - -
    # - - - - - - -
    # X O X - - - -
    # O O O X - - -
    # X O X O X - -
    And Es el turno de X
    When Elige la columna 1
    Then Mostrar mensaje X gana
    And Game over

  Scenario: Tablero lleno
    Given Tablero
    # O X O X O X -
    # X O X O X O X
    # O X O X O X O
    # X X O X O X X
    # O O X O O X O
    # X O X O X O X
    And Es el turno de O
    When Elige la columna 6
    Then Mostrar tablero lleno empate
    And Game over