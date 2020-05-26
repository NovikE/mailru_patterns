package driver;

import decorator.CustomDriverDecorator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static CustomDriverDecorator driver;

    private DriverSingleton() {
    }

    public static CustomDriverDecorator getDriver() {
        if (null == driver) {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("platformName", Platform.WINDOWS);
            try {
                driver = new CustomDriverDecorator(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
             driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
           //driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
