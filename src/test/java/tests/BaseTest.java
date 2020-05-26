package tests;

import decorator.CustomDriverDecorator;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListener;


@Listeners({TestListener.class})
public class BaseTest {

    protected CustomDriverDecorator driver;


    @BeforeMethod
    public void setUp(){

       driver = DriverSingleton.getDriver();

    }

    @AfterMethod
    public void tearDown(){

        DriverSingleton.closeDriver();

    }

}
