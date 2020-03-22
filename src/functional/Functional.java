package functional;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Functional {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[3]/button")).click();

        List<WebElement> elements, buttons;
        elements = driver.findElements(By.cssSelector("h4.product-name"));
        buttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot","Brinjal"};
        List itemsNeededList = Arrays.asList(itemsNeeded); // convert String to List
        Thread.sleep(3000);
        for (int i = 0; i < elements.size(); i++) {
            String name = elements.get(i).getText().split("-")[0].strip();

            if (itemsNeededList.contains(name)) {
                System.out.println(name);
                buttons.get(i).click();
                Thread.sleep(1000);
            }
        }

        Thread.sleep(5000);

        driver.close();






    }
}
