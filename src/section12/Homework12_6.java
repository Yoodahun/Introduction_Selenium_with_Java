package section12;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Homework12_6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement checkboxes, checkedbox, editbox;
        Select dropdown;
        List<WebElement> checkbox;
        String message;


    // 1. Select Checkbox
        checkboxes = driver.findElement(By.id("checkbox-example"));
        checkbox = checkboxes.findElements(By.tagName("label"));

        checkedbox = checkbox.get(new Random().nextInt(3));
        checkedbox.findElement(By.tagName("input")).click();

    // 2. Grab the checkbox.
        message = checkedbox.getText();

    // 3. Select an option in dropdown. Option to select should come from checkbox.
        dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdown.selectByVisibleText(message);

    // 4. Enter the step2 grabbed label text in Editbox
        editbox = driver.findElement(By.id("name"));
        editbox.sendKeys(message);

    // 5. click alert button, and ten if text grabbed from step 2 in the popup message
        driver.findElement(By.id("alertbtn")).click();
        if(driver.switchTo().alert().getText().contains(message)) {
            System.out.println("There is " + message);
        } else {
            System.out.println("There is no message");
        }

        Thread.sleep(3000);
        driver.quit();



    }
}
