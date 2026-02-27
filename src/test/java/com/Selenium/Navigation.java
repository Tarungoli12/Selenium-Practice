package com.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://google.com");

        driver.navigate().to("https://rahulshettyacademy.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();
    }
}