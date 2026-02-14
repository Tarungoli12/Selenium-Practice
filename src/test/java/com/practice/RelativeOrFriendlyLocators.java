package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeOrFriendlyLocators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //above
        WebElement nameInputBox = driver.findElement(By.name("name"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameInputBox)).getText());

        //below
        WebElement password = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.cssSelector("input[type='date']")).below(password)).sendKeys("11022024");
        System.out.println(driver.findElement(By.cssSelector("input[type='date']")).getAttribute("value"));

        //left
        WebElement labelCheckBox = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
        driver.findElement(with(By.id("exampleCheck1")).toLeftOf(labelCheckBox)).click();

        //right
        WebElement radioBtn = driver.findElement(By.id("inlineRadio1"));
        driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).click();
    }
}
