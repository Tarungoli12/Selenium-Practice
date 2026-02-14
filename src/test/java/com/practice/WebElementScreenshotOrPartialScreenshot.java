package com.practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class WebElementScreenshotOrPartialScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        String courseName = "Hello";
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys(courseName);
        File src = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("logo.png"));
    }
}
