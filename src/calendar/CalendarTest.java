package calendar;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        //(//a[@value="MAA"])[2]
        //a[@value="BLR"]

        WebElement from, to, departDate;
        Thread.sleep(4000);
        from = driver.findElement(By.xpath(".//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]"));
        from.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@value=\"BLR\"]")).click();
        Thread.sleep(2000);

        to = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]"));
        to.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();
        //*[@id="ctl00_mainContent_ddl_originStation1_CTNR"]
        Thread.sleep(2000);

        /* Calendar */

        departDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[2]/a"));
        departDate.click();

        driver.close();



    }
}
