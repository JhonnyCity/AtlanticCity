Feature: DatosBrieff


  @front @EC06
  Scenario Outline: Validar que se pueda activar los torneos pendientes.
    Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    And hago clic en la opción Nuevo
    Then Activo todas las promos

    Examples:
      | Vertical    | Idinvitado |
      | Ir a casino | 7293       |

  @front @EC07
  Scenario Outline: Validar que coincida la información de "<NombrePromocion>" en el Home trx VS el Brief.
    Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    Then valido las fechas en los cards de todas las "<NombrePromocion>"
      | PCuota                       | PMesas                         | PMega                           | PTop                          | PVip                               | PuntosVip           | PEstelar                          | PuntosEstelar        | PSueños                                | PuntosSueños         | PDelivery                                               | PWinner                        | TextCardCuota                                                                                           | TextCardMesas                                                                                                  | TextCardMega                                                                                    | TextCardTop                                            |
      | Cada semana más de S/ 50,000 | S/ 21,050 en premios semanales | S/ 7,700 en premios quincenales | S/ 9,200 en premios semanales | S/ 9,999 repartidos en cada sorteo | 5 puntos = 1 opción | Sigue jugando y gana más opciones | 1 punto = 2 opciones | S/ 25,000 en premios todas las semanas | 10 puntos = 1 opción | Acumula 800 puntos y disfruta de un delicioso almuerzo. | S/ 10,800 en premios semanales | Realiza apuestas simples o combinadas con cuotas iguales o superiores a 10.00, a partir de S/10 o $2.5. | Acumula puntos jugando en tus mesas favoritas de Evolution y Pragmatic y sube en el ranking con tus ganancias. | Acumula puntos jugando en tus máquinas favoritas online y sube en el ranking con tus victorias. | ¡Participa todas las semanas y demuestra ser el mejor! |

    Examples:
      | Vertical    | NombrePromocion       | Idinvitado |
      | Ir a sports | Torneo de Mesas       | 7293       |
      | Ir a sports | Torneo de Cuotas      | 7293       |
      | Ir a sports | Top Atlantic          | 7293       |
      | Ir a sports | Winner de Winners     | 7293       |
      | Ir a sports | Atlantic Vip Royal    | 7293       |
      | Ir a sports | Sorteo Estelar        | 7293       |
      | Ir a sports | Sorteo de tus Sueños  | 7293       |
      | Ir a sports | Megatorneo Atlantic   | 7293       |
      | Ir a sports | Delivery de la Semana | 46790      |

  @front @EC08
  Scenario Outline: Validar que se visualicen los componentes correspondientes para la "<vista>" No Logueado
    Given Realizo el acceso a la vista "<vista>"
    Then visualizo al cabecera de la "<vista>"
    And visualizo el contenido de la "<vista>"
    And visualizo el footer de la "<vista>"

    Examples:
      | vista             |
      | Landing           |
      | MenuHamburguesaNL |
      | HomeTrxNL         |
      | HomeColNL         |
      | HomeMaquinasNL    |
      | HomeMesasNL       |

  @front @EC09
  Scenario Outline: Validar que se visualicen los componentes correspondientes para la "<vista>" Logueado
    Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario      | contrasenna |
      | Pruebasfide9 | Fide2021    |
    Given Realizo el acceso a la vista "<vista>"
    Then visualizo al cabecera de la "<vista>" LG
    And visualizo el contenido de la "<vista>" LG
    And visualizo el footer de la "<vista>" LG

    Examples:
      | vista             | Vertical    |
      | MenuHamburguesaNL | Ir a sports |
      | HomeTrxNL         | Ir a sports |
      | HomeColNL         | Ir a sports |
      | HomeMaquinasNL    | Ir a sports |
      | HomeMesasNL       | Ir a sports |
      | mesasEvolution    | Ir a sports |
      | mesasPragmatic    | Ir a sports |
      | mesasEzugi        | Ir a sports |
      | canjePuntos       | Ir a sports |
      | FestivalSemana    | Ir a sports |


