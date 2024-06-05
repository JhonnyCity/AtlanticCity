Feature: Poder generar el código de depósito con Tarjeta

   Background:
     Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos

  @Deposito @
  Scenario Outline: Validar que genere el código de pago con el monto mínimo
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |usuVahpc |  atl1Vipeh  |
    And Selecciono botón Depositar"
    And Selecciono "<Pasarela>"
    And Selecciono el monto:
      |MontoOrigen|
      |30               |
    And Selecciono botón Siguiente
    Then Se debe mostrar el siguiente mensaje
      |mensaje                    |
      |Tu código se está generando|
    And Se muestra código de pago
    And Se muestra el monto mínimo
      |MontoMinimoResultante |
      |S/ 30.00              |
    Examples:
      | Vertical    | Pasarela     |
      | Ir a casino | Kashio       |
      | Ir a sports | Safetypay    |
      | Ir a casino | PagoEfectivo |
      | Ir a sports | Pago con QR  |


  @Deposito @
  Scenario Outline: Validar que genere el código de pago con el monto maximo
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |usuVahpc |  atl1Vipeh  |
    And Selecciono botón Depositar"
    And Selecciono "<Pasarela>"
    And Selecciono el monto:
      |MontoOrigen|
      |300        |
    And Selecciono botón Siguiente
    Then Se debe mostrar el siguiente mensaje
      |mensaje                    |
      |Tu código se está generando|
    And Se muestra código de pago
    And Se muestra el monto maximo
      |MontoMaximoResultante |
      |S/ 300.00                |
    Examples:
      | Vertical    | Pasarela     |
      | Ir a casino | Kashio       |
      | Ir a sports | Safetypay    |
      | Ir a casino | PagoEfectivo |
      | Ir a sports | Pago con QR  |

  @Deposito @epa
    Scenario Outline: Validar que permita depositar mediante tarjeta con el monto máximo
      When Me encuentro en "<Vertical>"
      And ingreso los datos del usuario
         | usuario | contrasenna |
         |usuVahpc |  atl1Vipeh  |
       And Selecciono botón Depositar"
      And Selecciono "<Pasarela>"
      And Selecciono el monto:
         |MontoOrigen|
         |300        |
      And Acepto términos y condiciones de depósito
      And Selecciono botón Siguiente tarjeta
      And Selecciono boton Pagar sin agregar tarjeta
      And Ingreso "<Tarjeta>" "<Fechacaducidad>" Ingreso "<CVV>"
      And Selcciono botón Depositar
      Then Se muestra mensaje "Estamos procesando tu depósito"
      Examples:
        | Vertical    | Pasarela      | Tarjeta          | Fechacaducidad | CVV |
        | Ir a casino | DebitoCredito | 4009175332806176 | 11/25          | 123 |
        | Ir a sports | DebitoCredito | 4009175332806176 | 11/25          | 123 |

  @Deposito @epa
  Scenario Outline: Validar que permita depositar mediante tarjeta con el monto minimo
    When Me encuentro en "<Vertical>"
    And ingreso los datos del usuario
      | usuario | contrasenna |
      |usuVahpc |  atl1Vipeh  |
    And Selecciono botón Depositar"
    And Selecciono "<Pasarela>"
    And Selecciono el monto:
      | MontoOrigen |
      | 30          |
    And Acepto términos y condiciones de depósito
    And Selecciono botón Siguiente tarjeta
    And Selecciono boton Pagar sin agregar tarjeta
    And Ingreso "<Tarjeta>" "<Fechacaducidad>" Ingreso "<CVV>"
    And Selcciono botón Depositar
    Then Se muestra mensaje "Hubo un error al procesar tu depósito"
    Examples:
      | Vertical    | Pasarela      | Tarjeta          | Fechacaducidad | CVV |
      | Ir a casino | DebitoCredito | 4009175332806176 | 11/25          | 123 |
      | Ir a sports | DebitoCredito | 4009175332806176 | 11/25          | 123 |


