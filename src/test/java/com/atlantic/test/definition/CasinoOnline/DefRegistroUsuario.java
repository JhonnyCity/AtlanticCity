package com.atlantic.test.definition.CasinoOnline;
import atlantic.CasinoOnline.step.StepRegistroUsuario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DefRegistroUsuario {
    @Steps
    StepRegistroUsuario stepRegistroUsuario;

    @When("le doy clic en el botón Registrarse")
    public void le_doy_clic_en_el_botón_registrarse() {
        // Write code here that turns the phrase above into concrete actions
        stepRegistroUsuario.seleccionarBotonRegistrar();
    }
    @When("completo los datos del usuario segun el {string} {string}")
    public void completo_los_datos_del_usuario_segun_el(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String, String>> datosUsuario = dataTable.asMaps(String.class, String.class);
        String nom =datosUsuario.get(0).get("Nombres");
        String apeP =datosUsuario.get(0).get("PrimerApellido");
        String apeM =datosUsuario.get(0).get("SegundoApellido");
        String email =datosUsuario.get(0).get("Correo");
        String dni =datosUsuario.get(0).get("NumeroDoc");
        String telefono =datosUsuario.get(0).get("Celular");
        String codPromo =datosUsuario.get(0).get("CodigoPromo");
        stepRegistroUsuario.completarDatosUsuario(
                nom,apeP,apeM,email,dni,telefono,codPromo
        );

        stepRegistroUsuario.seleccionarBotonSiguientePasoDos();
        stepRegistroUsuario.seleccionarCheckPrimerPaso();
    }
    @When("completo la informacion del codigo sms")
    public void completo_la_informacion_del_codigo_sms() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Código SMS");
        stepRegistroUsuario.completarCodigoSMS();
    }
    @When("ingreso la información del codigo sms por tres veces")
    public void ingreso_la_información_del_codigo_sms_por_tres_veces() {
        // Write code here that turns the phrase above into concrete actions
        stepRegistroUsuario.seleccionarBotonValidarSMS();
        stepRegistroUsuario.completarCodigoSMSTresVeces();
    }
    @When("hago clic en el botón {string}")
    public void hago_clic_en_el_botón(String string) {
        // Write code here that turns the phrase above into concrete actions
        stepRegistroUsuario.seleccionarBotonSiguientePasoTres();
    }
    @When("completo el registro de la cuenta segun el {string}")
    public void completo_el_registro_de_la_cuenta_segun_el(String string, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        List<Map<String, String>> datosUsuarioAlias = dataTable.asMaps(String.class, String.class);
        String alias =datosUsuarioAlias.get(0).get("Alias");
        String clave =datosUsuarioAlias.get(0).get("Clave");
        stepRegistroUsuario.ingresarAlias(alias,clave);
        stepRegistroUsuario.seleccionarBono();

    }
    @When("hago clic en el botón Finalizar")
    public void hago_clic_en_el_botón_finalizar() {
        // Write code here that turns the phrase above into concrete actions
        stepRegistroUsuario.seleccionarFinalizar();
    }
    @Then("se muestra el mensaje {string} en la página de Genial ya tienes tu cuenta")
    public void se_muestra_el_mensaje_en_la_página_de_genial_ya_tienes_tu_cuenta(String mensaje) {
        // Write code here that turns the phrase above into concrete actions
        String mensajeEsperado=mensaje;
        String mensajeObtenido= stepRegistroUsuario.extraerTextoRespuestaCuentaCreada();
        assertEquals(mensajeObtenido,mensajeEsperado);
    }
    @Then("hago clic en el botón Depositar luego")
    public void hago_clic_en_el_boton_depositar_luego() {
        // Write code here that turns the phrase above into concrete actions
        stepRegistroUsuario.seleccionarBotonDepositarLuego();
    }
    @Then("se redirige a la home de la vertical {string}")
    public void se_redirige_a_la_home_de_la_vertical(String string) {
        // Write code here that turns the phrase above into concrete actions
        stepRegistroUsuario.validarVisibilidadElement();
    }
}
