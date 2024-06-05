package atlantic.CasinoOnline.xpath;

public class XpathHome {
    private static XpathHome obj = null;
    private XpathHome() {
    }
    public static XpathHome getInstancia() {
        instanciar();
        return obj;
    }
    private synchronized static void instanciar() {
        if (obj == null) {
            obj = new XpathHome();
        }
    }

    //CABECERA
    public final String btnSport="//a[@class='styles_Item__geCsQ' and span[text()='sports']]";
    public final String btnCasino="//a[@class='styles_Item__geCsQ' and span[text()='casino']]";
    public final String BtnFavoritos="//div[contains(@class, 'bordeBtnFavorito') and .//p[contains(text(), 'Favoritos')]]";
    public final String btnPromociones="//a[@class='styles_Item__geCsQ' and span[text()='promociones']]";
    public final String btnIngresar="//button[contains(text(),'Ingresar')]";
    public final String btnIniciarSesion="//button[contains(@class, 'styles_baseButton__3ohKA') and contains(@class, 'styles_primaryButton__02bqI') and contains(@class, 'styles_mediumButton__UnRlN') and text()='Iniciar Sesión']\n";
    public final String btnRegistrar="//a[contains(text(),'Regístrate')]";
    public final String btnCrearCuenta="//div[@class='styles_baseButton__3ohKA styles_secondaryDarkButton__0RuYF styles_mediumButton__UnRlN styles_linkContainer__CXW88']/a[text()='Crear Cuenta']";


    //CONTENIDO LANDING
    public final String ContenidoCARD="//div[@class='home-cards clmc-flex-center clmc-w100 undefined']";
    public final String ContenidoSeccionPreguntas="//div[@class='SeoSection_container__KC6h0']";

    //TRX
    public final String ContenidoTeDevolvemos="//span[contains(text(),'hasta S/1,000')]";
    public final String ContenidoTeRegalamos="//span[contains(text(),'hasta S/500')]";
    public final String txtMaquinas="//p[contains(text(),'Máquinas')]";
    public final String txtMesasEnVivo="//p[contains(text(),'Mesas en vivo')]";
    public final String txtMesas="//p[contains(text(),'Mesas')]";
    public final String txtApuestasDeportivas="//p[contains(text(),'Apuestas deportivas')]";
    public final String txtAtlanticClub="//p[contains(text(),'Atlantic City Club')]";
    public final String contenidoAtlanticClub="//span[contains(text(),'Descubre el mundo de las apuestas como nunca antes')]";
    public final String contenidoApuestasDeportivas="//span[contains(text(),'El programa de recompensas que premia tu lealtad c')]";
    public final String btnIrSport="//button[contains(text(),'ir a sportS')]";
    //SEO
    public final String txtCasinoOnlinePeru="//h1[contains(text(),'Casino online en Perú de Atlantic City Casino & Sp')]";
    public final String txtMasInformacionInteres="//h2[contains(text(),'Más información de tu interés:')]";
    public final String SEObtnMostrarMas="//span[contains(text(),'Mostrar más')]";
    public final String SEOpregunta1="//h3[contains(text(),'¿Cuáles son los mejores juegos de casino online?')]";
    public final String SEOpregunta2="//h3[contains(text(),'¿Es seguro jugar en el casino online?')]";
    public final String SEOpregunta3="//h3[contains(text(),'¿Puedo jugar al casino online desde el móvil?')]";
    public final String SEOpregunta4="//h3[contains(text(),'¿Qué métodos de pago puedo usar en el casino en lí')]";
    public final String SEOpregunta5="//h3[contains(text(),'¿Qué es un live casino?')]";
    public final String SEOpregunta6="//h3[contains(text(),'Diferencias entre casino online y casino en vivo')]";
    public final String SEOcentroAyuda="//a[@href='/casino-online/centro-de-ayuda' and text()='Centro de Ayuda.']";
   //SEO TRAGAMONEDAS
    public final String TxtTragamonedasCasino="//h1[contains(text(),'Tragamonedas en Casino Online')]";
    public final String SEOMQpregunta1="//h3[contains(text(),'¿Cuál es la mejor máquina de tragamonedas?')]";
    public final String SEOMQpregunta2="//h3[contains(text(),'¿Cómo puedo jugar tragamonedas online?')]";
    public final String SEOMQpregunta3="//h3[contains(text(),'¿Qué tipos de tragamonedas existen?')]";
    public final String SEOMQpregunta4="//h3[contains(text(),'¿Cuáles son las ventajas de jugar a las máquinas t')]";

    //SEO MESAS
    public final String txtJuegosMesa="//h1[contains(text(),'Juegos de mesa en Casino')]";
    public final String SEOMESpregunta1="//h3[contains(text(),'¿Qué debo tener en cuenta antes de jugar en línea?')]";
    public final String SEOMESpregunta2="//h3[contains(text(),'¿Los juegos de mesa en línea son seguros?')]";
    public final String SEOMESpregunta3="//h3[contains(text(),'¿Cómo sé que juego es el mejor para mí?')]";



    public final String FlechaDerechaSlider ="//img[contains(@src, 'https://www.casinoatlanticcity.com/static/img/iconos/sliderDerecho.png')]";
    public final String FlechaIzquierdoSlider="//img[contains(@src, 'https://www.casinoatlanticcity.com/static/img/iconos/sliderIzquierdo.png')]";
    public final String btnBuscarJuego="//input[@id='generalSearchInput']";
    public final String flechaFavoritos="//a[@href='/casino-online/promociones' and button[text()='VER MÁS']]";
    public final String flechamaquinas="//a[@href='/casino-online/tragamonedas' and button[text()='VER MÁS']]";
    public final String fechaMesasEnVivo="//a[@href='' and button[text()='VER MÁS']]";
    public final String fechaMesas="//a[@href='/casino-online/juegos-de-mesa' and button[text()='VER MÁS']]";
    public final String txtRetiroRapido="//div[img[@src='https://www.casinoatlanticcity.com/static/img/seo_content/casino_online/retiro.svg'] and p[contains(text(), 'Retiro rápido')]]";
    public final String txtSeguridadGarantia="//div[img[@src='https://www.casinoatlanticcity.com/static/img/seo_content/casino_online/seguridad.svg'] and p[contains(text(), 'Seguridad')]]";
    public final String txtCasinoLider="//div[img[@src='https://www.casinoatlanticcity.com/static/img/seo_content/casino_online/casino.svg'] and p[contains(text(), 'Casino líder')]]";
    public final String txtServicioPersonalizado="//div[img[@src='https://www.casinoatlanticcity.com/static/img/seo_content/casino_online/servicio_personalizado.svg'] and p[contains(text(), 'Servicio')]]";

    public final String txtJuegoNuevos="//div[@class='sliderLobby-header' and .//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/juegos_new.svg'] and .//p[contains(text(), 'Juegos nuevos')] and .//a[@href='/casino-online/tragamonedas/juegos-nuevos'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String txtMasjugados="//div[@class='sliderLobby-header' and .//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/maquinas.svg'] and .//p[contains(text(), 'Más jugados')] and .//a[@href='/casino-online/tragamonedas/populares'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String txtClasicos="//div[@class='sliderLobby-header' and .//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/clasicos.svg'] and .//p[contains(text(), 'Clásicos')] and .//a[@href='/casino-online/tragamonedas/clasicas'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String txtHighRollers="//div[@class='sliderLobby-header' and .//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/high_rollers.svg'] and .//p[text()='High rollers'] and .//a[@href='/casino-online/tragamonedas/high-rollers'] and .//button[contains(., 'VER MÁS')]]";
    public final String txtProveedores="//div[@class='sliderLobby-header' and .//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/proveedores.svg'] and .//p[text()='Proveedores'] and .//a[@href='/casino-online/tragamonedas/proveedores'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String txtUltimosJackPots="//div[contains(text(),'Últimos Jackpots')]";
    public final String txtParati="//div[@class='sliderLobby-header' and .//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/foryou.svg'] and .//p[text()='Para ti'] and .//a[@href='/casino-online/tragamonedas/para-ti'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String btnFavoritosMQ="//div[@class='bordeBtnFavorito' and .//p[contains(@class, 'clmc-btn-primary') and contains(@class, 'clmc-icon-button') and contains(@class, 'favouritesButton') and contains(@class, 'styles_favoritebtn__YjtAb') and text()='Favoritos']]";
    public final String txtProgresivos="//div[@class='sliderLobby-header' and .//p[text()='Progresivos'] and .//a[@href='/casino-online/tragamonedas/progresivas'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String txtAtracciones="//div[@class='styles_actions__ngrUb' and .//div[text()='Atracciones'] and .//a[@href='/casino-online/tragamonedas/bonificacion'][text()='Ver más']]";
    public final String txtTodosLosJuegos="//div[@class='sliderLobby-header' and .//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/todos.svg'] and .//p[text()='Todos los juegos'] and .//a[@href='/casino-online/tragamonedas/todos'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String txtTragamonedasCasino="//h1[contains(text(),'Tragamonedas en Casino Online')]";
    public final String txtMasInformacion="//h2[contains(text(),'Más información de tu interés:')]";
    public final String btnBuscarJuegoMQ="//input[@id='generalSearchInput']";
    public final String txtRuleta="//div[@class='sliderLobby-header'][.//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/ruleta.svg'] and .//p[text()='Ruleta'] and .//a[@href='/casino-online/juegos-de-mesa/ruleta'] and .//button[contains(text(), 'VER MÁS')]]\n";
    public final String txtBlackjack="//div[@class='sliderLobby-header'][.//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/blackjack.svg'] and .//p[text()='Blackjack'] and .//a[@href='/casino-online/juegos-de-mesa/blackjack'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String txtBaccarat="//div[@class='sliderLobby-header']/div[img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/bacarat.svg'] and p[text()='Baccarat']]";
    public final String txtPoker="//div[@class='sliderLobby-header']/div[img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/poker.svg'] and p[text()='Poker']]";
    public final String txtTodolosJueg="//div[@class='sliderLobby-header'][.//img[@src='https://www.casinoatlanticcity.com/static/img/casino-online-menu/title/todos.svg'] and .//p[text()='Todos los juegos'] and .//a[@href='/casino-online/juegos-de-mesa/todos'] and .//button[contains(text(), 'VER MÁS')]]";
    public final String txtMasInformacionde="//h2[contains(text(),'Más información de tu interés:')]";
    public final String iconorulete="//a[@class='styles_opcionMenu__t2Qjp' and contains(@href, '/casino-online/juegos-de-mesa/')]/p[contains(text(), 'Ruleta')]";
    public final String iconoBlackjack="//a[@class='styles_opcionMenu__t2Qjp' and contains(@href, '/casino-online/juegos-de-mesa/')]/p[contains(text(), 'Blackjack')]";
    public final String iconoBaccarat="//a[@class='styles_opcionMenu__t2Qjp' and contains(@href, '/casino-online/juegos-de-mesa/')]/p[contains(text(), 'Baccarat')]\n";
    public final String iconoPoker="//a[@class='styles_opcionMenu__t2Qjp' and contains(@href, '/casino-online/juegos-de-mesa/')]/p[contains(text(), 'Poker')]\n";
    public final String iconoTodosJuegos="//a[@class='styles_opcionMenu__t2Qjp' and contains(@href, '/casino-online/juegos-de-mesa/')]/p[contains(text(), 'Todos los juegos')]\n";

    //FOOTER LANDING
    public final String iconoKashio="//picture/img[@src=\"https://www.casinoatlanticcity.com/static/img/pagos/kashio.svg\"]";
    public final String iconoVisa="//div[@class='styles_paymentMethods_Grid__3ab2Y']/div[@class='acity-footer_grid__item'][2]/picture[source/@srcset='https://www.casinoatlanticcity.com/static/img/footer/1440/Visa.png']\n";
    public final String iconoMasterCard="//div[@class='styles_paymentMethods_Grid__3ab2Y']/div[@class='acity-footer_grid__item'][3]/picture[source/@srcset='https://www.casinoatlanticcity.com/static/img/footer/1440/Mastercard.png']\n";
    public final String iconoInterbank="//div[@class='styles_paymentMethods_Grid__3ab2Y']/div[@class='acity-footer_grid__item'][4]/picture[source/@srcset='https://www.casinoatlanticcity.com/static/img/footer/1440/Interbank.png']\n";
    public final String iconoSafetyPay="//div[@class='styles_paymentMethods_Grid__3ab2Y']/div[@class='acity-footer_grid__item'][5]/picture[source/@srcset='https://www.casinoatlanticcity.com/static/img/footer/1440/SafetyPay.png']\n";
    public final String iconoPagoEfectivo="//div[@class='styles_paymentMethods_Grid__3ab2Y']/div[@class='acity-footer_grid__item'][6]/picture[source/@srcset='https://www.casinoatlanticcity.com/static/img/footer/1440/PagoEfectivo.png']\n";
    public final String iconoYape="//div[@class='styles_paymentMethods_Grid__3ab2Y']/div[@class='acity-footer_grid__item'][7]/picture[source/@srcset='https://www.casinoatlanticcity.com/static/img/footer/1440/Yape.png']\n";
    public final String iconoPlin="//div[@class='styles_paymentMethods_Grid__3ab2Y']/div[@class='acity-footer_grid__item'][8]/picture[source/@srcset='https://www.casinoatlanticcity.com/static/img/footer/1440/Plin.png']\n";

    public final String iconoCasinoOnline="//a/img[@src=\"https://www.casinoatlanticcity.com/static/img/logos/logo-casino.svg\"]";
    public final String iconoSport="//a/img[@src=\"https://www.casinoatlanticcity.com/static/img/logos/logo-apuestas.svg\"]";
    public final String IconosRandom="//div[contains(@class, 'styles_footerGridItem__FmhhR') and contains(@class, 'styles_validationSealsPos__H_qdB') and contains(@class, 'styles_validationSeals___AMwg')]";

    public final String txtMediosPago="//p[contains(text(),'Medios de pago')]";
    public final String txtQuienesSomos="//a[contains(@href, '/quienes-somos')]//u[contains(text(),'¿Quiénes somos?')]";
    public final String txtCasinoOnline="//a[contains(@href, '/casino-online')]//u[contains(text(),'Casino online')]";
    public final String txtSportFooter="//a[contains(@href, '/apuestas-deportivas')]//u[text()='Sports']";
    public final String txtBlogApuesta="//a[contains(@href, 'https://blog.casinoatlanticcity.com/')]//u[contains(text(),'Blog de apuestas deportivas')]";
    public final String txtterminos="//a[contains(@href, '/casino-online/terminos-y-condiciones')]//u[contains(text(),'Términos y Condiciones')]";
    public final String txtprivacidad="//a[contains(@href, '/casino-online/politica-de-proteccion-de-datos-personal')]//u[contains(text(),'Política de Privacidad')]";
    public final String txtcookies="//a[contains(@href, '/casino-online/politica-de-cookies')]//u[contains(text(),'Política de Cookies')]";
    public final String txtreglas="//a[contains(@href, '/apuestas-deportivas/terminos-y-condiciones-apuestas-deportivas')]//u[contains(text(),'Reglas de Atlantic City Sports')]";
    public final String txtchatenlinea="//u[contains(text(),'Chat en línea')]";
    public final String txtcentrodeayuda="//a[contains(@href, '/casino-online/centro-de-ayuda')]//u[contains(text(),'Centro de ayuda')]";
    public final String iconoLibroReclamacion="//a[contains(@href, '/casino-online/libro-reclamaciones')]";

    public final String iconoCOAtlantic="//img[contains(@src, 'https://www.casinoatlanticcity.com/static/img/logos/logo-casino.svg')]";
    public final String iconoCOAtlantic2="(//a[contains(@href,'/casino-online')]//img[contains(@src, 'https://www.casinoatlanticcity.com/static/img/logos/logo-casino.svg')])[2]";

    public final String iconoAPAtlantic="//img[contains(@src, 'https://www.casinoatlanticcity.com/static/img/logos/logo-apuestas.svg')]";
    public final String footerAtlanticDerechosReservados="//span[contains(text(),'2024')]";

    //BOTON HAMBURGUESA
    public final String btnHamburguesaNL="//button[contains(@class, 'LandingHeader_user-menu-button__b8re4')]";
    public final String btnHamburguesaLG="//button[contains(@class, 'IconButton_textDarkButton')]";

    public final String btnInicio="//div[@class='clmc-bg-light-primary clmc-border-radius clmc-p20']//p[@class='normal-link normal-link-login4 menuActivo2']/button\n";
    public final String btnPromocionesNL="//div[@class='clmc-bg-light-primary clmc-border-radius clmc-p20']//a[@href='/promociones']/p[@class='promo-link ']/img\n";
    public final String btnCasinoNL="//div[@class='clmc-bg-light-primary clmc-border-radius clmc-p20']//a[@href='/casino-online']/p[@class='casino-link']/button\n";
    public final String btnSportNL="//div[@class='clmc-bg-light-primary clmc-border-radius clmc-p20']//a[@href='/apuestas-deportivas']/p[@class='apuestas-link']/button\n";
    public final String btnQuienesSomos="//a[@href='/quienes-somos' and descendant::p[contains(text(), 'Quiénes somos')]]";

    //LOGUEADO -----------------

    //HAMGURGUESA
    public final String btnPromocionesLG="//div[contains(@class,'clmc-bg-light-primary clmc-border-radius clmc-p20')]//a[contains(@href,'/casino-online/promociones')]";
    public final String btnMaquinasLG="//div[contains(@class,'clmc-bg-light-primary clmc-border-radius clmc-p20')]//a[contains(@href,'/casino-online/tragamonedas')]";
    public final String btnMesasVivoLG="//p[contains(text(),'MESAS EN VIVO') and contains(@class, '')]";
    public final String btnMesasEvolution="//a[contains(@href,'/casino-online/mesas-evolution')]";
    public final String btnMesasPragmatic="//a[contains(@href,'/casino-online/mesas-pragmatic')]";
    public final String btnMesasEzugi="//a[contains(@href,'/casino-online/mesas-ezugi')]";

    public final String btnMesasLG="//p[contains(text(),'MESAS') and contains(@class, 'menuPadre normal-link normal-link-login2 clmc-pointer mesas-menu')]";
    public final String btnAtlanticCityLG="//p[contains(text(),'ATLANTIC CITY CLUB') and contains(@class, 'menuPadre marginItemMenuTop normal-link normal-link-login3 clmc-pointer mesas-menu menuAtlanticClub linkDorado')]";
    public final String btnIraSportLG="//p[contains(text(),'IR A SPORTS') and contains(@class, 'apuestas-link normal-link-login')]";
    public final String btnCanjePuntos="//a[contains(@href,'/casino-online/atlantic-club/ecommerce')]";
    public final String btnDelivery="//a[contains(@href,'/casino-online/atlantic-club/delivery-atlantic')]";


    //HOME
    public final String btnDepositar="(//button[contains(text(),'DEPOSITAR') and contains(@class, '')])[1]";
    public final String btnNotificaciones="(//button[contains(@aria-label, 'Notificaciones')])[1]";
    public final String btnUsuario="//p[contains(@data-testid, 'user-menu-button')]//button[contains(@aria-label, 'UserMenu')]";
    public final String btnRegistrateJuega="(//a[contains(text(),'Regístrate y juega')])[1]";
    public final String btnRegistrateJuega2="(//a[contains(text(),'Regístrate y juega')])[2]";
    public final String btnRegistrateJuega3="//a[contains(text(),'REGÍSTRATE Y JUEGA')]";
    public final String bonoCasino="//span[contains(text(),'Bono Casino')]";
    public final String bonoSport="//span[contains(text(),'Bono Sports')]";
    public final String btnLoquiero="(//a[contains(@href, '/registro') and text()='¡LO QUIERO!'])[1]";
    public final String btnLoquiero2="(//a[contains(@href, '/registro') and text()='¡LO QUIERO!'])[2]";
    public final String txtTitiloAtlanticClub="//h2[contains(text(),'¿Qué es Atlantic City Club?')]";
    public final String txtContenidoAtlanticClub="//p[contains(text(),'El programa de recompensas que premia tu lealtad con beneficios exclusivos. Gana puntos jugando en tus máquinas favoritas y canjéalos por dinero y delivery de nuestro restaurante. También participarás de promociones millonarias, eventos exclusivos y una atención personalizada.')]";
    public final String CuadroJuego="(//*[@class=\"styles_container__81eO7 styles_mediumContainer__TWFdT\"])[1]";
    public final String JugarBotonJuego="(//div[@class='styles_container__81eO7 styles_mediumContainer__TWFdT'])[1]//button[contains(text(), 'Jugar')]";
    public final String ApiJuego="//iframe[@id='iframe-calimaco']";

    //Perfil
    public final String IconoDatosPersonales="(//button[@tabindex='0' and @type='button' and @aria-label='UserMenu'])[2]";
    public final String btnPerfil="//p[contains(text(),'Perfil')]";
    public final String btnVerificarIdentidad="//p[contains(text(),'Verificación de identidad')]";
    public final String btnAgregarDocumento="//div[contains(@class, 'styles_baseButton__w3ZVN') and contains(@class, 'styles_textButton__V_0EH') and contains(@class, 'styles_mediumButton__fy2t6') and .//a[contains(text(), 'AGREGAR DOCUMENTO')]]";
    public final String btnAgregarCuenta="//div[contains(@class, 'styles_baseButton__w3ZVN') and contains(@class, 'styles_textButton__V_0EH') and contains(@class, 'styles_mediumButton__fy2t6') and .//a[contains(text(), 'Agregar Cuenta')]]\n";
    public final String btnValidarNumero="//div[contains(@class, 'styles_baseButton__w3ZVN') and contains(@class, 'styles_textButton__V_0EH') and contains(@class, 'styles_mediumButton__fy2t6') and .//a[contains(text(), 'VALIDAR NÚMERO')]]";
    public final String inputAgregarDniFrontal="(//label[contains(@class, 'MuiButtonBase-root') and contains(text(), 'CARGAR')]/input[@type='file'])[1]";
    public final String inputAgregarDniPosterior="(//label[contains(@class, 'MuiButtonBase-root') and contains(text(), 'CARGAR')]/input[@type='file'])[2]";
    public final String btnCuentaBancaria="//p[contains(text(),'Número de cuenta bancaria')]";
    public final String inputAgregarEstadoBancario="(//label[contains(@class, 'MuiButtonBase-root') and contains(text(), 'CARGAR')]/input[@type='file'])[3]";
    public final String btnEnviar="//button[@id='submitFilterSecondStep']";
    public final String btnRetirar="//button[contains(text(),'Retirar')]";
    public final String btnTransferenciaBancaria="//p[contains(text(),'Transf. bancaria')]";
    public final String txtIngresarMonto="//input[@id='payoutsAmountInput']";
    public final String btnContinuar2="//button[contains(text(),'Continuar')]";


    //Promociones
    public final String btnDepositarPromo="//p[contains(text(),'DEPOSITAR') and contains(@class, '')]";
    public final String txtBienveidoPromos="//h1[contains(text(),'Bienvenido a Promociones Atlantic')]";
    public final String btnMisPromociones="//button[contains(text(),'Mis Promociones')]";
    public final String btnNuevo="//button[contains(text(),'Nuevo')]";
    public final String btnResultados="//button[contains(text(),'Resultados')]";

    public final String txtMisPromosActivas="//span[contains(text(),'Mis promociones activas')]";

    //MESAS EN VIVO

    public final String iconoCorazon="//div[@class='iframeButtons']//button[@data-tooltip-content='Agregar a favoritos']";
    public final String iconoAmplicar="//div[@class='iframeButtons']//button[@data-tooltip-content='Pantalla completa']";
    public final String iconoCerrar="//div[@class='iframeButtons']//button[@data-tooltip-content='Salir del juego']";
    public final String LinkApiEvo="//iframe[@id='iframe-calimaco']";

    //EVOLUTION
    public final String btnParaTi="//nav[contains(text(),'')]//span[contains(text(),'Para ti')]";
    public final String btnJuegos="//nav[contains(text(),'')]//span[contains(text(),'Juegos')]";
    public final String btnFavoritos="//nav[contains(text(),'')]//span[contains(text(),'Favoritos')]";



    //FESTIVAL
    public final String txtComeGanoPuntos="//a[@href=\"/casino-online/centro-de-ayuda/preguntas/atlantic-city-club#comoAcumularPuntosTab2\" and span[text()=\"¿Cómo gano más puntos?\"]]";
    public final String txtAlcanza800="//span[contains(text(), \"Alcanza\")]";
    public final String txtcontenidoDelivery="//div[contains(@class, \"infoDescripcion\")]";
    public final String txtSolicitarDeliveryconten="//span[contains(text(),'Reserva tu pedido para este sábado o domingo y dis')]";
    public final String txtpuntosReinician="//span[contains(text(), \"Los puntos se reinician semanalmente. Realiza el canje antes de las 11:59 pm del miércoles\")]\n";
    public final String txtDudasConsultas="//strong[contains(text(),'¿Dudas o consultas?')]";
    public final String PuntajeActual="//div[contains(text(),'')]//div[contains(@class,'tienes-pts')]";
    public final String txtTituloFestival="//h1[contains(text(),'Festival')]";
    public final String txtDiasCanjeFestival="//div[contains(@class,'infoHorarios')]";
    public final String txtSolicitarDelivery="//strong[contains(text(),'Solicitar delivery')]";
    public final String btnCanjearDelivery="//a[contains(text(),'CANJEAR')]";
    public final String btnPreguntasFrecuentes="//a[contains(., \"Preguntas frecuentes\") and @href=\"/casino-online/centro-de-ayuda/preguntas/atlantic-city-club#zonaSobreDelivery\"]\n";
    public final String btnTerminosyC="//a[contains(., \"Términos y condiciones\") and @href=\"/casino-online/terminos-y-condiciones#clausula32\"]\n";
    public final String getBtnDepositarDelivery="//p[contains(text(),'DEPOSITAR')]";
    public final String btnNotificacionesDelivery="(//button[contains(@aria-label,'Notificaciones')])[1]";
    public final String IconosRandomDelivery="//div[contains(@class,'footer_validationSealsPos')]";
    public final String btnAgregarDireccion="//span[contains(text(),'Agregar dirección')]";
    public final String txtDirrecion="//input[@id='formDireccion']";
    public final String txtReferencia="//input[@id='formReferencia']";
    public final String txtNombreDireccion="//input[@id='formNombreDireccion']";
    public final String txtObservacion="//textarea[@id='formObservacion']";
    public final String btnAgregarDirrecionEnvio="//button[contains(text(),'AGREGAR DIRECCIÓN')]";
    public final String txtDirrecionAgregada="//span[contains(text(),'Dirección de entrega - NOMBRE')]";
    public final String btnContinuar="//a[contains(text(),'CONTINUAR')]";
    public final String btnCanjear="//button[contains(text(),'CANJEAR')]";

    //CANJE
    public final String txtTituloCanjePuntos="//h1[contains(text(),'Canje de puntos Atlantic')]";
    public final String txtSubTituloCanje="//span[contains(@class, 'jsx-355f9f6498b66257') and contains(., 'Tiene ') and .//a[contains(text(), 'Ver detalle')]]";
    public final String btnDireccionEnvio="//span[contains(text(),'Dirección de envío:')]";
    public final String btnAgregarDirrecion2="//span[contains(text(),'AGREGAR DIRECCIÓN')]";
    public final String selectDistrito="//select[@name='distrito']";
    public final String txtDirrecionCanje="//input[@id='txtDir']";
    public final String txtReferenciaCanje="//input[@id='txtRef']";
    public final String txtNombreDireccionCanje="//input[@id='txtNameDir']";
    public final String selectDireccion="//h2[contains(text(),'Prueba')]";
    public final String PrimerPedido="(//div[starts-with(@class, 'jsx-355f9f6498b66257 row')]//div[starts-with(@class, 'col-xl-3 col-lg-3 col-md-4 col-sm-6 col-6 ')]//button[starts-with(@class, 'a-button-secondary w-100')])[1]";
    public final String btnAgregarDirrecionCanje="//button[contains(text(),'Agregar dirección')]";
    public final String btnAgregarCarrito="//button[contains(text(),'AGREGAR AL CARRITO')]";
    public final String btnAgregarCarrito2="//button[contains(text(),'Agregar al carrito')]";
    public final String btnSelectRetiro="//td[contains(text(),'$10.00')]";
    public final String txtTotal="//div[contains(text(),'Total')]";
    public final String btnContinuarCanje="//button[contains(text(),'CONTINUAR')]";

    public final String txtHorarioAtencion="//span[contains(text(),'Nuestro horario de atención es de 12 PM a 9 PM.')]";
    public final String btnDirrecionEnvio="//span[contains(text(),'Dirección de envío:')]";
    public final String btnHistorialPedidos="//span[contains(text(),'Historial de pedidos')]";
    public final String btnCarritoCanjes="//span[contains(text(),'Carrito de canjes')]";
    public final String btnRestaurante = "//button[contains(text(),'Restaurante')]";
    public final String btnEfectivo="//button[contains(text(),'Efectivo')]";
    public final String btnMisDirecciones="//a[contains(text(),'IR A MIS DIRECCIONES')]";



}
