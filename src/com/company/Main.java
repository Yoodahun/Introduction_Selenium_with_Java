package com.company;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static String DRIVER_PATH = "/Users/yoodahun/Documents/Github/Java/Selenium WebDriver with Java/chromedriver";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        driver.navigate().to("https://www.naver.com");
        driver.navigate().back();
        System.out.println(driver.getTitle());


        driver.close();




    }
}
