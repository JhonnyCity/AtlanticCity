package atlantic.CasinoOnline.step;


import atlantic.CasinoOnline.page.PageDeposito;
import net.serenitybdd.annotations.Steps;


public class StepDeposito extends PageDeposito{

    @Steps
    private PageDeposito pageDeposito;

    public void seleccionarBotonDeposito() throws InterruptedException {
        pageDeposito.seleccionarBotonDepositar();
    }
    public void seleccionarBotonTipoPago(String tipoPago){

        pageDeposito.seleccionarBotonTipoPago(tipoPago);
    }
    public void seleccionarMonto(String dato){

        pageDeposito.seleccionarMonto(dato);
    }
    public void seleccionarDepositoSiguiente(){

        pageDeposito.seleccionarBotonDepositoSiguiente();
    }
    public String validarCodigoGenerado(String tipoPago) {
        String codigoMostrado= pageDeposito.obtenerCodigoGenerado(tipoPago);
        return codigoMostrado;
    }
    public String validarMontoMinimoGenerado(String tipoPago){

        return pageDeposito.obtenerMontoMinimo(tipoPago);
    }
    public String validarMensajeMostrado(){

        return pageDeposito.obtenerMensajeMostrado();
    }
    public void seleccionarTerminosCondiciones(){

        pageDeposito.seleccionarTerminosCondiciones();
    }
    public void seleccionarBotonSiguiente(){

        pageDeposito.seleccionarBotonSiguiente();
    }
    public void seleccionarBotonPagarSinAgregarTarjeta(){

        pageDeposito.seleccionarBotonPagarSinAgregarTarjeta();
    }

    public void ingresarDatosDeposito(String numeroTarjeta, String vencimiento,String cvv){
        IngresarDatosTarjetas(numeroTarjeta,vencimiento,cvv);
    }
    public void seleccionarBotonDepositar(){
        SeleccionarDepositar();
    }
    public void validarMensaje(String Mensaje){
        validarMensajes2(Mensaje);
    }
}
