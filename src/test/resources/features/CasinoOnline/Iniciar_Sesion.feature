  #Autor: Luis Lara

   Feature: LPoder realizar el inicio de sesión del usuario a la pltaforma web del casino Atlantic City
     Como fanatico de las maquinas de tragamonedas
     Quiero iniciar sesión en la web del casino Atlantic City
     Para poder disfrutrar de los juegos virtuales

     Background:
       Given Lingreso a la web del casino

     @LValidarInicioSesionUsuario
     Scenario Outline: LValidar inicio de sesión para la cuenta creada
       When Lselecciono la opcion iniciar sesion
       And Lingreso el "<usuario>" y "<contrasenna>"
       And Lselecciono el boton iniciar sesion
       Then Lse debe mostrar el usuario logueado "<usuarioLogueado>"
       Examples:LDatos de usuario Loqueado
         | usuario | contrasenna |usuarioLogueado|
         |usuVahpc |  atl1Vipeh  | usuVahpc      |