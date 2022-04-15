Feature: Como administrador quiero registrar franquicias para ver donde se trabaja

  Background:
    Given Sesion de administracion iniciada
    Given Lista de franquicias
    #Nombre,Ubicacion,NumeroEmpleados
    #Segovia I,Avenida Acueducto 22,1
    #Avila II,Calle muralla 12,1
    #Madrid I,Plaza Mayor 5,1

  Scenario: Registrar franquicia nueva
    Given Nombre: Segovia II
    Given Ubicacion: Calle Riaza 4
    When Registra franquicia
    Then Añadir franquicia a la lista
    #Nombre,Ubicacion,NumeroEmpleados
    #Segovia II,Calle Riaza 4,0

  Scenario: Registrar franquicia ya registrada
    Given Nombre: Segovia I
    Given Ubicacion: Calle Laud
    When Registra franquicia
    Then Mostrar mensaje nombre de franquicia ya registrado
