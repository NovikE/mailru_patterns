package decorator;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Set;

public class CustomDriverDecorator implements WebDriver, JavascriptExecutor {

    protected RemoteWebDriver driver;

    public CustomDriverDecorator(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public void get(String url) {
        System.out.println("Browser will open the page...");
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();

    }

    public void quit() {
        System.out.println("Browser will be closed now...");
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return driver.getScreenshotAs(target);
    }

    public Object executeScript(String script, Object... args) {
        return driver.executeScript(script, args);
    }

    public Object executeAsyncScript(String script, Object... args) {
        return driver.executeAsyncScript(script, args);
    }
}
