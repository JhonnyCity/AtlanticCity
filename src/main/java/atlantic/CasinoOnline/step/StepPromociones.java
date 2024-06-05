package atlantic.CasinoOnline.step;

import atlantic.CasinoOnline.page.PagePromociones;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StepPromociones extends PagePromociones {


    public void seleccionarPromociones(){
        ClickPromociones();
    }
    public void limpiezajson(){
        eliminarJson();
    }
    public void seleccionarPromocion(String nombrePromocion){
        ClickPromocion(nombrePromocion);
    }
    public void seleccionarAvance(){
        ClickAvance();
    }
    public void enviarDatosPremio(String puesto,String premio){
        validarPremioPuesto(puesto,premio);
    }
    public void validarPremio(String ValorPremio){
        compararPremio(ValorPremio);
    }
    public void validarTextoFecha(String TextoFecha){
        compararTextoFecha(TextoFecha);
    }
    public void validarValorMulti(String ValorMulti){
        compararValorMulti(ValorMulti);
    }
    public void validarTextoParticipar(String TextoParticipar){
        compararTextoParticular(TextoParticipar);
    }
    public void validarTextoCanje(String TextoCanje){
        compararTextoCanje(TextoCanje);
    }
    public void ingresarIdinvitado(String idinvitado){
        ingresarID(idinvitado);
    }
    public void seleccionarBuscar(){
        seleccionar_Buscar();
    }
    public void seleccionarCanje(){
        seleccionar_Canje();
    }
    public void validarPuntosSorteo(){
        existenPuntosSorteo();
    }
    public void validarOpcionesporCanjear(){
        existenOpcionesporCanjear();
    }
    public void validarOpcionesCanjeadas(String promo){
        GuardarSorteos(promo);
    }
    public void activarPromos(){
        ActivarPromo();
    }
    public void validacionAvanceTorneo(String promo){
        estadoAvanceTorneo(promo);
    }
    public void validarExistenciaPromocion(String promocion){
        ValidarSeMuestrPromo(promocion);
    }
    public void validarExistenciaPromocionNuevo(String promocion){
        ValidarSeMuestrPromoNuevo(promocion);
    }

    public void validarBotonCanjear(){
        ValidarSeMuestraBotonCanjear();
    }
    public void redirrecionamientoPromo(String nombrePromocion){
        redirrecionLinkPromo(nombrePromocion);
    }
    public void validacionFechasCard(String promocion, String[] valores){
        ValidacionFechaCard(promocion,valores);
    }

    public void validacionFechasPromocion(String promocion){
        ValidacionFechaPromocion(promocion);
    }
    public void seleccionarNuevo(){
        ClickBotonNuevo();
    }
    public void seleccionarResultado(){
        ClickBotonResultado();
    }
    public void validacionResultados(String promocion){
        SeMuestraResultadosPromo(promocion);
    }
    public void validarDatosDelivery(){
        seMuestraTextoCanjeDelivery();
        seMuestraImgDelivery();
        seMuestraBotonCanjear();
    }
}
