package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ScrollUsingJS {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,150)");
        List<WebElement> fourthColumDetails = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for (WebElement element : fourthColumDetails){
            sum += Integer.parseInt(element.getText());
        }
        System.out.println(sum);

        driver.findElement(By.className("totalAmount")).getText();

        int total = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
        System.out.println(total);
        Assert.assertEquals(sum,total);
    }
}
