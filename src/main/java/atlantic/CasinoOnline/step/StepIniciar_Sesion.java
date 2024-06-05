package atlantic.CasinoOnline.step;

import atlantic.CasinoOnline.page.PageIniciar_Sesion;
import net.serenitybdd.annotations.Steps;

public class StepIniciar_Sesion {

    @Steps
    private PageIniciar_Sesion pageIniciar_sesion;
    public void seleccionarIniciar_Sesion(){

        pageIniciar_sesion.seleccionarInicioSesion();
    }

    public void seleccionarIrACasino(){

        pageIniciar_sesion.seleccionarCasinoOnline();
    }

    public void seleccionarVertical(String dato){

        pageIniciar_sesion.seleccionarVertical(dato);
    }

    public void ingresarDatosIniciarSesion(String usuario, String contrasenna){
        pageIniciar_sesion.ingresarDatosInicioSesion(usuario, contrasenna);
    }

    public void seleccionarIngresasr(){
            pageIniciar_sesion.seleccionarIngresar();
    }

}
