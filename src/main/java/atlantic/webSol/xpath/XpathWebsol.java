package atlantic.webSol.xpath;

public class XpathWebsol {

    private static XpathWebsol obj = null;

    private XpathWebsol() {
    }

    public static XpathWebsol getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathWebsol();
        }
    }

    //LOGIN
    public final String txtUsuario = "//input[@id='username']";
    public final String txtNombre = "//input[@id='Names']";

    public final String txtContra = "//input[@id='password']";
    public final String btnIngresar = "//button[contains(text(),'Iniciar Sesión')]";

    //HOME
    public final String btnBuscar = "//div[@class='classDivMenuGrupoOpcionNombre' and text()='Buscar Cliente']";
    public final String txtTarjetaInvitado = "//input[@id='PlayerCard']";
    public final String txtValorPromo = "//tbody/tr[@id='orden_1']/td[43]/div[1]";
    public final String txtValorPromo2 = "//tbody/tr[@id='orden_1']/td[45]/div[1]";

}

