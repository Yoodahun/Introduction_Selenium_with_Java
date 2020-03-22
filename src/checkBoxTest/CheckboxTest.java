package checkBoxTest;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CheckboxTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_SeniorCitizenDiscount\"]"));
        checkbox.click();
        System.out.println(checkbox.isSelected());

        Assert.assertTrue(checkbox.isSelected());

        /* checkbox counts */
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Thread.sleep(2000);
        /* Validate UI whether disable or enable */
        //round trip

        WebElement returnDate = driver.findElement(By.xpath("//*[@id=\"Div1\"]"));
        System.out.println(returnDate.getAttribute("style"));
        checkbox = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_rbtnl_Trip_1\"]"));
        checkbox.click();
        Thread.sleep(4000);
        if(returnDate.getAttribute("style").contains("1")) {
            System.out.println("enable!");
            Assert.assertTrue(true);
        } else {
            System.out.println("disable!");
            Assert.assertTrue(false);
        }
        System.out.println(returnDate.getAttribute("style"));
//        System.out.println(driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date2\"]")).isEnabled());



        driver.close();

    }
}
