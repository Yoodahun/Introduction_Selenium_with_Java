package actions;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));

        WebElement dragBox, dropBox;
        dragBox = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        dropBox = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
        Actions action = new Actions(driver);

        action.dragAndDrop(dragBox, dropBox).build().perform();
        driver.switchTo().defaultContent();


        Thread.sleep(3000);
        driver.close();


    }
}
