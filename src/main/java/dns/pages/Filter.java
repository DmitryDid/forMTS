package dns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Filter extends PagePrototype {

    private By.ByXPath minPriceXPAth = (By.ByXPath) By.xpath("//input[@data-name='min']");
    private By.ByXPath maxPriceXPAth = (By.ByXPath) By.xpath("//input[@data-name='max']");
    private By.ByXPath producerXPAth = (By.ByXPath) By.xpath("//input[@data-role='filter-items-search']");

    public Filter(WebDriver driver) {
        super(driver);
    }

    public void fillMinPrice(String minPrice) {
        logger.logInfo("   - Заполняем фильтр минимальной цены: " + minPrice);
        fillField(minPriceXPAth, minPrice);
    }

    public void fillMaxPrice(String maxPrice) {
        logger.logInfo("   - Заполняем фильтр максимальной цены: " + maxPrice);
        fillField(maxPriceXPAth, maxPrice);
    }

    public void selectProducer(String producerName) {
        logger.logInfo("   - Выбираем производителя: " + producerName);
        fillField(producerXPAth, producerName);
    }

    public void apply() {
        logger.logInfo("   - Применяем фильтр");
        driver.findElement(By.partialLinkText("Показать")).click();
    }

    public void sortBy(String sortingType) {
        logger.logInfo("   - Сортируем " + sortingType);
        driver.findElement(By.xpath("//div[@class='col'][1]//span[@class='title']")).click();
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='" + sortingType + "']")).click();
        driver.navigate().to(driver.getCurrentUrl());
    }

    private void fillField(By locator, String value) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
}