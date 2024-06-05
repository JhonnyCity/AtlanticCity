package atlantic.CasinoOnline.xpath;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XpathDepositoTarjeta {
    // singleton
    private static XpathDepositoTarjeta obj = null;
    private XpathDepositoTarjeta() {
    }
    public static XpathDepositoTarjeta getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathDepositoTarjeta();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public final String Xpath_CheckTerminoCondiciones ="//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @id='niubiz_terms_check' and @data-indeterminate='false']";

    public final String Xpath_Siguiente ="//button[@id='depositButton' and contains(text(), 'Siguiente')]";

    @FindBy(xpath = "//div[@id='inputOtroMonto']")
    public static WebElement otroMonto;

    //public final String Xpath_iframe ="//iframe[@id='depositResponseIframe']";
    public final String DepositoSource = "//iframe[@id='depositResponseIframe']";
    public final String btnPagarSinTarjeta = "//button[@id='depositWithoutCardButton']";
    public final String txtNumeroTarjeta = "//*[@id=\"txtNumeroTarjeta\"]";
    public final String txtMesAnnio = "//body/div[@id='niubiz_content']/div[@id='txtFechaVencimiento']/div[1]/iframe[1]";
    public final String txtCVV = "//body/div[@id='niubiz_content']/div[3]/div[1]/div[1]/iframe[1]";
    public final String btnDepositar = "//button[@id='depositButtonId']";
    public final String txtMensajeDeposito = "//p[contains(text(),'Hubo un error al procesar tu depósito')]";

}
