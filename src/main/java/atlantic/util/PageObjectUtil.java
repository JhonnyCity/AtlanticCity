package atlantic.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.*;
public class PageObjectUtil extends PageObject {

	// singleton
	private static PageObjectUtil obj = null;
	private long wdwTimeOut = 5L;


	private WebDriver driver = getDriver();

	private PageObjectUtil() {
	}

	public static PageObjectUtil getInstancia() {
		instanciar();
		return obj;
	}

	private synchronized static void instanciar() {
		if (obj == null) {
			obj = new PageObjectUtil();
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	// singleton
	UtilDef utilDef = new UtilDef();
	JSONObject jsonObject = new JSONObject();

	/**
	 * selenium; lista los elementos DOM encontrados mediante el xpath, para hacer
	 * click en un elemento mediante la posicion
	 *
	 * @param webDriver driver del page actual
	 * @param xpath     xpath a usar
	 * @param pos       posicion del elemento de la lista a usar
	 */
	public void seleniumClick(final String xpath, int pos) {
		utilDef.esperar_visibilidad_elemento(20, xpath);
		By by = By.xpath(xpath);
		List<WebElement> lista = driver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(1.5);
			}
		}
	}
	public void seleccionarComboxpath(WebDriver webDriver, final String path, int valor) {
		By by = By.xpath(path);
		WebElement selectElement = webDriver.findElement(by);
		List<WebElement> options = selectElement.findElements(By.tagName("option"));
		if (valor >= 0 && valor < options.size()) {
			WebElement option = options.get(valor);
			option.click();
			System.out.println("Opción seleccionada: " + option.getText());
		} else {
			System.out.println("Posición fuera de los límites");
		}
	}
	public void seleccionarCombo(WebDriver webDriver, final String path, String valor) {

		WebElement selectElement = webDriver.findElement(By.id(path));
		List<WebElement> options = selectElement.findElements(By.tagName("option"));

		for (WebElement option : options) {
			if (option.getText().contains(valor)) {
				option.click();
				break;
			}
		}
	}
	public void seleccionarComboPosicion(WebDriver webDriver, final String path, int valor) {
		WebElement selectElement = webDriver.findElement(By.id(path));
		List<WebElement> options = selectElement.findElements(By.tagName("option"));

		if (valor >= 0 && valor < options.size()) {
			WebElement option = options.get(valor);
			option.click();
			System.out.println("Opción seleccionada: " + option.getText());
		} else {
			System.out.println("Posición fuera de los límites");
		}
	}

	public void sleep(double seg) {
		long miliseg = (new Double(seg * 1000)).longValue();

		try {
			// System.out.println("sleep:\t\t" + seg + " seg... <--> " + miliseg +
			// "miliseg...");
			Thread.sleep(miliseg);
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void seleniumDobleClick(WebDriver webDriver, String we) {
		Actions actions = new Actions(webDriver);
		actions.doubleClick().build().perform();
		sleep(1.5);
	}

	public void toolkitPegarEnWebElement(WebDriver webDriver, final String path, int pos, String valor, int keyEvent) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(0.25);
				we.clear();
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(valor), null);

				try {
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);

					if (keyEvent != 0) {
						sleep(1.50);
						robot.keyPress(keyEvent);
						robot.keyRelease(keyEvent);
					}
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}

				sleep(1);
			}
		}
	}

	public void scrollJSToElement(WebDriver webDriver, String xpath) {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		WebElement elemento = seleniumWebElement(webDriver, xpath, 0);
		jse.executeScript("arguments[0].scrollIntoView();", elemento);
	}

	public WebElement seleniumWebElement(WebDriver webDriver, final String path, int pos) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			return lista.get(pos);
		}

		return null;
	}

	public void escribirEnObjetosHidden(WebDriver webDriver, final String pathHidden, final String pathInput, int pos,
										String valor) {
		WebElement elemHidden = webDriver.findElement(By.xpath(pathHidden));
		String js = "arguments[0].style.visibility='visible'";
		((JavascriptExecutor) webDriver).executeScript(js, elemHidden);
		List<WebElement> lista = webDriver.findElements(By.xpath(pathInput));

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);
			we.sendKeys(Keys.HOME);

			for (int i = 0; i < 15; i++) {
				we.sendKeys(Keys.DELETE);
			}

			we.sendKeys(valor, Keys.ENTER);
			sleep(3);
		}
	}

	/**
	 * Metodo Obtener texto de un dom
	 *
	 * @param webDriver
	 * @param path
	 * @param pos
	 * @return
	 */
	public String seleniumGetText(WebDriver webDriver, final String path, int pos) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);
		String texto;
		texto = lista.get(pos).getText();
		return texto;
	}

	public String obtenerTexto(final String xpath) {
		By by = By.xpath(xpath);
		WebElement we = driver.findElement(by);
		return we.getText();
	}

	/**
	 * selenium; hacemos click con el WebElement que se pasa
	 *
	 * @param WebElement elemento que se debe usar
	 * @param wdw        wdw es WebDriverWait que se usara para esperar que sea
	 *                   Clickable
	 */
	public void seleniumClick(WebElement element, WebDriverWait wdw) {
		wdw.until(ExpectedConditions.elementToBeClickable(element));
		sleep(0.50);
		element.click();
		sleep(0.50);
	}

	/**
	 * selenium-pwe; escribimos usando el WebElement
	 *
	 * @param item
	 * @param wdw
	 * @param valor
	 * @param key
	 */

	public void seleniumWrite(WebDriver webDriver, final String path, int pos, String valor, Keys key) {
		By by = By.xpath(path);
		List<WebElement> lista = webDriver.findElements(by);

		if (!lista.isEmpty()) {
			WebElement we = lista.get(pos);

			if (we.isDisplayed()) {
				we.click();
				sleep(0.25);
				we.clear();
				we.sendKeys(valor);

				if (key != null) {
					sleep(1.50);
					we.sendKeys(key);
				}

				sleep(1);
			}
		}
	}

	/**
	 * selenium-pwe,seleccionar combo por WebElement
	 *
	 * @param witem
	 * @param contenido
	 * @param path
	 * @param wdw
	 */
	public void seleccionarCombo(WebElement witem, String contenido, String path, WebDriverWait wdw) {
		wdw.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath(path)));
		Select dropdowntv = new Select(witem);
		dropdowntv.selectByVisibleText(contenido);
		sleep(0.5);
	}

	public void seleniumClickinCellTable(WebDriver webDriver, String pathTable, String marca, String modelo,
										 String columna) {
		int columnIndex = getColumnIndexTable(webDriver, pathTable, columna);
		int rowIndex = getRowIndexTable(webDriver, pathTable, marca, modelo);

		String cellXPath = pathTable + "/tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]/a";

		webDriver.findElement(By.xpath(cellXPath)).click();
		;
	}

	public int getRowIndexTable(WebDriver webDriver, String pathTable, String marca, String modelo) {
		List<WebElement> rows = webDriver.findElements(By.xpath(pathTable + "/tbody/tr"));

		for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
			WebElement row = rows.get(rowIndex);
			List<WebElement> cells = row.findElements(By.xpath("td/a"));
			for (int cellIndex = 0; cellIndex < cells.size(); cellIndex++) {
				if (cells.get(cellIndex).getText().equals(marca) && cells.get(cellIndex + 1).getText().equals(modelo)) {
					return rowIndex + 1;
				}
			}

		}
		throw new RuntimeException("La fila con marca " + marca + " no esta en la tabla");
	}

	public int getColumnIndexTable(WebDriver webDriver, String pathTable, String column) {
		List<WebElement> columnHeaders = webDriver.findElements(By.xpath(pathTable + "/thead/tr/th"));
		for (int columnIndex = 0; columnIndex < columnHeaders.size(); columnIndex++) {
			if (columnHeaders.get(columnIndex).getText().equals(column)) {
				return columnIndex + 1;
			}
		}
		throw new RuntimeException("La columna " + column + " no esta en la tabla");
	}

	public void seleniumEscribir(final String path, String valor) {
		utilDef.esperar_visibilidad_elemento(20, path);
		By by = By.xpath(path);
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(valor);
	}

	public void PresionarBotonEnter(){
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	public String fechaFormatoLatinoLargo() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = date.format(formatter);
		return text;


	}


	public void seleccionarClickCheckJavaScript(WebDriver webDriver, String xpath) {
		WebElement boton = webDriver.findElement(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].click();", boton);
	}

	public void desplegarAbajoJAvaScript(WebDriver webDriver, String xpath) {
		WebElement boton = webDriver.findElement(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		executor.executeScript("arguments[0].scrollIntoView(true);", boton);
	}

	public void esperaImplicita(WebDriver webDriver, String xpath) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
		jsExecutor.executeScript("document.evaluate(" + xpath + "," +
				" document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
	}


	public void limpiarTextoCodigoSMS(WebDriver webDriver) {
		((JavascriptExecutor) webDriver).executeScript(
				"var elemento = document.querySelector('.otpInput_inputRow__htlgz'); " +
						"if (elemento) { " +
						"    var inputs = elemento.querySelectorAll('input'); " +
						"    inputs.forEach(function(input) { " +
						"        input.value = ''; " +
						"    }); " +
						"}"
		);
	}

	public static Boolean validarVisibilidadJavaScript(WebDriver webDriver, String element) {
		JavascriptExecutor executor = (JavascriptExecutor) webDriver;
		return (Boolean) executor.executeScript("return arguments[0].offsetWidth > 0 && arguments[0].offsetHeight > 0;", element);
	}

	public void clickElementByJavascript(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public String GuardarSource(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String src = element.getAttribute("src");
		System.out.println(src);
		return src;
	}

	public String GuardarData(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		String style = element.getAttribute("data-test-value");
		System.out.println(style);
		return style;
	}



}
