Feature: Como administrador quiero ver la lista de franquicias para tener un control de ellas

  Background:
    Given Sesion de administracion iniciada
    Given Lista de franquicias
    #Nombre,Ubicacion,NumeroEmpleados
    #Segovia I,Avenida Acueducto 22,1
    #Avila II,Calle muralla 12,1
    #Madrid I,Plaza Mayor 5,1

  Scenario: Listar franquicias
    When Lista franquicias
    Then Mostrar tabla con los datos de las franquicias registradas