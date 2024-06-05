package atlantic.CasinoOnline.page;

import atlantic.CasinoOnline.xpath.XpathFront;
import atlantic.CasinoOnline.xpath.XpathHome;
import atlantic.CasinoOnline.xpath.XpathPromociones;
import atlantic.util.PageObjectUtil;
import atlantic.util.UtilDef;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PageHome extends PageObject {

    protected XpathHome Home = XpathHome.getInstancia();
    protected XpathPromociones Promociones = XpathPromociones.getInstancia();

    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

    UtilDef utilDef = new UtilDef();

    public void abrirvistas(String vista){
        utilDef.esperarSegundos(5);
        switch (vista){
            case "Landing":
                getDriver().get("https://www.casinoatlanticcity.com/");
                break;
            case "MenuHamburguesaNL":
                getDriver().get("https://www.casinoatlanticcity.com/");
                break;
            case "HomeTrxNL":
                getDriver().get("https://www.casinoatlanticcity.com/promociones");
                break;
            case "HomeColNL":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online");
                break;
            case "HomeMaquinasNL":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/tragamonedas");
                break;
            case "HomeMesasNL":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/juegos-de-mesa");
                break;
            case "mesasEvolution":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/mesas-evolution");
                break;
            case "mesasPragmatic":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/mesas-pragmatic");
                break;
            case "mesasEzugi":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/mesas-ezugi");
                break;
            case "FestivalSemana":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/atlantic-club/delivery-atlantic");
                break;
            case "canjePuntos":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/atlantic-club/ecommerce");
                break;
            case "Apuesta":
                getDriver().get("https://www.casinoatlanticcity.com/apuestas-deportivas#/overview");
                break;
        }
    }
    public void validarCabecera(String vista){
        switch (vista){
            case "Landing":
                if (utilDef.seMuestra(Home.btnSport)&& utilDef.seMuestra(Home.btnCasino)
                &&utilDef.seMuestra(Home.btnPromociones)&&utilDef.seMuestra(Home.btnIngresar)
                        && utilDef.seMuestra(Home.btnRegistrar)){
                    System.out.println("Todos los botnos de cabecera correctamente");
                }else {
                    Assert.fail("Los botnos de la cabecera estan fallando");
                }
                break;
            case "MenuHamburguesaNL":
                pageObjectUtil.seleniumClick(Home.btnHamburguesaNL,0);
                break;
            case "HomeTrxNL":
                if (utilDef.seMuestra(Home.btnSport)&& utilDef.seMuestra(Home.btnCasino)
                        &&utilDef.seMuestra(Home.btnIngresar)
                        && utilDef.seMuestra(Home.btnRegistrar)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
            case "HomeColNL":
                if (utilDef.seMuestra(Home.btnIniciarSesion)
                        && utilDef.seMuestra(Home.btnCrearCuenta)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
            case "HomeMaquinasNL":
                if (utilDef.seMuestra(Home.btnIniciarSesion)
                        && utilDef.seMuestra(Home.btnCrearCuenta)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
            case "HomeMesasNL":
                if (utilDef.seMuestra(Home.btnIniciarSesion)
                        && utilDef.seMuestra(Home.btnCrearCuenta)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
        }
    }

    public void validarContenido(String vista){
        switch (vista){
            case "Landing":
                if (utilDef.seMuestra(Home.ContenidoCARD)&& utilDef.seMuestra(Home.ContenidoSeccionPreguntas)
                ){
                    System.out.println("Todos el contenido esta correctamente");
                }else {
                    Assert.fail("El contenido esta fallando");
                }
                break;
            case "MenuHamburguesaNL":
                if (utilDef.seMuestra(Home.btnInicio)&& utilDef.seMuestra(Home.btnPromocionesNL)
                        && utilDef.seMuestra(Home.btnCasinoNL)&& utilDef.seMuestra(Home.btnSportNL)
                ){
                    System.out.println("Todos el contenido hamburguesa esta correctamente");
                }else {
                    Assert.fail("El contenido hamburguesa esta fallando");
                }
                break;
            case "HomeTrxNL":
                JSONObject datos = null;
                if (utilDef.seMuestra(Home.ContenidoTeDevolvemos)&& utilDef.seMuestra(Home.ContenidoTeRegalamos)
                ){
                    System.out.println("Contenido de devolvemos esta correctamente");
                }else {
                    Assert.fail("Contenido de devolvemos esta fallando");
                }

                List<WebElement> cards = Serenity.getDriver().findElements(By.cssSelector("div[class^='previewPromoCard_cardContainer___Y42M']"));

                List<String> titles = new ArrayList<>();

                List<String> contend = new ArrayList<>();

                for (WebElement card : cards) {
                    try {
                        WebElement titleSpan = card.findElement(By.cssSelector("div.previewPromoCard_cardHeader__cyJeZ span"));
                        String title = titleSpan.getText();
                        titles.add(title);
                        WebElement contenidodiv = card.findElement(By.cssSelector("div.previewPromoCard_cardBody__v40hF"));
                        String contenido = contenidodiv.getText();
                        contend.add(contenido);
                        pageObjectUtil.seleniumClick("(//button[contains(@class, 'MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeSmall carousel-button css-1xhbec8')])[1]",0);
                        if(title.contains("JUGADA DE LABORATORIO")){
                            utilDef.HacerScroll("//span[contains(text(),'Winner de winners')]");
                            pageObjectUtil.seleniumClick("(//button[contains(@class, 'MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeSmall carousel-button css-1xhbec8')])[2]",0);
                        }
                    }catch (Exception ex){
                    }
                }
                List<String> alltorneos = new ArrayList<>();

                alltorneos.add("MEGATORNEO ATLANTIC");
                alltorneos.add("TORNEO DE MESAS");
                alltorneos.add("SORTEO ESTELAR");
                alltorneos.add("SORTEO ESTELAR");
                alltorneos.add("SORTEO ELECTRÓNICO");
                alltorneos.add("DELIVERY DE FIN DE SEMANA");
                alltorneos.add("SORTEO ATLANTIC VIP ROYAL");
                alltorneos.add("TOP ATLANTIC");
                alltorneos.add("MULTIPLICADORES");
                alltorneos.add("SORTEO DE TUS SUEÑOS");
                alltorneos.add("DROPS & WINS");
                alltorneos.add("SUPERCUOTA");
                alltorneos.add("JUGADA DE LABORATORIO");
                alltorneos.add("WINNER DE WINNERS");
                alltorneos.add("TORNEO DE CUOTAS");
                alltorneos.add("PAGO ANTICIPADO");

                try {
                    String Link = "HomeTrxNl";
                    Link = "data/Home/" + Link + ".json";
                    String dataPromos = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(dataPromos);
                }catch (Exception ex){
                }

                List<String> contenidoPromos = new ArrayList<>();
                boolean found;
                for (int i = 1; i <= 16; i++) {
                    String promoKey = "promo" + i;
                    contenidoPromos.add(datos.getString(promoKey));
                }

                for (String torneo : alltorneos) {
                    found = false;
                    for (String titulo : titles) {
                        if (titulo.contains(torneo)) {
                            System.out.println("Se muestra correctamente el torneo " + torneo);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Assert.fail("No se encuentra " + torneo);
                    }
                }
                for (String textos : contenidoPromos) {
                    found = false;

                    for (String contenido : contend) {
                        if (contenido.contains(textos)) {
                            System.out.println("Se muestra correctamente el contenido " + textos);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Assert.fail("No se encuentra " + textos);
                    }
                }

                if (utilDef.seMuestra(Home.btnRegistrateJuega3)&& utilDef.seMuestra(Home.btnRegistrateJuega2)
                        && utilDef.seMuestra(Home.btnRegistrateJuega)){
                    System.out.println("Botones registrate y juega se visualizan correctamente");
                }else {
                    Assert.fail("Botones registrate y juega se visualizan incorrectamente");
                }
                if (utilDef.seMuestra(Home.bonoCasino)&& utilDef.seMuestra(Home.bonoSport)){
                    System.out.println("Botones bonos se visualizan correctamente");
                }else {
                    Assert.fail("Botones bonos se visualizan incorrectamente");
                }
                if (utilDef.seMuestra(Home.btnLoquiero)&& utilDef.seMuestra(Home.btnLoquiero2)){
                    System.out.println("Botones lo quiero se visualizan correctamente");
                }else {
                    Assert.fail("Botones lo quiero se visualizan incorrectamente");
                }
                if (utilDef.seMuestra(Home.txtTitiloAtlanticClub)&& utilDef.seMuestra(Home.txtContenidoAtlanticClub)){
                    System.out.println("Contenido Atlantic se visualizan correctamente");
                }else {
                    Assert.fail("Contenido Atlantic se visualizan incorrectamente");
                }

                break;
            case "HomeColNL":
                if (utilDef.seMuestra(Home.txtMaquinas)&& utilDef.seMuestra(Home.txtMesasEnVivo)
                        &&utilDef.seMuestra(Home.txtMesas)&&utilDef.seMuestra(Home.txtApuestasDeportivas)
                        &&utilDef.seMuestra(Home.contenidoAtlanticClub)&&utilDef.seMuestra(Home.contenidoApuestasDeportivas)
                        &&utilDef.seMuestra(Home.btnIrSport)&&utilDef.seMuestra(Home.FlechaDerechaSlider)
                        &&utilDef.seMuestra(Home.FlechaIzquierdoSlider)&&utilDef.seMuestra(Home.btnBuscarJuego)
                        &&utilDef.seMuestra(Home.flechamaquinas)&&utilDef.seMuestra(Home.fechaMesasEnVivo)
                        &&utilDef.seMuestra(Home.fechaMesas)&&utilDef.seMuestra(Home.txtMasInformacionInteres)
                        && utilDef.seMuestra(Home.txtAtlanticClub)
                        ){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                if(utilDef.seMuestra(Home.txtCasinoOnlinePeru)
                        &&utilDef.seMuestra(Home.SEObtnMostrarMas)&&utilDef.seMuestra(Home.SEOpregunta1)
                        &&utilDef.seMuestra(Home.SEOpregunta2)&&utilDef.seMuestra(Home.SEOpregunta3)
                        &&utilDef.seMuestra(Home.SEOpregunta4)&&utilDef.seMuestra(Home.SEOpregunta5)
                        &&utilDef.seMuestra(Home.SEOpregunta6)&&utilDef.seMuestra(Home.SEOcentroAyuda))
                {
                    System.out.println("Todos los textos de SEO estan correctos");
                }else {
                    Assert.fail("los textos de SEO estan incorrectos");
                }
                break;
            case "HomeMaquinasNL":
                if (utilDef.seMuestra(Home.txtJuegoNuevos)&& utilDef.seMuestra(Home.txtMasjugados)&&utilDef.seMuestra(Home.btnBuscarJuegoMQ)
                        &&utilDef.seMuestra(Home.txtProgresivos)&&utilDef.seMuestra(Home.txtAtracciones)
                        &&utilDef.seMuestra(Home.txtClasicos)&&utilDef.seMuestra(Home.txtHighRollers)
                        && utilDef.seMuestra(Home.txtProveedores)&& utilDef.seMuestra(Home.txtUltimosJackPots)
                        &&utilDef.seMuestra(Home.txtTodosLosJuegos)){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                if(utilDef.seMuestra(Home.TxtTragamonedasCasino)&&utilDef.seMuestra(Home.txtMasInformacion)
                        &&utilDef.seMuestra(Home.SEObtnMostrarMas)&&utilDef.seMuestra(Home.SEOMQpregunta1)
                        &&utilDef.seMuestra(Home.SEOMQpregunta2)&&utilDef.seMuestra(Home.SEOMQpregunta3)
                        &&utilDef.seMuestra(Home.SEOMQpregunta4)&&utilDef.seMuestra(Home.SEOcentroAyuda))
                {
                    System.out.println("Todos los textos de SEO estan correctos");
                }else {
                    Assert.fail("los textos de SEO estan incorrectos");
                }
                break;
            case "HomeMesasNL":
                if (utilDef.seMuestra(Home.iconorulete)&& utilDef.seMuestra(Home.iconoBlackjack)
                        &&utilDef.seMuestra(Home.iconoBaccarat)&&utilDef.seMuestra(Home.iconoPoker)
                        && utilDef.seMuestra(Home.iconoTodosJuegos)){
                    System.out.println("Todos los iconos correctos");
                }else {
                    Assert.fail("los iconos estan incorrectos");
                }
                if (utilDef.seMuestra(Home.txtRuleta)&& utilDef.seMuestra(Home.txtBlackjack)
                        &&utilDef.seMuestra(Home.txtBaccarat)&&utilDef.seMuestra(Home.txtPoker)
                        && utilDef.seMuestra(Home.txtTodolosJueg)&& utilDef.seMuestra(Home.btnBuscarJuegoMQ)){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                if(utilDef.seMuestra(Home.txtJuegosMesa)&&utilDef.seMuestra(Home.txtMasInformacionde)
                        &&utilDef.seMuestra(Home.SEObtnMostrarMas)&&utilDef.seMuestra(Home.SEOMESpregunta1)
                        &&utilDef.seMuestra(Home.SEOMESpregunta2)&&utilDef.seMuestra(Home.SEOMESpregunta3)
                        &&utilDef.seMuestra(Home.SEOcentroAyuda))
                {
                    System.out.println("Todos los textos de SEO estan correctos");
                }else {
                    Assert.fail("los textos de SEO estan incorrectos");
                }
                break;
        }
    }
    public void validarFooter(String vista){
        switch (vista){
            case "Landing":
                if (utilDef.seMuestra(Home.iconoKashio)&& utilDef.seMuestra(Home.iconoVisa)
                        &&utilDef.seMuestra(Home.iconoMasterCard)&&utilDef.seMuestra(Home.iconoInterbank)
                        && utilDef.seMuestra(Home.iconoSafetyPay)&& utilDef.seMuestra(Home.iconoPagoEfectivo)
                        &&utilDef.seMuestra(Home.iconoYape)&&utilDef.seMuestra(Home.iconoPlin)
                        &&utilDef.seMuestra(Home.IconosRandom)){
                    System.out.println("Todos los Iconos de pago estan correctos");
                }else {
                    Assert.fail("Los iconos de pago no se visualizan correctamente");
                }
                if (utilDef.seMuestra(Home.iconoCasinoOnline)&& utilDef.seMuestra(Home.iconoSport)
                ){
                    System.out.println("Los botones de verticales se visualizan correctamente");
                }else {
                    Assert.fail("Los botones de verticales no se visualizan correctamente");
                }
                break;
            case "MenuHamburguesaNL":
                if (utilDef.seMuestra(Home.btnQuienesSomos)){
                    System.out.println("Todos el contenido hamburguesa esta correctamente");
                }else {
                    Assert.fail("El contenido hamburguesa esta fallando");
                }
                break;
            case "HomeTrxNL":
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)&&utilDef.seMuestra(Home.txtSportFooter)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandom)&&utilDef.seMuestra(Home.txtcentrodeayuda)
                        &&utilDef.seMuestra(Home.iconoLibroReclamacion)&&utilDef.seMuestra(Home.iconoCOAtlantic)
                        &&utilDef.seMuestra(Home.iconoAPAtlantic)&&utilDef.seMuestra(Home.footerAtlanticDerechosReservados)
                ){
                    System.out.println("Todos los Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                break;
            case "HomeColNL":
                utilDef.HacerScroll(Home.txtQuienesSomos);
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)&&utilDef.seMuestra(Home.txtSportFooter)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandom)&&utilDef.seMuestra(Home.txtcentrodeayuda)
                        &&utilDef.seMuestra(Home.iconoLibroReclamacion)&&utilDef.seMuestra(Home.iconoCOAtlantic2)
                        &&utilDef.seMuestra(Home.iconoAPAtlantic)&&utilDef.seMuestra(Home.footerAtlanticDerechosReservados)
                ){
                    System.out.println("Todos los  Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                break;
            case "HomeMaquinasNL":
                utilDef.HacerScroll(Home.txtQuienesSomos);
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandom)&&utilDef.seMuestra(Home.txtcentrodeayuda)
                        &&utilDef.seMuestra(Home.iconoLibroReclamacion)&&utilDef.seMuestra(Home.iconoCOAtlantic2)
                        &&utilDef.seMuestra(Home.iconoAPAtlantic)&&utilDef.seMuestra(Home.footerAtlanticDerechosReservados)
                ){
                    System.out.println("Todos los Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                if (utilDef.seMuestra(Home.iconoKashio)&& utilDef.seMuestra(Home.iconoVisa)
                        &&utilDef.seMuestra(Home.iconoMasterCard)&&utilDef.seMuestra(Home.iconoInterbank)
                        && utilDef.seMuestra(Home.iconoSafetyPay)&& utilDef.seMuestra(Home.iconoPagoEfectivo)
                        &&utilDef.seMuestra(Home.iconoYape)&&utilDef.seMuestra(Home.iconoPlin)){
                    System.out.println("Todos los Iconos de pago estan correctos");
                }else {
                    Assert.fail("Los iconos de pago no se visualizan correctamente");
                }
                break;
            case "HomeMesasNL":
                utilDef.HacerScroll(Home.txtQuienesSomos);
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandom)&&utilDef.seMuestra(Home.txtcentrodeayuda)){
                    System.out.println("Todos los Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                if (utilDef.seMuestra(Home.iconoKashio)&& utilDef.seMuestra(Home.iconoVisa)
                        &&utilDef.seMuestra(Home.iconoMasterCard)&&utilDef.seMuestra(Home.iconoInterbank)
                        && utilDef.seMuestra(Home.iconoSafetyPay)&& utilDef.seMuestra(Home.iconoPagoEfectivo)
                        &&utilDef.seMuestra(Home.iconoYape)&&utilDef.seMuestra(Home.iconoPlin)
                        ){
                    System.out.println("Todos los Iconos de pago estan correctos");
                }else {
                    Assert.fail("Los iconos de pago no se visualizan correctamente");
                }
                break;
        }
    }

    public void validarCabeceraLG(String vista){
        switch (vista){
            case "MenuHamburguesaNL":
                pageObjectUtil.seleniumClick(Home.btnHamburguesaLG,0);
                break;
            case "HomeTrxNL":
                if (utilDef.seMuestra(Home.btnDepositarPromo)&& utilDef.seMuestra(Home.btnNotificaciones)
                        &&utilDef.seMuestra(Home.btnUsuario)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
            case "HomeColNL":
                if (utilDef.seMuestra(Home.btnDepositar)
                        && utilDef.seMuestra(Home.btnNotificaciones)&& utilDef.seMuestra(Home.btnUsuario)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
            case "HomeMaquinasNL":
                if (utilDef.seMuestra(Home.btnDepositar)
                        && utilDef.seMuestra(Home.btnNotificaciones)&& utilDef.seMuestra(Home.btnUsuario)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
            case "HomeMesasNL":
                if (utilDef.seMuestra(Home.btnDepositar)
                        && utilDef.seMuestra(Home.btnNotificaciones)&& utilDef.seMuestra(Home.btnUsuario)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
            case "mesasEvolution":
                if (utilDef.seMuestra(Home.iconoCorazon)
                        && utilDef.seMuestra(Home.iconoAmplicar)&& utilDef.seMuestra(Home.iconoCerrar)){
                    System.out.println("Los botones de la cabecera se visualizan correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera se visualizan incorrectamente");
                }
            case "mesasPragmatic":
                if (utilDef.seMuestra(Home.iconoCorazon)
                        && utilDef.seMuestra(Home.iconoAmplicar)&& utilDef.seMuestra(Home.iconoCerrar)){
                    System.out.println("Los botones de la cabecera se visualizan correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera se visualizan incorrectamente");
                }
                break;
            case "mesasEzugi":
                if (utilDef.seMuestra(Home.iconoCorazon)
                        && utilDef.seMuestra(Home.iconoAmplicar)&& utilDef.seMuestra(Home.iconoCerrar)){
                    System.out.println("Los botones de la cabecera se visualizan correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera se visualizan incorrectamente");
                }
                break;
            case "FestivalSemana":
                if (utilDef.seMuestra(Home.getBtnDepositarDelivery)
                        && utilDef.seMuestra(Home.btnNotificacionesDelivery)&& utilDef.seMuestra(Home.btnUsuario)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
            case "canjePuntos":
                if (utilDef.seMuestra(Home.getBtnDepositarDelivery)
                        && utilDef.seMuestra(Home.btnNotificacionesDelivery)&& utilDef.seMuestra(Home.btnUsuario)){
                    System.out.println("Todos los botones de cabecera correctamente");
                }else {
                    Assert.fail("Los botones de la cabecera estan fallando");
                }
                break;
        }
    }
    public void validarContenidoLG(String vista){
        switch (vista){
            case "MenuHamburguesaNL":
                if (utilDef.seMuestra(Home.btnPromocionesLG)&& utilDef.seMuestra(Home.btnMaquinasLG)
                        && utilDef.seMuestra(Home.btnMesasVivoLG)&& utilDef.seMuestra(Home.btnMesasLG)
                        && utilDef.seMuestra(Home.btnAtlanticCityLG)
                ){
                    System.out.println("Todos el contenido hamburguesa esta correctamente");
                }else {
                    Assert.fail("El contenido hamburguesa esta fallando");
                }
                pageObjectUtil.seleniumClick(Home.btnMesasVivoLG,0);
                if (utilDef.seMuestra(Home.btnMesasEvolution)&& utilDef.seMuestra(Home.btnMesasPragmatic)
                        && utilDef.seMuestra(Home.btnMesasEzugi)){
                    System.out.println("Todas las redirecciones de mesas en vivo correctamente");
                }else {
                    Assert.fail("redirreciones de mesas en vivo fallando");
                }
                break;
            case "HomeTrxNL":
                if (utilDef.seMuestra(Home.txtBienveidoPromos)&& utilDef.seMuestra(Home.btnMisPromociones)
                        && utilDef.seMuestra(Home.btnNuevo)&& utilDef.seMuestra(Home.btnResultados)){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                utilDef.esperarSegundos(10);
                break;
            case "HomeColNL":
                JSONObject datos = null;
                List<WebElement> cards = Serenity.getDriver().findElements(By.cssSelector("div[class^='cardItem styles_sliderLobbyCard__4HWLw d-flex align-items-end']"));

                List<String> titles = new ArrayList<>();

                List<String> contend = new ArrayList<>();

                List<String> etiqueta = new ArrayList<>();
                for (WebElement card : cards) {
                    try {
                        WebElement titleSpan = card.findElement(By.cssSelector("p.styles_txt1__RqVuD"));
                        String title = titleSpan.getText();
                        titles.add(title);
                        WebElement contenidodiv = card.findElement(By.cssSelector("div.styles_content__MkKgl span"));
                        String contenido = contenidodiv.getText();
                        contend.add(contenido);
                        WebElement etiquetaSpan = card.findElement(By.cssSelector("div.styles_etiquetaTipo__cNT6T"));
                        String etiquet = etiquetaSpan.getText();
                        etiqueta.add(etiquet);
                    }catch (Exception ex){
                    }
                }
                try {
                    String Link = "TitulosTrxLGPromos";
                    Link = "data/Home/" + Link + ".json";
                    String dataPromos = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(dataPromos);
                }catch (Exception ex){
                }

                List<String> contenidoTitulo = new ArrayList<>();
                boolean found;
                for (int i = 1; i <= 10; i++) {
                    String promoKey = "titulo" + i;
                    contenidoTitulo.add(datos.getString(promoKey));
                }
                List<String> contenido = new ArrayList<>();

                for (int i = 1; i <= 10; i++) {
                    String promoKey = "contenido" + i;
                    contenido.add(datos.getString(promoKey));
                }
                List<String> contenidoEtiqueta = new ArrayList<>();

                for (int i = 1; i <= 10; i++) {
                    String promoKey = "etiqueta" + i;
                    contenidoEtiqueta.add(datos.getString(promoKey));
                }

                for (String torneo : contenidoTitulo) {
                    found = false;
                    for (String titulo : titles) {
                        if (titulo.contains(torneo)) {
                            System.out.println("Se muestra correctamente el torneo " + torneo);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Assert.fail("No se encuentra " + torneo);
                    }
                }
                for (String textos : contenido) {
                    found = false;

                    for (String contenido2 : contend) {
                        if (contenido2.contains(textos)) {
                            System.out.println("Se muestra correctamente el contenido " + textos);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Assert.fail("No se encuentra " + textos);
                    }
                }
                for (String textos : contenidoEtiqueta) {
                    found = false;

                    for (String etiquet : etiqueta) {
                        if (etiquet.contains(textos)) {
                            System.out.println("Se muestra correctamente el contenido " + textos);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        Assert.fail("No se encuentra " + textos);
                    }
                }

                if (utilDef.seMuestra(Home.txtMaquinas)&& utilDef.seMuestra(Home.txtMesasEnVivo)&& utilDef.seMuestra(Home.BtnFavoritos)
                        &&utilDef.seMuestra(Home.txtMesas)&&utilDef.seMuestra(Home.txtApuestasDeportivas)
                        &&utilDef.seMuestra(Home.contenidoAtlanticClub)&&utilDef.seMuestra(Home.contenidoApuestasDeportivas)
                        &&utilDef.seMuestra(Home.btnIrSport)&&utilDef.seMuestra(Home.FlechaDerechaSlider)
                        &&utilDef.seMuestra(Home.FlechaIzquierdoSlider)&&utilDef.seMuestra(Home.btnBuscarJuego)
                        &&utilDef.seMuestra(Home.flechamaquinas)&&utilDef.seMuestra(Home.fechaMesasEnVivo)
                        &&utilDef.seMuestra(Home.fechaMesas)&&utilDef.seMuestra(Home.txtMasInformacionInteres)&& utilDef.seMuestra(Home.flechaFavoritos)
                        && utilDef.seMuestra(Home.txtAtlanticClub)
                ){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                if(utilDef.seMuestra(Home.txtCasinoOnlinePeru)
                        &&utilDef.seMuestra(Home.SEObtnMostrarMas)&&utilDef.seMuestra(Home.SEOpregunta1)
                        &&utilDef.seMuestra(Home.SEOpregunta2)&&utilDef.seMuestra(Home.SEOpregunta3)
                        &&utilDef.seMuestra(Home.SEOpregunta4)&&utilDef.seMuestra(Home.SEOpregunta5)
                        &&utilDef.seMuestra(Home.SEOpregunta6)&&utilDef.seMuestra(Home.SEOcentroAyuda)
                        &&utilDef.seMuestra(Home.txtRetiroRapido)&&utilDef.seMuestra(Home.txtSeguridadGarantia)
                        &&utilDef.seMuestra(Home.txtCasinoLider)&&utilDef.seMuestra(Home.txtServicioPersonalizado))
                {
                    System.out.println("Todos los textos de SEO estan correctos");
                }else {
                    Assert.fail("los textos de SEO estan incorrectos");
                }

                break;
            case "HomeMaquinasNL":
                if (utilDef.seMuestra(Home.txtJuegoNuevos)&& utilDef.seMuestra(Home.txtMasjugados)&&utilDef.seMuestra(Home.btnBuscarJuegoMQ)
                        &&utilDef.seMuestra(Home.txtProgresivos)&&utilDef.seMuestra(Home.txtAtracciones)&&utilDef.seMuestra(Home.btnFavoritosMQ)
                        &&utilDef.seMuestra(Home.txtClasicos)&&utilDef.seMuestra(Home.txtHighRollers)&&utilDef.seMuestra(Home.txtParati)
                        && utilDef.seMuestra(Home.txtProveedores)&& utilDef.seMuestra(Home.txtUltimosJackPots)
                        &&utilDef.seMuestra(Home.txtTodosLosJuegos)){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                if(utilDef.seMuestra(Home.TxtTragamonedasCasino)&&utilDef.seMuestra(Home.txtMasInformacion)
                        &&utilDef.seMuestra(Home.SEObtnMostrarMas)&&utilDef.seMuestra(Home.SEOMQpregunta1)
                        &&utilDef.seMuestra(Home.SEOMQpregunta2)&&utilDef.seMuestra(Home.SEOMQpregunta3)
                        &&utilDef.seMuestra(Home.SEOMQpregunta4)&&utilDef.seMuestra(Home.SEOcentroAyuda))
                {
                    System.out.println("Todos los textos de SEO estan correctos");
                }else {
                    Assert.fail("los textos de SEO estan incorrectos");
                }
                break;
            case "HomeMesasNL":
                if (utilDef.seMuestra(Home.iconorulete)&& utilDef.seMuestra(Home.iconoBlackjack)
                        &&utilDef.seMuestra(Home.iconoBaccarat)&&utilDef.seMuestra(Home.iconoPoker)
                        && utilDef.seMuestra(Home.iconoTodosJuegos)){
                    System.out.println("Todos los iconos correctos");
                }else {
                    Assert.fail("los iconos estan incorrectos");
                }
                if (utilDef.seMuestra(Home.txtRuleta)&& utilDef.seMuestra(Home.txtBlackjack)&& utilDef.seMuestra(Home.btnFavoritosMQ)
                        &&utilDef.seMuestra(Home.txtBaccarat)&&utilDef.seMuestra(Home.txtPoker)
                        && utilDef.seMuestra(Home.txtTodolosJueg)){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                if(utilDef.seMuestra(Home.txtJuegosMesa)&&utilDef.seMuestra(Home.txtMasInformacionde)
                        &&utilDef.seMuestra(Home.SEObtnMostrarMas)&&utilDef.seMuestra(Home.SEOMESpregunta1)
                        &&utilDef.seMuestra(Home.SEOMESpregunta2)&&utilDef.seMuestra(Home.SEOMESpregunta3)
                        &&utilDef.seMuestra(Home.SEOcentroAyuda))
                {
                    System.out.println("Todos los textos de SEO estan correctos");
                }else {
                    Assert.fail("los textos de SEO estan incorrectos");
                }
                break;
            case "mesasEvolution":
                break;
            case "mesasPragmatic":
                break;
            case "mesasEzugi":
                break;
            case "FestivalSemana":
                if (utilDef.seMuestra(Home.PuntajeActual)&& utilDef.seMuestra(Home.txtTituloFestival)
                        &&utilDef.seMuestra(Home.txtDiasCanjeFestival)&&utilDef.seMuestra(Home.txtSolicitarDelivery)
                        &&utilDef.seMuestra(Home.txtComeGanoPuntos)&&utilDef.seMuestra(Home.txtAlcanza800)
                        &&utilDef.seMuestra(Home.txtcontenidoDelivery)&&utilDef.seMuestra(Home.txtSolicitarDeliveryconten)
                        && utilDef.seMuestra(Home.btnCanjearDelivery)&& utilDef.seMuestra(Home.btnPreguntasFrecuentes)
                        &&utilDef.seMuestra(Home.btnTerminosyC)&& utilDef.seMuestra(Home.txtpuntosReinician)
                        && utilDef.seMuestra(Home.txtDudasConsultas)){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                break;
            case "canjePuntos":
                if (utilDef.seMuestra(Home.txtTituloCanjePuntos)&& utilDef.seMuestra(Home.btnDirrecionEnvio)
                        &&utilDef.seMuestra(Home.btnHistorialPedidos)&&utilDef.seMuestra(Home.btnCarritoCanjes)
                        && utilDef.seMuestra(Home.btnRestaurante)&& utilDef.seMuestra(Home.btnEfectivo)
                        &&utilDef.seMuestra(Home.btnMisDirecciones)&&utilDef.seMuestra(Home.txtSubTituloCanje)){
                    System.out.println("Todos los textos de contenido estan correctos");
                }else {
                    Assert.fail("los textos de contenido estan incorrectos");
                }
                LocalTime now = LocalTime.now();

                LocalTime noon = LocalTime.NOON;
                if (now.isBefore(noon)) {
                    if(utilDef.seMuestra(Home.txtHorarioAtencion)){
                        System.out.println("Horario de atencion Correcto antes de las 12PM");
                    }else{
                        Assert.fail("No se muestra mensaje de horario de atencion en canje");
                    }
                } else {
                    pageObjectUtil.seleniumClick(Home.btnDireccionEnvio,0);
                    pageObjectUtil.seleniumClick(Home.btnAgregarDirrecion2,0);
                    pageObjectUtil.seleccionarComboxpath(getDriver(),Home.selectDistrito,1);
                    pageObjectUtil.seleniumEscribir(Home.txtDirrecionCanje,"Prueba");
                    pageObjectUtil.seleniumEscribir(Home.txtReferenciaCanje,"Prueba");
                    pageObjectUtil.seleniumEscribir(Home.txtNombreDireccionCanje,"Prueba");
                    utilDef.esperarSegundos(2);
                    utilDef.HacerScroll(Home.txtDirrecionCanje);
                    utilDef.esperarSegundos(2);
                    pageObjectUtil.seleniumClick(Home.btnAgregarDirrecionCanje,0);
                    getDriver().get("https://www.casinoatlanticcity.com/casino-online/atlantic-club/ecommerce");
                    pageObjectUtil.seleniumClick(Home.btnDireccionEnvio,0);
                    pageObjectUtil.seleniumClick(Home.selectDireccion,0);
                    utilDef.esperarSegundos(2);
                    utilDef.HacerScroll(Home.btnEfectivo);
                    utilDef.esperarSegundos(2);
                    pageObjectUtil.seleniumClick(Home.PrimerPedido,0);
                    pageObjectUtil.seleniumClick(Home.btnAgregarCarrito,0);
                    utilDef.esperarSegundos(5);
                    getDriver().get("https://www.casinoatlanticcity.com/casino-online/atlantic-club/ecommerce");
                    pageObjectUtil.seleniumClick(Home.btnEfectivo,0);
                    utilDef.HacerScroll(Home.btnEfectivo);
                    utilDef.esperarSegundos(2);
                    pageObjectUtil.seleniumClick(Home.btnSelectRetiro,0);
                    pageObjectUtil.seleniumClick(Home.btnAgregarCarrito2,0);
                    utilDef.esperarSegundos(2);
                    getDriver().get("https://www.casinoatlanticcity.com/casino-online/atlantic-club/ecommerce");
                    pageObjectUtil.seleniumClick(Home.btnCarritoCanjes,0);
                    utilDef.HacerScroll(Home.txtTotal);
                    utilDef.seMuestra(Home.btnContinuarCanje);
                }
                break;
        }
    }
    public void validarFooterLG(String vista){
        switch (vista){
            case "MenuHamburguesaNL":
                pageObjectUtil.seleniumClick(Home.btnAtlanticCityLG,0);
                if (utilDef.seMuestra(Home.btnCanjePuntos)&& utilDef.seMuestra(Home.btnDelivery)){
                    System.out.println("Todos el contenido de Atlantic Club esta correctamente");
                }else {
                    Assert.fail("El contenido de Atlantic Club  esta fallando");
                }
                break;
            case "HomeTrxNL":
                metodoObtenerCardsActuales();
                break;
            case "HomeColNL":
                utilDef.HacerScroll(Home.txtQuienesSomos);
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)&&utilDef.seMuestra(Home.txtSportFooter)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandom)&&utilDef.seMuestra(Home.txtcentrodeayuda)
                        &&utilDef.seMuestra(Home.iconoLibroReclamacion)&&utilDef.seMuestra(Home.iconoCOAtlantic2)
                        &&utilDef.seMuestra(Home.iconoAPAtlantic)&&utilDef.seMuestra(Home.footerAtlanticDerechosReservados)
                ){
                    System.out.println("Todos los Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                break;
            case "HomeMaquinasNL":
                utilDef.HacerScroll(Home.txtQuienesSomos);
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandom)&&utilDef.seMuestra(Home.txtcentrodeayuda)
                        &&utilDef.seMuestra(Home.iconoLibroReclamacion)&&utilDef.seMuestra(Home.iconoCOAtlantic2)
                        &&utilDef.seMuestra(Home.iconoAPAtlantic)&&utilDef.seMuestra(Home.footerAtlanticDerechosReservados)
                ){
                    System.out.println("Todos los Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                if (utilDef.seMuestra(Home.iconoKashio)&& utilDef.seMuestra(Home.iconoVisa)
                        &&utilDef.seMuestra(Home.iconoMasterCard)&&utilDef.seMuestra(Home.iconoInterbank)
                        && utilDef.seMuestra(Home.iconoSafetyPay)&& utilDef.seMuestra(Home.iconoPagoEfectivo)
                        &&utilDef.seMuestra(Home.iconoYape)&&utilDef.seMuestra(Home.iconoPlin)){
                    System.out.println("Todos los Iconos de pago estan correctos");
                }else {
                    Assert.fail("Los iconos de pago no se visualizan correctamente");
                }
                break;
            case "HomeMesasNL":
                utilDef.HacerScroll(Home.txtQuienesSomos);
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandom)&&utilDef.seMuestra(Home.txtcentrodeayuda)
                        &&utilDef.seMuestra(Home.iconoLibroReclamacion)&&utilDef.seMuestra(Home.iconoCOAtlantic2)
                        &&utilDef.seMuestra(Home.iconoAPAtlantic)&&utilDef.seMuestra(Home.footerAtlanticDerechosReservados)
                ){
                    System.out.println("Todos los Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                if (utilDef.seMuestra(Home.iconoKashio)&& utilDef.seMuestra(Home.iconoVisa)
                        &&utilDef.seMuestra(Home.iconoMasterCard)&&utilDef.seMuestra(Home.iconoInterbank)
                        && utilDef.seMuestra(Home.iconoSafetyPay)&& utilDef.seMuestra(Home.iconoPagoEfectivo)
                        &&utilDef.seMuestra(Home.iconoYape)&&utilDef.seMuestra(Home.iconoPlin)
                ){
                    System.out.println("Todos los Iconos de pago estan correctos");
                }else {
                    Assert.fail("Los iconos de pago no se visualizan correctamente");
                }
                break;
            case "FestivalSemana":
                utilDef.HacerScroll(Home.txtQuienesSomos);
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandomDelivery)&&utilDef.seMuestra(Home.txtcentrodeayuda)
                        &&utilDef.seMuestra(Home.iconoLibroReclamacion)&&utilDef.seMuestra(Home.iconoCOAtlantic2)
                        &&utilDef.seMuestra(Home.iconoAPAtlantic)&&utilDef.seMuestra(Home.footerAtlanticDerechosReservados)
                ){
                    System.out.println("Todos los Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                if (utilDef.seMuestra(Home.iconoKashio)&& utilDef.seMuestra(Home.iconoVisa)
                        &&utilDef.seMuestra(Home.iconoMasterCard)&&utilDef.seMuestra(Home.iconoInterbank)
                        && utilDef.seMuestra(Home.iconoSafetyPay)&& utilDef.seMuestra(Home.iconoPagoEfectivo)
                        &&utilDef.seMuestra(Home.iconoYape)&&utilDef.seMuestra(Home.iconoPlin)){
                    System.out.println("Todos los Iconos de pago estan correctos");
                }else {
                    Assert.fail("Los iconos de pago no se visualizan correctamente");
                }
                metodoDelivery();

                break;
            case "canjePuntos":
                utilDef.HacerScroll(Home.txtQuienesSomos);
                if (utilDef.seMuestra(Home.txtQuienesSomos)&& utilDef.seMuestra(Home.txtCasinoOnline)
                        &&utilDef.seMuestra(Home.txtBlogApuesta)&&utilDef.seMuestra(Home.txtterminos)
                        && utilDef.seMuestra(Home.txtprivacidad)&& utilDef.seMuestra(Home.txtcookies)
                        &&utilDef.seMuestra(Home.txtreglas)&&utilDef.seMuestra(Home.txtchatenlinea)
                        &&utilDef.seMuestra(Home.IconosRandomDelivery)&&utilDef.seMuestra(Home.txtcentrodeayuda)
                        &&utilDef.seMuestra(Home.iconoLibroReclamacion)&&utilDef.seMuestra(Home.iconoCOAtlantic2)
                        &&utilDef.seMuestra(Home.iconoAPAtlantic)&&utilDef.seMuestra(Home.footerAtlanticDerechosReservados)
                ){
                    System.out.println("Todos los Iconos de footer estan correctos");
                }else {
                    Assert.fail("Los iconos de footer no se visualizan correctamente");
                }
                if (utilDef.seMuestra(Home.iconoKashio)&& utilDef.seMuestra(Home.iconoVisa)
                        &&utilDef.seMuestra(Home.iconoMasterCard)&&utilDef.seMuestra(Home.iconoInterbank)
                        && utilDef.seMuestra(Home.iconoSafetyPay)&& utilDef.seMuestra(Home.iconoPagoEfectivo)
                        &&utilDef.seMuestra(Home.iconoYape)&&utilDef.seMuestra(Home.iconoPlin)){
                    System.out.println("Todos los Iconos de pago estan correctos");
                }else {
                    Assert.fail("Los iconos de pago no se visualizan correctamente");
                }
                break;
        }
    }
    public void metodoDelivery(){
        utilDef.HacerScroll(Home.txtcontenidoDelivery);
        utilDef.esperarSegundos(2);
        pageObjectUtil.seleniumClick(Home.btnCanjearDelivery,0);
        pageObjectUtil.seleniumClick(Home.btnAgregarDireccion,0);
        pageObjectUtil.seleniumEscribir(Home.txtDirrecion, "PRUEBA");
        pageObjectUtil.seleniumEscribir(Home.txtReferencia, "PRUEBATXT");
        pageObjectUtil.seleniumEscribir(Home.txtNombreDireccion, "NOMBREPRUEA");
        pageObjectUtil.seleniumEscribir(Home.txtObservacion, "PRUEBA");
        utilDef.esperarSegundos(5);
        utilDef.HacerScroll("//label[contains(text(),'Observaciones de entrega')]");
        utilDef.esperarSegundos(5);
        utilDef.HacerScroll(Home.btnAgregarDirrecionEnvio);
        pageObjectUtil.seleniumClick(Home.btnAgregarDirrecionEnvio,0);
        utilDef.seMuestra(Home.txtDirrecionAgregada);
        pageObjectUtil.seleniumClick(Home.btnContinuar,0);
        utilDef.esperarSegundos(5);
        pageObjectUtil.seleccionarCombo(getDriver(),"opDia","Sábado");
        pageObjectUtil.seleccionarComboPosicion(getDriver(),"opPlato",1);
        pageObjectUtil.seleccionarComboPosicion(getDriver(),"opBebida",2);
        utilDef.seMuestra(Home.btnCanjear);
    }
    public void metodoObtenerCardsActuales(){
        try {
            List<WebElement> cards = Serenity.getDriver().findElements(By.cssSelector("div[id^='home-trx-card_promociones-']"));

            List<String> classesFound = new ArrayList<>();

            // Añadir las clases encontradas al conjunto
            for (WebElement card : cards) {
                String cardClass = card.getAttribute("id");
                classesFound.add(cardClass);
            }

            List<String> allClasses = new ArrayList<>();

            allClasses.add("home-trx-card_promociones-1");
            allClasses.add("home-trx-card_promociones-2");
            allClasses.add("home-trx-card_promociones-3");
            allClasses.add("home-trx-card_promociones-4");
            allClasses.add("home-trx-card_promociones-5");
            allClasses.add("home-trx-card_promociones-6");
            allClasses.add("home-trx-card_promociones-9");
            allClasses.add("home-trx-card_promociones-10");
            allClasses.add("home-trx-card_promociones-11");
            allClasses.add("home-trx-card_promociones-13");

            // Determinar las clases faltantes
            List<String> missingClasses = new ArrayList<>();
            for (String classId : allClasses) {
                if (!classesFound.contains(classId)) {
                    missingClasses.add(classId);
                }
            }
            System.out.println("Clases encontradas: " + classesFound);
            pageObjectUtil.seleniumClick("(//div[contains(text(),'Todos')])[2]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='torneo']",0);
            for (String clase : classesFound) {
                if (clase.contains("home-trx-card_promociones-4")|| clase.contains("home-trx-card_promociones-5")
                        || clase.contains("home-trx-card_promociones-6")|| clase.contains("home-trx-card_promociones-11")) {
                    utilDef.seMuestra("//div[contains(@id,'"+clase+"')]");
                }
            }
            pageObjectUtil.seleniumClick("//div[contains(text(),'Torneos')]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='todos']",0);
            pageObjectUtil.seleniumClick("(//div[contains(text(),'Todos')])[2]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='sorteo']",0);
            for (String clase : classesFound) {
                if (clase.equals("home-trx-card_promociones-1")|| clase.contains("home-trx-card_promociones-2")
                        || clase.equals("home-trx-card_promociones-3")) {
                    utilDef.seMuestra("//div[contains(@id,'"+clase+"')]");
                }
            }
            pageObjectUtil.seleniumClick("//div[contains(text(),'Sorteos')]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='todos']",0);
            pageObjectUtil.seleniumClick("(//div[contains(text(),'Todos')])[2]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='casino']",0);
            for (String clase : classesFound) {
                if (clase.equals("home-trx-card_promociones-1")|| clase.contains("home-trx-card_promociones-2")
                        || clase.equals("home-trx-card_promociones-3")|| clase.contains("home-trx-card_promociones-4")
                        || clase.contains("home-trx-card_promociones-5")|| clase.contains("home-trx-card_promociones-6")) {
                    utilDef.seMuestra("//div[contains(@id,'"+clase+"')]");
                }
            }
            pageObjectUtil.seleniumClick("//div[contains(text(),'Casino')]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='todos']",0);
            pageObjectUtil.seleniumClick("(//div[contains(text(),'Todos')])[2]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='delivery']",0);
            for (String clase : classesFound) {
                if (clase.contains("home-trx-card_promociones-13")) {

                    utilDef.seMuestra("//div[contains(@id,'"+clase+"')]");
                }
            }
            pageObjectUtil.seleniumClick("//div[contains(text(),'Delivery')]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='todos']",0);
            pageObjectUtil.seleniumClick("(//div[contains(text(),'Todos')])[2]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='sports']",0);
            for (String clase : classesFound) {
                if (clase.contains("home-trx-card_promociones-10")|| clase.contains("home-trx-card_promociones-11")) {

                    utilDef.seMuestra("//div[contains(@id,'"+clase+"')]");
                }
            }
            pageObjectUtil.seleniumClick("//div[contains(text(),'Sport')]",0);
            pageObjectUtil.seleniumClick("//li[@data-value='todos']",0);
            pageObjectUtil.seleniumClick(Promociones.btnNuevo,0);
            //ir a nuevo y verificar con la clase for
            for (String missingClass : missingClasses) {
                String nuevoValor = missingClass.replace("promociones", "nuevo");
                utilDef.seMuestra("//div[contains(@id,'"+nuevoValor+"')]");
            }
            pageObjectUtil.seleniumClick(Promociones.btnResultados,0);
            //ir a nuevo y verificar con la clase for
            for (String clase : classesFound) {
                if (clase.contains("home-trx-card_promociones-13")) {
                    String nuevoValor = clase.replace("promociones", "resultados");
                    utilDef.seMuestra("//div[contains(@id,'"+nuevoValor+"')]");
                }
            }

        } catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void ClickMaquina(){
        utilDef.esperarSegundos(5);
        pageObjectUtil.seleniumClick(Home.CuadroJuego,0);
        pageObjectUtil.seleniumClick(Home.JugarBotonJuego,0);
        utilDef.esperarSegundos(10);
    }
    public void AbriApiJuego(){
        String LinkApi = pageObjectUtil.GuardarSource(Home.ApiJuego);
        System.out.println("Link de api : "+ LinkApi);
        getDriver().get(LinkApi);
        utilDef.esperarSegundos(10);
    }

    public void clickIconoDatosPersonales(){
        pageObjectUtil.seleniumClick(Home.IconoDatosPersonales,0);
    }
    public void clickPerfil(){
        pageObjectUtil.seleniumClick(Home.btnPerfil,0);
    }
    public void clickBotonVerificarIdentidad(){
        pageObjectUtil.seleniumClick(Home.btnVerificarIdentidad,0);
    }
    public void visualizarAgregarDocumento(){
        utilDef.seMuestra(Home.btnAgregarDocumento);
    }
    public void visualizarAgregarCuenta(){
        utilDef.seMuestra(Home.btnAgregarCuenta);
    }
    public void visualizarValidarNumero(){
        utilDef.seMuestra(Home.btnValidarNumero);
    }
    public void clickBotonAgregarDocumento(){
        pageObjectUtil.seleniumClick(Home.btnAgregarDocumento,0);
    }
    public void agregarImagenBotonAgregarfrontal(){
        utilDef.cargarImagenFile(Home.inputAgregarDniFrontal,"src/test/resources/img/reybob.jpg");
    }
    public void agregarImagenBotonAgregarPosterior(){
        utilDef.cargarImagenFile(Home.inputAgregarDniPosterior,"src/test/resources/img/reybob.jpg");

    }
    public void agregarImagenBotonAgregarBancario(){
        pageObjectUtil.seleniumClick(Home.btnCuentaBancaria,0);
        utilDef.cargarImagenFile(Home.inputAgregarEstadoBancario,"src/test/resources/img/reybob.jpg");

    }
    public void visualizarBotonEnviar(){
        utilDef.seMuestra(Home.btnEnviar);
    }
    public void clickBotonRetirar(){
        pageObjectUtil.seleniumClick(Home.btnRetirar,0);
    }
    public void clickBotonTransferencia(){
        pageObjectUtil.seleniumClick(Home.btnTransferenciaBancaria,0);
    }
    public void ingresamosMonto(String monto){
        pageObjectUtil.seleniumEscribir(Home.txtIngresarMonto,monto);
    }
    public void visualizarBotonContinuar(){
        utilDef.seMuestra(Home.btnContinuar2);
    }
}

