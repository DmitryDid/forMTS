package dns.pages;

import dns.core.Logger;
import dns.helpers.CheckHelper;
import org.openqa.selenium.WebDriver;

public class PagePrototype {

    protected WebDriver driver;
    protected Logger logger;
    protected CheckHelper checkHelper;

    public PagePrototype(WebDriver driver) {
        this.driver = driver;
        this.logger = new Logger();
        this.checkHelper = new CheckHelper(driver, logger);
    }
}