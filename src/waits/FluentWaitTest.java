package waits;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    public static void main(String[] args) {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.cssSelector("button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                                        .withTimeout(Duration.ofSeconds(30))
                                        .pollingEvery(Duration.ofSeconds(1))
                                        .ignoring(NoSuchElementException.class);
        WebElement text = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.id("finish")).isDisplayed()) {
                    return driver.findElement(By.id("finish"));

                } else {
                    return null;
                }
            }
        });

        System.out.println(text.getText());

        driver.close();






    }
}
