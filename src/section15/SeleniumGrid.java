package section15;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    public static void main(String[] args) throws MalformedURLException {
        //DesiredCapabilities.

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("Chrome");
        dc.setPlatform(Platform.WIN10);

    //Testing remotely.
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);


    }
}
