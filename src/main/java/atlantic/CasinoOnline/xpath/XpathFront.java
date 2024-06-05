package atlantic.CasinoOnline.xpath;

public class XpathFront {

    private static XpathFront obj = null;
    private XpathFront() {
    }
    public static XpathFront getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathFront();
        }
    }
//promociones

    public final String TorneoMesas="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-6']//th[contains(text(),'Torneo: ')]";
    public final String TorneoCuotas="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-11']//th[contains(text(),'Torneo: ')]";
    public final String TopAtlantic="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-4']//th[contains(text(),'Torneo: ')]";
    public final String Winner="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-10']//th[contains(text(),'Torneo: ')]";
    public final String TorneoMega="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-5']//th[contains(text(),'Torneo: ')]";


    // MARTES JUEVES Y SABADO ROYAL Y ESTELAR
    public final String Sorteovip="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-2']//span[contains(text(),'sorteo:')]";
    public final String SorteoEstelar="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-1']//span[contains(text(),'sorteo:')]";
    public final String SorteoSueños="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-3']//span[contains(text(),'sorteo:')]";
    public final String Delivery="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-13']//span[contains(text(),'Disponible:')]";


//PREMIOS
    public final String PMesa="//p[contains(text(),' en premios semanales')and Strong[contains(text(),'S/ 21,050')]]";
    public final String PCuota="//p[contains(text(),'Cada semana más de ')and Strong[contains(text(),'S/ 50,000')]]";
    public final String PMega="//p[contains(text(),' en premios quincenales')and Strong[contains(text(),'S/ 7,700')]]";
    public final String PTop="//p[contains(text(),' en premios semanales')and Strong[contains(text(),'S/ 9,200')]]";
    public final String PVip="//span[contains(text(),' repartidos en cada sorteo')and Strong[contains(text(),'S/ 9,999')]]";
    public final String PuntosVip="//span[contains(text(),'5 puntos = 1 opción')]";
    public final String PEstelar="//span[contains(text(),'Sigue jugando y gana más opciones')]";
    public final String PuntosEstelar="//span[contains(text(),'1 punto = 2 opciones')]";
    public final String PSueños="//span[contains(text(),' en premios todas las semanas')and Strong[contains(text(),'S/ 25,000')]]";
    public final String PuntosSueños="//span[contains(text(),'10 puntos = 1 opción')]";
    public final String PDelivery="//span[contains(text(),'Acumula ')and Strong[contains(text(),'800')]]";
    public final String PWinner="//p[contains(text(),' en premios semanales')and Strong[contains(text(),'S/ 10,800')]]";

    //IDENTIFICADOR DE CARDS
    public final String CardCuota="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-11']//button[@class='styles_button__q_K2v']";
    public final String CardMesas="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-6']//button[@class='styles_button__q_K2v']";
    public final String CardMega="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-5']//button[@class='styles_button__q_K2v']";
    public final String CardWinner="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-10']//button[@class='styles_button__q_K2v']";
    public final String CardTop="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-4']//button[@class='styles_button__q_K2v']";
    public final String CardVip="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-2']//button[@class='styles_button__q_K2v']";
    public final String CardEstelar="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-1']//button[@class='styles_button__q_K2v']";
    public final String CardSueños="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-3']//button[@class='styles_button__q_K2v']";
    public final String CardDelivery="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-13']//button[@class='styles_button__q_K2v']";

    //IDENTIFICADOR DE CARDS - Ver mas

    public final String VermasMesas="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-6']//a[contains(.,'Ver más')]";
    public final String VermasCuota="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-11']//a[contains(.,'Ver más')]";
    public final String VermasMega="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-5']//a[contains(.,'Ver más')]";
    public final String VermasWinner="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-10']//a[contains(.,'Ver más')]";
    public final String VermasTop="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-4']//a[contains(.,'Ver más')]";
    public final String VermasVip="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-2']//a[contains(.,'Ver más')]";
    public final String VermasEstelar="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-1']//a[contains(.,'Ver más')]";
    public final String VermasSueños="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-3']//a[contains(.,'Ver más')]";
    public final String VermasDelivery="//main[@id='homeTrxContent']/div[@id='home-trx-card_promociones-13']//a[contains(.,'Ver más')]";
    //TEXTOSCARD
    public final String TxtCuota="//p[contains(text(),'Realiza apuestas simples o combinadas con cuotas ')and Strong[contains(text(),'iguales o superiores a 10.00')]]";
    public final String TxtWinner="//p[contains(text(),'')and Strong[contains(text(),'¡Demuestra ser el mejor!')]]";
    public final String TxtMesas="//p[contains(.,'Acumula puntos jugando en tus mesas favoritas de ')]";
    public final String TxtMega="//p[contains(.,'Acumula puntos jugando en tus máquinas ')]";
    public final String TxtTop="//p[contains(.,'¡Participa todas las semanas y demuestra ser el mejor!')]";
    public final String TxtVip="//p[contains(.,' Mínimo es de 100 opciones y máximo de 600 opciones')]";
    public final String TxtEstelar="//p[contains(.,' Mínimo es de 50 opciones y máximo de 200 opciones')]";
    public final String TxtSueños="//p[contains(.,' Mínimo es de 200 opciones y máximo de 5000 opciones')]";
    public final String TxtDelivery="//p[contains(.,'Días de delivery:')]";

    //PROMOS DETALLES
    public final String btnVerCondiciones ="//p[contains(text(),'Ver condiciones')]";
    public final String btnInformacion="//button[contains(.,'Información')]";
    public final String btnVerCondiciones2 ="//u[contains(.,'Ver condiciones')]";

    //MESA

    public final String mesapremio="(//span[contains(.,'S/21,050')])[1]";
    public final String mesaComoParticipar2="//p[contains(.,'Juega en tus mesas y mesas en vivo de')]";
    public final String mesaPeriodoAcumulacion="//p[contains(.,'a las 00:00 hrs hasta el viernes')]";
    public final String mesaJuegosParticipantes="//p[contains(.,'Mesas y mesas en vivo (ruleta, blackjack, baccarat, póquer) de Evolution y Pragmatic.')]";
    public final String mesaExclusiones="//p[contains(.,'Algunos juegos de mesas en vivo no participan.')]";
    public final String mesaCondicionFechas="//ol[contains(.,'El Torneo de Mesas se llevará a cabo online y solo se permitirá')]";
    public final String mesaCondicionJuegosParticipantes="//p[contains(.,'Los juegos que participarán')]";

    //Cuota

    public final String cuotaPremio="//p[contains(.,'Gana hasta S/2,500')]";
    public final String cuotaPeriodoAcumulacion="//p[contains(text(),'De lunes a lunes de 8 AM a 8 AM')]";
    public final String cuotaResultados="//p[contains(.,'Alcanza el rango de cuota y gana hasta S/50,000 más.')]";
    public final String cuotaSuperCuota="//p[contains(.,'TORNEO DE CUOTAS')]";
    public final String cuotaPremioCuota="//span[contains(.,'Premios: S/11,150')]";
    public final String cuotaPremioSuperCuota="//span[contains(.,'Premios: S/65,000')]";
    public final String cuotaCondicionesFechas="//ol[contains(.,'Para participar y acumular puntos, es necesario activar la promoción en la opción “')]";
    public final String SupercuotaCondicionesFechas="//ol[contains(.,'La Súper Cuota estará vigente desde el')]";

    //ESTELAR
    public final String estelarPremio="(//span[contains(.,'S/7,500')])[1]";
    public final String estelarPremio2="(//span[contains(.,'S/14,999')])[1]";
    public final String estelaracumula="//p[contains(.,'Canjea tus opciones')]";
    public final String estelarPeriodo="//p[contains(.,'a las 00:00 hrs. hasta el')]";
    public final String estelarCanje="//p[contains(.,' opciones y máximo de')]";
    public final String estelarExclusiones="//p[contains(.,'Juegos de póker, ruleta, juegos de mesa, mesas en vivo, apuestas deportivas y deportes virtuales.')]";
    public final String estelarCondicionesFechasAcumulacion="//ul[contains(.,'Acumulas opciones desde el')]";

    //MEGA
    public final String MegaPremio="(//span[contains(.,'S/7,700')])[1]";
    public final String MegaComoParticipar2="//p[contains(.,'Juega con tu ')]";
    public final String MegaAcumulacion="//p[contains(.,'a las 00:00 hrs hasta el')]";
    public final String MegaExclusiones="//p[contains(.,'No se incluyen juegos de póker, ruleta, juegos de mesa, mesas en vivo, apuestas deportivas y deportes virtuales.')]";
    public final String MegaCondicionesFechasAcumulacion="//ol[contains(.,'Mega Torneo Atlantic estará vigente desde el')]";

    //SUEÑOS
    public final String SueñosPremio="(//span[contains(.,'S/25,000')])[1]";
    public final String SueñoComoParticipar2="//p[contains(.,'Canjea tus opciones ')]";
    public final String SueñoPuntos="//p[contains(.,'solo con tu saldo efectivo. El saldo bono no cuenta')]";
    public final String SueñoAcumulacion="//p[contains(.,' las 00:00 hrs. hasta el')]";
    public final String SueñoCanje="//p[contains(.,'Mínimo es de ')]";
    public final String SueñoExclusiones="//p[contains(.,'Juegos de póker, ruleta, juegos de mesa, mesas en vivo, apuestas deportivas y deportes virtuales.')]";
    public final String SueñoCondicionesFechasAcumulacion="//ul[contains(.,': Acumulas opciones desde el')]";

    //TOP
    public final String TopPremio="(//span[contains(.,'S/9,200')])[1]";
    public final String TopComoParticipar2="//p[contains(.,'Acumula puntos solo con tu')]";
    public final String TopAcumulacion="//p[contains(.,'a las 00:00 hrs hasta el')]";
    public final String TopExclusiones="//p[contains(.,'No se incluyen juegos de póker, ruleta, juegos de mesa, mesas en vivo, apuestas deportivas y deportes virtuales.')]";
    public final String TopCondicionesFechasAcumulacion="//ol[contains(.,'El Top Atlantic estará vigente desde el')]";

    //VIP
    public final String VipPremio="(//span[contains(.,'S/9,999')])[1]";
    public final String VipComoParticipar2="//p[contains(.,'Cada 5 puntos es igual a 1 opción')]";
    public final String VipPuntos="//p[contains(.,'solo con tu saldo efectivo. El saldo bono no cuenta.')]";
    public final String VipAcumulacion="//p[contains(.,'a las 00:00 hrs. hasta el')]";
    public final String VipCanje="//p[contains(.,'Mínimo es de 100 opciones y máximo de 600 opciones.')]";
    public final String VipExclusiones="//p[contains(.,'Juegos de póker, ruleta, juegos de mesa, mesas en vivo, apuestas deportivas y deportes virtuales.')]";
    public final String VipCondicionesFechasAcumulacion="//ul[contains(.,'las 00:00 hrs hasta el')]";

    //WINNER
    public final String WinnerComoParticipar1="//div[contains(text(),'')and Strong[contains(text(),'S/20.00 o $5.00.')]]";
    public final String WinnerPeriodoAcumulacion="//div[contains(text(),'')and Strong[contains(text(),'Periodo de acumulación:')]]";
    public final String WinnerApuestasPermitidas="//div[contains(text(),'')and Strong[contains(text(),'Apuestas permitidas:')]]";
    public final String WinnerNoParticipan="//div[contains(text(),'')and Strong[contains(text(),'No participan:')]]";
    public final String WinnerCondicionPuntos="//ol[contains(.,'El Torneo Winner de Winners se llevará a cabo online y solo se permitirá participar a través de nuestra página web o nuestra App.')]";

    //DELIVERY
    public final String DeliveryPeriodo="//ul[contains(.,'SÁBADO')]";
    public final String DeliveryPuntos="//span[contains(.,'puntos para tener tu delivery')]";



}
