package end2end;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {
//Total practice UI element
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");

        WebElement from, to, departDate, returnDate, checkbox;
        Select passengers;

/* Dropdown */
        Thread.sleep(2000);
    /* from */
        from = driver.findElement(By.xpath(".//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]"));
        from.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value=\"BLR\"]")).click();
        Thread.sleep(2000);
    /* to */
        to = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]"));
        to.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();
        Thread.sleep(2000);
/* Calendar */
    /* depart date */
        departDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[2]/a"));
        //*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[4]/td[2]/a
        departDate.click();
        Thread.sleep(2000);
        returnDate = driver.findElement(By.xpath("//*[@id=\"Div1\"]"));
        if(returnDate.getAttribute("style").contains("1")) {
            System.out.println("enable!");
            Assert.assertTrue(false);
        } else {
            System.out.println("disable!");
            Assert.assertTrue(true);
        }
/* Select */
    /* Select passengers */
        driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
        Thread.sleep(2000);
        passengers = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_Adult\"]")));
        passengers.selectByValue("4");
        Thread.sleep(2000);
/* Checkbox */
        checkbox = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_friendsandfamily\"]"));
        checkbox.click();
/* click the search button */
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();
        Thread.sleep(3000);

        driver.close();

    }
}
