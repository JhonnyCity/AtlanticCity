package com.atlantic.test.definition.CRMSolOnline;

import atlantic.util.GuardadoDatos;
import atlantic.util.PageObjectUtil;
import atlantic.util.UtilDef;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class comparacionData {
    protected GuardadoDatos guardadoDatos = GuardadoDatos.getInstancia();

    @Given("Validacion comparacion online,websol,crm en la {string}")
    public void Validacioncomparaciononlinwebsolcrm(String promos) {
        guardadoDatos.ExtraerPuntosWebsol(promos);
    }
}
