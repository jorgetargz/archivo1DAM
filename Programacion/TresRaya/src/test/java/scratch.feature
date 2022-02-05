Feature: como usuario quiero poner una ficha para ganar

  Scenario: Casilla ocupada
    Given Tablero
    # X - -
    # - - -
    # - - -
    And Es el turno de O
    When Elige la posicion 0,0
    Then Mostrar mensaje celda ocupada
    And Pedir nuevas coordenadas

  Scenario: Coordenadas incorrectas
    Given Tablero
    # X - -
    # - - -
    # - - -
    And Es el turno de O
    When Elige la posicion 3,3
    Then Mostrar mensaje coordenadas incorrectas
    And Pedir nuevas coordenadas

  Scenario: Tres en raya vertical
    Given Tablero
    # X O X
    # X O -
    # - - -
    And Es el turno de O
    When Elige la posicion 1,2
    Then Mostrar mensaje O gana
    And Game over

  Scenario: Tres en raya horizontal
    Given Tablero
    # X X -
    # O O -
    # X - -
    And Es el turno de O
    When Elige la posicion 1,2
    Then Mostrar mensaje O gana
    And Game over

  Scenario: Tres en raya diagonal
    Given Tablero
    # O X -
    # X O -
    # X - -
    And Es el turno de O
    When Elige la posicion 2,2
    Then Mostrar mensaje O gana
    And Game over

  Scenario: Tres en raya diagonal inversa
    Given Tablero
    # X - O
    # X O X
    # - - -
    And Es el turno de O
    When Elige la posicion 0,2
    Then Mostrar mensaje O gana
    And Game over

  Scenario: Tablero lleno
    Given Tablero
    # X O X
    # X O O
    # O X -
    And Es el turno de X
    When Elige la posicion 2,2
    Then Mostrar mensaje tablero lleno
    And Game over
