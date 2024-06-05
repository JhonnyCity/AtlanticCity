package atlantic.webSol.page;

import atlantic.CasinoOnline.xpath.XpathPromociones;
import atlantic.util.GuardadoDatos;
import atlantic.util.PageObjectUtil;
import atlantic.util.UtilDef;
import atlantic.webSol.xpath.XpathWebsol;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class PageWebsol extends PageObject {

    protected XpathWebsol Websol = XpathWebsol.getInstancia();
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

    UtilDef utilDef = new UtilDef();


    public void inicializarWebsol() {
        getDriver().get("https://websol.acity.com.pe/isol/");
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
    }
    public void ingresarDatosInicioSesionWebsol(String usuario,String contra){
        pageObjectUtil.seleniumEscribir(Websol.txtUsuario, usuario);
        pageObjectUtil.seleniumEscribir(Websol.txtContra, contra);
        pageObjectUtil.seleniumClick(Websol.btnIngresar,0);
    }
    public void SeleccionarbuscarinvitadoWebsol(){
        pageObjectUtil.seleniumClick(Websol.btnBuscar,0);
        pageObjectUtil.seleniumClick(Websol.btnBuscar,0);
    }
    public void ingresarTarjetaInvitado(String codInvitado){
        getDriver().get("https://websol.acity.com.pe/isol/?o=buscar_clientes&PlayerCard="+codInvitado);
    }
    public void extraerInfo(String promo){
        utilDef.esperar_visibilidad_elemento(25,Websol.txtValorPromo);
        utilDef.GuardarDatosWebsol(promo,Websol.txtValorPromo);
        utilDef.GuardarDatosWebsol(promo,Websol.txtValorPromo2);
    }
}