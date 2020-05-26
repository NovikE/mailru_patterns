package pages;

import decorator.CustomDriverDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected CustomDriverDecorator driver;

    protected final int WAIT_TIMEOUTS_SECONDS = 10;

    protected AbstractPage(CustomDriverDecorator driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
