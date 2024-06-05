package com.atlantic.test.definition.webSol;

import atlantic.CasinoOnline.step.StepPromociones;
import atlantic.webSol.step.StepWebsol;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;

import java.util.List;
import java.util.Map;


public class DefPromociones extends StepWebsol {
    @Given("realizo el inicio de sesión con un usuario en Websol")
    public void realizoeliniciodesesionconunusuarioenWebsol() {
        IngresarWebsol();
    }
    @When("ingreso los datos del usuario Websol")
    public void ingreso_los_datos_del_usuario(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> datosClientes = dataTable.asMaps(String.class, String.class);
        String usuario =datosClientes.get(0).get("usuario");
        String password =datosClientes.get(0).get("contrasenna");
        ingresarDatosInicioSesion(usuario,password);
        Serenity.takeScreenshot();
    }
    @When("Selecciono Iniciar Sesion")
    public void SeleccionoIniciarSesion() {SeleccionoIniciarSesion();
    }

    @When("Selecciono Buscar Cliente")
    public void Seleccionobuscarinvitado() {
        Seleccionarbuscarinvitado();
        Serenity.takeScreenshot();
    }
    @When("Ingreso Tarjeta de invitado {string}")
    public void IngresoTarjetadeinvitado(String tarInvitado) {
        ingresarTarjetaInvitado(tarInvitado);

    }
    @Then("Extraer Datos Websol {string}")
    public void
    ExtraerDatosWebsol(String promo) {
        extraerDatosWebsol(promo);
        Serenity.takeScreenshot();
    }

}
