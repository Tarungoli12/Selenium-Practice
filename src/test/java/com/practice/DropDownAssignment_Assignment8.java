package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DropDownAssignment_Assignment8 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String expectedCountry = "India";
        driver.findElement(By.id("autocomplete")).sendKeys("Ind");

        // Explicit wait for suggestions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@id='ui-id-1']/li/div")
        ));

        List<WebElement> counrtyList = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div"));
        for(WebElement country : counrtyList){
            if(country.getText().equalsIgnoreCase(expectedCountry)){
                System.out.println(country.getText());
                Assert.assertEquals(country.getText(),expectedCountry);
                country.click();
                break;
            }
        }

        // Alternative - get and print the value by using the keyboard actions
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(2000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
    }
}
