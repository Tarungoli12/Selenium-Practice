package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String username = driver.findElement(By.xpath("(//i)[1]")).getText();
        String password = driver.findElement(By.xpath("(//i)[2]")).getText();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='user']")).click();
        WebElement okayBtn = driver.findElement(By.id("okayBtn"));
        wait.until(ExpectedConditions.elementToBeClickable(okayBtn));
        okayBtn.click();
        WebElement selectTagWebElement = driver.findElement(By.tagName("select"));
        Select select = new Select(selectTagWebElement);
        select.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        wait.until(ExpectedConditions.titleIs("ProtoCommerce"));
        List<WebElement> items = driver.findElements(By.xpath("//button[normalize-space()='Add']"));
        for (WebElement item : items) {
            item.click();
        }
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        for(WebElement product : products){
            System.out.println(product.getText());
        }
    }
}

