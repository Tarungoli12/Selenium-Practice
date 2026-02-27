package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandleAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.xpath("//h3/following-sibling::a")).click();
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String window : windows){
            if(!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                System.out.println(driver.findElement(By.tagName("h3")).getText());
            }
        }
        driver.switchTo().window(currentWindow);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
