package atlantic.CRMCloud.xpath;

public class XpathCRM {

    private static XpathCRM obj = null;
    private XpathCRM() {
    }
    public static XpathCRM getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathCRM();
        }
    }

    //LOGIN
    public final String txtUsuario="//input[@id='username']";

    public final String txtContra="//input[@id='password']";
    public final String btnIngresar="//button[contains(text(),'Ingresar')]";

    //HOME
    public final String btnNuevaBusqueda="//span[contains(text(),'Nueva busqueda')]";
    public final String txtCodigoInvitado="//input[@id='txtCodigo']";
    public final String btnBuscar="//button[@id='btnBuscarLista']";
    public final String btnPerfil="//button[contains(text(),'Perfil')]";

}
