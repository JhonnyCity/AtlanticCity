Feature: Flujo real

  Background:


  @flujoreal
Scenario Outline: Registro exitoso de usuario en Atlantic City Omitiendo el paso de Registro de OTP
    Given ingreso a la web del casino
    When le doy clic en el botón Registrarse
    And completo los datos del usuario segun el "<tipoDoc>" "<tipoMoneda>"
    | Nombres  | PrimerApellido  | SegundoApellido  | Correo                | NumeroDoc | Celular | CodigoPromo |
    | usuVxxxx | usuVxxxx        | usuVxxxx         | xxxx@gmail.com        | 37785447      | 987587415    | 1234         |
    And completo la informacion del codigo sms
    And ingreso la información del codigo sms por tres veces
    And hago clic en el botón "Siguiente"
    And completo el registro de la cuenta segun el "<tipoBono>"
    | Alias      | Clave      |
    | usuVxxxx   | atl1Vxxxx   |
    And hago clic en el botón Finalizar
    Then se muestra el mensaje "<mensaje>" en la página de Genial ya tienes tu cuenta
    And hago clic en el botón Depositar luego
    And se redirige a la home de la vertical "<valorHome>"
    Examples: Datos del usuario nuevo
    | tipoDoc | tipoMoneda | tipoBono | valorHome    | mensaje                      |
    | DNI     | Soles      | Maquinas | casinoOnline | ¡Genial, ya tienes una cuenta!|
   # | Pasaporte | Dolares    | AD       | sport         |Genial ya tienes tu cuenta|
     # | Carnet    | Soles      | SinBono  | casinoOnline  |Genial ya tienes tu cuenta|

    @flujoreal
    Scenario Outline: Validar que genere el código de pago con el monto mínimo para "<Pasarela>"
        Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
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


    @flujoreal
    Scenario Outline: Validar que genere el código de pago con el monto maximo para "<Pasarela>"
        Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
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

    @flujoreal
    Scenario Outline: Validar el acceso a los juegos de "<vista>"
        Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
        When Me encuentro en "<Vertical>"
        And ingreso los datos del usuario
            | usuario      | contrasenna |
            | Testautomation01 | Testautomation01    |
        Given Realizo el acceso a la vista "<vista>"
        When Selecciono maquina para jugar
        Then Validar acceso maquina

        Examples:
            | vista             | Vertical    |
            | HomeMaquinasNL | Ir a sports |
            | HomeMesasNL         | Ir a sports |

    @flujoreal
    Scenario Outline: Validar la carga de documentos para el usuario
        Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
        When Me encuentro en "<Vertical>"
        And ingreso los datos del usuario
            | usuario          | contrasenna      |
            | Testautomation01 | Testautomation01 |
        When Selecciono icono datos personales
        And Selecciono boton perfil
        And Selecciono el boton Verificar identidad
        When Visualizamos el estado de los documentos pendientes
        When Agregamos documento de identidad
        And Agregamos imagen dni delantera
        And Agregamos imagen dni posterior
        When Agregamos documento bancario
        Then Validamos la visualizacion del boton enviar

        Examples:
            | Vertical    |
            | Ir a sports |

    @flujoreal
    Scenario Outline: Validar que se visualicen los componentes correspondientes para la "<vista>" Logueado
        Given realizo el inicio de sesión con un usuario en moneda soles sin depósitos
        When Me encuentro en "<Vertical>"
        And ingreso los datos del usuario
            | usuario        | contrasenna    |
            | Testcalimaco30 | Testcalimaco30 |
        When Selecciono icono datos personales
        And Selecciono boton retirar
        And Selecciono transferencia bancaria
        When Ingresamos monto de retiro "<monto>"
        Then Validamos boton de continuar retiro

        Examples:
            | Vertical    | monto |
            | Ir a sports | 30    |