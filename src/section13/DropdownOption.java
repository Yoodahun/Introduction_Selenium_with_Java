package section13;

import enums.TestConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownOption {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://ksrtc.in/oprs-web/");

        //BENGALURU INTERNATION AIRPORT

        String target = "BENGALURU INTERNATION AIRPORT";
        WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"fromPlaceName\"]"));
        inputBox.sendKeys("beng");
        Thread.sleep(3000);

        //Javascript DOM can extract hidden elements.
        //Selenium cannot identify hidden elements

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        String value = "return document.getElementById(\"fromPlaceName\").value;";

        String text = (String)javascriptExecutor.executeScript(value);

        while (!text.equals(target)) {
            System.out.println(text);
            inputBox.sendKeys(Keys.ARROW_DOWN);
            text = (String)javascriptExecutor.executeScript(value);
            Thread.sleep(2000);
        }
        inputBox.sendKeys(Keys.ENTER);
        System.out.println(inputBox.getText());

        Thread.sleep(3000);
        driver.quit();



    }
}
