package dns.helpers;

import dns.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckHelper {
    private WebDriver driver;
    private Logger logger;

    public CheckHelper(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
    }

    public void checkPageHeader(String headerText) {
        logger.logInfo("   - Проверка текста заголовка страницы");
        String currentText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Ошибка! Проверка текста заголовка не пройдена.", headerText, currentText);
    }

    public void checkPrice(String expectedPrice) {
        logger.logInfo("   - Проверка цены товара");
        String currentPrice = driver.findElement(By.cssSelector("span.price")).getText();
        Assert.assertEquals("Ошибка! Проверка значения цены не пройдена.", expectedPrice, currentPrice);
    }
}