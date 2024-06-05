package atlantic.CasinoOnline.page;

import atlantic.CasinoOnline.xpath.XpathGeneracionCodigo;
import atlantic.util.PageObjectUtil;
import atlantic.util.UtilDef;
import atlantic.CasinoOnline.xpath.XpathDepositoTarjeta;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;

import java.time.Duration;

import static net.serenitybdd.screenplay.waits.Wait.until;
import static org.junit.Assert.assertEquals;

public class PageDeposito extends PageObject{

    @Managed(clearCookies = ClearCookiesPolicy.BeforeEachTest)


    private WebDriverWait wdw = null;
    private long wdwTimeOut = 300L;

    //protected PageObjecUtil pageObjectUtil = PageObjecUtil.getInstancia();
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
    protected XpathGeneracionCodigo xpathGeneracionCodigo = XpathGeneracionCodigo.getInstancia();
    protected XpathDepositoTarjeta Deposito = XpathDepositoTarjeta.getInstancia();

    UtilDef utilDef = new UtilDef();


    public void seleccionarBotonDepositar() throws InterruptedException {
        //utilDef.esperaImplicita(xpathGeneracionCodigo.Xpath_btnDepositar,15);
        //pageObjectUtil.esperaImplicita(getDriver(),xpathGeneracionCodigo.Xpath_btnDepositar);
        pageObjectUtil.clickElementByJavascript(getDriver(),xpathGeneracionCodigo.Xpath_btnDepositar);
    }
    public void seleccionarBotonTipoPago(String tipoPago){
        utilDef.esperarSegundos(3);
        switch (tipoPago){
            case "Kashio":
                pageObjectUtil.seleniumClick(xpathGeneracionCodigo.Xpath_btnPagoKashio, 0);
                break;
            case "Safetypay":
                pageObjectUtil.seleniumClick(xpathGeneracionCodigo.Xpath_btnPagoSafetyPay, 0);
                break;
            case "PagoEfectivo":
                pageObjectUtil.seleniumClick(xpathGeneracionCodigo.Xpath_btnPagoEfectivo, 0);
                break;
            case "Pago con QR":
                pageObjectUtil.seleniumClick(xpathGeneracionCodigo.Xpath_btnPagoQR, 0);
                break;
            case "DebitoCredito":
                pageObjectUtil.seleniumClick(xpathGeneracionCodigo.Xpath_btnDebitoCredito,0);
                break;

        }
    }
    public void seleccionarMonto(String dato){
        utilDef.esperaImplicita(xpathGeneracionCodigo.retornarXpathMonto(dato),15);
    }
    public void seleccionarBotonDepositoSiguiente(){
        pageObjectUtil.seleniumClick(xpathGeneracionCodigo.Xpath_btnDepositarSiguiente,0);
        utilDef.esperarSegundos(2);
        waitForRenderedElements(By.xpath(xpathGeneracionCodigo.Xpath_depositoPopup));
    }

    /*
    Validar dentro del popup
     */
    public String obtenerMensajeMostrado(){
        String popup = "//div[@id='depositpopup']";
        String elementoV="//p[contains(text(),'Tu código se está generando')]";
        utilDef.esperar_visibilidad_elemento(2, popup);
        // Esperar a que el elemento esté visible dentro del popup
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        //WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='depositLoading']/div/p[1]")));
        utilDef.esperar_visibilidad_elemento(2,elementoV);
        String texto = pageObjectUtil.obtenerTexto(elementoV);
        // Obtener el texto del elemento
        //String texto = elemento.getText();
        System.out.println("Texto dentro del popup: " + texto);
        return texto;
    }


    public void validarVisibilidadElemento(){
        utilDef.navegarDentroIframe(xpathGeneracionCodigo.Xpath_iframe);
    }

    public String obtenerCodigoGenerado(String tipoPago){
        String valorDevuelto="";
        switch (tipoPago){
            case "Kashio":
                validarVisibilidadElemento();
                utilDef.esperar_visibilidad_elemento(5, xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoKashio);
                valorDevuelto= pageObjectUtil.obtenerTexto(xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoKashio);
                utilDef.esperarSegundos(5);
                break;
            case "Safetypay":
                validarVisibilidadElemento();
                utilDef.esperar_visibilidad_elemento(5, xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoSafetypay);
                valorDevuelto= pageObjectUtil.obtenerTexto(xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoSafetypay);
                utilDef.esperarSegundos(5);
                break;
            case "PagoEfectivo":
                validarVisibilidadElemento();
                utilDef.navegarDentroIframe(xpathGeneracionCodigo.Xpath_iframe_PE);
                utilDef.esperar_visibilidad_elemento(5, xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoPagoEfectivo);
                valorDevuelto= pageObjectUtil.obtenerTexto(xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoPagoEfectivo);
                utilDef.esperarSegundos(5);
                break;
            default:
                utilDef.esperar_visibilidad_elemento(5, xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoQR);
                valorDevuelto= pageObjectUtil.obtenerTexto(xpathGeneracionCodigo.Xpath_lblCodigoPagoEsperadoQR);
                utilDef.esperarSegundos(5);
                break;
        }
        return valorDevuelto;
    }

    public String obtenerMontoMinimo(String tipoPago){
        String valorDevuelto="";
        switch (tipoPago){
            case "Kashio":
                utilDef.esperar_visibilidad_elemento(5, xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoKashio);
                valorDevuelto= pageObjectUtil.obtenerTexto(xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoKashio);
                valorDevuelto=utilDef.concatenarSimboloMoneda(valorDevuelto,"PEN");
                System.out.println("valorDevuelto: "+valorDevuelto);
                break;
            case "Safetypay":
                utilDef.esperar_visibilidad_elemento(5, xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoSafetypay);
                valorDevuelto= pageObjectUtil.obtenerTexto(xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoSafetypay);
                break;
            case "PagoEfectivo":
                utilDef.esperar_visibilidad_elemento(5, xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoPagoEfectivo);
                valorDevuelto= pageObjectUtil.obtenerTexto(xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoPagoEfectivo);
                valorDevuelto=utilDef.extraerValor(valorDevuelto);
                valorDevuelto=utilDef.concatenarSimboloMoneda(valorDevuelto,"PEN");
                break;
            default:
                utilDef.esperar_visibilidad_elemento(5, xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoQR);
                valorDevuelto= pageObjectUtil.obtenerTexto(xpathGeneracionCodigo.Xpath_lblMontoMinimoMostradoQR);
                valorDevuelto=utilDef.convertirFormatoPagoQR(valorDevuelto);
                break;
        }
        return valorDevuelto;

    }

    public void seleccionarTerminosCondiciones(){


        pageObjectUtil.clickElementByJavascript(getDriver(), Deposito.Xpath_CheckTerminoCondiciones);
        utilDef.esperarSegundos(2);
    }
    public void seleccionarBotonSiguiente(){
        pageObjectUtil.seleniumClick(Deposito.Xpath_Siguiente,0);
    }
    public void seleccionarBotonPagarSinAgregarTarjeta(){

        utilDef.esperarSegundos(2);
        String LinkApi = pageObjectUtil.GuardarSource(Deposito.DepositoSource);
        System.out.println("Link de api : "+ LinkApi);
        getDriver().get(LinkApi);
        utilDef.esperarSegundos(5);
        pageObjectUtil.seleniumClick(Deposito.btnPagarSinTarjeta,0);
    }

    public void IngresarDatosTarjetas(String numerotarjeta,String vencimiento,String cvv){
        utilDef.esperarSegundos(5);
        utilDef.seMuestra(Deposito.txtNumeroTarjeta);
        pageObjectUtil.seleniumEscribir(Deposito.txtNumeroTarjeta, numerotarjeta);
        pageObjectUtil.seleniumEscribir(Deposito.txtMesAnnio, vencimiento);
        pageObjectUtil.seleniumEscribir(Deposito.txtCVV, cvv);

    }
    public void SeleccionarDepositar(){
        pageObjectUtil.clickElementByJavascript(getDriver(), Deposito.btnDepositar);
        utilDef.esperarSegundos(5);
    }
    public void validarMensajes2(String Mensaje) {
     /*   utilDef.esperar_visibilidad_elemento(30, Deposito.txtMensajeDeposito);
        String MensajeError = pageObjectUtil.obtenerTexto(Deposito.txtMensajeDeposito);
        assertEquals(MensajeError,Mensaje);
        */
    }

}
