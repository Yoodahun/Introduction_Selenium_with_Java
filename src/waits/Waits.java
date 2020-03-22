package waits;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Waits {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[3]/button")).click();
        addItems(driver);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
//        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());




        Thread.sleep(5000);

        driver.close();
    }

    static void addItems(WebDriver driver) throws InterruptedException {
        List<WebElement> elements, buttons;

        elements = driver.findElements(By.cssSelector("h4.product-name"));
        buttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

        String[] itemsNeeded = TestConstants.TEST_VEGETABLES.getValues();
        List itemsNeededList = Arrays.asList(itemsNeeded); // convert String to List
//        Thread.sleep(3000);

        for (int i = 0; i < elements.size(); i++) {
            String name = elements.get(i).getText().split("-")[0].strip();

            if (itemsNeededList.contains(name)) {
                System.out.println(name);
                buttons.get(i).click();
//                Thread.sleep(500);
            }
        }
    }
}
