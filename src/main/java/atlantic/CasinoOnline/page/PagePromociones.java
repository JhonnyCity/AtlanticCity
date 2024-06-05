package atlantic.CasinoOnline.page;

import atlantic.CasinoOnline.xpath.XpathDepositoTarjeta;
import atlantic.CasinoOnline.xpath.XpathFront;
import atlantic.CasinoOnline.xpath.XpathPromociones;
import atlantic.util.GuardadoDatos;
import atlantic.util.PageObjectUtil;
import atlantic.util.UtilDef;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.json.JSONObject;
import org.junit.Assert;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import static org.junit.Assert.assertEquals;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class PagePromociones extends PageObject {

    protected XpathPromociones Promociones = XpathPromociones.getInstancia();
    protected XpathFront Front = XpathFront.getInstancia();
    protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();

    UtilDef utilDef = new UtilDef();

    public void ClickPromociones() {
        utilDef.esperar_visibilidad_elemento(20,Promociones.BarrasMenu);
       try {
           pageObjectUtil.seleniumClick(Promociones.BarrasMenu, 0);
           pageObjectUtil.seleniumClick(Promociones.BtnPromociones, 0);
       }catch (Exception ex){
           pageObjectUtil.seleniumClick(Promociones.BarrasMenu, 0);
           pageObjectUtil.seleniumClick(Promociones.BtnPromociones, 0);
       }
    }
    public void Limpiezatotal(String nombreArchivo){
        File carpeta = new File(nombreArchivo);

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles((dir, nombre) -> nombre.toLowerCase().endsWith(".json"));

            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile()) {
                        if (archivo.delete()) {
                            System.out.println("Archivo JSON \"" + archivo.getName() + "\" eliminado correctamente.");
                        } else {
                            System.out.println("No se pudo eliminar el archivo JSON \"" + archivo.getName() + "\".");
                        }
                    }
                }
            } else {
                System.out.println("No hay archivos JSON en la carpeta especificada.");
            }
        } else {
            System.out.println("La carpeta especificada no existe.");
        }
    }

    public void eliminarJson(){
        String Online = "json/CasinoOnline";
        String CRM = "json/CRMCloud";
        String WebSol = "json/WebSol";

        Limpiezatotal(Online);
        Limpiezatotal(CRM);
        Limpiezatotal(WebSol);
    }
    public void ClickPromocion(String nombrePromo) {

        String xpath = "//strong[contains(text(),'" + nombrePromo + "')]";
        utilDef.esperar_visibilidad_elemento(30,xpath);
        pageObjectUtil.seleniumClick(xpath, 0);
    }

    public void ClickAvance() {
        try {
            pageObjectUtil.seleniumClick(Promociones.BtnAvance, 0);
        }catch (Exception ex){
            pageObjectUtil.seleniumClick(Promociones.BtnAvance2, 0);
        }
    }
    public String validarPremioPuesto(String puesto, String premio) {
        String xpathCopa = "//div[contains(@style, 'background-image: url') and contains(@style, 'trophy-" + puesto + ".svg')]";
        utilDef.esperar_visibilidad_elemento(10,xpathCopa);
        System.out.println("Se visualiza la copa para el puesto :" + puesto);

        String xpathPremio = "//strong[text()='" + premio + "']";
        String textoPremio = pageObjectUtil.obtenerTexto(xpathPremio);
        System.out.println("Premio : " + textoPremio);
        String MontoPEN = utilDef.concatenarSimboloMoneda2(premio, "PEN");
        System.out.println("MONTO PEN : " + MontoPEN);
        assertEquals(MontoPEN, textoPremio);
        return textoPremio;
    }

    public void compararPremio(String premio) {
        utilDef.esperar_visibilidad_elemento(10,Promociones.txtPremio);
        String textoPremio = pageObjectUtil.obtenerTexto(Promociones.txtPremio);
        System.out.println("Premio es : " + textoPremio);
        assertEquals(premio, textoPremio);
    }

    public void compararTextoFecha(String fecha) {
        String textoFecha = pageObjectUtil.obtenerTexto(Promociones.txtFecha);
        System.out.println("Fechas : " + textoFecha);
        assertEquals(fecha, textoFecha);
    }

    public void compararValorMulti(String multi) {
        utilDef.esperarElemento(2, element(Promociones.txtBotonx5));
    }

    public void compararTextoParticular(String participar) {
        String textoParticipar = pageObjectUtil.obtenerTexto(Promociones.txtComoParticipar);
        System.out.println("Texto Participar : " + textoParticipar);
        assertEquals(participar, textoParticipar);
    }

    public void compararTextoCanje(String canje) {
        String textoCanje = pageObjectUtil.obtenerTexto(Promociones.txtCanje);
        System.out.println("Canje es : " + textoCanje);
        assertEquals(canje, textoCanje);
    }

    public void ingresarID(String idinvitado){
        utilDef.esperar_visibilidad_elemento(30, Promociones.BtnOjoAmarillo);
        pageObjectUtil.seleniumClick(Promociones.BtnOjoAmarillo,0);
        pageObjectUtil.seleniumEscribir(Promociones.txtIdInvitado,idinvitado);
    }
    public void seleccionar_Buscar(){
        pageObjectUtil.seleniumClick(Promociones.BtnActualizarOjo,0);
    }
    public void seleccionar_Canje(){
        pageObjectUtil.seleniumClick(Promociones.BtnCanje,0);
    }
    public String  existenPuntosSorteo(){
        String valor;
        if (PuntosActivos()) {
            utilDef.esperar_visibilidad_elemento(20,Promociones.txtmispuntos);
            valor = pageObjectUtil.obtenerTexto(Promociones.txtmispuntos);
            System.out.println("Mis puntos : " + valor);
        }else{
            //utilDef.esperar_visibilidad_elemento(5,Promociones.txtProntoSorteo);
            valor = "0";
            System.out.println("Mensaje" + valor);
        }
        return valor;
    }
    public String existenOpcionesporCanjear(){
        String valor;
        if (OpcionesCanjearActivo()){
            utilDef.esperar_visibilidad_elemento(20,Promociones.txtopcionesCanjear);
            valor = pageObjectUtil.obtenerTexto(Promociones.txtopcionesCanjear);
            System.out.println("Tus puntos "+valor);
        }else {
            //utilDef.esperar_visibilidad_elemento(5,Promociones.txtYaCanjeaste);
            valor = "0";
            System.out.println("Mensaje "+valor);
        }
        Pattern pattern = Pattern.compile("Equivalen a (\\d+) opciones");
        Matcher matcher = pattern.matcher(valor);
        if (matcher.find()) {
            valor = matcher.group(1);
        }

        return valor;
    }
    public String  existenOpcionesCanjeadas(){
        utilDef.esperar_visibilidad_elemento(20,Promociones.txtopcionesCanjeadas);
        String valor = pageObjectUtil.obtenerTexto(Promociones.txtopcionesCanjeadas);
        System.out.println("Opciones Canjeadas: " + valor);
        return valor;
    }
    public void GuardarSorteos(String promo){
        String puntos = existenPuntosSorteo();
        String OpcionesPorCanjear = existenOpcionesporCanjear();
        String OpcionesCanjeadas = existenOpcionesCanjeadas();
        GuardadoDatos.getInstancia().GuardarDatosOnline(promo,puntos,OpcionesPorCanjear,OpcionesCanjeadas);
    }
    public void ActivarPromo(){
        try {
            pageObjectUtil.sleep(10);
            pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[1]",0);
            pageObjectUtil.sleep(10);
            pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[1]",0);
            pageObjectUtil.sleep(10);
            pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[1]",0);
            pageObjectUtil.sleep(10);
            pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[1]",0);
            pageObjectUtil.sleep(10);
            pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[1]",0);
            pageObjectUtil.sleep(10);
        }catch (Exception ex){
            try {
                pageObjectUtil.sleep(10);
                pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[2]",0);
                pageObjectUtil.sleep(10);
                pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[2]",0);
                pageObjectUtil.sleep(10);
                pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[2]",0);
                pageObjectUtil.sleep(10);
                pageObjectUtil.seleniumClick("(//button[contains(text(),'Quiero participar')])[2]",0);
            }catch (Exception exs){

            }

        }
    }
    public boolean promocionActiva(){
        return utilDef.seMuestra(Promociones.txtPromocionActiva);
    }
    public boolean promocionActivaCuotas(){
        return utilDef.seMuestra(Promociones.txtActivastePromo);
    }
    public boolean DeliveryActivo(){
        return utilDef.seMuestra(Promociones.txtDeliveryActivo);
    }
    public boolean DeliveryActivoPuntosSuperados(){
        return utilDef.seMuestra(Promociones.txtDeliverySuperado);
    }
    public boolean promocionActivaWinners(){
        return utilDef.seMuestra(Promociones.txtActivastePromoWinners);
    }

    public boolean PuntosActivos(){
        return utilDef.seMuestra(Promociones.txtmispuntos);
    }
    public boolean OpcionesCanjearActivo(){
        return utilDef.seMuestra(Promociones.txtopcionesCanjear);
    }
    public String obtenerPuestoActualTorneo(){
        String valor;
        try {
            utilDef.esperar_visibilidad_elemento(10,Promociones.txtpuestoTorneo);
            valor = pageObjectUtil.obtenerTexto(Promociones.txtpuestoTorneo);
            System.out.println("Puesto Actual: " + valor);

        }catch (Exception ex){
            valor = pageObjectUtil.GuardarData(Promociones.imgpuestoTorneo);
            System.out.println("Puesto Actual: " + valor);
        }
        return valor;
    }
    public String obtenerPuestoActualWinner(){
        String valor;
        try {
            utilDef.esperar_visibilidad_elemento(10,Promociones.txtPuestoWinner);
            valor = pageObjectUtil.obtenerTexto(Promociones.txtPuestoWinner);
            System.out.println("Puesto Actual: " + valor);

        }catch (Exception ex){
            valor = pageObjectUtil.GuardarData(Promociones.imgpuestoWinner);
            System.out.println("Puesto Actual: " + valor);
        }
        return valor;
    }
    public String obtenerPuntosWinner(){
        String valor;
        utilDef.esperar_visibilidad_elemento(10,Promociones.txtPuntosWinner);
        valor = pageObjectUtil.obtenerTexto(Promociones.txtPuntosWinner);
        System.out.println("Puntos Actual: " + valor);
        return valor;
    }
    public String obtenerMontosWinner(){
        String valor;
        utilDef.esperar_visibilidad_elemento(10,Promociones.txtPremioWinner);
        valor = pageObjectUtil.obtenerTexto(Promociones.txtPremioWinner);
        System.out.println("Puntos Actual: " + valor);
        return valor;
    }
    public String obtenerPuntosActual(){
        utilDef.esperar_visibilidad_elemento(10,Promociones.txtpuntosTorneo);
        String valor = pageObjectUtil.obtenerTexto(Promociones.txtpuntosTorneo);
        System.out.println("Puntos Actuales: " + valor);
        return valor;
    }
    public String obtenerPremioActual(){
        utilDef.esperar_visibilidad_elemento(10,Promociones.txtpremioTorneo);
        String valor = pageObjectUtil.obtenerTexto(Promociones.txtpremioTorneo);
        System.out.println("Premio Actual: " + valor);
        return valor;
    }
    public void estadoAvanceTorneo(String promo){
        String Puesto = "0";
        String Puntos = "0";
        String Premio = "S/0";
        switch (promo){
            case "Winner de Winners":
                if (promocionActivaWinners()){
                    System.out.println("Promocion Activa pero sin puntos");
                }else {
                    Puesto = obtenerPuestoActualWinner();
                    Puntos = obtenerPuntosWinner();
                    Premio = obtenerMontosWinner();
                }break;

            case "Torneo de Cuotas":
                if (promocionActivaCuotas()){
                    System.out.println("Promocion Activa pero sin puntos");
                }else {
                    Puesto = obtenerPuestoActualTorneo();
                    Puntos = obtenerPuntosActual();
                    Premio = obtenerPremioActual();
                }
                break;
            case "Festival":
                if (DeliveryActivoPuntosSuperados()){
                    System.out.println("PUNTOS SUPERADOS");
                    Puntos = "POR PUNTOS";
                } else if (DeliveryActivo()) {
                    System.out.println("Faltan Puntos");
                    Puntos = "FALTAN";
                }
                else{
                    System.out.println("No se visualiza");
                    Puntos = "NULL";
                }
                GuardadoDatos.getInstancia().GuardarDatosDelivery(promo,Puntos);
                break;
            default:
                if (promocionActiva()){
                    System.out.println("Promocion Activa pero sin puntos");
                }else {
                    Puesto = obtenerPuestoActualTorneo();
                    Puntos = obtenerPuntosActual();
                    Premio = obtenerPremioActual();
                }
                break;
        }
        if (Puntos.equals("POR PUNTOS")){

        }else{
            GuardadoDatos.getInstancia().GuardarDatosOnline3(promo,Puesto,Puntos,Premio);
        }
    }
    public void redirrecionLinkPromo(String nombrePromocion){
        switch (nombrePromocion){
            case "Torneo de Mesas":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/promociones/torneo-mesas");
                  break;
            case "Megatorneo Atlantic":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/promociones/mega-torneo");
                   break;
            case "Top Atlantic":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/promociones/top-atlantic");
                   break;
            case "Winner de Winners":
                getDriver().get("https://www.casinoatlanticcity.com/apuestas-deportivas/promociones/winner-de-winners");
                   break;
            case "Atlantic Vip Royal":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/promociones/sorteo-vip-royal");
                break;
            case "Sorteo Estelar":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/promociones/sorteo-estelar");
                break;
            case "Sorteo de tus Sueños":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/promociones/sorteo-suenos");
                break;
            case "Torneo de Cuotas":
                getDriver().get("https://www.casinoatlanticcity.com/apuestas-deportivas/promociones/torneo-cuotas");
                break;
            case "Festival":
                getDriver().get("https://www.casinoatlanticcity.com/casino-online/promociones");
                break;
              }
    }

    public void ValidacionFechaCard(String promocion, String[] premios){
        String fechaPromocion ="";
        int fechaDiferencia =0;
        String fechaActual =utilDef.fechaActual();
        String Premio;
        String Puntos;
        String TextoCard;
        String posicion2;
        boolean verificacion=true;
        String[] valores;
        ValidarSeMuestrPromo(promocion);
        String fechaFormato = "";
        JSONObject datos = null;
        try {
            String Link = "textos";
            Link = "data/promociones/" + Link + ".json";
            String content = new String(Files.readAllBytes(Paths.get(Link)));
            datos = new JSONObject(content);
        }catch (Exception ex){
        }
        switch (promocion){
            case "Torneo de Mesas":
                valores = ValorFinalEspacio(Front.TorneoMesas);
                fechaPromocion = valores[0];
                fechaDiferencia = Integer.parseInt(valores[1]);
                fechaFormato = valores[2];
                Premio =pageObjectUtil.obtenerTexto(Front.PMesa);
                Assert.assertEquals(Premio,premios[1]);
                //Serenity.takeScreenshot();

                pageObjectUtil.seleniumClick(Front.CardMesas,0);
                TextoCard = pageObjectUtil.obtenerTexto(Front.TxtMesas);
                System.out.println(TextoCard);
                System.out.println(datos.getString("TextCardMesas"));
                System.out.println(fechaFormato);
                if (TextoCard.contains(datos.getString("TextCardMesas"))&& TextoCard.contains(fechaFormato))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }

                pageObjectUtil.seleniumClick(Front.VermasMesas,0);

                break;
            case "Torneo de Cuotas":

                valores = ValorFinalEspacio(Front.TorneoCuotas);
                fechaPromocion = valores[0];
                fechaDiferencia = Integer.parseInt(valores[1]);
                fechaFormato = valores[2];
                Premio =pageObjectUtil.obtenerTexto(Front.PCuota);
                Assert.assertEquals(Premio,premios[0]);
                //Serenity.takeScreenshot();
                pageObjectUtil.seleniumClick(Front.CardCuota,0);
                TextoCard = pageObjectUtil.obtenerTexto(Front.TxtCuota);
                if (TextoCard.contains(datos.getString("TextCardCuota"))&& TextoCard.contains(fechaFormato))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                pageObjectUtil.seleniumClick(Front.VermasCuota,0);
                break;
            case "Top Atlantic":

                valores = ValorFinalEspacio(Front.TopAtlantic);
                fechaPromocion = valores[0];
                fechaDiferencia = Integer.parseInt(valores[1]);
                fechaFormato = valores[2];
                Premio =pageObjectUtil.obtenerTexto(Front.PTop);
                System.out.println(premios[3]);
                Assert.assertEquals(Premio,premios[3]);
                //Serenity.takeScreenshot();
                pageObjectUtil.seleniumClick(Front.CardTop,0);
                 TextoCard = pageObjectUtil.obtenerTexto(Front.TxtTop);
                if (TextoCard.contains(datos.getString("TextCardTop"))&& TextoCard.contains(fechaFormato))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                pageObjectUtil.seleniumClick(Front.VermasTop,0);
                break;
            case "Winner de Winners":
                valores = ValorFinalEspacio(Front.Winner);
                fechaPromocion = valores[0];
                fechaDiferencia = Integer.parseInt(valores[1]);
                fechaFormato = valores[2];
                Premio =pageObjectUtil.obtenerTexto(Front.PWinner);
                System.out.println(premios[11]);
                Assert.assertEquals(Premio,premios[11]);
                //Serenity.takeScreenshot();
                pageObjectUtil.seleniumClick(Front.CardWinner,0);
                TextoCard = pageObjectUtil.obtenerTexto(Front.TxtWinner);
                if (TextoCard.contains(datos.getString("TextCardWinner")))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                pageObjectUtil.seleniumClick(Front.VermasWinner,0);
                break;
            case "Megatorneo Atlantic":
                    valores = ValorFinalEspacio(Front.TorneoMega);
                    fechaPromocion = valores[0];
                    fechaDiferencia = Integer.parseInt(valores[1]);
                    fechaFormato = valores[2];
                Premio =pageObjectUtil.obtenerTexto(Front.PMega);
                System.out.println(premios[2]);
                Assert.assertEquals(Premio,premios[2]);
                //Serenity.takeScreenshot();
                pageObjectUtil.seleniumClick(Front.CardMega,0);
                TextoCard = pageObjectUtil.obtenerTexto(Front.TxtMega);
                if (TextoCard.contains(datos.getString("TextCardMega"))&& TextoCard.contains(fechaFormato))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                pageObjectUtil.seleniumClick(Front.VermasMega,0);
                break;
            case "Atlantic Vip Royal":
                    valores = ValorFinalEspacio(Front.Sorteovip);
                    fechaPromocion = valores[0];
                    fechaDiferencia = Integer.parseInt(valores[1]);
                    fechaFormato = valores[2];

                try {
                    Premio =pageObjectUtil.obtenerTexto(Front.PVip);
                    Assert.assertEquals(Premio,premios[4]);
                }catch (Exception ex){

                }
                Puntos =pageObjectUtil.obtenerTexto(Front.PuntosVip);
                System.out.println(premios[4]);
                Assert.assertEquals(Puntos,premios[5]);
                //Serenity.takeScreenshot();
                pageObjectUtil.seleniumClick(Front.CardVip,0);
                TextoCard = pageObjectUtil.obtenerTexto(Front.TxtVip);
                if (TextoCard.contains(datos.getString("TextCardVip")))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                pageObjectUtil.seleniumClick(Front.VermasVip,0);
                break;
            case "Sorteo Estelar":
                    valores = ValorFinalEspacio(Front.SorteoEstelar);
                    fechaPromocion = valores[0];
                    fechaDiferencia = Integer.parseInt(valores[1]);
                    fechaFormato = valores[2];
                //CORREGIR CUANDO APAREZCA LOS PUNTOS
                Premio =pageObjectUtil.obtenerTexto(Front.PEstelar);
                Puntos =pageObjectUtil.obtenerTexto(Front.PuntosEstelar);
                System.out.println(premios[6]);
                Assert.assertEquals(Premio,premios[6]);
                Assert.assertEquals(Puntos,premios[7]);
                //Serenity.takeScreenshot();
                pageObjectUtil.seleniumClick(Front.CardEstelar,0);
                TextoCard = pageObjectUtil.obtenerTexto(Front.TxtEstelar);
                if (TextoCard.contains(datos.getString("TextCardEstelar")))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                pageObjectUtil.seleniumClick(Front.VermasEstelar,0);

                break;
            case "Sorteo de tus Sueños":
                    valores = ValorFinalEspacio(Front.SorteoSueños);
                    fechaPromocion = valores[0];
                    fechaDiferencia = Integer.parseInt(valores[1]);
                    fechaFormato = valores[2];
                //AÑADIR VALIDACION DE CUANDO APARECE EL BOTON
                Premio =pageObjectUtil.obtenerTexto(Front.PSueños);
                Puntos =pageObjectUtil.obtenerTexto(Front.PuntosSueños);
                System.out.println(premios[8]);
                Assert.assertEquals(Premio,premios[8]);
                Assert.assertEquals(Puntos,premios[9]);
                //Serenity.takeScreenshot();
                pageObjectUtil.seleniumClick(Front.CardSueños,0);
                TextoCard = pageObjectUtil.obtenerTexto(Front.TxtSueños);
                if (TextoCard.contains(datos.getString("TextCardSueños"))&& TextoCard.contains(fechaFormato))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                pageObjectUtil.seleniumClick(Front.VermasSueños,0);
                break;
            case "Delivery":
                fechaPromocion = pageObjectUtil.obtenerTexto(Front.Delivery);
                Premio =pageObjectUtil.obtenerTexto(Front.PDelivery);
                System.out.println(premios[10]);
                Assert.assertEquals(Premio,premios[10]);
                //Serenity.takeScreenshot();
                pageObjectUtil.seleniumClick(Front.CardDelivery,0);
                TextoCard = pageObjectUtil.obtenerTexto(Front.Delivery);
                if (TextoCard.contains(datos.getString("TextCardDelivery")))
                {
                    System.out.println("Textos correctos");
                } else {
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                pageObjectUtil.seleniumClick(Front.VermasDelivery,0);
                break;
        }
        System.out.println("FECHA ACTUAL: " + fechaActual);
        System.out.println("FECHA SORTEO: " + fechaPromocion);
        System.out.println("FECHA SORTEO: " + fechaFormato);

        System.out.println("Diferencia entre actual y sorteo : "+fechaDiferencia);

        if (fechaDiferencia <= 15) {
            System.out.println("La fecha del sorteo no es mayor a 7 días de la fecha actual.");
            verificacion=true;
        } else {
            System.out.println("La fecha del sorteo es mayor a 7 días de la fecha actual.");
            verificacion=false;
        }
        ResultadoTrue(verificacion);

        ValidacionCard(promocion,fechaFormato);
        //ACA PONER LA FUNCION DE ABAJO Y QUE RECIBA LA FECHA EN EL FORMATO CORRESPONDIENTE
    }

    public void ValidacionCard(String promocion,String fechaFormato){
        String Link;
        JSONObject datos;
        String content;
        String Premio;
        String Premioxpath;
        String ComoParticipar2;
        String ComoParticipar2xpath;
        String PeriodoAcumulacion;
        String PeriodoAcumulacion2;
        String PeriodoAcumulacion3;
        String PeriodoAcumulacion4;
        String PeriodoAcumulacionxpath;
        String JuegosParticipantes;
        String JuegosParticipantesxpath;
        String Exclusiones;
        String Exclusionesxpath;
        String CondicionJuegosParticipantes;
        String Condicionesxpath;
        String Resultados;
        String Resultadosxpath;
        String ComoParticiparCuota;
        String ComoParticiparSuperCuota;
        String ComoParticiparCuotaxpath;
        String PremioCuota;
        String PremioCuotaxpath;
        String PremioSuperCuota;
        String PremioSuperCuotaxpath;
        String CondicionFechaCuota;
        String CondicionFechaSuperCuota;
        String CondicionFechaCuotaxpath;
        String CondicionFechaSuperCuotaxpath;
        String puntos;
        String puntosxpath;
        String canje;
        String canjexpath;
        String resultado;
        System.out.println("FECHA SORTEO EN LA OTRA FUNCION: " + fechaFormato);
        if (fechaFormato != null && !fechaFormato.isEmpty()) {
            resultado = fechaFormato.substring(0, 1).toLowerCase() + fechaFormato.substring(1);
            System.out.println(resultado);
        } else {
            resultado = "";
            System.out.println("La cadena está vacía o es nula.");
        }

        switch (promocion) {
            case "Torneo de Mesas":
                try {
                    Link = "Mesas";
                    Link = "data/promocionesCard/" + Link + ".json";
                    content = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(content);

                    Premio = datos.getString("premio");
                    utilDef.seMuestra(Front.mesapremio);
                    Premioxpath = pageObjectUtil.obtenerTexto(Front.mesapremio);
                    System.out.println("Texto a comparar : "+Premioxpath);
                    if (Premioxpath.contains(Premio))
                    {
                        System.out.println("Premio Correcto");
                    } else {
                        Assert.fail("Premio Incorrecto");
                    }
                    ComoParticipar2 = datos.getString("ComoParticipar2");
                    ComoParticipar2xpath = pageObjectUtil.obtenerTexto(Front.mesaComoParticipar2);
                    System.out.println("Texto a comparar : "+ComoParticipar2xpath);
                    if (ComoParticipar2xpath.contains(ComoParticipar2))
                    {
                        System.out.println("Como participar Correcto");
                    } else {
                        Assert.fail("Como participar incorrecto");
                    }
                    //PeriodoAcumulacion = datos.getString("PeriodoAcumulacion2");
                    PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.mesaPeriodoAcumulacion);
                    System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                    if (PeriodoAcumulacionxpath.contains(fechaFormato))
                    {
                        System.out.println("Periodo Acumulacion Correcto");
                    } else {
                        Assert.fail("Periodo Acumulacion incorrecto");
                    }
                    JuegosParticipantes = datos.getString("JuegosParticipantes");
                    JuegosParticipantesxpath = pageObjectUtil.obtenerTexto(Front.mesaJuegosParticipantes);
                    System.out.println("Texto a comparar : "+JuegosParticipantesxpath);
                    if (JuegosParticipantesxpath.contains(JuegosParticipantes))
                    {
                        System.out.println("Juegos participantes Correcto");
                    } else {
                        Assert.fail("Juegos participantes incorrecto");
                    }
                    Exclusiones = datos.getString("Exclusiones");
                    Exclusionesxpath = pageObjectUtil.obtenerTexto(Front.mesaExclusiones);
                    System.out.println("Texto a comparar : "+Exclusionesxpath);
                    if (Exclusionesxpath.contains(Exclusiones))
                    {
                        System.out.println("Exclusiones Correcto");
                    } else {
                        Assert.fail("Exclusiones incorrecto");
                    }

                    pageObjectUtil.seleniumClick(Front.btnVerCondiciones,0);

                    CondicionJuegosParticipantes = datos.getString("CondicionJuegosParticipantes");
                    Condicionesxpath = pageObjectUtil.obtenerTexto(Front.mesaCondicionFechas);
                    System.out.println("Texto a comparar : "+Condicionesxpath);
                    if (Condicionesxpath.contains(CondicionJuegosParticipantes))
                    {
                        System.out.println("Condiciones,Juegos participantes Correcto");
                    } else {
                        Assert.fail("Condiciones,Juegos participantes incorrecto");
                    }
                    if (Condicionesxpath.contains(resultado))
                    {
                        System.out.println("Condiciones,fechas Correcto");
                    } else {
                        Assert.fail("Condiciones,fechas incorrecto");
                    }

                } catch (IOException | JSONException e) {
                     e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
            case "Torneo de Cuotas":
                try {
                    Link = "Cuota";
                    Link = "data/promocionesCard/" + Link + ".json";
                    content = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(content);

                    Premio = datos.getString("premio");
                    utilDef.seMuestra(Front.cuotaPremio);
                    Premioxpath = pageObjectUtil.obtenerTexto(Front.cuotaPremio);
                    System.out.println("Texto a comparar : "+Premioxpath);
                    if (Premioxpath.contains(Premio))
                    {
                        System.out.println("Premio Correcto");
                    } else {
                        Assert.fail("Premio Incorrecto");
                    }

                    pageObjectUtil.seleniumClick(Front.btnInformacion,0);

                    Resultados = datos.getString("Resultados");
                    Resultadosxpath = pageObjectUtil.obtenerTexto(Front.cuotaResultados);
                    System.out.println("Texto a comparar : "+Resultadosxpath);
                    if (Resultadosxpath.contains(Resultados))
                    {
                        System.out.println("Resultado Correcto");
                    } else {
                        Assert.fail("Resultado incorrecto");
                    }
                    PeriodoAcumulacion = datos.getString("PeriodoAcumulacion");
                    PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.cuotaPeriodoAcumulacion);
                    System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                    if (PeriodoAcumulacionxpath.contains(PeriodoAcumulacion))
                    {
                        System.out.println("Periodo Acumulacion Correcto");
                    } else {
                        Assert.fail("Periodo Acumulacion incorrecto");
                    }
                    ComoParticiparCuota = datos.getString("ComoParticiparCuota");
                    ComoParticiparSuperCuota = datos.getString("ComoParticiparSuperCuota");
                    ComoParticiparCuotaxpath = pageObjectUtil.obtenerTexto(Front.cuotaSuperCuota);
                    System.out.println("Texto a comparar : "+ComoParticiparCuotaxpath);
                    if (ComoParticiparCuotaxpath.contains(ComoParticiparCuota))
                    {
                        System.out.println("Juegos participantes Correcto");
                    } else {
                        Assert.fail("Juegos participantes incorrecto");
                    }
                    if (ComoParticiparCuotaxpath.contains(ComoParticiparSuperCuota))
                    {
                        System.out.println("Juegos participantes Correcto");
                    } else {
                        Assert.fail("Juegos participantes incorrecto");
                    }
                    PremioCuota = datos.getString("cuotaPremioCuota");
                    PremioCuotaxpath = pageObjectUtil.obtenerTexto(Front.cuotaPremioCuota);
                    System.out.println("Texto a comparar : "+PremioCuotaxpath);
                    if (PremioCuotaxpath.contains(PremioCuota))
                    {
                        System.out.println("Premio Cuota Correcto");
                    } else {
                        Assert.fail("Premio Cuota incorrecto");
                    }
                    PremioSuperCuota = datos.getString("cuotaPremioSuperCuota");
                    PremioSuperCuotaxpath = pageObjectUtil.obtenerTexto(Front.cuotaPremioSuperCuota);
                    System.out.println("Texto a comparar : "+PremioSuperCuotaxpath);
                    if (PremioSuperCuotaxpath.contains(PremioSuperCuota))
                    {
                        System.out.println("Premio Super Cuota Correcto");
                    } else {
                        Assert.fail("Premio Super Cuota incorrecto");
                    }

                    pageObjectUtil.seleniumClick(Front.btnVerCondiciones2,0);

                    CondicionFechaCuotaxpath = pageObjectUtil.obtenerTexto(Front.cuotaCondicionesFechas);
                    System.out.println("Texto a comparar : "+CondicionFechaCuotaxpath);
                    if (CondicionFechaCuotaxpath.contains(resultado))
                    {
                        System.out.println("Fecha Cuota Correcto");
                    } else {
                        Assert.fail("Fecha Cuota Cuota incorrecto");
                    }
                    CondicionFechaSuperCuotaxpath = pageObjectUtil.obtenerTexto(Front.SupercuotaCondicionesFechas);
                    System.out.println("Texto a comparar : "+CondicionFechaSuperCuotaxpath);
                    if (CondicionFechaSuperCuotaxpath.contains(resultado))
                    {
                        System.out.println("Fecha Super Cuota Correcto");
                    } else {
                        Assert.fail("Fecha Super Cuota incorrecto");
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
            case "Top Atlantic":
                try {
                    Link = "Top";
                    Link = "data/promocionesCard/" + Link + ".json";
                    content = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(content);

                    Premio = datos.getString("premio");
                    utilDef.seMuestra(Front.TopPremio);
                    Premioxpath = pageObjectUtil.obtenerTexto(Front.TopPremio);
                    System.out.println("Texto a comparar : "+Premioxpath);
                    if (Premioxpath.contains(Premio))
                    {
                        System.out.println("Premio Correcto");
                    } else {
                        Assert.fail("Premio Incorrecto");
                    }
                    ComoParticipar2 = datos.getString("ComoParticipar2");
                    ComoParticipar2xpath = pageObjectUtil.obtenerTexto(Front.TopComoParticipar2);
                    System.out.println("Texto a comparar : "+ComoParticipar2xpath);
                    if (ComoParticipar2xpath.contains(ComoParticipar2))
                    {
                        System.out.println("Como participar Correcto");
                    } else {
                        Assert.fail("Como participar incorrecto");
                    }
                    PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.TopAcumulacion);
                    System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                    if (PeriodoAcumulacionxpath.contains(fechaFormato))
                    {
                        System.out.println("Periodo Acumulacion Correcto");
                    } else {
                        Assert.fail("Periodo Acumulacion incorrecto");
                    }
                    Exclusiones = datos.getString("Exclusiones");
                    Exclusionesxpath = pageObjectUtil.obtenerTexto(Front.TopExclusiones);
                    System.out.println("Texto a comparar : "+Exclusionesxpath);
                    if (Exclusionesxpath.contains(Exclusiones))
                    {
                        System.out.println("Exclusiones Correcto");
                    } else {
                        Assert.fail("Exclusiones incorrecto");
                    }

                    pageObjectUtil.seleniumClick(Front.btnVerCondiciones,0);

                    CondicionJuegosParticipantes = datos.getString("CondicionExclusiones");
                    CondicionFechaCuotaxpath = pageObjectUtil.obtenerTexto(Front.TopCondicionesFechasAcumulacion);
                    System.out.println("Texto a comparar : "+CondicionFechaCuotaxpath);
                    if (CondicionFechaCuotaxpath.contains(resultado))
                    {
                        System.out.println("Fecha en Condiciones Correcto");
                    } else {
                        Assert.fail("Fecha en Condiciones incorrecto");
                    }
                    if (CondicionFechaCuotaxpath.contains(CondicionJuegosParticipantes))
                    {
                        System.out.println("Exclusiones en Condiciones Correcto");
                    } else {
                        Assert.fail("Exclusiones en Condiciones incorrecto");
                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
            case "Winner de Winners":
                try {
                    Link = "Winner";
                    Link = "data/promocionesCard/" + Link + ".json";
                    content = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(content);

                    pageObjectUtil.seleniumClick(Front.btnInformacion,0);

                    ComoParticipar2 = datos.getString("ComoParticipar2");
                    utilDef.seMuestra(Front.WinnerComoParticipar1);
                    ComoParticipar2xpath = pageObjectUtil.obtenerTexto(Front.WinnerComoParticipar1);
                    System.out.println("Texto a comparar : "+ComoParticipar2xpath);
                    if (ComoParticipar2xpath.contains(ComoParticipar2))
                    {
                        System.out.println("Como participar Correcto");
                    } else {
                        Assert.fail("Como participar incorrecto");
                    }
                    PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.WinnerPeriodoAcumulacion);
                    System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                    if (PeriodoAcumulacionxpath.contains(resultado))
                    {
                        System.out.println("Periodo Acumulacion Correcto");
                    } else {
                        Assert.fail("Periodo Acumulacion incorrecto");
                    }
                    JuegosParticipantes = datos.getString("ApuestasPermitidas");
                    JuegosParticipantesxpath = pageObjectUtil.obtenerTexto(Front.WinnerApuestasPermitidas);
                    System.out.println("Texto a comparar : "+JuegosParticipantesxpath);
                    if (JuegosParticipantesxpath.contains(JuegosParticipantes))
                    {
                        System.out.println("Juegos participantes Correcto");
                    } else {
                        Assert.fail("Juegos participantes incorrecto");
                    }
                    Exclusiones = datos.getString("Noparticipan");
                    Exclusionesxpath = pageObjectUtil.obtenerTexto(Front.WinnerNoParticipan);
                    System.out.println("Texto a comparar : "+Exclusionesxpath);
                    if (Exclusionesxpath.contains(Exclusiones))
                    {
                        System.out.println("Exclusiones Correcto");
                    } else {
                        Assert.fail("Exclusiones incorrecto");
                    }

                    pageObjectUtil.seleniumClick(Front.btnVerCondiciones2,0);

                    CondicionFechaCuota = datos.getString("CondicionPuntos");
                    CondicionFechaCuotaxpath = pageObjectUtil.obtenerTexto(Front.WinnerCondicionPuntos);
                    System.out.println("Texto a comparar : "+CondicionFechaCuotaxpath);
                    if (CondicionFechaCuotaxpath.contains(CondicionFechaCuota))
                    {
                        System.out.println("Condicion puntos Correcto");
                    }else
                    {
                        Assert.fail("Condicion puntos incorrecto");
                    }
                    if (CondicionFechaCuotaxpath.contains(resultado)) {
                        System.out.println("Periodo Acumulacion Correcto");}
                    else
                    {
                        Assert.fail("Periodo Acumulacion incorrecto");
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
            case "Megatorneo Atlantic":
                try {
                Link = "Mega";
                Link = "data/promocionesCard/" + Link + ".json";
                content = new String(Files.readAllBytes(Paths.get(Link)));
                datos = new JSONObject(content);

                Premio = datos.getString("premio");
                utilDef.seMuestra(Front.MegaPremio);
                Premioxpath = pageObjectUtil.obtenerTexto(Front.MegaPremio);
                System.out.println("Texto a comparar : "+Premioxpath);
                if (Premioxpath.contains(Premio))
                {
                    System.out.println("Premio Correcto");
                } else {
                    Assert.fail("Premio Incorrecto");
                }
                ComoParticipar2 = datos.getString("ComoParticipar2");
                ComoParticipar2xpath = pageObjectUtil.obtenerTexto(Front.MegaComoParticipar2);
                System.out.println("Texto a comparar : "+ComoParticipar2xpath);
                if (ComoParticipar2xpath.contains(ComoParticipar2))
                {
                    System.out.println("Como participar Correcto");
                } else {
                    Assert.fail("Como participar incorrecto");
                }
                PeriodoAcumulacion = datos.getString("PeriodoAcumulacion");
                PeriodoAcumulacion2 = datos.getString("PeriodoAcumulacion2");
                PeriodoAcumulacion3 = datos.getString("PeriodoAcumulacion3");
                PeriodoAcumulacion4 = datos.getString("PeriodoAcumulacion4");
                String PeriodoAcumulacion5 = datos.getString("PeriodoAcumulacion5");
                PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.MegaAcumulacion);
                System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                if (PeriodoAcumulacionxpath.contains(PeriodoAcumulacion)&& PeriodoAcumulacionxpath.contains(PeriodoAcumulacion2))
                {
                    System.out.println("Periodo Acumulacion Correcto");
                } else if (PeriodoAcumulacionxpath.contains(PeriodoAcumulacion3)&& PeriodoAcumulacionxpath.contains(PeriodoAcumulacion4)) {
                    System.out.println("Periodo Acumulacion Correcto");
                }else if (PeriodoAcumulacionxpath.contains(PeriodoAcumulacion3)&& PeriodoAcumulacionxpath.contains(PeriodoAcumulacion5)) {
                    System.out.println("Periodo Acumulacion Correcto");
                } else {
                    Assert.fail("Periodo Acumulacion incorrecto");
                }

                Exclusiones = datos.getString("Exclusiones");
                Exclusionesxpath = pageObjectUtil.obtenerTexto(Front.MegaExclusiones);
                System.out.println("Texto a comparar : "+Exclusionesxpath);
                if (Exclusionesxpath.contains(Exclusiones))
                {
                    System.out.println("Exclusiones Correcto");
                } else {
                    Assert.fail("Exclusiones incorrecto");
                }

                pageObjectUtil.seleniumClick(Front.btnVerCondiciones,0);

                Condicionesxpath = pageObjectUtil.obtenerTexto(Front.MegaCondicionesFechasAcumulacion);
                System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                if (Condicionesxpath.contains(PeriodoAcumulacion)&& Condicionesxpath.contains(PeriodoAcumulacion2))
                {
                    System.out.println("Condicion Fecha Correcto");
                } else if (Condicionesxpath.contains(PeriodoAcumulacion3)&& Condicionesxpath.contains(PeriodoAcumulacion4)) {
                    System.out.println("Condicion Fecha Correcto");
                } else if (Condicionesxpath.contains(PeriodoAcumulacion3)&& Condicionesxpath.contains(PeriodoAcumulacion5)) {
                    System.out.println("Condicion Fecha Correcto");
                }
                else {
                    Assert.fail("Condicion Fecha incorrecto");
                }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
            case "Atlantic Vip Royal":
                try {
                    Link = "vip";
                    Link = "data/promocionesCard/" + Link + ".json";
                    content = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(content);

                    Premio = datos.getString("premio");
                    utilDef.seMuestra(Front.VipPremio);
                    Premioxpath = pageObjectUtil.obtenerTexto(Front.VipPremio);
                    System.out.println("Texto a comparar : "+Premioxpath);
                    if (Premioxpath.contains(Premio))
                    {
                        System.out.println("Premio Correcto");
                    } else {
                        Assert.fail("Premio Incorrecto");
                    }
                    ComoParticipar2 = datos.getString("ComoParticipar2");
                    ComoParticipar2xpath = pageObjectUtil.obtenerTexto(Front.VipComoParticipar2);
                    System.out.println("Texto a comparar : "+ComoParticipar2xpath);
                    if (ComoParticipar2xpath.contains(ComoParticipar2))
                    {
                        System.out.println("Como participar Correcto");
                    } else {
                        Assert.fail("Como participar incorrecto");
                    }
                    puntos = datos.getString("AcumulaPuntos");
                    puntosxpath = pageObjectUtil.obtenerTexto(Front.VipPuntos);
                    System.out.println("Texto a comparar : "+puntosxpath);
                    if (puntosxpath.contains(puntos))
                    {
                        System.out.println("Puntos Correcto");
                    } else {
                        Assert.fail("Puntos incorrecto");
                    }
                    PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.VipAcumulacion);
                    System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                    if (PeriodoAcumulacionxpath.contains(resultado))
                    {
                        System.out.println("Periodo Acumulacion Correcto");
                    } else {
                        Assert.fail("Periodo Acumulacion incorrecto");
                    }

                    canje = datos.getString("canje");
                    canjexpath = pageObjectUtil.obtenerTexto(Front.VipCanje);
                    System.out.println("Texto a comparar : "+canjexpath);
                    if (canjexpath.contains(canje))
                    {
                        System.out.println("Canje Correcto");
                    } else {
                        Assert.fail("Canje incorrecto");
                    }
                    Exclusiones = datos.getString("Exclusiones");
                    Exclusionesxpath = pageObjectUtil.obtenerTexto(Front.VipExclusiones);
                    System.out.println("Texto a comparar : "+Exclusionesxpath);
                    if (Exclusionesxpath.contains(Exclusiones))
                    {
                        System.out.println("Exclusiones Correcto");
                    } else {
                        Assert.fail("Exclusiones incorrecto");
                    }

                    pageObjectUtil.seleniumClick(Front.btnVerCondiciones,0);

                    Condicionesxpath = pageObjectUtil.obtenerTexto(Front.VipCondicionesFechasAcumulacion);
                    System.out.println("Texto a comparar : "+Condicionesxpath);
                    if (Condicionesxpath.contains(resultado))
                    {
                        System.out.println("Condiciones,Juegos participantes Correcto");
                    } else {
                        Assert.fail("Condiciones,Juegos participantes incorrecto");
                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
            case "Sorteo Estelar":
                try {
                    Link = "estelar";
                    Link = "data/promocionesCard/" + Link + ".json";
                    content = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(content);

                    Premio = datos.getString("premio");
                    PremioCuota = datos.getString("premio2");
                    Premioxpath = "";
                    if(utilDef.seMuestra(Front.estelarPremio)){
                        Premioxpath = pageObjectUtil.obtenerTexto(Front.estelarPremio);
                    } else if (utilDef.seMuestra(Front.estelarPremio2)){
                        Premioxpath = pageObjectUtil.obtenerTexto(Front.estelarPremio2);
                    }

                    System.out.println("Texto a comparar : "+Premioxpath);
                    if (Premioxpath.contains(Premio))
                    {
                        System.out.println("Premio Correcto");
                    } else if (Premioxpath.contains(PremioCuota)) {
                        System.out.println("Premio Correcto");
                    } else {
                        Assert.fail("Premio Incorrecto");
                    }
                    ComoParticipar2 = datos.getString("ComoParticipar2");
                    ComoParticipar2xpath = pageObjectUtil.obtenerTexto(Front.estelaracumula);
                    System.out.println("Texto a comparar : "+ComoParticipar2xpath);
                    if (ComoParticipar2xpath.contains(ComoParticipar2))
                    {
                        System.out.println("Como participar Correcto");
                    } else {
                        Assert.fail("Como participar incorrecto");
                    }
                    PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.estelarPeriodo);
                    System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                    if (PeriodoAcumulacionxpath.contains(resultado))
                    {
                        System.out.println("Periodo Acumulacion Correcto");
                    } else {
                        Assert.fail("Periodo Acumulacion incorrecto");
                    }

                    canje = datos.getString("canje");
                    canjexpath = pageObjectUtil.obtenerTexto(Front.estelarCanje);
                    System.out.println("Texto a comparar : "+canjexpath);
                    if (canjexpath.contains(canje))
                    {
                        System.out.println("Canje Correcto");
                    } else {
                        Assert.fail("Canje incorrecto");
                    }
                    Exclusiones = datos.getString("Exclusiones");
                    Exclusionesxpath = pageObjectUtil.obtenerTexto(Front.estelarExclusiones);
                    System.out.println("Texto a comparar : "+Exclusionesxpath);
                    if (Exclusionesxpath.contains(Exclusiones))
                    {
                        System.out.println("Exclusiones Correcto");
                    } else {
                        Assert.fail("Exclusiones incorrecto");
                    }

                    pageObjectUtil.seleniumClick(Front.btnVerCondiciones,0);

                    Condicionesxpath = pageObjectUtil.obtenerTexto(Front.estelarCondicionesFechasAcumulacion);
                    System.out.println("Texto a comparar : "+Condicionesxpath);
                    if (Condicionesxpath.contains(resultado))
                    {
                        System.out.println("Condiciones,Juegos participantes Correcto");
                    } else {
                        Assert.fail("Condiciones,Juegos participantes incorrecto");
                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
            case "Sorteo de tus Sueños":
                try {
                    Link = "sueños";
                    Link = "data/promocionesCard/" + Link + ".json";
                    content = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(content);

                    Premio = datos.getString("premio");
                    utilDef.seMuestra(Front.SueñosPremio);
                    Premioxpath = pageObjectUtil.obtenerTexto(Front.SueñosPremio);
                    System.out.println("Texto a comparar : "+Premioxpath);
                    if (Premioxpath.contains(Premio))
                    {
                        System.out.println("Premio Correcto");
                    } else {
                        Assert.fail("Premio Incorrecto");
                    }
                    ComoParticipar2 = datos.getString("ComoParticipar2");
                    ComoParticipar2xpath = pageObjectUtil.obtenerTexto(Front.SueñoComoParticipar2);
                    System.out.println("Texto a comparar : "+ComoParticipar2xpath);
                    if (ComoParticipar2xpath.contains(ComoParticipar2))
                    {
                        System.out.println("Como participar Correcto");
                    } else {
                        Assert.fail("Como participar incorrecto");
                    }
                    puntos = datos.getString("AcumulaPuntos");
                    puntosxpath = pageObjectUtil.obtenerTexto(Front.SueñoPuntos);
                    System.out.println("Texto a comparar : "+puntosxpath);
                    if (puntosxpath.contains(puntos))
                    {
                        System.out.println("Puntos Correcto");
                    } else {
                        Assert.fail("Puntos incorrecto");
                    }
                    PeriodoAcumulacion = datos.getString("PeriodoAcumulacion");
                    PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.SueñoAcumulacion);
                    System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                    if (PeriodoAcumulacionxpath.contains(PeriodoAcumulacion))
                    {
                        System.out.println("Periodo Acumulacion Correcto");
                    } else {
                        Assert.fail("Periodo Acumulacion incorrecto");
                    }

                    canje = datos.getString("canje");
                    canjexpath = pageObjectUtil.obtenerTexto(Front.SueñoCanje);
                    System.out.println("Texto a comparar : "+canjexpath);
                    if (canjexpath.contains(canje))
                    {
                        System.out.println("Canje Correcto");
                    } else {
                        Assert.fail("Canje incorrecto");
                    }
                    Exclusiones = datos.getString("Exclusiones");
                    Exclusionesxpath = pageObjectUtil.obtenerTexto(Front.SueñoExclusiones);
                    System.out.println("Texto a comparar : "+Exclusionesxpath);
                    if (Exclusionesxpath.contains(Exclusiones))
                    {
                        System.out.println("Exclusiones Correcto");
                    } else {
                        Assert.fail("Exclusiones incorrecto");
                    }

                    pageObjectUtil.seleniumClick(Front.btnVerCondiciones,0);

                    Condicionesxpath = pageObjectUtil.obtenerTexto(Front.SueñoCondicionesFechasAcumulacion);
                    System.out.println("Texto a comparar : "+Condicionesxpath);
                    if (Condicionesxpath.contains(PeriodoAcumulacion))
                    {
                        System.out.println("Condiciones,Juegos participantes Correcto");
                    } else {
                        Assert.fail("Condiciones,Juegos participantes incorrecto");
                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
            case "Delivery":
                try {
                    Link = "delivery";
                    Link = "data/promocionesCard/" + Link + ".json";
                    content = new String(Files.readAllBytes(Paths.get(Link)));
                    datos = new JSONObject(content);

                    PeriodoAcumulacion = datos.getString("Periodo");
                    utilDef.seMuestra(Front.DeliveryPeriodo);
                    PeriodoAcumulacionxpath = pageObjectUtil.obtenerTexto(Front.DeliveryPeriodo);
                    System.out.println("Texto a comparar : "+PeriodoAcumulacionxpath);
                    if (PeriodoAcumulacionxpath.contains(PeriodoAcumulacion))
                    {
                        System.out.println("Fecha Correcto");
                    } else {
                        Assert.fail("Fecha Incorrecto");
                    }
                    puntos = datos.getString("puntos");
                    puntosxpath = pageObjectUtil.obtenerTexto(Front.DeliveryPuntos);
                    System.out.println("Texto a comparar : "+puntosxpath);
                    if (puntosxpath.contains(puntos))
                    {
                        System.out.println("Puntos Correcto");
                    } else {
                        Assert.fail("Puntos incorrecto");
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    Assert.fail("No se encontraron los textos correctos en la reversa de los card");
                }
                break;
        }
    }

    public String[] ValorFinalEspacio(String xpath){
        String valor = pageObjectUtil.obtenerTexto(xpath);
        int start = valor.indexOf(": ") + 2;
        // Encuentra la posición del primer espacio
        int end = valor.indexOf("/", start);
        String resultado = valor.substring(start, end);
        System.out.println(resultado);
        String fechaPromocion = utilDef.obtenerValorLuegoEspacioFinal(valor);
        String fechaDiferencia = utilDef.calcularDiferenciaFecha(fechaPromocion);
        return new String[]{fechaPromocion, fechaDiferencia,resultado};
    }

    public void ResultadoTrue(boolean estado){
        assertTrue(estado);
    }

    public void ValidacionFechaPromocion(String promocion){
        String avanceTorneo = "";
        String regex = "";
        Pattern patron = null;
        Matcher matcher = null;
        String fechaInicio = "";
        String fechaFin = "";
        switch (promocion) {
            case "Winner de Winners":
                utilDef.esperar_visibilidad_elemento(10,Promociones.btnInformacion);
                pageObjectUtil.seleniumClick(Promociones.btnInformacion,0);

                utilDef.esperar_visibilidad_elemento(10,Promociones.txtPeriodoWinnersWinners);
                avanceTorneo = pageObjectUtil.obtenerTexto(Promociones.txtPeriodoWinnersWinners);
                System.out.println("texto: " + avanceTorneo);
                regex = "\\b\\d{2}/\\d{2}\\b";

                patron = Pattern.compile(regex);
                matcher = patron.matcher(avanceTorneo);

                if (matcher.find()) {
                    fechaInicio = matcher.group();
                }
                if (matcher.find()) {
                    fechaFin = matcher.group();
                }

                System.out.println("Fecha de inicio: " + fechaInicio);
                System.out.println("Fecha de fin: " + fechaFin);
                ResultadoTrue(utilDef.VerificarIntervaloFecha(fechaInicio,fechaFin));

                break;
            case "Torneo de Cuotas":
                utilDef.esperar_visibilidad_elemento(10,Promociones.txtPeriodoTorneoCuotas);
                avanceTorneo = pageObjectUtil.obtenerTexto(Promociones.txtPeriodoTorneoCuotas);
                System.out.println("texto: " + avanceTorneo);
                regex = "\\b\\d{2}/\\d{2}\\b";

                patron = Pattern.compile(regex);
                matcher = patron.matcher(avanceTorneo);

                if (matcher.find()) {
                    fechaInicio = matcher.group();
                }
                if (matcher.find()) {
                    fechaFin = matcher.group();
                }

                System.out.println("Fecha de inicio: " + fechaInicio);
                System.out.println("Fecha de fin: " + fechaFin);
                ResultadoTrue(utilDef.VerificarIntervaloFecha(fechaInicio,fechaFin));

                break;
            default:
                utilDef.esperar_visibilidad_elemento(10,Promociones.lblPeriodoAcumulacion);
                pageObjectUtil.sleep(5);
                String valor = pageObjectUtil.obtenerTexto(Promociones.lblPeriodoAcumulacion);

                String FechaInicio = utilDef.fechaFormatoDiaMesMayuscula(valor);
                System.out.println("fecha Inicio Dia/Mes :  "+FechaInicio);
                String FechaFin = utilDef.fechaFormatoDiaMesMinuscula(valor);
                System.out.println("fecha Fin Dia/Mes :  "+FechaFin);
                ResultadoTrue(utilDef.VerificarIntervaloFecha(FechaInicio,FechaFin));
                break;
        }
    }
    public void ValidarSeMuestrPromo(String promocion){
       switch (promocion){
           case "Drops and Wins":
               utilDef.esperar_visibilidad_elemento(5,Promociones.txtPagoAnticipadoCard);
               assertTrue(utilDef.seMuestra(Promociones.txtPagoAnticipadoCard));
               break;
           default:
               String xpath = "//strong[contains(text(),'" + promocion + "')]";
               utilDef.esperar_visibilidad_elemento(30,xpath);
               assertTrue(utilDef.seMuestra(xpath));
       }
    }
    public void ValidarSeMuestrPromoNuevo(String promocion) {
        switch (promocion) {
            case "Pago Anticipado":
                utilDef.esperar_visibilidad_elemento(40, Promociones.imgDropAndWin);
                assertTrue(utilDef.seMuestra(Promociones.imgDropAndWin));
                break;

            case "Drops and Wins":

                utilDef.esperar_visibilidad_elemento(40,Promociones.txtPagoAnticipadoCard);
                assertTrue(utilDef.seMuestra(Promociones.txtPagoAnticipadoCard));
                break;

            default:
                assertTrue(utilDef.seMuestra(Promociones.imgDropAndWin));
                assertTrue(utilDef.seMuestra(Promociones.txtPagoAnticipadoCard));
                break;
        }
        assertFalse(utilDef.seMuestra("//strong[contains(text(),'neo')]"));
    }
    public void ClickBotonNuevo(){
        pageObjectUtil.seleniumClick(Promociones.btnNuevo,0);
    }
    public void ClickBotonResultado(){
        pageObjectUtil.seleniumClick(Promociones.btnResultados,0);
    }
    public void SeMuestraResultadosPromo(String promocion){
        String xpath = "//strong[contains(text(),'" + promocion + "')]";
        utilDef.esperar_visibilidad_elemento(40,xpath);
        assertTrue(utilDef.seMuestra(xpath));
    }
    public void ValidarSeMuestraBotonCanjear(){
        assertTrue(utilDef.seMuestra(Promociones.btnCajearOpciones));
    }
    public void seMuestraTextoCanjeDelivery(){
        assertTrue(utilDef.seMuestra(Promociones.txtYaPuedesCanjear));
    }
    public void seMuestraImgDelivery(){
        assertTrue(utilDef.seMuestra(Promociones.imgDelivery));
    }
    public void seMuestraBotonCanjear(){
        assertTrue(utilDef.seMuestra(Promociones.btnCanjear));
    }
}