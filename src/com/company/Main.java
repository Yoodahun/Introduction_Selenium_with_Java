package com.company;


import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();

        driver.get("https://login.salesforce.com/");

        driver.findElement(By.id("username")).sendKeys("dahun4032");
        driver.findElement(By.id("password")).sendKeys("hello");
        driver.findElement(By.id("Login")).click();

//        String errorMessage = driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();
//        System.out.println(errorMessage);

        driver.navigate().to("https://www.google.com");
        driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("Hi");





        driver.close();




    }
}
