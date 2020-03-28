package section13;

import enums.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class TableGrid {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22711/rsaixi-vs-eng-2-day-practice-match-england-tour-of-south-africa-2019-20");

        // get information in the table grid.
        // 어떠한 비슷한 CSS로 유추해볼 수 있음.

        WebElement table;
        table = driver.findElement(By.cssSelector(".cb-col.cb-col-100.cb-ltst-wgt-hdr"));

        List<WebElement> row = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)" ));
        Thread.sleep(3000);
        System.out.println( row.size());
//        System.out.println( row.get(0).findElement(By.cssSelector(".cb-col.cb-col-8.text-right.text-bold")).getText());

        int score = 0;
        int total = 0;
        for( int i = 0; i < row.size()-2; i++) {
            String sc = row.get(i).getText();
            score += Integer.parseInt(sc);
        }
        total = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]/div[13]/div[2]")).getText());
        Thread.sleep(2000);
        score += Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]/div[12]/div[2]")).getText());

        System.out.println(total);
        System.out.println(score);

        Thread.sleep(3000);
        driver.quit();




    }
}
