package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentForm {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("Tarun");

        driver.findElement(By.name("email")).sendKeys("G");

        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Tarun@123");

        driver.findElement(By.id("exampleCheck1")).click();

        WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
        Select select = new Select(gender);

        select.selectByVisibleText("Female");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("21092002");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
    }
}
