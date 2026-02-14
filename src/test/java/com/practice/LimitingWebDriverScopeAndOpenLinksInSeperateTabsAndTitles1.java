package com.practice;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitingWebDriverScopeAndOpenLinksInSeperateTabsAndTitles1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().window().maximize();

        //1. Give me the count of links on the page.
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. Count of footer section.
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // Limiting webdriver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //3. count of 2nd column links in footer section.
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        //4. click on each link in the 2nd column and check if the pages are opening (excluding 1st link)
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);    //crtl+click
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000L);
        }// opens all the tabs

        Set<String> abc = driver.getWindowHandles();//4

        // print the titles of all opened pages
        for (String s : abc) {
            driver.switchTo().window(s);
            System.out.println(driver.getTitle());
        }
    }

}
