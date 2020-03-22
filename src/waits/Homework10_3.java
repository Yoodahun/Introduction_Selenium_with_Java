package waits;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework10_3 {
    public static void main(String[] args) {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));

        System.out.println(driver.findElement(By.id("results")).getText());

        driver.close();


    }
}
