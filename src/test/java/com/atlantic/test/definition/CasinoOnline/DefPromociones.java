package com.atlantic.test.definition.CasinoOnline;

import atlantic.CasinoOnline.step.StepIniciarSesion;
import atlantic.CasinoOnline.step.StepPaginaPrincipal;
import atlantic.CasinoOnline.step.StepPromociones;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DefPromociones extends StepPromociones {

    @When("me dirijo a la seccion de Promociones")
    public void medirijoalasecciondePromociones() {
        seleccionarPromociones();
        Serenity.takeScreenshot();
    }
    @Given("realizo limpieza")
    public void realizolimpieza() {
        limpiezajson();
    }
    @When("selecciono la promoción {string}")
    public void seleccionolapromocion(String nombrePromocion) {
        seleccionarPromocion(nombrePromocion);
        Serenity.takeScreenshot();
    }
    @When("Ingreso a la web de la {string}")
    public void Ingresoalawebdela(String nombrePromocion) {
        redirrecionamientoPromo(nombrePromocion);
        Serenity.takeScreenshot();
    }
    @When("se muestra la tabla del ranking  del {string}")
    public void semuestralatabladelrankingdel(String dato) {
        try {
            seleccionarAvance();
            Serenity.takeScreenshot();
        }catch (Exception ex){

        }
    }
    @Then("validar el Premio y el Puesto")
    public void validarelPremioyelPuesto(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> ranking = dataTable.asMaps(String.class, String.class);
        String Puesto1 =ranking.get(0).get("Puesto");
        String Premio1 =ranking.get(0).get("Premio");
        String Puesto2 =ranking.get(1).get("Puesto");
        String Premio2 =ranking.get(1).get("Premio");
        String Puesto3 =ranking.get(2).get("Puesto");
        String Premio3 =ranking.get(2).get("Premio");

        enviarDatosPremio(Puesto1,Premio1);
        enviarDatosPremio(Puesto2,Premio2);
        enviarDatosPremio(Puesto3,Premio3);
        Serenity.takeScreenshot();
    }
    @Then("se muestra la información estática de la promoción con los valores esperados")
    public void semuestralainformaciónestáticadelapromociónconlosvaloresesperados(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> informacion = dataTable.asMaps(String.class,String.class);

        String ValorPremio =informacion.get(0).get("Valor del Premio");
        String TextoFecha =informacion.get(0).get("Texto de Fecha");
        String ValorMulti =informacion.get(0).get("Valor de Multiplicador");
        String TextoParticipar =informacion.get(0).get("Texto Como Participar");
        String TextoCanje =informacion.get(0).get("Texto Canje");

        validarPremio(ValorPremio);
        validarTextoFecha(TextoFecha);
        validarValorMulti(ValorMulti);
        validarTextoParticipar(TextoParticipar);
        validarTextoCanje(TextoCanje);

        Serenity.takeScreenshot();
    }

    @When("Ingreso con el ojito el {string}")
    public void WhenIngresoConElOjitoEl(String idinvitado)
    {
        ingresarIdinvitado(idinvitado);
        Serenity.takeScreenshot();
    }
    @When("Selecciono buscar")
    public void WhenSeleccionoBuscar()
    {
        seleccionarBuscar();
    }

    @When("selecciono la opcion canje")
    public void WhenSeleccionoLaOpcionCanje()
    {
        seleccionarCanje();
    }
    @When("hago clic en la opción Nuevo")
    public void hagoclicenlaopciónNuevo()
    {
        seleccionarNuevo();
    }
    @When("hago clic en la opción Resultados")
    public void hagoclicenlaopciónResultados()
    {
        seleccionarResultado();
    }
    @Then("se valida los resultados de la promocion {string}")
    public void Thensevalidalosresultadosdelapromocion(String promocion)
    {
        validacionResultados(promocion);
    }
    @Then("Se muestran los puntos del sorteo")
    public void ThenSeMuestranLosPuntosDelSorteo()
    {

    }
    @Then("Se muestra las opciones por canjear")
    public void ThenSeMuestraLasOpcionesPorCanjear()
    {

    }
    @Then("Activo todas las promos")
    public void ThenActivotodaslaspromos()
    {
        activarPromos();
    }
    @Then("Se muestra las opciones canjeadas {string}")
    public void ThenSeMuestraLasOpcionesCanjeadas(String promo)
    {
        validarOpcionesCanjeadas(promo);
    }
    @Then("Se muestra el avance actual del torneo {string}")
    public void ThenSeMuestraElAvanceActualDelTorneo(String promo)
    {
        validacionAvanceTorneo(promo);
        Serenity.takeScreenshot();
    }
    @Then("valido las fechas en los cards de todas las {string}")
    public void Thenvalidolasfechasenloscardsdetodaslas(String promocion,io.cucumber.datatable.DataTable dataTable)
    {
        List<Map<String, String>> datosClientes = dataTable.asMaps(String.class, String.class);
        String PCuota =datosClientes.get(0).get("PCuota");
        String PMesas =datosClientes.get(0).get("PMesas");
        String PMega =datosClientes.get(0).get("PMega");
        String PTop =datosClientes.get(0).get("PTop");
        String PVip =datosClientes.get(0).get("PVip");
        String PuntosVip =datosClientes.get(0).get("PuntosVip");
        String PEstelar =datosClientes.get(0).get("PEstelar");
        String PuntosEstelar =datosClientes.get(0).get("PuntosEstelar");
        String PSueños =datosClientes.get(0).get("PSueños");
        String PuntosSueños =datosClientes.get(0).get("PuntosSueños");
        String PDelivery =datosClientes.get(0).get("PDelivery");
        String PWinner =datosClientes.get(0).get("PWinner");
        String TextCardCuota =datosClientes.get(0).get("TextCardCuota");
        String TextCardMesas =datosClientes.get(0).get("TextCardMesas");
        String TextCardMega =datosClientes.get(0).get("TextCardMega");
        String TextCardTop =datosClientes.get(0).get("TextCardTop");
        String[] valores = {PCuota,PMesas,PMega,PTop,PVip,PuntosVip,
                PEstelar,PuntosEstelar,PSueños,PuntosSueños,PDelivery,PWinner
                ,TextCardCuota,TextCardMesas,TextCardMega,TextCardTop};

       validacionFechasCard(promocion,valores);
    }

    @Then("valido las fechas de todas las {string}")
    public void Thenvalidolasfechasdetodaslas(String promocion)
    {
        validacionFechasPromocion(promocion);
    }
    @Then("veo la tarjeta de la promoción {string}")
    public void veolatarjetadelapromoción(String promocion)
    {
        validarExistenciaPromocion(promocion);
    }
    @Then("valido la imagen,textos y boton del delivery")
    public void validolaimagentextosybotondeldelivery()
    {
        validarDatosDelivery();
    }
    @Then("solo veo la tarjeta de la promoción {string}")
    public void soloveolatarjetadelapromoción(String promocion)
    {
        validarExistenciaPromocionNuevo(promocion);
    }
    @Then("y su boton correspondiente")
    public void ysubotoncorrespondiente()
    {
        validarBotonCanjear();
    }
}
