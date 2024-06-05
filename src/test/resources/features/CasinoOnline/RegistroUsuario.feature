 #Autor: Ronald Carrasco
Feature: Poder realizar el registro de un usurio

  Background:
    Given ingreso a la web del casino

  @ValidarRegistroUsuario
  Scenario Outline: Registro exitoso de usuario en Atlantic City Omitiendo el paso de Registro de OTP
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