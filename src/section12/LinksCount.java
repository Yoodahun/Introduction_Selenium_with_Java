package section12;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinksCount {
/*
    Section 12 - Real Time Exercises
    88. print the links count in the page

*/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    //the count of links on the page.
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

    //local driver - count of footersection links
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
        System.out.println(footerLinks.size());

    //find links only first columns
        WebElement columnsDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> firstColumnLinks = columnsDriver.findElements(By.tagName("a"));
        System.out.println(firstColumnLinks.size());

    //click on each link in the columns and check if the pages are opening.
        String clickOnLinks = Keys.chord(Keys.COMMAND, Keys.ENTER);
        for(int i = 1; i < firstColumnLinks.size(); i++) {
            firstColumnLinks.get(i).sendKeys(clickOnLinks);
            //get the tile every child tabs.

            Thread.sleep(5000);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while(it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }






        Thread.sleep(3000);
        driver.quit();

    }
}
