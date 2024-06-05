package atlantic.CasinoOnline.xpath;

public class XpathPromociones {

    private static XpathPromociones obj = null;
    private XpathPromociones() {
    }
    public static XpathPromociones getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathPromociones();
        }
    }

    public final String BarrasMenu="//button[contains(@class, 'IconButton_baseButton') and contains(@aria-label, 'UserMenu')]";
    public final String BtnPromociones="//p[text()='Promociones']";
    public final String BtnAvance="//div[contains(text(),'Avance')]";
    public final String BtnAvance2="//button[contains(text(),'Avance')]";
    public final String txtPremio="//span[text()='S/' and @class='_content_knp8h_2']";
    public final String txtFecha="//p[text()='Martes y jueves']";
    public final String txtBotonx5="//img[@class='_bubble_117os_16' and @src='https://ctp-cms.s3.amazonaws.com/CMS_COL/PROD/PROMOCIONES/assets/multi5x.svg']";
    public final String txtComoParticipar="//p[contains(text(), 'Canjea tus opciones')]";
    public final String txtCanje="//p[@class='promos-v3-text-base sm:promos-v3-text-lg' and Strong[text()='Canje:']]";
    public final String BtnOjoAmarillo="//button[contains(text(),'ID:')]";
    public final String txtIdInvitado="//input[@placeholder='ID']";
    public final String BtnActualizarOjo="//button[contains(text(),'Actualizar')]";
    public final String BtnCanje="//div[contains(text(),'Canje')]";
    public final String btnCajearOpciones="//button[contains(text(),'Canjear opciones')]";
    public final String btnNuevo="//button[contains(text(),'Nuevo')]";
    public final String btnResultados="//button[contains(text(),'Resultados')]";

    //VENTANA CANJE
    public final String txtmispuntos="//h4[@id='idpuntaje']";
    public final String txtProntoSorteo="//h4[contains(text(),'¡Pronto será el sorteo!')]";
    public final String txtopcionesCanjear="//p[@id='puntajeEquivalencia']";
    public final String txtYaCanjeaste="//p[contains(text(),'Ya canjeaste el máximo de opciones para el sorteo.')]";
    public final String txtopcionesCanjeadas="//h3[@id='opcionesCanjeadas']";
    public final String txtFechaTorneos="//th[contains(text(),'Torneo: ')and Strong[contains(text(),'Lunes')]]";
    public final String txtFechaSorteos="//span[contains(text(),'Fecha del sorteo:')and Strong[contains(text(),'Viernes')]]";


    //VENTANA AVANCE - TORNEO
    public final String txtpuestoTorneo="//p[@id='idPuesto']";
    public final String imgpuestoTorneo="//img[@id='idPremio']";
    public final String txtpuntosTorneo="//p[@id='idPuntos']";
    public final String txtpremioTorneo="//p[@id='idPremio']";
    public final String txtPromocionActiva="//p[contains(text(),'¡Empieza a jugar!')]";
    public final String txtActivastePromo="//p[contains(text(),'¡Activaste la promoción!')]";
    public final String txtDeliveryActivo="//span[contains(text(),'¡Sigue jugando!')]";
    public final String txtDeliverySuperado="//button[contains(text(),'Ir a canjear')]";
    public final String txtActivastePromoWinners="//p[contains(text(),'¡Empieza a jugar!')]";
    public final String txtPuestoWinner="//div[@class='text-box_position']/div[1]/strong";
    public final String txtPuntosWinner="//div[@class='text-box_position']/div[2]";
    public final String txtPremioWinner="//div[@class='text-box_position']/div[3]";

    public final String imgpuestoWinner="";

    //INFORMACION - TORNEO
    public final String lblPeriodoAcumulacion="//p[contains(., 'Periodo de acumulación:') and contains(., 'hasta el')]";
    public final String btnInformacion="//button[text()='Información']";
    public final String txtPeriodoTorneoCuotas="//p[contains(text(), '/') and @class='subtitulo_ranking']";
    public final String txtPeriodoWinnersWinners="//div[@class='itemCheck_line_text' and Strong[text()='Periodo de acumulación:']]";

    //VENTANA NUEVO
    public final String imgDropAndWin="//img[@alt='Drops and Wins-img']";
    public final String txtPagoAnticipadoCard="//strong[contains(text(),'Pago Anticipado')]";

    //VENTANA DELIVERY
    public final String txtYaPuedesCanjear="//strong[contains(text(),'¡YA PUEDES CANJEARLO!')]";
    public final String imgDelivery="//img[@class='jsx-3221587721 imgEvento rounded']";
    public final String btnCanjear="//a[contains(text(),'CANJEAR')]";
}
