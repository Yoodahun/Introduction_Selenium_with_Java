package actions;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;

public class Homework11_4 {
    public static void main(String[] args) {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/windows");

        WebElement clickHere, text;
        String parent, child;

        clickHere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        clickHere.click();

        Iterator<String> windowsIterator = driver.getWindowHandles().iterator();
        parent = windowsIterator.next();
        child = windowsIterator.next();

        driver.switchTo().window(child);
        text = driver.findElement(By.xpath("/html/body/div/h3"));
        System.out.println(text.getText());

        driver.switchTo().window(parent);
        text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
        System.out.println(text.getText());

        driver.quit();

    }
}
