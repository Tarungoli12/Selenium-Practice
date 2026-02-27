package com.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsEx {

    @Test
    public void regular(){
        //Count the number of names starting with 'A' in the list in normal fashion
        ArrayList<String> list = new ArrayList<String>();
        list.add("Abhijeet");
        list.add("Don");
        list.add("Alekya");
        list.add("Adam");
        list.add("Ram");

        int count = 0;
        for(String name : list){
            if(name.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter(){
        //Count the number of names starting with 'A' in the list using Streams
        ArrayList<String> list = new ArrayList<String>();
        list.add("Abhijeet");
        list.add("Don");
        list.add("Alekya");
        list.add("Adam");
        list.add("Ram");

        long c = list.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

        //print all names
        list.forEach(System.out::println);

        //print the names which length is >4
        list.stream().filter(s->s.length()>4).forEach(System.out::println);

        //print the first result for names which length is >4
        list.stream().filter(s->s.length()>4).limit(1).forEach(System.out::println);

    }

    @Test
    public void createStream(){
        //Count the number of names starting with 'A' by creating the Streams
        long c = Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s->s.startsWith("A")).count();
        System.out.println(c);

        //Terminal operation will execute only if intermediate operation (filter) return true
        long d = Stream.of("Abhijeet","Don","Alekya","Adam","Ram").filter(s ->
        {
            s.startsWith("A");
            return false;
        }).count();
        System.out.println(d); //It will return 0
    }

    @Test
    public void StreamMap() {
        //print the names ends with 'A' with uppercase
        Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Rama").filter(s -> s.endsWith("a"))
                .map(String::toUpperCase).forEach(System.out::println);

        //print the names in uppercase start with "A" and sort
        List<String> list1 = Arrays.asList("Abhijeet","Adam","Alekya","Ram","Don");
        list1.stream().filter(s->s.startsWith("A")).sorted()
                .map(String::toUpperCase).forEach(System.out::println);

        //Merging the two list and sort
        System.out.println("Merging the two list and sort");
        List<String> list2 = Arrays.asList("Man","Women","Don");
        Stream<String> newStream = Stream.concat(list1.stream(),list2.stream());
        newStream.sorted().forEach(System.out::println);

        //verify the adam is present
        boolean flag = list1.stream().anyMatch(s->s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect(){

        //store the names in list whose names are ends with 'a' and in uppercase
        List<String> ls = Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Rama").filter(s -> s.endsWith("a")).
                map(String::toUpperCase).toList();
        System.out.println(ls.get(0));

        //print the unique elements in sorted order
        List<Integer> list = Arrays.asList(3,2,2,7,5,1,9,7);
        list.stream().distinct().sorted().forEach(System.out::println);
    }

    @Test
    public void cartItemsSort(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on first column header for to sort the values
        driver.findElement(By.xpath("//th[1]")).click();

        //store the names in list with getText() using streams
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> original = items.stream().map(WebElement::getText).toList();

        //sort the original string using streams
        List<String> actual = original.stream().sorted().toList();

        //check if two lists are equal
        Assert.assertEquals(actual, original);
    }


    @Test
    public void cartItemsPrice(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on first column header for to sort the values
        driver.findElement(By.xpath("//th[1]")).click();

        //store the price of particular veggie name in list with getText() using streams
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> price = items.stream().filter(s->s.getText().
                contains("Beans")).map(s->getVeggiePrice(s)).toList();
        price.forEach(System.out::println);
    }

    private String getVeggiePrice(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }


    @Test
    public void CartPageNation(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on first column header for to sort the values
        driver.findElement(By.xpath("//th[1]")).click();
        List<WebElement> items;
        List<String> price;

        do{
            items = driver.findElements(By.xpath("//tr/td[1]"));
            price = items.stream().filter(s->s.getText().
                    contains("Rice")).map(s->getVeggiePrice(s)).toList();
            if(price.isEmpty()){
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        }while (price.isEmpty());

        price.forEach(System.out::println);
    }

    @Test
    public void cartPageFilter(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> result = items.stream().filter(s->s.getText().contains("Rice")).toList();
        Assert.assertEquals(items.size(),result.size());

    }
}
