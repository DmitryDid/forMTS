package dns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Catalog extends PagePrototype {

    private String catalogXPath = "//div[@class='item' and @data-id='catalog-item']";
    private String nameXPAth = catalogXPath + "//h3";
    private String priceXPAth = catalogXPath + "//span[@data-of='price-total']";
    private List<WebElement> catalog;

    public Catalog(WebDriver driver) {
        super(driver);
    }


    public String getFirstItemName() {
        init();
        logger.logInfo("   - Получаем название первого продукта");
        return driver.findElements(By.xpath(nameXPAth)).get(0).getText();
    }

    public String getFirstItemPrice() {
        logger.logInfo("   - Получаем цену первого продукта");
        return driver.findElements(By.xpath(priceXPAth)).get(0).getText();
    }

    public String getLastItemName() {
        init();
        logger.logInfo("   - Получаем название последнего продукта");
        return driver.findElements(By.xpath(nameXPAth)).get(catalog.size() - 1).getText();
    }

    public String getLastItemPrice() {
        logger.logInfo("   - Получаем цену последнего продукта");
        return driver.findElements(By.xpath(priceXPAth)).get(catalog.size() - 1).getText();
    }

    private void init() {
        driver.navigate().to(driver.getCurrentUrl());
        catalog = driver.findElements(By.xpath(catalogXPath));
    }

    public void goToTheLastPage() {
        try {
            driver.findElement(By.xpath("//span[@class='item edge']")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//span[@class=' item edge']")).click();
        } finally {
            return;
        }
    }
}