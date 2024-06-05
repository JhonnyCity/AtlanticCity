package com.atlantic.test.definition.CasinoOnline;

import atlantic.CasinoOnline.step.StepHome;
import atlantic.CasinoOnline.step.StepPromociones;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;

public class DefHome extends StepHome {
    @Given("Realizo el acceso a la vista {string}")
    public void Realizoelaccesoalavista(String vista) {
        redirrecionamientoVista(vista);
        Serenity.takeScreenshot();
    }
    @Then("visualizo al cabecera de la {string}")
    public void visualizoalcabeceradela(String vista) {
        validacioCabecera(vista);
        Serenity.takeScreenshot();
    }
    @Then("visualizo el contenido de la {string}")
    public void visualizoelcontenidodela(String vista) {
        validacionContenido(vista);
        Serenity.takeScreenshot();
    }
    @Then("visualizo el footer de la {string}")
    public void visualizoelfooterdela(String vista) {
        validacionFooter(vista);
        Serenity.takeScreenshot();
    }

    @Then("visualizo al cabecera de la {string} LG")
    public void visualizoalcabeceradelaLG(String vista) {
        validacioCabeceraLG(vista);
        Serenity.takeScreenshot();
    }
    @Then("visualizo el contenido de la {string} LG")
    public void visualizoelcontenidodelaLG(String vista) {
        validacionContenidoLG(vista);
        Serenity.takeScreenshot();
    }
    @Then("visualizo el footer de la {string} LG")
    public void visualizoelfooterdelaLG(String vista) {
        validacionFooterLG(vista);
        Serenity.takeScreenshot();
    }
    @When("Selecciono maquina para jugar")
    public void Seleccionomaquinaparajugar() {
        SeleccionarMaquina();
        Serenity.takeScreenshot();
    }
    @When("Validar acceso maquina")
    public void Validaraccesomaquina() {
        accesoMaquina();
        Serenity.takeScreenshot();
    }

    @When("Selecciono icono datos personales")
    public void Seleccionoiconodatospersonales() {
        seleccionarIconoDatosPersonales();
        Serenity.takeScreenshot();
    }
    @When("Selecciono boton perfil")
    public void Seleccionobotonperfil() {
        seleccionarPerfil();
        Serenity.takeScreenshot();
    }
    @When("Selecciono el boton Verificar identidad")
    public void SeleccionoelbotonVerificaridentidad() {
        seleccionarBotonVerificarIdentidad();
        Serenity.takeScreenshot();
    }
    @When("Visualizamos el estado de los documentos pendientes")
    public void Visualizamoselestadodelosdocumentospendientes() {
        visualizaBotonAgregarDocumento();
        visualizarBotonAgregarCuenta();
        visualizarBotonValidarNumero();
        Serenity.takeScreenshot();
    }
    @When("Agregamos documento de identidad")
    public void Agregamosdocumentodeidentidad() {
        seleccionarBotonAgregarDocumento();
        Serenity.takeScreenshot();
    }
    @When("Agregamos imagen dni delantera")
    public void Agregamosimagendnidelantera() {
        seleccionarBotonAgregarimagenFrontal();
        Serenity.takeScreenshot();
    }
    @When("Agregamos imagen dni posterior")
    public void Agregamosimagendniposterior() {
        seleccionarBotonAgregarimagenPosterior();
        Serenity.takeScreenshot();
    }
    @When("Agregamos documento bancario")
    public void Agregamosdocumentobancario() {
        seleccionarAgregarDocumentoBancario();
        Serenity.takeScreenshot();
    }
    @Then("Validamos la visualizacion del boton enviar")
    public void Validamoslavisualizaciondelbotonenviar() {
        ValidamosBotonEnviar();
        Serenity.takeScreenshot();
    }
    @When("Selecciono boton retirar")
    public void Seleccionobotonretirar() {
        seleccionarBotonRetirar();
        Serenity.takeScreenshot();
    }
    @When("Selecciono transferencia bancaria")
    public void Seleccionotransferenciabancaria() {
        seleccionarTransferenciaBancaria();
        Serenity.takeScreenshot();
    }
    @When("Ingresamos monto de retiro {string}")
    public void Ingresamosmontoderetiro(String monto) {
        ingresamosMontoRetiro(monto);
        Serenity.takeScreenshot();
    }
    @Then("Validamos boton de continuar retiro")
    public void Validamosbotondecontinuarretiro() {
        VisualizarBotonContinuarRetiro();
        Serenity.takeScreenshot();
    }
}
