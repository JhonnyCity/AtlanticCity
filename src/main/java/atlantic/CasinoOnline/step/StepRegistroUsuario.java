package atlantic.CasinoOnline.step;


import atlantic.CasinoOnline.page.PageIniciarSesion;
import atlantic.CasinoOnline.page.PageRegistroUsuario;
import net.serenitybdd.annotations.Steps;


public class StepRegistroUsuario {

    @Steps
    private PageRegistroUsuario pageRegistroUsuario;
    @Steps
    private PageIniciarSesion pageIniciarSesion;

   public void seleccionarBotonRegistrar(){
       pageIniciarSesion.seleccionarCookies();
       pageRegistroUsuario.seleccionarBotonRegistrar();
   }
   public void completarDatosUsuario(
           String nom,
           String apeP,
           String apeM,
           String email,
           String dni,
           String telefono,
           String codPromo
   ){
       pageRegistroUsuario.completarDatosUsuario(nom,apeP,apeM,email,dni,telefono,codPromo);
   }
   public void seleccionarCheckPrimerPaso(){
       pageRegistroUsuario.seleccionarCheckPrimerPaso();
   }
   public void seleccionarBotonSiguientePasoDos(){
       pageRegistroUsuario.seleccionarBotonSiguientePasoDos();
   }
   public void completarCodigoSMS(){
       pageRegistroUsuario.completarCodigoSMS();
   }
   public void seleccionarBotonValidarSMS(){
       pageRegistroUsuario.seleccionarBotonValidarCodigoSMS();
   }
   public void completarCodigoSMSTresVeces(){
       pageRegistroUsuario.ingresarNuevosDatosCodigoSMS();
       pageRegistroUsuario.ingresarNuevosDatosCodigoSMSTres();
   }
   public void seleccionarBotonSiguientePasoTres(){
       pageRegistroUsuario.seleccionarBotonSiguientePasoTres();
   }
   public void ingresarAlias(String usu, String pwd){
       pageRegistroUsuario.ingresarAlias(usu,pwd);
   }
   public void seleccionarBono(){
       pageRegistroUsuario.seleccionarRadioButton();
   }
   public void seleccionarFinalizar(){
       pageRegistroUsuario.seleccionarBotonFinalizar();
   }
   public String extraerTextoRespuestaCuentaCreada(){
       return pageRegistroUsuario.extraerTextoRespuestaCuentaCreada();
   }
   public void seleccionarBotonDepositarLuego(){
       pageRegistroUsuario.seleccionarBotonDepositatLuego();
   }
   public Boolean validarVisibilidadElement(){
       return pageRegistroUsuario.validarVisibilidadElemento();
   }

}
