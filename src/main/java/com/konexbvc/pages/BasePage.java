package com.konexbvc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }

    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    public WebElement getElement(By element) {
        return driver.findElement(element);
    }
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }
    public void clear(By elementLocation) {
    	driver.findElement(elementLocation).clear();
    }

}