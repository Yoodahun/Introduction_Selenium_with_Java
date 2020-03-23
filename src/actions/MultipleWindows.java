package actions;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup");

        driver.findElement(By.xpath("//*[@id=\"initialView\"]/footer/ul/li[1]/a")).click();

    //Return handling id
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> id = ids.iterator();

        String parentId = id.next();
        String child = id.next();

        driver.switchTo().window(child);


        Thread.sleep(3000);
        driver.close();



    }


}
