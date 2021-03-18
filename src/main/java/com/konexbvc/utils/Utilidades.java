package com.konexbvc.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.konexbvc.pages.BasePage;

import io.qameta.allure.Attachment;

public class Utilidades extends BasePage {
	//private static WebDriver driver;
	
	public Utilidades(WebDriver driver) {
		super(driver);
		
		}

    public static void waitInMs(Integer milliseconds)  {
        try {
           Thread.sleep(milliseconds);
        } catch (Exception e) {}
    }
    
    public static void seleccionarKeyBoard(WebElement field) {
		field.sendKeys(Keys.UP);	
	    field.click();
		field.sendKeys(Keys.ENTER);
		
	}
    
   public static void takeSnapShot(WebDriver webdriver, String nombrePantalla) throws IOException {
	   try {
    	Calendar calendario = Calendar.getInstance();
    	int  hora, minutos, segundos;
    	hora =calendario.get(Calendar.HOUR_OF_DAY);
    	minutos = calendario.get(Calendar.MINUTE);
    	segundos = calendario.get(Calendar.SECOND);
    	
    	File screenshotFile =((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
    	File f= new File("C:\\Users\\505GT\\eclipse-workspace\\shopperAllure\\allure-results\\"+nombrePantalla+hora+minutos+segundos+".png");
    	com.google.common.io.Files.copy(screenshotFile, f);
    
	    
           } catch (Exception e) {}
	   }
   @Attachment(value = "Screenshot", type = "image/png")
   public static byte[] screenshot() {
       return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
   }

}

