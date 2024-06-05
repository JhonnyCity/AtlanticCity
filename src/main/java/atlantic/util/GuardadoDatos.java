package atlantic.util;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actions.Switch;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuardadoDatos extends PageObject {
    private static GuardadoDatos obj = null;
    private long wdwTimeOut = 5L;


    private WebDriver driver = getDriver();

    private GuardadoDatos() {
    }

    public static GuardadoDatos getInstancia() {
        instanciar();
        return obj;
    }

    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new GuardadoDatos();
        }
    }
    public void GuardarDatos1(String dato) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Festival", dato);
        String promo ="Festival";
        try (FileWriter file = new FileWriter("json/CRMCloud/" + promo + ".json")) {
            file.write(jsonObject.toString());
            System.out.println("Datos guardados correctamente en '" + promo + ".json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void GuardarDatosDelivery(String promo,String dato) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Festival", dato);

        try (FileWriter file = new FileWriter("json/CasinoOnline/"+promo+".json")) {
            file.write(jsonObject.toString());
            System.out.println("Datos guardados correctamente en '"+promo+".json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void GuardarDatos2(String promo,String dato,String dato2) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("monto", dato);
        jsonObject.put("posicion", dato2);

        try (FileWriter file = new FileWriter("json/CRMCloud/"+promo+".json")) {
            file.write(jsonObject.toString());
            System.out.println("Datos guardados correctamente en '"+promo+".json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void GuardarDatos3(String promo,String dato,String dato2,String dato3) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("monto", dato);
        jsonObject.put("posicion", dato2);
        jsonObject.put("puntos", dato3);

        try (FileWriter file = new FileWriter("json/CRMCloud/"+promo+".json")) {
            file.write(jsonObject.toString());
            System.out.println("Datos guardados correctamente en '"+promo+".json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void GuardarDatos4(String promo,String dato, String dato2,String dato3,String dato4) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("monto", dato);
        jsonObject.put("opcCanjeadas", dato2);
        jsonObject.put("opcPorCanjeadas", dato3);
        jsonObject.put("puntos", dato4);

        try (FileWriter file = new FileWriter("json/CRMCloud/"+promo+".json")) {
            file.write(jsonObject.toString());
            System.out.println("Datos guardados correctamente en '"+promo+".json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GuardarDatosOnline3(String promo,String dato,String dato2,String dato3) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("posicion", dato);
        jsonObject.put("puntos", dato2);
        jsonObject.put("monto", dato3);

        try (FileWriter file = new FileWriter("json/CasinoOnline/"+promo+".json")) {
            file.write(jsonObject.toString());
            System.out.println("Datos guardados correctamente en '"+promo+".json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void GuardarDatosOnline(String promo,String dato,String dato2,String dato3) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("puntos", dato);
        jsonObject.put("opcionesPorCanjear", dato2);
        jsonObject.put("opcionesCanjeadas", dato3);

        try (FileWriter file = new FileWriter("json/CasinoOnline/"+promo+".json")) {
            file.write(jsonObject.toString());
            System.out.println("Datos guardados correctamente en '"+promo+".json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void GuardarDatoWebSol(String promo,String dato) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("valor :", dato);

        try (FileWriter file = new FileWriter("json/WebSol/"+promo+".json")) {
            file.write(jsonObject.toString());
            System.out.println("Datos guardados correctamente en '"+promo+".json'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ExtraerPuntosWebsol(String promo) {
        //WEB SOL
        String Link;
        String Linkpuesto;
        String MontoWebSol;
        String PuestoWebSol;
        String OpcPorCanjearWebSol;
        //CRMCLOUD
        JSONObject datosJSON;
        String MontoCRM;
        String PuestoCRM;
        String PuntosCRM;
        String OpcPorCanjearCRM;
        String OpcCanjeadasCRM;
        //CASINO ONLINE
        String MontoOnline;
        String PuestoOnline;
        String PuntosOnline;
        String OpcPorCanjearOnline;
        String OpcCanjeadasOnline;
        //ESTADOS
        String estado1;
        String estado2;
        String estado3;
        //DATOS
        String Puntos = "PUNTOS";
        String MONTOS = "MONTOS";
        String PUESTO = "PUESTOS";
        String OpcPorCanjear = "OPCIONES POR CANJEAR";
        String OpcCanjeadas = "OPCIONES CANJEADAS";

        switch (promo) {
            case "Megatorneo":
                //WEBSOL - PUESTO Y MONTO GANADO
                Link = "MEGA TORNEO";
                Linkpuesto = "puesto MEGA TORNEO";
                Link = "json/WebSol/" + Link + ".json";
                MontoWebSol = ObtenerDatosWebsol(Link);
                System.out.println("monto WebSol: "+MontoWebSol);
                Link = "json/WebSol/" + Linkpuesto + ".json";
                PuestoWebSol = ObtenerDatosWebsol(Link);
                System.out.println("puesto WebSol: "+PuestoWebSol);

                //CRMCLOUD - PUESTO,PUNTOS Y MONTO GANADO
                Link = "Mega Torneo";
                Link = "json/CRMCloud/" + Link + ".json";
                datosJSON = ObtenerDatosCRM(Link);
                PuestoCRM = datosJSON.getString("posicion");
                MontoCRM = datosJSON.getString("monto");
                PuntosCRM = datosJSON.getString("puntos");
                System.out.println("puesto CRM: "+PuestoCRM);
                System.out.println("monto CRM: "+MontoCRM);
                System.out.println("puntos CRM: "+PuntosCRM);

                //CASINO ONLINE
                Link = "Megatorneo Atlantic";
                Link = "json/CasinoOnline/" + Link + ".json";
                datosJSON = ObtenerDatosCRM(Link);
                PuestoOnline = datosJSON.getString("posicion");
                MontoOnline = datosJSON.getString("monto");
                PuntosOnline = datosJSON.getString("puntos");
                System.out.println("puesto puesto: "+PuestoOnline);
                System.out.println("monto Online: "+MontoOnline);
                System.out.println("puntos Online: "+PuntosOnline);
                estado1 = ComparacionResultados(promo,PUESTO,PuestoOnline,PuestoCRM,PuestoWebSol);
                estado2 = ComparacionResultados(promo,MONTOS,MontoOnline,MontoCRM,MontoWebSol);
                estado3 = ComparacionResultados2(promo,Puntos,PuntosOnline,PuntosCRM);
                comparacionEstado(estado1,estado2,estado3);
                break;
            case "Atlantic Vip":
                //WEBSOL - PUESTO Y MONTO GANADO
                Link = "SORTEO VIP";
                Link = "json/WebSol/" + Link + ".json";
                OpcPorCanjearWebSol = ObtenerDatosWebsol(Link);
                System.out.println("Opciones por Canjear: "+OpcPorCanjearWebSol);

                //CRMCLOUD - PUESTO,PUNTOS Y MONTO GANADO
                Link = "Atlantic VIP";
                Link = "json/CRMCloud/" + Link + ".json";
                datosJSON = ObtenerDatosCRM2(Link);
                OpcPorCanjearCRM = datosJSON.getString("opcPorCanjeadas");
                MontoCRM = datosJSON.getString("monto");
                OpcCanjeadasCRM = datosJSON.getString("opcCanjeadas");
                PuntosCRM = datosJSON.getString("puntos");
                System.out.println("Opciones por Canjear: "+OpcPorCanjearCRM);
                System.out.println("monto Online: "+MontoCRM);
                System.out.println("puntos Online: "+PuntosCRM);
                System.out.println("Opciones Canjeadas: "+OpcCanjeadasCRM);

                //CASINO ONLINE
                Link = "Atlantic Vip Royal";
                Link = "json/CasinoOnline/" + Link + ".json";
                datosJSON = ObtenerDatosOnline(Link);
                OpcPorCanjearOnline = datosJSON.getString("opcionesPorCanjear");
                OpcCanjeadasOnline = datosJSON.getString("opcionesCanjeadas");
                PuntosOnline = datosJSON.getString("puntos");
                System.out.println("Opciones por Canjear: "+OpcPorCanjearOnline);
                System.out.println("puntos Online: "+PuntosOnline);
                System.out.println("Opciones Canjeadas: "+OpcCanjeadasOnline);
                estado1 = ComparacionResultados(promo,OpcPorCanjear,OpcPorCanjearWebSol,OpcPorCanjearOnline,OpcPorCanjearCRM);
                estado2 = ComparacionResultados2(promo,Puntos,PuntosCRM,PuntosOnline);
                estado3 = ComparacionResultados2(promo,OpcCanjeadas,OpcCanjeadasCRM,OpcCanjeadasOnline);
                comparacionEstado(estado1,estado2,estado3);
                break;
            case "Sorteo de tus Sueños":
                //WEBSOL - PUESTO Y MONTO GANADO
                Link = "SORTEO SUEÑOS";
                Link = "json/WebSol/" + Link + ".json";
                OpcPorCanjearWebSol = ObtenerDatosWebsol(Link);
                System.out.println("Opciones por Canjear: "+OpcPorCanjearWebSol);

                //CRMCLOUD - PUESTO,PUNTOS Y MONTO GANADO
                Link = "Sorteo de tus Sueños";
                Link = "json/CRMCloud/" + Link + ".json";
                datosJSON = ObtenerDatosCRM2(Link);
                OpcPorCanjearCRM = datosJSON.getString("opcPorCanjeadas");
                MontoCRM = datosJSON.getString("monto");
                OpcCanjeadasCRM = datosJSON.getString("opcCanjeadas");
                PuntosCRM = datosJSON.getString("puntos");
                System.out.println("Opciones por Canjear: "+OpcPorCanjearCRM);
                System.out.println("monto Online: "+MontoCRM);
                System.out.println("puntos Online: "+PuntosCRM);
                System.out.println("Opciones Canjeadas: "+OpcCanjeadasCRM);

                //CASINO ONLINE
                Link = "Sorteo de tus Sueños";
                Link = "json/CasinoOnline/" + Link + ".json";
                datosJSON = ObtenerDatosOnline(Link);
                OpcPorCanjearOnline = datosJSON.getString("opcionesPorCanjear");
                OpcCanjeadasOnline = datosJSON.getString("opcionesCanjeadas");
                PuntosOnline = datosJSON.getString("puntos");
                System.out.println("Opciones por Canjear: "+OpcPorCanjearOnline);
                System.out.println("puntos Online: "+PuntosOnline);
                System.out.println("Opciones Canjeadas: "+OpcCanjeadasOnline);
                estado1 = ComparacionResultados(promo,OpcPorCanjear,OpcPorCanjearWebSol,OpcPorCanjearOnline,OpcPorCanjearCRM);
                estado2 = ComparacionResultados2(promo,Puntos,PuntosCRM,PuntosOnline);
                estado3 = ComparacionResultados2(promo,OpcCanjeadas,OpcCanjeadasCRM,OpcCanjeadasOnline);
                comparacionEstado(estado1,estado2,estado3);
                break;
            case "Sorteo Estelar":
                //WEBSOL - PUESTO Y MONTO GANADO
                Link = "SORTEO ESTELAR";
                Link = "json/WebSol/" + Link + ".json";
                OpcPorCanjearWebSol = ObtenerDatosWebsol(Link);
                System.out.println("Opciones por Canjear: "+OpcPorCanjearWebSol);

                //CRMCLOUD - PUESTO,PUNTOS Y MONTO GANADO
                Link = "Sorteo estelar";
                Link = "json/CRMCloud/" + Link + ".json";
                datosJSON = ObtenerDatosCRM2(Link);
                OpcPorCanjearCRM = datosJSON.getString("opcPorCanjeadas");
                MontoCRM = datosJSON.getString("monto");
                OpcCanjeadasCRM = datosJSON.getString("opcCanjeadas");
                PuntosCRM = datosJSON.getString("puntos");
                System.out.println("Opciones por Canjear: "+OpcPorCanjearCRM);
                System.out.println("monto Online: "+MontoCRM);
                System.out.println("puntos Online: "+PuntosCRM);
                System.out.println("Opciones Canjeadas: "+OpcCanjeadasCRM);

                //CASINO ONLINE
                Link = "Sorteo Estelar";
                Link = "json/CasinoOnline/" + Link + ".json";
                datosJSON = ObtenerDatosOnline(Link);
                OpcPorCanjearOnline = datosJSON.getString("opcionesPorCanjear");
                OpcCanjeadasOnline = datosJSON.getString("opcionesCanjeadas");
                PuntosOnline = datosJSON.getString("puntos");
                System.out.println("Opciones por Canjear: "+OpcPorCanjearOnline);
                System.out.println("puntos Online: "+PuntosOnline);
                System.out.println("Opciones Canjeadas: "+OpcCanjeadasOnline);
                estado1 = ComparacionResultados(promo,OpcPorCanjear,OpcPorCanjearWebSol,OpcPorCanjearOnline,OpcPorCanjearCRM);
                estado2 = ComparacionResultados2(promo,Puntos,PuntosCRM,PuntosOnline);
                estado3 = ComparacionResultados2(promo,OpcCanjeadas,OpcCanjeadasCRM,OpcCanjeadasOnline);
                comparacionEstado(estado1,estado2,estado3);
                break;

            case "Top Atlantic":
                //WEBSOL - PUESTO Y MONTO GANADO
                Link = "TOP ATLANTIC";
                Linkpuesto = "Puesto TOP ATLANTIC";
                Link = "json/WebSol/" + Link + ".json";
                MontoWebSol = ObtenerDatosWebsol(Link);
                System.out.println("monto WebSol: "+MontoWebSol);
                Link = "json/WebSol/" + Linkpuesto + ".json";
                PuestoWebSol = ObtenerDatosWebsol(Link);
                System.out.println("puesto WebSol: "+PuestoWebSol);

                //CRMCLOUD - PUESTO,PUNTOS Y MONTO GANADO
                Link = "Top Atlantic";
                Link = "json/CRMCloud/" + Link + ".json";
                datosJSON = ObtenerDatosCRM(Link);
                PuestoCRM = datosJSON.getString("posicion");
                MontoCRM = datosJSON.getString("monto");
                PuntosCRM = datosJSON.getString("puntos");
                System.out.println("puesto CRM: "+PuestoCRM);
                System.out.println("monto CRM: "+MontoCRM);
                System.out.println("puntos CRM: "+PuntosCRM);

                //CASINO ONLINE
                Link = "Top Atlantic";
                Link = "json/CasinoOnline/" + Link + ".json";
                datosJSON = ObtenerDatosCRM(Link);
                PuestoOnline = datosJSON.getString("posicion");
                MontoOnline = datosJSON.getString("monto");
                PuntosOnline = datosJSON.getString("puntos");
                System.out.println("puesto Online: "+PuestoOnline);
                System.out.println("monto Online: "+MontoOnline);
                System.out.println("puntos Online: "+PuntosOnline);
                estado1 = ComparacionResultados(promo,PUESTO,PuestoOnline,PuestoCRM,PuestoWebSol);
                estado2 = ComparacionResultados(promo,MONTOS,MontoOnline,MontoCRM,MontoWebSol);
                estado3 = ComparacionResultados2(promo,Puntos,PuntosOnline,PuntosCRM);
                comparacionEstado(estado1,estado2,estado3);
                break;
            case "Torneo de Mesas":
                //CRMCLOUD - PUESTO,PUNTOS Y MONTO GANADO
                Link = "Torneo de Mesas";
                Link = "json/CRMCloud/" + Link + ".json";
                datosJSON = ObtenerDatosCRM(Link);
                PuestoCRM = datosJSON.getString("posicion");
                MontoCRM = datosJSON.getString("monto");
                PuntosCRM = datosJSON.getString("puntos");
                System.out.println("puesto CRM: "+PuestoCRM);
                System.out.println("monto CRM: "+MontoCRM);
                System.out.println("puntos CRM: "+PuntosCRM);

                //CASINO ONLINE
                Link = "Torneo de Mesas";
                Link = "json/CasinoOnline/" + Link + ".json";
                datosJSON = ObtenerDatosCRM(Link);
                PuestoOnline = datosJSON.getString("posicion");
                MontoOnline = datosJSON.getString("monto");
                PuntosOnline = datosJSON.getString("puntos");
                System.out.println("puesto Online: "+PuestoOnline);
                System.out.println("monto Online: "+MontoOnline);
                System.out.println("puntos Online: "+PuntosOnline);

                estado1 = ComparacionResultados2(promo,PUESTO,PuestoOnline,PuestoCRM);
                estado2 = ComparacionResultados2(promo,MONTOS,MontoOnline,MontoCRM);
                estado3 = ComparacionResultados2(promo,Puntos,PuntosOnline,PuntosCRM);
                comparacionEstado(estado1,estado2,estado3);
                break;
            case "Festival":
                //CRMCLOUD - PUESTO,PUNTOS Y MONTO GANADO
                Link = "Festival";
                Link = "json/CRMCloud/" + Link + ".json";
                PuntosCRM = ObtenerDatosDelivery(Link);
                System.out.println("puntos Delivery CRM: "+PuntosCRM);

                //CASINO ONLINE
                Link = "Festival";
                Link = "json/CasinoOnline/" + Link + ".json";
                PuntosOnline = ObtenerDatosDelivery(Link);
                System.out.println("puntos Delivery Online: "+PuntosOnline);

                estado1 = ComparacionResultados2(promo,"DELIVERY",PuntosCRM,PuntosOnline);
                assertEquals(estado1,"correcto");
                break;
            case "Winner de Winners":
                //CRMCLOUD - PUESTO,PUNTOS Y MONTO GANADO
                Link = "TORNEO WINNERS";
                Link = "json/CRMCloud/" + Link + ".json";
                datosJSON = ObtenerDatosCRM(Link);
                PuestoCRM = datosJSON.getString("posicion");
                MontoCRM = datosJSON.getString("monto");
                System.out.println("puesto CRM: "+PuestoCRM);
                System.out.println("monto CRM: "+MontoCRM);

                //CASINO ONLINE
                Link = "Winner de Winners";
                Link = "json/CasinoOnline/" + Link + ".json";
                datosJSON = ObtenerDatosCRM(Link);
                PuestoOnline = datosJSON.getString("posicion");
                MontoOnline = datosJSON.getString("monto");
                System.out.println("puesto Online: "+PuestoOnline);
                System.out.println("monto Online: "+MontoOnline);

                estado1 = ComparacionResultados2(promo,PUESTO,PuestoOnline,PuestoCRM);
                estado2 = ComparacionResultados2(promo,MONTOS,MontoOnline,MontoCRM);
                assertEquals(estado1,estado2);
                break;
            default:
                System.out.println("epale");
                break;
        }
    }
    public String ObtenerDatosWebsol(String link){
        String valor ;
        try {
            // Leer el contenido del archivo JSON como una cadena
            String content = new String(Files.readAllBytes(Paths.get(link)));

            JSONObject jsonObject = new JSONObject(content);

            // Extraer datos del objeto JSON
            valor = LimpiezaDatos(jsonObject.getString("valor :"));

        } catch (IOException e) {
            valor ="";
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (JSONException e) {
            valor ="";
            System.err.println("Error al analizar el JSON: " + e.getMessage());
        }
        return valor;
    }
    public String ObtenerDatosDelivery(String link){
        String valor ;
        try {
            // Leer el contenido del archivo JSON como una cadena
            String content = new String(Files.readAllBytes(Paths.get(link)));

            JSONObject jsonObject = new JSONObject(content);

            // Extraer datos del objeto JSON
            valor = LimpiezaDatos(jsonObject.getString("Festival"));

        } catch (IOException e) {
            valor ="";
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (JSONException e) {
            valor ="";
            System.err.println("Error al analizar el JSON: " + e.getMessage());
        }
        return valor;
    }
    public JSONObject ObtenerDatosCRM(String link){
        JSONObject datos = new JSONObject();
        try {
            String content = new String(Files.readAllBytes(Paths.get(link)));

            JSONObject jsonObject = new JSONObject(content);

            datos.put("posicion", LimpiezaDatos(jsonObject.getString("posicion")));
            datos.put("monto", LimpiezaDatos(jsonObject.getString("monto")));
            datos.put("puntos", LimpiezaDatos(jsonObject.getString("puntos")));

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("Error al analizar el JSON: " + e.getMessage());
        }
        return datos;
    }
    public JSONObject ObtenerDatosCRM2(String link){
        JSONObject datos = new JSONObject();
        try {
            String content = new String(Files.readAllBytes(Paths.get(link)));

            JSONObject jsonObject = new JSONObject(content);

            datos.put("monto", LimpiezaDatos(jsonObject.getString("monto")));
            datos.put("opcPorCanjeadas", LimpiezaDatos(jsonObject.getString("opcPorCanjeadas")));
            datos.put("opcCanjeadas", LimpiezaDatos(jsonObject.getString("opcCanjeadas")));
            datos.put("puntos", LimpiezaDatos(jsonObject.getString("puntos")));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("Error al analizar el JSON: " + e.getMessage());
        }
        return datos;
    }
    public JSONObject ObtenerDatosOnline(String link){
        JSONObject datos = new JSONObject();
        try {
            String content = new String(Files.readAllBytes(Paths.get(link)));

            JSONObject jsonObject = new JSONObject(content);

            datos.put("opcionesCanjeadas", LimpiezaDatos(jsonObject.getString("opcionesCanjeadas")));
            datos.put("opcionesPorCanjear", LimpiezaDatos(jsonObject.getString("opcionesPorCanjear")));
            datos.put("puntos", LimpiezaDatos(jsonObject.getString("puntos")));

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("Error al analizar el JSON: " + e.getMessage());
        }
        return datos;
    }
    public String LimpiezaDatos(String valor){
        valor = valor.replaceAll(",", "");
        valor = valor.replaceAll("S/. ", "");
        valor = valor.replaceAll("S/", "");
        valor = valor.replaceAll("canjear:", "");
        return valor;
    }
    public String ComparacionResultados(String promo,String etiqueta,String valor,String valor2,String valor3){
        String estado;
        if (valor.equals(valor2) && valor2.equals(valor3)) {
            estado = "correcto";
            System.out.println("---Comparacion---"+etiqueta);
            System.out.println("valor : "+valor);
            System.out.println("valor2 : "+valor2);
            System.out.println("valor3 : "+valor3);
            System.out.println("Los valores son iguales en la promo "+promo);
        }else{
            estado = "incorrecto";
            System.out.println("---Comparacion---"+etiqueta);
            System.out.println("valor : "+valor);
            System.out.println("valor2 : "+valor2);
            System.out.println("valor3 : "+valor3);
            System.out.println("Los valores son diferentes en la promo " +promo);
        }
        return estado;
    }
    public String ComparacionResultados2(String promo,String etiqueta,String valor,String valor2){
        String estado;
        if (valor.equals(valor2)) {
            estado = "correcto";
            System.out.println("---Comparacion---"+etiqueta);
            System.out.println("valor : "+valor);
            System.out.println("valor2 : "+valor2);
            System.out.println("Los valores son iguales en la promo "+promo);
        }else{
            estado = "incorrecto";
            System.out.println("---Comparacion---"+etiqueta);
            System.out.println("valor : "+valor);
            System.out.println("valor2 : "+valor2);
            System.out.println("Los valores son diferentes en la promo " +promo);
        }
        return estado;
    }
    public void comparacionEstado(String estado1,String estado2,String estado3){
        String estado;
        if (estado1=="correcto" && estado2=="correcto" && estado3=="correcto"){
            System.out.println("estado : "+estado1);
            System.out.println("estado2 : "+estado2);
            System.out.println("estado3 : "+estado3);
            estado = "correcto";
        }else{
            estado = "incorrecto";
            System.out.println("estado : "+estado1);
            System.out.println("estado2 : "+estado2);
            System.out.println("estado3 : "+estado3);
        }
        String Definido = "correcto";
        assertEquals(Definido,estado);
    }
}
