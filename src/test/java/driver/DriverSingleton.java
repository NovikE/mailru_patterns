package driver;

import decorator.CustomDriverDecorator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static CustomDriverDecorator driver;

    private DriverSingleton() {
    }

    public static CustomDriverDecorator getDriver() {
        if (null == driver) {
            WebDriverManager.chromedriver().setup();
            driver = new CustomDriverDecorator(new ChromeDriver());
           //driver = ChromeDriver();
        }
           // driver = new CustomDriverDecorator(driver);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
           //driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
