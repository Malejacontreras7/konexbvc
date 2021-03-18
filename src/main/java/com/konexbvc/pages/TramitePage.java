package com.konexbvc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.konexbvc.utils.Utilidades;


import io.qameta.allure.Step;

public class TramitePage extends BasePage{
	
	By btnRegistrarTramite = By.xpath("//a[contains(text(),'Registrar Trámite')]");
	By txtNombre = By.id("id_nombre");
	By txtCorreo = By.id("id_correo");
	By cbxTramite = By.id("id_tramite");	
	By txtSolicitud = By.id("id_solicitud");
	By chkAutorizo = By.id("exampleCheck1");
	By btnGuardar = By.xpath("//button[contains(.,'Guardar')]");
	By lblRespuesta = By.xpath("//section[@id='intro']/div/div[2]/ul/li");	
	By txtTramite = By.id("tramite");
	By btnConsultarTramite = By.xpath("//button[contains(.,'Consultar Trámite')]");
	By lblResultEstado = By.xpath("//div[2]/div[2]");
	
	By txtCorreoTramite = By.id("login");
	By btnRefrescar = By.xpath("//input[@value='Revisa el correo']");
	By lblPrimerCorreo = By.xpath("//span[2]");

	public TramitePage(WebDriver driver) {
		super(driver);
		
	}
	
	@Step("Seleccionar Boton Registrar Tramite")
	public TramitePage seleccionarRegistroTramite() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(btnRegistrarTramite);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}	
	
	@Step("Ingresar Datos Registro Tramite")
	public TramitePage ingresarDatos(String nombre, String correo, String tramite,
			                          String solicitud) {
		Utilidades.waitInMs(500);
        writeText(txtNombre, nombre);
        writeText(txtCorreo, correo);
        Select unoSel = new Select(driver.findElement(cbxTramite));
		unoSel.selectByVisibleText(tramite);
        writeText(txtSolicitud, solicitud);
        click(chkAutorizo);
        Utilidades.screenshot();
        
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Guardar Tramite")
	public TramitePage guardarTramite() {
		Utilidades.waitInMs(500);
		Utilidades.screenshot();
        click(btnGuardar);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}	
	
	@Step("Validar Resultado Tramite Creado")
    public TramitePage comprobarResultadoCorrecto() {
        Utilidades.waitInMs(1000);
        Utilidades.screenshot();
        String resultado=getElement(lblRespuesta).getText();
        Assert.assertEquals(getElement(lblRespuesta).getText(), resultado);
        Utilidades.screenshot();
        return this;
    }
	
	@Step("Consultar Estado de Tramite")
	public TramitePage consultarTramite(String numeroTramite) {
		Utilidades.waitInMs(500);
        writeText(txtTramite, numeroTramite);  
        Utilidades.screenshot();
        click(btnConsultarTramite);
        Utilidades.screenshot();        
        Utilidades.waitInMs(500);
		return this;
	}
	
	@Step("Validar Resultado Consulta Tramite")
    public TramitePage comprobarResultadoCorrectoConsultaTramite() {
        Utilidades.waitInMs(1000);
        Utilidades.screenshot(); 
        String resultado=getElement(lblResultEstado).getText();
        Assert.assertEquals(getElement(lblResultEstado).getText(), resultado);
        Utilidades.screenshot();
        return this;
    }
	
	@Step("Validar Correo Electronico")
	public TramitePage validarCorreo(String correo) {
		Utilidades.waitInMs(500);
		clear(txtCorreoTramite);
        writeText(txtCorreoTramite, correo);  
        Utilidades.screenshot();
        click(btnRefrescar);
        Utilidades.screenshot(); 
        click(lblPrimerCorreo);
        Utilidades.screenshot();
        Utilidades.waitInMs(500);
		return this;
	}
	
	
}
