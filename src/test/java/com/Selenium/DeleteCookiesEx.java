package com.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookiesEx {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();  // Delete All cookies
//        driver.manage().deleteCookieNamed("SessionKey"); //Delete specific named cookie
        driver.get("http://google.com/");
    }
}
