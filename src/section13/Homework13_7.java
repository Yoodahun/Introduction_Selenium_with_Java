package section13;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homework13_7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> tableRow;
        WebElement table;
        int rowCount, columnCount;

        table = driver.findElement(By.xpath("//*[@id=\"product\"]"));
        tableRow = table.findElements(By.tagName("tr"));
    //1. number of row. total 11 rows.
        rowCount = tableRow.size();
        System.out.println(rowCount);
    //2. number of columns. total 3 columns.
        columnCount = tableRow.get(0).findElements(By.tagName("th")).size();
        System.out.println(columnCount);
    //3. print second row data.
        System.out.println(tableRow.get(2).getText());

        Thread.sleep(3000);
        driver.quit();



    }
}
