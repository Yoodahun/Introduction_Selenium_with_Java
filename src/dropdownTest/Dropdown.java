package dropdownTest;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
/* Auto Suggestive Dropdown */

        WebElement fromCity, toCity;
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(4000);
        fromCity = driver.findElement(By.xpath("//*[@id=\"fromCity\"]"));
        fromCity.click();
//        fromCity.clear();
        fromCity = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromCity.click();
        Thread.sleep(2000);
        fromCity.sendKeys("mum");
        Thread.sleep(2000);
        fromCity.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        fromCity.sendKeys(Keys.ENTER);
        Thread.sleep(4000);

        toCity = driver.findElement(By.xpath("//input[@placeholder='To']"));
//        toCity.click();
        Thread.sleep(2000);
        toCity.sendKeys("chenn");
        Thread.sleep(2000);
        toCity.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        toCity.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

/* Dynamic Dropdown */
/*
        driver.get("https://www.spicejet.com/");
        //(//a[@value="MAA"])[2]
        //a[@value="BLR"]

        Thread.sleep(4000);
        driver.findElement(By.xpath(".//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@value=\"BLR\"]")).click();
        Thread.sleep(2000);
        //*[@id="ctl00_mainContent_ddl_originStation1_CTNR"]
*/


/* Static Dropdown  */
/*
//        Thread.sleep(4000);
//        WebElement adult = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        driver.findElement(By.id("divpaxinfo")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());


        System.out.println("Click");
        Thread.sleep(4000);
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        System.out.println("Click");
        s.selectByValue("2");
        Thread.sleep(4000);
        s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
//        Select s = new Select(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[4]/table/tbody/tr[2]/td/div/p[4]/table/tbody/tr/td/select")));
        Thread.sleep(4000);
        s.selectByValue("USD");
        Thread.sleep(4000);
        s.selectByIndex(1);
        System.out.println(s.getOptions());
        Thread.sleep(4000);

*/
        driver.close();


    }
}
