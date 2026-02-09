package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SpiceJetDatePicker {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //checking the todate datepicker is disabled or not
        // System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        driver.get("https://www.spicejet.com/");
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
}
