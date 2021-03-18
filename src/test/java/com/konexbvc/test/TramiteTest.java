package com.konexbvc.test;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.konexbvc.test.utils.Listeners.TestListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
@Epic("Gestion Tramites KonexBVC")
@Feature("Crear y Consultar Tramites")

public class TramiteTest extends BaseTest {
public Properties fileprops = new Properties();
	
	public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        return fileprops;
    }
	
	@Test(priority=0, description="Crear Tramite Portal Konexbvc")
    @Severity(SeverityLevel.NORMAL)
    @Description("Crear Tramite")
    @Story("Crear Tramite")
    @TmsLink("XRPRJ-1")
    public void registrarTramite () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		registro.seleccionarRegistroTramite()
		.ingresarDatos(getProperties().getProperty("nombre"),
				       getProperties().getProperty("correo"),
				       getProperties().getProperty("tramite"),
				       getProperties().getProperty("solicitud")
				       )
		.guardarTramite()		
		.comprobarResultadoCorrecto();        
        
    }
	
	@Test(priority=1, description="Consultar Tramite Portal Konexbvc")
    @Severity(SeverityLevel.NORMAL)
    @Description("Consultar Tramite")
    @Story("Consultar Tramite")
    @TmsLink("XRPRJ-1")
    public void consultarTramite () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		registro.consultarTramite(getProperties().getProperty("consultaTramite"))		
		.comprobarResultadoCorrectoConsultaTramite();        
        
    }
	
	@Test(priority=2, description="Consultar Numero de Tramite en el correo electronico")
    @Severity(SeverityLevel.NORMAL)
    @Description("Consultar Tramite Correo")
    @Story("Consultar Tramite Correo")
    @TmsLink("XRPRJ-1")
    public void consultarTramiteCorreo () throws Exception {
		home.irPortal(getProperties().getProperty("url"));
		registro.seleccionarRegistroTramite()
		.ingresarDatos(getProperties().getProperty("nombre"),
				       getProperties().getProperty("correo"),
				       getProperties().getProperty("tramite"),
				       getProperties().getProperty("solicitud")
				       )
		.guardarTramite();
		home.irPortal(getProperties().getProperty("urlCorreo"));
		registro.validarCorreo(getProperties().getProperty("correoTramite"));        
        
    }

}
