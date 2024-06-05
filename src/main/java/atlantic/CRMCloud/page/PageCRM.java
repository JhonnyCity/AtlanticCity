package atlantic.CRMCloud.page;

import atlantic.CRMCloud.xpath.XpathCRM;
import atlantic.CasinoOnline.xpath.XpathPromociones;
import atlantic.util.PageObjectUtil;
import atlantic.util.UtilDef;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class PageCRM extends PageObject {

    protected XpathCRM CRM = XpathCRM.getInstancia();
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

    UtilDef utilDef = new UtilDef();

    public void inicializarCRMCloud() {
        getDriver().get("https://crmatlantic.acity.com.pe/");
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        Serenity.takeScreenshot();
    }
    public void ingresarDatosInicioSesionCRM(String usuario,String contra){
        pageObjectUtil.seleniumEscribir(CRM.txtUsuario, usuario);
        pageObjectUtil.seleniumEscribir(CRM.txtContra, contra);
        pageObjectUtil.seleniumClick(CRM.btnIngresar,0);
    }
    public void clickBotonNuevaBusqueda(){
    pageObjectUtil.seleniumClick(CRM.btnNuevaBusqueda,0);
    }
    public void ingresarCodigoInvitado(String codInvitado){
        pageObjectUtil.seleniumEscribir(CRM.txtCodigoInvitado,codInvitado);
    }
    public void clickBotonBuscarInvitado(){
        pageObjectUtil.seleniumClick(CRM.btnBuscar,0);
    }
    public void clickBotonPerfil(){
        pageObjectUtil.seleniumClick(CRM.btnPerfil,0);
    }
    public void extraerInfo(String promo){
        pageObjectUtil.sleep(10);
        utilDef.pruebaExtraer(promo);
    }
}