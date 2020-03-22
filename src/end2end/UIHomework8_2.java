package end2end;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UIHomework8_2 {
    public static void main(String[] args) throws InterruptedException {
/* Homework 8-2 */

        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cleartrip.com/");

        WebElement element;
        Select adults;
    /* from */
        element = driver.findElement(By.xpath("//*[@id=\"FromTag\"]"));
        element.sendKeys("new");

    /* Depart Date */
        element = driver.findElement(By.xpath("//*[@id=\"DepartDate\"]"));
        element.click();
        Thread.sleep(2000);
    /* Select member */
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[6]/a")).click();
        adults = new Select(driver.findElement(By.xpath("//*[@id=\"Adults\"]")));
        adults.selectByValue("2");
    /* Click More Options */
        element = driver.findElement(By.xpath("//*[@id=\"MoreOptionsLink\"]"));
        element.click();
    /* Preferred Airline */
        driver.findElement(By.xpath("//*[@id=\"AirlineAutocomplete\"]")).sendKeys("indigo");
        Thread.sleep(3000);
    /* Click Search Flights */
        driver.findElement(By.xpath("//*[@id=\"SearchBtn\"]")).click();
    /* get Error Message */
        System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

        Thread.sleep(3000);
        driver.close();


    }
}
