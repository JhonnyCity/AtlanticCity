Feature: ComparacionData
  @CRMCloudOnline @TC00
  Scenario Outline: Limpieza json
    Given realizo limpieza

    Examples:
      | Vertical    |
      | Ir a sports |

  @CRMCloudOnline @EC01
  Scenario Outline: Validar que se visualice la información de los sorteos. "<NombrePromocion>"
    Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When Ingreso a la web de la "<NombrePromocion>"
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    When selecciono la opcion canje
    Then Se muestran los puntos del sorteo
    And Se muestra las opciones por canjear
    And Se muestra las opciones canjeadas "<NombrePromocion>"

    Examples:
      | Vertical    | NombrePromocion      | Idinvitado |
      | Ir a sports | Atlantic Vip Royal   | 46790      |
      | Ir a sports | Sorteo Estelar       | 46790      |
      | Ir a sports | Sorteo de tus Sueños | 46790      |

  @CRMCloudOnline @TC02
  Scenario Outline: Validar que se visualice la información de los torneos y delivery."<NombrePromocion>"
    Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When Ingreso a la web de la "<NombrePromocion>"
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    When se muestra la tabla del ranking  del "<NombrePromocion>"
    Then Se muestra el avance actual del torneo "<NombrePromocion>"

    Examples:
      | Vertical    | NombrePromocion     | Idinvitado |
      | Ir a sports | Festival            | 46790      |
      | Ir a sports | Torneo de Mesas     | 46790      |
      | Ir a sports | Megatorneo Atlantic | 46790      |
      | Ir a sports | Top Atlantic        | 46790      |
      | Ir a sports | Winner de Winners   | 7293       |
   #  | Ir a sports | Torneo de Cuotas    | 46790      |

  @CRMCloudOnline @TC03
  Scenario Outline: Validar que se muestren "<NombrePromocion>" del usuario en CRMCloud
    Given realizo el inicio de sesión con un usuario en CRMCloud
    And ingreso los datos del usuario CRM
      | usuario | contrasenna |
      | jprado  | NOsequeponer12   |
    When Selecciono Nueva búsqueda
    And Ingreso Codigo de invitado "<Codigoinvitado>"
    And Selecciono buscar invitado
    And Selecciono el botón Perfil de la primera opción
    Then Extraer Datos "<NombrePromocion>"
    Examples:
      | Codigoinvitado | NombrePromocion      |
      | 46790          | FESTIVAL             |
      | 46790          | Top Atlantic         |
      | 46790          | Sorteo estelar       |
      | 46790          | Atlantic VIP         |
      | 46790          | Sorteo de tus Sueños |
      | 46790          | Mega Torneo          |
      | 46790          | Torneo de Mesas      |
      | 7293           | TORNEO WINNERS       |


  @CRMCloudOnline @TC04
  Scenario Outline: Validar que se visualice la información de "<NombrePromocion>" en Websol.
    Given realizo el inicio de sesión con un usuario en Websol
    And ingreso los datos del usuario Websol
      | usuario | contrasenna |
      | jprado  | NOsequeponer12   |
    And Ingreso Tarjeta de invitado "<Tarjetainvitado>"
    Then Extraer Datos Websol "<NombrePromocion>"

    Examples:
      | Tarjetainvitado | NombrePromocion     |
      | 80104245        | MEGA TORNEO         |
      | 80104245        | SORTEO VIP          |
      | 80104245        | SORTEO SUEÑOS       |
      | 80104245        | SORTEO ESTELAR      |
      | 80104245        | TOP ATLANTIC        |
      | 80104245        | Puesto TOP ATLANTIC |
      | 80104245        | Puesto MEGA TORNEO  |

  @CRMCloudOnline @EC05
  Scenario Outline: Validar que coincida la data de "<NombrePromocion>" en la Web + CRMCloud + Websol.
    Given Validacion comparacion online,websol,crm en la "<NombrePromocion>"

    Examples:
      | NombrePromocion      |
      | Megatorneo           |
      | Atlantic Vip         |
      | Sorteo de tus Sueños |
      | Sorteo Estelar       |
      | Top Atlantic         |
      | Torneo de Mesas      |
      | Winner de Winners    |
      | Festival             |


