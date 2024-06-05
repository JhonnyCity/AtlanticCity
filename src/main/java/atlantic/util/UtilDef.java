package atlantic.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.temporal.ChronoUnit;

import net.serenitybdd.core.Serenity;

import net.serenitybdd.screenplay.actions.Switch;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;


import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilDef extends PageObject {

	Random random = new Random();

	public static Properties p;
	private static UtilDef obj = null;
	private WebDriver driver = getDriver();

	public static UtilDef getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new UtilDef();
		}
	}

	public void esperarElemento(int intentos, WebElement elemento) {
		int contador = 0;
		while (element(elemento).isEnabled() == false) {
			contador++;
			if (element(elemento).isEnabled() == true || contador == intentos) {
				System.out.println("Se encuentra elemento o contador finalizo");
				break;
			} else {
				esperarSegundos(1);
			}

		}
	}


	public void esperarSegundos(int tipoEspera) {
		try {
			Thread.sleep(tipoEspera * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cargarImagenFile(String xpath,String ruta){
		WebElement fileInput = getDriver().findElement(By.xpath(xpath));
		File file = new File(ruta);
		String absolutePath = file.getAbsolutePath();
		fileInput.sendKeys(absolutePath);
	}

	public String obtnerMensaje(WebElement webelement, int intentos) {
		boolean flag = false;
		String mensajeConfirmacion = "";
		flag = confirmarElementoActivo(3, webelement);
		System.out.println("flag " + flag);
		if (flag == true) {
			mensajeConfirmacion = webelement.getText();
		} else {
			mensajeConfirmacion = "No se recibio mensaje";
		}
		return mensajeConfirmacion;
	}

	public boolean confirmarElementoActivo(int intentos, WebElement elemento) {
		int contador = 0;
		System.out.println("Espera Elemento : " + elemento.toString());
		Serenity.takeScreenshot();
		boolean confirmacion = true;
		while (element(elemento).isEnabled() == false) {
			confirmacion = false;
			contador++;
			if (element(elemento).isEnabled() == true) {
				System.out.println("Se encuentra elemento");
				confirmacion = true;
				break;
			}
			if (element(elemento).isEnabled() == true || contador == intentos) {
				System.out.println("Se encuentra elemento o contador finalizo");
				break;
			} else {
				esperarSegundos(1);
				System.out.println("contador: " + contador + elemento);
			}
		}
		return confirmacion;
	}

	/**
	 * Metodo espera a que elemento sea visibile en el dom, segun su xpath.
	 *
	 * @param tiempo_seg
	 * @param xpath
	 */
	public void esperar_visibilidad_elemento(int tiempo_seg, final String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tiempo_seg));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void navegarDentroIframe(String xpath) {
		withAction().moveToElement(find(By.xpath(xpath))).perform();
		WebElement iframe = getDriver().findElement(By.xpath(xpath));
		getDriver().switchTo().frame(iframe);
	}

	public void navegarDentroPopUp(String xpath) {
		withAction().moveToElement(find(By.xpath(xpath))).perform();
		WebElement popUp = getDriver().findElement(By.xpath(xpath));
		getDriver().switchTo().frame(popUp);
	}

	public String concatenarSimboloMoneda(String dato, String moneda) {
		String valorConcatenado = "";
		if (moneda == "PEN") {
			valorConcatenado = "S/ " + dato;
			System.out.println("ValorConcatenado:" + valorConcatenado);
		} else {
			valorConcatenado = "USD " + dato;
		}
		return valorConcatenado;
	}

	public String concatenarSimboloMoneda2(String dato, String moneda) {
		String valorConcatenado = "";
		if (moneda == "PEN") {
			valorConcatenado = "S/" + dato;
			System.out.println("ValorConcatenado:" + valorConcatenado);
		} else {
			valorConcatenado = "USD " + dato;
		}
		return valorConcatenado;
	}

	public String extraerValor(String texto) {
		Pattern pattern = Pattern.compile("\\d+\\.\\d{2}");
		Matcher matcher = pattern.matcher(texto);
		if (matcher.find()) {
			return matcher.group(0);
		} else {
			return null;
		}
	}

	public String convertirFormatoPagoQR(String texto) {
		Pattern pattern = Pattern.compile("S/(\\d+)");
		Matcher matcher = pattern.matcher(texto);
		if (matcher.find()) {
			String numero = matcher.group(1);
			double valor = Double.parseDouble(numero);
			String valorFormateado = String.format("%.2f", valor);
			String textoFinal = "S/ " + valorFormateado;
			return textoFinal;
		} else {
			return texto;
		}
	}

	public static void tabAndClickCheckBox(WebDriver driver, WebElement webElement) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		//webElement.click();
	}

	public void pressSpaceKeyOnCheckbox(WebDriver driver, WebElement webElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).sendKeys(" ").build().perform();
	}

	public int randomNumber(String tipo) {
		int numero = 0;
		switch (tipo) {
			case "correo":
				numero = random.nextInt(90000) + 10000;
				break;
			case "dni":
				numero = random.nextInt(9000000) + 1000000;
				break;
			case "movil":
				numero = random.nextInt(90000000) + 10000000;
				break;
			default:
				System.out.println("Opción no reconocida");
		}
		return numero;
	}

	public String randomPhone(String movil) {
		String nuevoMovil = "";
		int index = movil.indexOf('9');
		if (index != -1) {
			String parteAntesDel9 = movil.substring(0, index + 1);
			nuevoMovil = parteAntesDel9 + randomNumber("movil");
		} else {
			System.out.println("No se encontro ningún elemento");
		}
		return nuevoMovil;
	}

	public String randomatoINgresoTexto(String valor) {
		String nuevaCadena = "";
		int indiceN = valor.indexOf('V');
		if (indiceN != -1) {
			String parteAntesDelV = valor.substring(0, indiceN + 1);
			nuevaCadena = parteAntesDelV + generateLetters(4);
		} else {
			System.out.println("La letra 'V' no se encontró en la cadena.");
		}
		return nuevaCadena;
	}

	public static String generateLetters(int longitud) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < longitud; i++) {
			int numeroAleatorio = random.nextInt(26);
			char letraAleatoria = (char) (numeroAleatorio + 97);
			sb.append(letraAleatoria);
		}
		return sb.toString();
	}


	public String randomEmail(String correo) {
		String[] partes = correo.split("@");
		String dominio = partes[1];
		String parteLocalConNumero = generateLetters(4) + randomNumber("correo");
		return parteLocalConNumero + "@" + dominio;
	}

	public String randomDni(String dni) {
		String nuevoDni = "";
		int index = dni.indexOf('3');
		if (index != -1) {
			String parteAntesDel7 = dni.substring(0, index + 1);
			nuevoDni = parteAntesDel7 + randomNumber("dni");
		} else {
			System.out.println("No se encontro ningún elemento");
		}
		return nuevoDni;
	}

	public String randomNameLastAliaPass(String valor) {
		String nuevaCadena = "";
		int indiceN = valor.indexOf('V');
		if (indiceN != -1) {
			String parteAntesDelV = valor.substring(0, indiceN + 1);
			nuevaCadena = parteAntesDelV + generateLetters(4);
		} else {
			System.out.println("La letra 'V' no se encontró en la cadena.");
		}
		return nuevaCadena;
	}

	public void esperaImplicita(String webElement, int time) {
		getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		element(webElement).click();
	}

	public boolean seMuestra(String e) {
		{
			try {
				esperar_visibilidad_elemento(15, e);
				return true;
			} catch (Exception ex) {
				System.out.println(ex);
				return false;
			}
		}
	}

	public void HacerScroll(String elemento){
		JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
		WebElement element = Serenity.getDriver().findElement(By.xpath(elemento));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public boolean seMuestraCorto(String e) {
		{
			try {
				esperar_visibilidad_elemento(1, e);
				return true;
			} catch (Exception ex) {
				return false;
			}
		}
	}
	public String obtenerValorLuegoEspacioFinal(String valor) {

		int espacioIndex = valor.lastIndexOf(' ');
		String fecha = valor.substring(espacioIndex + 1);
		return fecha;
	}

	public String fechaActual() {
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
		String fechaFormateada = fechaActual.format(formatter);
		return fechaFormateada;
	}

	private static LocalDate parseFecha(String fechaStr) {
		int anioActual = LocalDate.now().getYear();

		String fechaCompletaStr = fechaStr + "/" + anioActual;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate fecha = LocalDate.parse(fechaCompletaStr, formatter);
		return fecha;
	}

	public String calcularDiferenciaFecha(String fechaPromo) {
		LocalDate fechaActual = parseFecha(fechaActual());
		LocalDate fechaSorteo = parseFecha(fechaPromo);

		long diferenciaDias = ChronoUnit.DAYS.between(fechaSorteo, fechaActual);

		String diferenciaDiasStr = String.valueOf(diferenciaDias);

		return diferenciaDiasStr;
	}

	public String fechaFormatoDiaMesMinuscula(String valor) {

		Pattern pattern = Pattern.compile("\\b(?:(?:lunes|martes|miércoles|jueves|viernes|sábado|domingo) \\d{2} de (?:enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre))\\b");
		Matcher matcher = pattern.matcher(valor);

		String fecha = null;
		if (matcher.find()) {
			fecha = matcher.group();
		}

		String regex = "(\\d{1,2}) de ([a-zA-Z]+)";

		java.util.regex.Pattern patron = java.util.regex.Pattern.compile(regex);
		matcher = patron.matcher(fecha);

		String dia = "";
		String mes = "";

		if (matcher.find()) {
			dia = matcher.group(1);
			mes = matcher.group(2);
		}

		String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
		int mesNumerico = java.util.Arrays.asList(meses).indexOf(mes.toLowerCase()) + 1;

		String fechaFormateada = dia + "/" + String.format("%02d", mesNumerico);

		return fechaFormateada;
	}

	public String fechaFormatoDiaMesMayuscula(String valor) {

		Pattern pattern = Pattern.compile("\\b(?:(?:Lunes|Martes|Miércoles|Jueves|Viernes|Sábado|Domingo) \\d{2} de (?:enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre))\\b");
		Matcher matcher = pattern.matcher(valor);

		String fecha = null;
		if (matcher.find()) {
			fecha = matcher.group();
		}

		String regex = "(\\d{1,2}) de ([a-zA-Z]+)";

		java.util.regex.Pattern patron = java.util.regex.Pattern.compile(regex);
		matcher = patron.matcher(fecha);

		String dia = "";
		String mes = "";

		if (matcher.find()) {
			dia = matcher.group(1);
			mes = matcher.group(2);
		}

		String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
		int mesNumerico = java.util.Arrays.asList(meses).indexOf(mes.toLowerCase()) + 1;

		String fechaFormateada = dia + "/" + String.format("%02d", mesNumerico);

		return fechaFormateada;
	}

	public boolean VerificarIntervaloFecha(String fechaInicial, String fechaFinal) {

		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
		String fechaActualStr = fechaActual.format(formatter);

		if (fechaActualStr.compareTo(fechaInicial) >= 0 && fechaActualStr.compareTo(fechaFinal) <= 0) {
			System.out.println("La fecha de hoy está dentro del intervalo.");
			return true;
		} else {
			System.out.println("La fecha de hoy está fuera del intervalo.");
			return false;
		}
	}

	public void pruebaExtraer(String promo) {
		esperarSegundos(8);
		List<WebElement> filas = driver.findElements(By.xpath("//table[@class='table table-hover table-light']/tbody/tr"));
		for (WebElement fila : filas) {
			String textoColumna1 = fila.findElement(By.xpath("./td[1]")).getText();
			String texto = promo + " Avance";
			String texto2 = promo + " AVANCE";
			String monto;
			String posicion;
			String puntos;
			String opcionesCanjear;
			String opcionesPorCanjear;
			String MontoPEN;
			switch (promo) {
				case "FESTIVAL":
					if (textoColumna1.contains(promo)) {
						String clasifico = valorFestival(fila);
						GuardadoDatos.getInstancia().GuardarDatos1(clasifico);
					}
					break;
				case "Torneo de Mesas":
					if (textoColumna1.contains(promo)) {
						monto = valorMonto(fila);
						MontoPEN = concatenarSimboloMoneda2(monto, "PEN");
						posicion = valorPosicion(fila);
						puntos = valorPuntosTorneo(fila);
						GuardadoDatos.getInstancia().GuardarDatos3(promo, MontoPEN, posicion, puntos);
					}
					break;
				case "Mega Torneo":
					if (textoColumna1.contains(texto)) {
						monto = valorMonto(fila);
						MontoPEN = concatenarSimboloMoneda2(monto, "PEN");
						posicion = valorPosicion(fila);
						puntos = valorPuntosTorneo(fila);
						GuardadoDatos.getInstancia().GuardarDatos3(promo, MontoPEN, posicion, puntos);
					}
					break;
				case "Top Atlantic":
					if (textoColumna1.contains(texto)) {
						monto = valorMonto(fila);
						MontoPEN = concatenarSimboloMoneda2(monto, "PEN");
						posicion = valorPosicion(fila);
						puntos = valorPuntosTorneo(fila);
						GuardadoDatos.getInstancia().GuardarDatos3(promo, MontoPEN, posicion, puntos);
					}
					break;
				case "TORNEO WINNERS":
					if (textoColumna1.contains(texto2)) {
						monto = valorMonto(fila);
						MontoPEN = concatenarSimboloMoneda2(monto, "PEN");
						posicion = valorPosicion(fila);
						GuardadoDatos.getInstancia().GuardarDatos2(promo, MontoPEN, posicion);
					}
					break;
				case "Atlantic VIP":
					if (textoColumna1.contains(texto)) {
						monto = valorMonto(fila);
						MontoPEN = concatenarSimboloMoneda2(monto, "PEN");
						opcionesCanjear = valorOpcionesCanjeadas(fila);
						opcionesPorCanjear = valorOpcionesPorCanjear(fila);
						puntos = valorPuntos(fila);
						GuardadoDatos.getInstancia().GuardarDatos4(promo, MontoPEN, opcionesCanjear, opcionesPorCanjear, puntos);
					}
					break;
				case "Sorteo estelar":
					if (textoColumna1.contains(texto)) {
						monto = valorMonto(fila);
						MontoPEN = concatenarSimboloMoneda2(monto, "PEN");
						opcionesCanjear = valorOpcionesCanjeadas(fila);
						opcionesPorCanjear = valorOpcionesPorCanjear(fila);
						puntos = valorPuntos(fila);
						GuardadoDatos.getInstancia().GuardarDatos4(promo, MontoPEN, opcionesCanjear, opcionesPorCanjear, puntos);
					}
					break;
				case "Sorteo de tus Sueños":
					if (textoColumna1.contains(texto)) {
						monto = valorMonto(fila);
						MontoPEN = concatenarSimboloMoneda2(monto, "PEN");
						opcionesCanjear = valorOpcionesCanjeadas(fila);
						opcionesPorCanjear = valorOpcionesPorCanjear(fila);
						puntos = valorPuntos(fila);
						GuardadoDatos.getInstancia().GuardarDatos4(promo, MontoPEN, opcionesCanjear, opcionesPorCanjear, puntos);
					}
					break;
				case "Torneo de Cuotas":
					if (textoColumna1.contains(texto)) {
						monto = valorMonto(fila);
						MontoPEN = concatenarSimboloMoneda2(monto, "PEN");
						posicion = valorPosicion(fila);
						puntos = valorPuntosTorneo(fila);
						GuardadoDatos.getInstancia().GuardarDatos3(promo, MontoPEN, posicion, puntos);
					}
					break;
			}
		}
	}

	public String valorMonto(WebElement fila) {
		String textoColumna2 = fila.findElement(By.xpath("./td[2]")).getText();
		String[] lineas = textoColumna2.split("\n");

		String monto = obtenerValor(lineas[0]);

		System.out.println("Monto Ganado: " + monto);
		return monto;
	}

	public String valorPosicion(WebElement fila) {
		String textoColumna2 = fila.findElement(By.xpath("./td[2]")).getText();
		String[] lineas = textoColumna2.split("\n");

		String posicion = obtenerValor(lineas[1]);

		System.out.println("Posición: " + posicion);
		return posicion;
	}

	public String valorOpcionesPorCanjear(WebElement fila) {
		String textoColumna2 = fila.findElement(By.xpath("./td[2]")).getText();
		String[] lineas = textoColumna2.split("\n");

		String posicion = obtenerValor(lineas[1]);

		System.out.println("Opciones por Canjear: " + posicion);
		return posicion;
	}

	public String valorPuntosTorneo(WebElement fila) {
		String textoColumna2 = fila.findElement(By.xpath("./td[2]")).getText();
		String[] lineas = textoColumna2.split("\n");

		String puntos = obtenerValor(lineas[2]);

		System.out.println("Puntos: " + puntos);
		return puntos;
	}

	public String valorOpcionesCanjeadas(WebElement fila) {
		String textoColumna2 = fila.findElement(By.xpath("./td[2]")).getText();
		String[] lineas = textoColumna2.split("\n");

		String puntos = obtenerValor(lineas[2]);

		System.out.println("Opciones Canjeadas : " + puntos);
		return puntos;
	}

	public String valorPuntos(WebElement fila) {
		String textoColumna2 = fila.findElement(By.xpath("./td[2]")).getText();
		String[] lineas = textoColumna2.split("\n");

		String puntos = obtenerValor(lineas[3]);

		System.out.println("Puntos: " + puntos);
		return puntos;
	}

	public String valorFestival(WebElement fila) {
		String textoColumna2 = fila.findElement(By.xpath("./td[2]")).getText();
		String[] lineas = textoColumna2.split("\n");

		String clasifico = obtenerClasificacion(lineas[0]);

		System.out.println("YA CLASIFICO: " + clasifico);
		return clasifico;
	}

	private String obtenerValor(String linea) {
		String[] partes = linea.split("\\s+");
		return partes[partes.length - 1];
	}

	private String obtenerClasificacion(String linea) {
		String[] partes = linea.split("YA CLASIFICÓ: ");
		if (partes.length > 1) {
			return partes[1].trim();
		} else {
			return "";
		}
	}

	public String ExtraerWebsol(String xpath) {
		String cadena2 = xpath;
		Pattern pattern = Pattern.compile("((SORTEO [A-ZÑ]+)|([A-Z\\sÑ]+)):\\s*([^:]+?)\\s+(?:opc\\.|Puesto:\\s*(\\d+))(?:\\s|$)");

		Matcher matcher = pattern.matcher(cadena2);

		StringBuilder result = new StringBuilder();

		// Bucle para encontrar y almacenar los datos de cada título
		while (matcher.find()) {
			String titulo = matcher.group(2) != null ? matcher.group(2).trim() : matcher.group(3).trim();
			String dato = matcher.group(4).trim();
			String puesto = matcher.group(5);

			// Agregar los datos al resultado
			if (puesto != null) {
				result.append(titulo).append(": ").append(dato).append("\n");
				result.append("Puesto ").append(titulo).append(": ").append(puesto).append("\n");
			} else {
				result.append(titulo).append(": ").append(dato).append("\n");
			}
		}
		System.out.println(result.toString());
		String dato = result.toString();
		return dato;

	}
	public void GuardarDatosWebsol(String promo,String xpath){
		String datos = PageObjectUtil.getInstancia().obtenerTexto(xpath);
		String dato = ExtraerWebsol(datos);
		String[] lineas = dato.split("\n");


		for (String linea : lineas) {
			String[] partes = linea.split(":");

			String titulo = partes[0].trim();

			String contenido = partes[1].trim();

			System.out.println(titulo+": "+contenido);

			if (titulo.equals(promo)){
				String titulo2 = titulo;
				System.out.println("funciona "+ titulo2);
				GuardadoDatos.getInstancia().GuardarDatoWebSol(titulo,contenido);
			}
		}
	}

}
