package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

//      Move To element
//        WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList"));
//        actions.moveToElement(element).build().perform();

//      Click on searchBox and type mobile in capital letters using keyboard shift and enter
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        actions.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("mobile").keyUp(Keys.SHIFT).sendKeys(Keys.ENTER).build().perform();

//      Right click (contextClick())
        actions.moveToElement(searchBar).click().contextClick().keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();

//      select the text
//        actions.moveToElement(searchBar).sendKeys("Mobile").doubleClick().build().perform();


        // Select text all using Actions
        WebElement input = driver.findElement(By.id("yourInputId"));
        actions.moveToElement(input).click().sendKeys("Date").keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL).build().perform();


        // Select text all using Keys.chord without actions class
        WebElement inputtest = driver.findElement(By.id("yourInputId"));
        inputtest.click(); // focus the input
        inputtest.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }
}
