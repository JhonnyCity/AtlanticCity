package atlantic.CasinoOnline.step;


import atlantic.CasinoOnline.page.PageIniciarSesion;
import atlantic.util.PageObjectUtil;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
//import net.thucydides.core.annotations.Step;
//import net.thucydides.core.annotations.Steps;

public class StepPaginaPrincipal {

    @Steps
    private PageIniciarSesion pageIniciarSesion;

    @Step
    public void abrirPaginaPrincipal() {
        PageObjectUtil.getInstancia().fechaFormatoLatinoLargo();
        pageIniciarSesion.inicializar();
    }


}
