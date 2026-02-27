package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableAssignment_Assignment7 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        // Locate table once
        WebElement table = driver.findElement(By.name("courses"));

        // Get all rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        int totalRows = rows.size();
        int totalColumns = rows.get(0).findElements(By.tagName("th")).size();

        System.out.println("Total rows in table : " + totalRows);
        System.out.println("Total columns in table : " + totalColumns);

        // Start from row index 1 (skip header)
        for (int i = 1; i < totalRows; i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            for (WebElement column : columns) {
                System.out.print(column.getText() + "  ");
            }
            System.out.println();
        }
    }
}