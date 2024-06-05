package com.atlantic.test.definition.CasinoOnline;

import atlantic.CasinoOnline.step.StepDeposito;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import static org.junit.Assert.assertEquals;

public class DefDepositoTarjeta extends StepDeposito{

    @Steps
    StepDeposito stepDeposito;


    @When("Acepto términos y condiciones de depósito")
    public void acepto_términos_y_condiciones_de_depósito() {
        // Write code here that turns the phrase above into concrete actions
       stepDeposito.seleccionarTerminosCondiciones();
        Serenity.takeScreenshot();
    }

    @When("Selecciono botón Siguiente tarjeta")
    public void selecciono_botón_siguiente_tarjeta() {
        // Write code here that turns the phrase above into concrete actions
        stepDeposito.seleccionarBotonSiguiente();
        Serenity.takeScreenshot();
    }

    @When("Selecciono boton Pagar sin agregar tarjeta")
    public void Selecciono_boton_Pagar_sin_agregar_tarjeta() {
        // Write code here that turns the phrase above into concrete actions
        stepDeposito.seleccionarBotonPagarSinAgregarTarjeta();
        Serenity.takeScreenshot();
    }

    @When("Ingreso {string} {string} Ingreso {string}")
    public void ingreso_ingreso(String numerotarjeta, String vencimiento, String cvv) {
        ingresarDatosDeposito(numerotarjeta,vencimiento,cvv);
        Serenity.takeScreenshot();
    }

    @When("Selcciono botón Depositar")
    public void selcciono_botón_depositar() {
        seleccionarBotonDepositar();
        Serenity.takeScreenshot();
    }
    @Then("Se muestra mensaje {string}")
    public void se_muestra_mensaje(String Mensaje) {
        validarMensaje(Mensaje);
    }


}
