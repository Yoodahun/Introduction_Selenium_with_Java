package actions;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.co.jp/");
//mouse over
        Actions action = new Actions(driver);
        //if there is no build() and perform(), doesn't execute.
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).build().perform();

//Input capital letter
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"))).click().build().perform();
        action.keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
        Thread.sleep(2000);

//Select Entire Text sentence.
        action.doubleClick().build().perform();
        Thread.sleep(1000);

//Right click.
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"))).build().perform();
        action.contextClick().build().perform();

//Drag and Drop (handling multiple windows)







        Thread.sleep(3000);
        driver.close();


    }
}
