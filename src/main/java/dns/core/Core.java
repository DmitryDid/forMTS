package dns.core;

import dns.helpers.CheckHelper;
import dns.pages.Catalog;
import dns.pages.Filter;
import dns.pages.Menu;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Core {

    private String expectedProductName;
    private String expectedProductPrice;
    private String actualProductName;
    private String actualProductPrice;

    protected WebDriver driver;
    protected Logger logger;
    protected CheckHelper checkHelper;
    protected Menu menu;
    protected Filter filter;
    protected Catalog catalog;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        init();
        logger.logInfo("Открываем стартовую страницу \"https://www.dns-shop.ru/\"");
        driver.get("https://www.dns-shop.ru/");

        try {
            driver.findElement(By.xpath("//a[@class='btn btn-additional']")).click();
        } catch (Exception e) {
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void init() {
        checkHelper = new CheckHelper(driver, logger);
        catalog = new Catalog(driver);
        logger = new Logger();
        filter = new Filter(driver);
        menu = new Menu(driver);
    }

    protected void checkCatalogSort() {
        logger.logInfo("Проверка:");
        filter.sortBy("По возрастанию цены");

        try {
            expectedProductName = catalog.getFirstItemName();
            expectedProductPrice = catalog.getFirstItemPrice();
        } catch (IndexOutOfBoundsException e) {
            logger.logInfo(driver.findElement(By.xpath("//div[@class='null-result']//p")).getText());
            return;
        }
        filter.sortBy("По убыванию цены");

        catalog.goToTheLastPage();

        actualProductName = catalog.getLastItemName();
        actualProductPrice = catalog.getLastItemPrice();

        logger.logInfo("   - Проверяем эквавалентность данных");
        Assert.assertEquals(expectedProductPrice, actualProductPrice);
        Assert.assertEquals(expectedProductName, actualProductName);
    }
}