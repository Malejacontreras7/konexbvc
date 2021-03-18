package com.konexbvc.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.konexbvc.pages.HomePage;

import com.konexbvc.pages.TramitePage;

public class BaseTest {

    public WebDriver driver;
    
    public HomePage home;
    public TramitePage registro;
 
    
    

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void inicializar() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1000,1000");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        home = new HomePage(driver);
        registro = new TramitePage(driver);
        
        
    }

    @AfterMethod
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

}
