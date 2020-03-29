package section14;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableSorting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(2000);

        WebElement th;
        List<WebElement> td; //tr td nth-child(2)
        th = driver.findElement(By.cssSelector("thead th:nth-child(2)"));

        ArrayList<String> originalList = new ArrayList<String>();
        ArrayList<String> sortedList = new ArrayList<String>();

        th.click();
        td = driver.findElements(By.cssSelector("tr td:nth-child(2)"));

        for (WebElement element : td) {
            System.out.println(element.getText());
            originalList.add(element.getText());
            sortedList.add(element.getText());
        }
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        Assert.assertTrue(originalList.equals(sortedList));

        th.click();
        td = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
        Thread.sleep(2000);
        originalList.clear();
        for (WebElement element : td) {
            System.out.println(element.getText());
            originalList.add(element.getText());
        }
        Collections.sort(sortedList);
        Assert.assertTrue(originalList.equals(sortedList));

        Thread.sleep(2000);
        driver.quit();





    }
}
