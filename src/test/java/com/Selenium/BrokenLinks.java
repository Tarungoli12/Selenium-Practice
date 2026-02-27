package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.*;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException, URISyntaxException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> urls = driver.findElements(By.xpath("//li[@class='gf-li']/a"));

        //Soft Assertion
        SoftAssert softAssert = new SoftAssert();


        for (WebElement element : urls){
            String url = element.getAttribute("href");
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("HEAD");
            con.connect();
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);

            softAssert.assertTrue(responseCode<400,"The link " + url + " is broken link with status code " + responseCode);

//            if(responseCode>400){
//                System.out.println("The link " + url + " is broken link with status code " + responseCode);
//                Assert.fail();
//            }
        }

        //It will store the errors in execution time, and it doesn't throw any error, so after using assertAll() at last it will give the errors which are occurred.
        softAssert.assertAll();
    }
}
