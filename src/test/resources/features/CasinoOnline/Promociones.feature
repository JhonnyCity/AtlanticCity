Feature: Validar tabla de ranking en torneos de ad

  Como cliente del Casino Atlantic City
  Quiero validar la tabla de ranking de los torneos de apuestas deportivas
  Para asegurarme que los datos muestren correctamente.

  Background:
    Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos

  @promociones @TC01
  Scenario Outline: Validar que se muestre correcamente la tabla de ranking en la promocion
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |usuVahpc |  atl1Vipeh  |
    When me dirijo a la seccion de Promociones
    And selecciono la promoción "<NombrePromocionad>"
    When se muestra la tabla del ranking  del "<NombrePromocionad>"
    Then validar el Premio y el Puesto
      | Puesto | Premio |
      | 1      | 2,000  |
      | 2      | 1,000  |
      | 3      | 800    |
    Examples:
      | Vertical    | NombrePromocionad |
      | Ir a sports | Top Atlantic      |

  @promociones @EC10
  Scenario Outline: Validar textos estáticos para la promoción
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |usuVahpc |  atl1Vipeh  |
    When me dirijo a la seccion de Promociones
    And selecciono la promoción "<NombrePromocion>"
    Then se muestra la información estática de la promoción con los valores esperados
      | Valor del Premio | Texto de Fecha | Valor de Multiplicador | Texto Como Participar | Texto Canje  |
      | <ValorPremio>    | <TextoFecha>   | <ValorMultiplicador>   | <TextoComoParticipar> | <TextoCanje> |

    Examples:
      | Vertical    | NombrePromocion      | ValorPremio | TextoFecha      | ValorMultiplicador | TextoComoParticipar                                                                          | TextoCanje                                                  |
      | Ir a sports | Atlantic Vip Royal   | S/9,999     | Martes y jueves | X5                 | Canjea tus opciones todos los lunes, miércoles y viernes. Cada 5 puntos es igual a 1 opción. | Canje: Mínimo es de 100 opciones y máximo de 600 opciones.  |
      | Ir a sports | Sorteo Estelar       | S/7,500     | Martes y jueves | X5                 | Canjea tus opciones todos los martes, jueves y sábados. Cada 1 punto es igual a 2 opciones.  | Canje: Mínimo es de 50 opciones y máximo de 200 opciones.   |
      | Ir a sports | Sorteo de tus Sueños | S/25,000    | Martes y jueves | X5                 | Canjea tus opciones todos los jueves. Cada 10 puntos es igual a 1 opción.                    | Canje: Mínimo es de 200 opciones y máximo de 5000 opciones. |

    #PENDIENTE ELABORACION
  @promociones @EC11
  Scenario Outline: Validar fechas y textos estáticos de Modal Términos y condiciones para la promoción "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |usuVahpc |  atl1Vipeh  |
    When me dirijo a la seccion de Promociones
    And selecciono la promoción "<NombrePromocion>"
    And hago clic en el botón "Ver Condiciones"
    Then se muestra el modal con las condiciones de la promoción con los valores esperados:
      | FechaSorteosRegulares1     | FechaSorteosRegulares2     | TextoAcumulacion     | TextoCanje     | TextoHoraSorteo     |
      | "<FechaSorteosRegulares1>" | "<FechaSorteosRegulares2>" | "<TextoAcumulacion>" | "<TextoCanje>" | "<TextoHoraSorteo>" |

    Examples:
      | Vertical    | NombrePromocion      | FechaSorteosRegulares1                 | FechaSorteosRegulares2  | TextoAcumulacion                                                                     | TextoCanje                                                                               | TextoHoraSorteo                 |
      | Ir a sports | Atlantic Vip Royal        | Martes y jueves :  A las 00:30 AM.     | Sábados: A la 01:00 AM. | Por cada 5 puntos, obtendrás una opción con un código de 6 dígitos para participar.  | El canje mínimo es de 100 opciones, y puedes acumular hasta un máximo de 600 opciones.   | entre la 3:00 AM y las 6:00 AM. |
      | Ir a sports | Sorteo Estelar       | Miércoles y viernes :  A las 00:30 AM. | Domingo: A la 01:00 AM. | Por cada 1 punto, obtendrás 2 opciones con un código de 6 dígitos para participar.   | El canje mínimo es de 50 opciones, y puedes acumular hasta un máximo de 200 opciones.    | entre la 3:00 AM y las 6:00 AM. |
      | Ir a sports | Sorteo de tus Sueños | Viernes: A la 1:30 AM.                 |                         | Por cada 10 puntos, obtendrás una opción con un código de 6 dígitos para participar. | El canje mínimo es de 200 opciones, y puedes acumular hasta un máximo de 5,000 opciones. | entre la 1:00 AM y las 3:00 AM. |

    #FASE PRIORITARIA

  @promociones @TC04
  Scenario Outline: Validar que se muestren la información de los sorteos del usuario en "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    And selecciono la promoción "<NombrePromocion>"
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    When selecciono la opcion canje
    Then Se muestran los puntos del sorteo
    And Se muestra las opciones por canjear
    And Se muestra las opciones canjeadas

    Examples:
      | Vertical    | NombrePromocion      | Idinvitado |
      | Ir a sports | Atlantic Vip Royal   | 5969       |
      | Ir a sports | Sorteo Estelar       | 44962      |
      | Ir a sports | Sorteo de tus Sueños | 1416       |

  @promociones @TC05
  Scenario Outline: Validar que se muestren la información de los torneos del usuario "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Beatriz17 |  649725Bea  |
    When me dirijo a la seccion de Promociones
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    And selecciono la promoción "<NombrePromocion>"
    When se muestra la tabla del ranking  del "<NombrePromocion>"
    Then Se muestra el avance actual del torneo

    Examples:
      | Vertical    | NombrePromocion     | Idinvitado |
      | Ir a sports | Torneo de Mesas     | 46790      |
      | Ir a sports | Megatorneo Atlantic | 46790      |
      | Ir a sports | Top Atlantic        | 46790      |
      | Ir a sports | Winner de Winners   | 46790      |

  @promociones @TC06
  Scenario Outline: Validar que se muestren la información de los sorteos del usuario "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Beatriz17 |  649725Bea  |
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

  @promociones @TC07
  Scenario Outline: Validar que se muestren la información de los torneos del usuario "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Beatriz17 |  649725Bea  |
    When Ingreso a la web de la "<NombrePromocion>"
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    When se muestra la tabla del ranking  del "<NombrePromocion>"
    Then Se muestra el avance actual del torneo "<NombrePromocion>"

    Examples:
      | Vertical    | NombrePromocion     | Idinvitado |
      | Ir a sports | Torneo de Mesas     | 46790      |
      | Ir a sports | Megatorneo Atlantic | 46790      |
      | Ir a sports | Top Atlantic        | 46790      |
      | Ir a sports | Winner de Winners   | 46790      |
      | Ir a sports | Torneo de Cuotas    | 46790      |

    @promociones @EC12
  Scenario Outline: Validar que la fecha actual esté en el rango de las fechas los cards de "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    Then valido las fechas en los cards de todas las "<NombrePromocion>"

    Examples:
      | Vertical    | NombrePromocion      | Idinvitado |
      | Ir a sports | Torneo de Mesas      | 46790      |
      | Ir a sports | Torneo de Cuotas     | 46790      |
      | Ir a sports | Top Atlantic         | 46790      |
      | Ir a sports | Winner de Winners    | 46790      |
      | Ir a sports | Atlantic Vip Royal   | 46790      |
      | Ir a sports | Sorteo Estelar       | 46790      |
      | Ir a sports | Sorteo de tus Sueños | 46790      |

  @promociones @EC13
  Scenario Outline: Validar las fechas de los torneos del usuario "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When Ingreso a la web de la "<NombrePromocion>"
    And Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    Then valido las fechas de todas las "<NombrePromocion>"

    Examples:
      | Vertical    | NombrePromocion      | Idinvitado |
      | Ir a sports | Winner de Winners    | 46790      |
      | Ir a sports | Torneo de Cuotas     | 46790      |
      | Ir a sports | Torneo de Mesas      | 46790      |
      | Ir a sports | Megatorneo Atlantic  | 46790      |
      | Ir a sports | Top Atlantic         | 46790      |
      | Ir a sports | Atlantic Vip Royal   | 46790      |
      | Ir a sports | Sorteo Estelar       | 46790      |
      | Ir a sports | Sorteo de tus Sueños | 46790      |

  @promociones @EC14
  Scenario Outline: Visualización de tarjetas de promociones en la página de Promociones "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    When Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    Then veo la tarjeta de la promoción "<NombrePromocion>"
    And y su boton correspondiente

    Examples:
      | Vertical    | NombrePromocion      | Idinvitado |
      | Ir a sports | Winner de Winners    | 46790      |
      | Ir a sports | Torneo de Cuotas     | 46790      |
      | Ir a sports | Torneo de Mesas      | 46790      |
      | Ir a sports | Megatorneo Atlantic  | 46790      |
      | Ir a sports | Top Atlantic         | 46790      |
      | Ir a sports | Atlantic Vip Royal   | 46790      |
      | Ir a sports | Sorteo Estelar       | 46790      |
      | Ir a sports | Sorteo de tus Sueños | 46790      |

  @promociones @TC11
  Scenario Outline: Visualización de tarjetas de promociones en la página de Promociones con torneos inactivos "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    When Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    Then veo la tarjeta de la promoción "<NombrePromocion>"
    And sus parametros correspondientes

    Examples:
      | Vertical    | NombrePromocion       | Idinvitado |
      | Ir a sports | Delivery de la Semana | 46790      |
      | Ir a sports | Top Atlantic          | 46790      |
      | Ir a sports | Atlantic Vip Royal    | 46790      |
      | Ir a sports | Sorteo Estelar        | 46790      |
      | Ir a sports | Sorteo de tus Sueños  | 46790      |

  @promociones @TC12
  Scenario Outline: visualizar que no aparezcan las promociones activas en Nuevo "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    When Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    When hago clic en la opción Nuevo
    Then solo veo la tarjeta de la promoción "<NombrePromocion>"

    Examples:
      | Vertical    | NombrePromocion | Idinvitado |
      | Ir a sports | Pago Anticipado | 237497      |
      | Ir a sports | Drops and Wins  | 237497      |


  @promociones @TC13
  Scenario Outline: visualizar que  aparezcan las promociones pendiente a activar en Nuevo "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    When Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    When hago clic en la opción Nuevo
    Then veo la tarjeta de la promoción "<NombrePromocion>"

    Examples:
      | Vertical    | NombrePromocion   | Idinvitado |
      | Ir a sports | Pago Anticipado   | 1012       |
      | Ir a sports | Drops and Wins    | 1012       |
      | Ir a sports | Winner de Winners | 1012       |
      | Ir a sports | Torneo de Cuotas  | 1012       |
      | Ir a sports | Torneo de Mesas   | 1012       |

  @promociones @TC14
  Scenario Outline: visualizar que  aparezcan los resultados de "<NombrePromocion>" en Resultados
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Testautomation01 |  Testautomation01  |
    When me dirijo a la seccion de Promociones
    When Ingreso con el ojito el "<Idinvitado>"
    And Selecciono buscar
    When hago clic en la opción Resultados
    Then se valida los resultados de la promocion "<NombrePromocion>"

    Examples:
      | Vertical | NombrePromocion | Idinvitado |
      | Ir a sports | Delivery de la Semana | 46790      |
      | Ir a sports | Top Atlantic          | 46790      |
      | Ir a sports | Atlantic Vip Royal    | 46790      |
      | Ir a sports | Sorteo Estelar        | 46790      |
      | Ir a sports | Sorteo de tus Sueños  | 46790      |

  @promociones @TC15
  Scenario Outline: visualizar datos de delivery "<NombrePromocion>"
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |Pruebasfide3 |  Fide2021  |
    When me dirijo a la seccion de Promociones
    And selecciono la promoción "<NombrePromocion>"
    Then valido la imagen,textos y boton del delivery


    Examples:
      | Vertical    | NombrePromocion       |
      | Ir a sports | Delivery de la Semana |