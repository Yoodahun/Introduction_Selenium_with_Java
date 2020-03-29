package section14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertification {
    public static void main(String[] args) {

        //general chrome profile.
        DesiredCapabilities ch = DesiredCapabilities.chrome();
        ch.acceptInsecureCerts(); //certificated.

//        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, value);

        //belongs to my local browser
        ChromeOptions c = new ChromeOptions();
        c.merge(ch);
        WebDriver driver = new ChromeDriver(c);
    }
}
