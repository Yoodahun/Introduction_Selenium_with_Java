package handlingAlerts;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {
//Handling Javascript Alerts.
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
/* click Alert */
        String text = "Test Message";
        WebElement textInput = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        textInput.sendKeys(text);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"alertbtn\"]")).click();

        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
/* confirm button alert */
        driver.findElement(By.xpath("//*[@id=\"confirmbtn\"]")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        driver.close();




    }
}
