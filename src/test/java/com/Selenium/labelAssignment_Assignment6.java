package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class labelAssignment_Assignment6 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        WebElement option = driver.findElement(By.id("checkBoxOption2"));
        option.click();
        String labelText = option.getAttribute("value").trim();
        WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropDown);
        select.selectByValue(labelText);

        driver.findElement(By.id("name")).sendKeys(labelText);
        driver.findElement(By.id("alertbtn")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Assert.assertTrue(alertText.contains(labelText));
    }
}
