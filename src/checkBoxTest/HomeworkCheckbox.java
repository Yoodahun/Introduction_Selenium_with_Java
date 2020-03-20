package checkBoxTest;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HomeworkCheckbox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        checkbox.click();
        Thread.sleep(2000);
        Assert.assertTrue(checkbox.isSelected());
        checkbox.click();
        Thread.sleep(2000);
        Assert.assertFalse(checkbox.isSelected());

        Assert.assertEquals(
                driver.findElements(By.cssSelector("input[type='checkbox']")).size(),
                3
        );

        driver.close();


    }
}
