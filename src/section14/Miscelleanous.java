package section14;

import enums.TestConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Miscelleanous {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty(TestConstants.CHROME_DRIVER.toString(), TestConstants.DRIVER_PATH.toString());
        WebDriver driver = new ChromeDriver();

//Maximize
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        System.out.println(System.getProperty("user.dir"));

//Screenshot
//        byte[] src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//        try {
//            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/screenshot.jpg");
//            fos.write(src);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/screenshot2.jpg"));

// Deleting cookies.
//        driver.manage().deleteAllCookies();


        Thread.sleep(2000);
        driver.quit();


    }
}
