package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class InvokingMultipleTabsOrWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        driver.switchTo().window(childWindowId);

        driver.get("https://rahulshettyacademy.com/");

        String courseName = driver.findElement(By.xpath("//h3[text()='Selenium WebDriver with Java - Basics to Advanced']")).getText();

        driver.switchTo().window(parentWindowId);

        driver.findElement(By.name("name")).sendKeys(courseName);
    }
}
