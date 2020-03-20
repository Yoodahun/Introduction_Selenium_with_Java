package checkBoxTest;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_SeniorCitizenDiscount\"]"));
        checkbox.click();
        System.out.println(checkbox.isSelected());

        /* checkbox counts */

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());



        driver.close();

    }
}
