package atlantic.CRMCloud.step;

import atlantic.CRMCloud.page.PageCRM;
import atlantic.CasinoOnline.page.PagePromociones;

public class StepCRM extends PageCRM {


    public void IngresarCRMCloud(){
        inicializarCRMCloud();
    }
    public void ingresarDatosInicioSesion(String usuario,String password){
        ingresarDatosInicioSesionCRM(usuario,password);
    }
    public void seleccionarNuevaBusqueda(){
        clickBotonNuevaBusqueda();
    }
    public void ingresarCodInvitado(String codInvitado){
        ingresarCodigoInvitado(codInvitado);
    }
    public void seleccionarBuscarInvitado(){
        clickBotonBuscarInvitado();
    }
    public void seleccionarBotonPerfil(){
        clickBotonPerfil();
    }
    public void extraerDatos(String promo){
        extraerInfo(promo);
    }
}
