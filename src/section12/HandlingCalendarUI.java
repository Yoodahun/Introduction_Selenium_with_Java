package section12;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingCalendarUI {
/*
    Section 12
    93. handling Calenadar UI in Travel Websites.
 */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        //march 31

        driver.findElement(By.xpath("//*[@id=\"travel_date\"]")).click();
        Thread.sleep(3000);

        //Grab common attribute.
        // June 24, 2020 select month and date
        WebElement month = driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]"));
        while(!month.getText().contains("June")) {
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[3]")).click();
        }

        List<WebElement> elements = driver.findElements(By.className("day"));

        for (WebElement element : elements) {
            if(element.getText().equals("24")) {
                element.click();
                break;
            }
        }

        Thread.sleep(3000);
        driver.quit();


    }
}
