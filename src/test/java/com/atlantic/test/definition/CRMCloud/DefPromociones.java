package com.atlantic.test.definition.CRMCloud;

import atlantic.CRMCloud.step.StepCRM;
import atlantic.CasinoOnline.step.StepPromociones;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;

import java.util.List;
import java.util.Map;


public class DefPromociones extends StepCRM {

    @Given("realizo el inicio de sesión con un usuario en CRMCloud")
    public void realizoeliniciodesesiónconunusuarioenCRMCloud() {
        IngresarCRMCloud();
    }
    @When("ingreso los datos del usuario CRM")
    public void ingreso_los_datos_del_usuario(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> datosClientes = dataTable.asMaps(String.class, String.class);
        String usuario =datosClientes.get(0).get("usuario");
        String password =datosClientes.get(0).get("contrasenna");
        ingresarDatosInicioSesion(usuario,password);
        Serenity.takeScreenshot();
    }
    @When("Selecciono Nueva búsqueda")
    public void SeleccionoNuevabúsqueda() {
        seleccionarNuevaBusqueda();
    }
    @When("Ingreso Codigo de invitado {string}")
    public void IngresoCodigodeinvitado(String codInvitado) {
        ingresarCodInvitado(codInvitado);
    }
    @When("Selecciono buscar invitado")
    public void Seleccionobuscarinvitado() {
        seleccionarBuscarInvitado();
        Serenity.takeScreenshot();
    }
    @When("Selecciono el botón Perfil de la primera opción")
    public void SeleccionoelbotónPerfildelaprimeraopción() {
        seleccionarBotonPerfil();
        Serenity.takeScreenshot();
    }
    @Then("Extraer Datos {string}")
    public void ExtraerDatos(String promo) {
        extraerDatos(promo);
        Serenity.takeScreenshot();
    }
}
