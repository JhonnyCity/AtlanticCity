package atlantic.CasinoOnline.step;

import atlantic.CasinoOnline.page.PageHome;

public class StepHome extends PageHome {

    public void redirrecionamientoVista(String vista){
        abrirvistas(vista);
    }

    public void validacioCabecera(String vista){
        validarCabecera(vista);
    }
    public void validacionContenido(String vista){
        validarContenido(vista);
    }
    public void validacionFooter(String vista){
        validarFooter(vista);
    }
    public void validacioCabeceraLG(String vista){
        validarCabeceraLG(vista);
    }
    public void validacionContenidoLG(String vista){
        validarContenidoLG(vista);
    }
    public void validacionFooterLG(String vista){
        validarFooterLG(vista);
    }
    public void SeleccionarMaquina(){
        ClickMaquina();
    }
    public void accesoMaquina(){
        AbriApiJuego();
    }
    public void seleccionarIconoDatosPersonales(){
        clickIconoDatosPersonales();
    }
    public void seleccionarPerfil(){
        clickPerfil();
    }
    public void seleccionarBotonVerificarIdentidad(){
        clickBotonVerificarIdentidad();
    }
    public void visualizaBotonAgregarDocumento(){
        visualizarAgregarDocumento();
    }
    public void visualizarBotonAgregarCuenta(){
        visualizarAgregarCuenta();
    }
    public void visualizarBotonValidarNumero(){
        visualizarValidarNumero();
    }
    public void seleccionarBotonAgregarDocumento(){
        clickBotonAgregarDocumento();
    }
    public void seleccionarBotonAgregarimagenFrontal(){
        agregarImagenBotonAgregarfrontal();
    }
    public void seleccionarBotonAgregarimagenPosterior(){
        agregarImagenBotonAgregarPosterior();
    }
    public void seleccionarAgregarDocumentoBancario(){
        agregarImagenBotonAgregarBancario();
    }
    public void ValidamosBotonEnviar(){
        visualizarBotonEnviar();
    }
    public void seleccionarBotonRetirar (){
        clickBotonRetirar();
    }
    public void seleccionarTransferenciaBancaria (){
        clickBotonTransferencia();
    }
    public void ingresamosMontoRetiro (String monto){
        ingresamosMonto(monto);
    }
    public void VisualizarBotonContinuarRetiro (){
        visualizarBotonContinuar();
    }
}
