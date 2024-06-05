package com.atlantic.test.definition.CasinoOnline;

import atlantic.CasinoOnline.step.StepIniciar_Sesion;
import atlantic.CasinoOnline.step.StepPaginaPrincipal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

public class DefIniciar_Sesion {

    @Steps
    private StepIniciar_Sesion stepIniciar_sesion;

    @Steps
    private StepPaginaPrincipal stepPaginaPrincipal;

    @Given("Lingreso a la web del casino")
    public void lingreso_a_la_web_del_casino() {

        stepPaginaPrincipal.abrirPaginaPrincipal();
        Serenity.takeScreenshot();
    }
    @When("Lselecciono la opcion iniciar sesion")
    public void lselecciono_la_opcion_iniciar_sesion() {

        stepIniciar_sesion.seleccionarIniciar_Sesion();
        stepIniciar_sesion.seleccionarIrACasino();
        Serenity.takeScreenshot();
    }
    @When("Lingreso el {string} y {string}")
    public void lingreso_el_y(String usuario, String contrasenna) {

        stepIniciar_sesion.ingresarDatosIniciarSesion(usuario, contrasenna);
        Serenity.takeScreenshot();
    }
    @When("Lselecciono el boton iniciar sesion")
    public void lselecciono_el_boton_iniciar_sesion() {

        stepIniciar_sesion.seleccionarIngresasr();
        Serenity.takeScreenshot();
    }
    @Then("Lse debe mostrar el usuario logueado {string}")
    public void lse_debe_mostrar_el_usuario_logueado(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
}
