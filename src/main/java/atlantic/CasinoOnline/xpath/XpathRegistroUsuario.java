package atlantic.CasinoOnline.xpath;


public class XpathRegistroUsuario {
    // singleton
    private static XpathRegistroUsuario obj = null;
    private XpathRegistroUsuario() {
    }
    public static XpathRegistroUsuario getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathRegistroUsuario();
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    public final String Xpath_btnRegistrar ="//*[contains(concat( ' ', @class, ' ' ), concat( ' ', 'styles_link__flZEQ', ' ' ))]";
    public final String Xpath_txtNombre ="//*[@id='firstname']";
    public final String Xpath_txtApePate ="//*[@id='paternalLastname']";
    public final String Xpath_txtApeMate ="//*[@id='maternalLastname']";
    public final String Xpath_txtEmail ="//*[@id='email']";
    public final String SelectNacionalidad ="//div[@id='nationality']";
    public final String optionPeru ="//li[text()='Peru']";
    public final String selectDia ="//div[@role='combobox' and @aria-labelledby='birthday-day-label' and contains(@class, 'MuiSelect-filled')]";
    public final String optiondia09 ="//li[@role='option' and @data-value='9']";
    public final String selectMes ="//div[@role='combobox' and @aria-labelledby='birthday-month-label' and contains(@class, 'MuiSelect-filled')]";
    public final String opcionMes04 ="//li[@role='option' and @data-value='4']";
    public final String selectAño ="//div[@role='combobox' and @aria-labelledby='birthday-year-label' and contains(@class, 'MuiSelect-filled')]";
    public final String optionAño2000 ="//li[@role='option' and @data-value='2000']";
    public final String Xpath_txtDni ="//*[@id='national_id']";
    public final String PersonaExpuestaNo ="//span[contains(text(),'No')]";
    public final String txtDirrecioN ="//input[@id='address']";
    public final String selectDepartamento ="//div[@id='State']";
    public final String opcionDepartamento ="//li[@role='option' and text()='Lima']";
    public final String selectProvincia ="//div[@id='province']";
    public final String opcionProvincia ="//li[@role='option' and text()='Lima ']";
    public final String selectDistrito ="//div[@aria-labelledby='city-label']";
    public final String opcionDistrito ="//li[@role='option' and text()='Lima']";
    public final String btnSiguiente1er ="//button[contains(text(),'Siguiente')]";
    public final String Xpath_txtTelefono ="//*[@id='mobileNational']";
    public final String Xpath_txtCodPromocional ="//*[@id='codigoPromocional']";
    public final String Xpath_checkMayorEdad ="//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @name='usoDatos']";
    public final String Xpath_checkAutorizoTermiCondic ="//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @name='checkTerms']";
    public final String Xpath_btnSiguiente ="//*[@id='registerFormStep1']/div[2]/button";
    public String Xpath_txtPrimerCodigoSMS="//div[@class='otpInput_inputRow__htlgz']/input[1]";
    public String Xpath_txtSegundoCodigoSMS="//div[@class='otpInput_inputRow__htlgz']/input[2]";
    public String Xpath_txtTerceroCodigoSMS="//div[@class='otpInput_inputRow__htlgz']/input[3]";
    public String Xpath_txtCuartoCodigoSMS="//div[@class='otpInput_inputRow__htlgz']/input[4]";

    public String Xpath_txtPrimerCodigoSMSSegundoIntento="//div[@class='otpInput_inputRow__htlgz otpInput_inputRow_error__GplfW']//input[1]";
    public String Xpath_txtSegundoCodigoSMSSegundoIntento="//div[@class='otpInput_inputRow__htlgz otpInput_inputRow_error__GplfW']//input[2]";
    public String Xpath_txtTerceroCodigoSMSSegundoIntento="//div[@class='otpInput_inputRow__htlgz otpInput_inputRow_error__GplfW']//input[3]";
    public String Xpath_txtCuartoCodigoSMSSegundoIntento="//div[@class='otpInput_inputRow__htlgz otpInput_inputRow_error__GplfW']//input[4]";
    public final String Xpath_btnSiguientePasoTres ="//button[contains(text(), 'Siguiente')]";
    public final String Xpath_btnValidarCodigoSMS = "//button[@class='clmc-btn-primary' and text()='Validar']";
    public final String Xpath_txtUsuario ="//*[@id=\":rk:\"]";
    public final String Xpath_txtContrasenna ="//div[contains(@class, 'MuiInputBase-root') and contains(@class, 'MuiFilledInput-root')]//input[@id='registerPasswordInput' and @name='password']";
    public final String Xpath_rdbBono = "//input[@type='radio' and @value='REGISTERCASINO' and @name='REGISTERCASINO']";
    public final String xpath_finalizar = "//*[@id='btnSend']";
    public final String xpath_mesnajeCuentaCreada = "//p[@class='clmc-txtc clmc-text-black title' and contains(text(), '¡Genial, ya tienes una cuenta!')]";

    public final String xpath_IraDepositar="//button[contains(text(), 'Depositar Luego')]";
    public final String xpath_Casino= "//img[contains(@class, 'styles_casino-logo__3_VBk') and @alt='Logo']";
    public final String xpath_Deportivo="//img[contains(@class, 'styles_apuestas-logo__T6Q1Z') and @alt='Logo']";

}
