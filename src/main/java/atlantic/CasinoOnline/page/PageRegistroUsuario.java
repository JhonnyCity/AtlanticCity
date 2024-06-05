package atlantic.CasinoOnline.page;

import atlantic.CasinoOnline.xpath.XpathRegistroUsuario;
import atlantic.util.PageObjectUtil;
import atlantic.util.UtilDef;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageRegistroUsuario extends PageObject{

    @Managed(clearCookies = ClearCookiesPolicy.BeforeEachTest)


    private WebDriverWait wdw = null;
    private long wdwTimeOut = 300L;

    //protected PageObjecUtil pageObjectUtil = PageObjecUtil.getInstancia();
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    protected XpathRegistroUsuario xpathRegistroUsuario = XpathRegistroUsuario.getInstancia();

    UtilDef utilDef = new UtilDef();


    public void seleccionarBotonRegistrar(){
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.Xpath_btnRegistrar,0);
    }
    public void completarDatosUsuario(
            String nom,
            String apeP,
            String apeM,
            String email,
            String dni,
            String telefono,
            String codPromo)
    {
        utilDef.esperarSegundos(2);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtNombre,utilDef.randomatoINgresoTexto(nom));
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtApePate,utilDef.randomatoINgresoTexto(apeP));
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtApeMate,utilDef.randomatoINgresoTexto(apeM));
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.SelectNacionalidad,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.optionPeru,0);
        utilDef.esperarSegundos(2);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.selectDia,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.optiondia09,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.selectMes,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.opcionMes04,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.selectAño,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.optionAño2000,0);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtEmail,utilDef.randomEmail(email));
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtDni, utilDef.randomDni(dni));
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtTelefono,utilDef.randomPhone(telefono));
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtCodPromocional,codPromo);
        utilDef.esperarSegundos(5);
    }
    public void seleccionarCheckPrimerPaso(){
        pageObjectUtil.desplegarAbajoJAvaScript(getDriver(),xpathRegistroUsuario.Xpath_checkAutorizoTermiCondic);
        pageObjectUtil.seleccionarClickCheckJavaScript(getDriver(),xpathRegistroUsuario.Xpath_checkAutorizoTermiCondic);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.PersonaExpuestaNo,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.btnSiguiente1er,0);
    }
    public void seleccionarBotonSiguientePasoDos(){
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.Xpath_btnSiguiente,0);
        utilDef.esperarSegundos(5);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.selectDepartamento,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.opcionDepartamento,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.selectProvincia,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.opcionProvincia,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.selectDistrito,0);
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.opcionDistrito,0);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.txtDirrecioN,"dirrecion de prueba");
    }
    public void seleccionarBotonSiguientePasoTres(){
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.Xpath_btnSiguientePasoTres,0);
        utilDef.esperarSegundos(5);
    }
    public void completarCodigoSMS(){
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtPrimerCodigoSMS,"1");
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtSegundoCodigoSMS,"1");
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtTerceroCodigoSMS,"1");
        utilDef.esperarSegundos(1);
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtCuartoCodigoSMS,"1");
        utilDef.esperarSegundos(1);
    }
    public void seleccionarBotonValidarCodigoSMS(){
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.Xpath_btnValidarCodigoSMS,0);
    }
    public void ingresarNuevosDatosCodigoSMS(){
        //pageObjectUtil.limpiarTextoCodigoSMS(getDriver());
        utilDef.seMuestra(xpathRegistroUsuario.Xpath_txtCuartoCodigoSMSSegundoIntento);
        //pageObjectUtil.seleniumEscribir(getDriver(),xpathRegistroUsuario.Xpath_txtCuartoCodigoSMSSegundoIntento,"2");
        element(xpathRegistroUsuario.Xpath_txtCuartoCodigoSMSSegundoIntento).sendKeys("2");
        utilDef.esperarSegundos(10);
        seleccionarBotonValidarCodigoSMS();
        utilDef.esperarSegundos(10);
    }
    public void ingresarNuevosDatosCodigoSMSTres(){
        //pageObjectUtil.limpiarTextoCodigoSMS(getDriver());
        utilDef.seMuestra(xpathRegistroUsuario.Xpath_txtCuartoCodigoSMSSegundoIntento);
        //pageObjectUtil.seleniumEscribir(getDriver(),xpathRegistroUsuario.Xpath_txtCuartoCodigoSMSSegundoIntento,"2");
        element(xpathRegistroUsuario.Xpath_txtCuartoCodigoSMSSegundoIntento).sendKeys("3");
        utilDef.esperarSegundos(10);
        seleccionarBotonValidarCodigoSMS();
        utilDef.esperarSegundos(10);
    }
    public void ingresarAlias(String usu, String pwd){
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtUsuario, utilDef.randomNameLastAliaPass(usu));
        pageObjectUtil.seleniumEscribir(xpathRegistroUsuario.Xpath_txtContrasenna,utilDef.randomNameLastAliaPass(pwd));
        utilDef.esperarSegundos(5);
    }
    public void seleccionarRadioButton(){
        //pageObjectUtil.seleniumClick(getDriver(),xpathRegistroUsuario.Xpath_rdbBono,0);
        pageObjectUtil.seleccionarClickCheckJavaScript(getDriver(),xpathRegistroUsuario.Xpath_rdbBono);
        utilDef.esperarSegundos(3);
    }
    public void seleccionarBotonFinalizar(){
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.xpath_finalizar,0);
        utilDef.esperarSegundos(15);
    }
    public String extraerTextoRespuestaCuentaCreada(){
        String mensajeRetornado="";
        utilDef.esperarSegundos(5);
        ExpectedConditions.visibilityOfElementLocated(By.id(xpathRegistroUsuario.xpath_mesnajeCuentaCreada));
        mensajeRetornado= pageObjectUtil.obtenerTexto(xpathRegistroUsuario.xpath_mesnajeCuentaCreada);
        System.out.println("mensajeRetornado: "+mensajeRetornado);
        return mensajeRetornado;
    }

    public void seleccionarBotonDepositatLuego(){
        pageObjectUtil.seleniumClick(xpathRegistroUsuario.xpath_IraDepositar,0);
    }
    public Boolean validarVisibilidadElemento(){
        return pageObjectUtil.validarVisibilidadJavaScript(getDriver(),xpathRegistroUsuario.xpath_Deportivo);
    }






}
