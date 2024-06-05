package atlantic.webSol.step;

import atlantic.CasinoOnline.page.PagePromociones;
import atlantic.webSol.page.PageWebsol;

public class StepWebsol extends PageWebsol {

    public void IngresarWebsol(){
        inicializarWebsol();
    }
    public void ingresarDatosInicioSesion(String usuario,String password){
        ingresarDatosInicioSesionWebsol(usuario,password);
    }


    public void Seleccionarbuscarinvitado(){
        SeleccionarbuscarinvitadoWebsol();
    }

    public void IngresoTarjetadeinvitado(String tarInvitado){
        ingresarTarjetaInvitado(tarInvitado);
    }
    public void extraerDatosWebsol(String promo){
        extraerInfo(promo);
    }
}
