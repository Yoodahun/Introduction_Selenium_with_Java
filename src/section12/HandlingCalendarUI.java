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

        List<WebElement> elements = driver.findElements(By.className("day"));

        for (WebElement element : elements) {
            if(element.getText().equals("31")) {
                element.click();
                break;
            }
        }

        Thread.sleep(3000);
        driver.quit();


    }
}
