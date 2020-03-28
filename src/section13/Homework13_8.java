package section13;

import enums.TestConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework13_8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String country = "United States (USA)";

        WebElement inputbox = driver.findElement(By.xpath("//*[@id=\"autocomplete\"]"));
        inputbox.sendKeys("us");

        while(!inputbox.getAttribute("value").equals(country)) {
            System.out.println(inputbox.getAttribute("value"));
            inputbox.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(2000);
        }
        inputbox.sendKeys(Keys.ENTER);
        System.out.println(inputbox.getText());

        Thread.sleep(3000);
        driver.quit();


    }
}
