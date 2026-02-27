package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Assertions2 {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //URL in the browser

        WebElement firstCheckBox = driver.findElement(By.id("checkBoxOption1"));

        firstCheckBox.click();

        Assert.assertTrue(firstCheckBox.isSelected());firstCheckBox.click();

        Assert.assertFalse(firstCheckBox.isSelected());

        List<WebElement> list = driver.findElements(By.cssSelector("input[type='checkbox']"));

        System.out.println(list.size());

    }
}
