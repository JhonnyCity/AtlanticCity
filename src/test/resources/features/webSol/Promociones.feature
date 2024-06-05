Feature: Validar datos de promocion Websol

  Como cliente del Casino Atlantic City
  Quiero validar los datos de las promociones y torneos en Websol
  Para asegurarme que los datos muestren correctamente.

  Background:
    Given realizo el inicio de sesión con un usuario en Websol
  @Websol @TC01
  Scenario Outline: Validar que se muestren la información de los sorteos del usuario
    And ingreso los datos del usuario Websol
      | usuario | contrasenna |
      | jprado  | Acity2024   |
    And Selecciono Buscar Cliente
    And Ingreso Tarjeta de invitado "<Tarjetainvitado>"
    Then Extraer Datos Websol

    Examples:
      | Tarjetainvitado |
      | 80104245        |
