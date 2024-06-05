Feature: Validar datos de promocion CRM Cloud

  Como cliente del Casino Atlantic City
  Quiero validar los datos de las promociones y torneos en CRM
  Para asegurarme que los datos muestren correctamente.

  Background:
    Given realizo el inicio de sesión con un usuario en CRMCloud
  @CRMCloud @TC01
  Scenario Outline: Validar que se muestren la información de los sorteos del usuario "<NombrePromocion>"
    And ingreso los datos del usuario CRM
      | usuario | contrasenna |
      | jprado  | Acity2024   |
    When Selecciono Nueva búsqueda
    And Ingreso Codigo de invitado "<Codigoinvitado>"
    And Selecciono buscar invitado
    And Selecciono el botón Perfil de la primera opción
    Then Extraer Datos "<NombrePromocion>"
    Examples:
      | Codigoinvitado | NombrePromocion      |
      | 46790          | FESTIVAL DE          |
      | 46790          | Top Atlantic         |
      | 46790          | Sorteo estelar       |
      | 46790          | Atlantic VIP         |
      | 46790          | Sorteo de tus Sueños |
      | 46790          | Mega Torneo          |
      | 46790          | Torneo de Mesas      |
      | 46790          | TORNEO WINNERS       |

