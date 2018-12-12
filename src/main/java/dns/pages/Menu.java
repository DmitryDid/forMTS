package dns.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Menu extends PagePrototype {

    public Menu(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(String categoryName) {
        logger.logInfo("   - Переходим в категорию: " + categoryName);
        driver.findElement(By.partialLinkText(categoryName)).click();
        checkHelper.checkPageHeader(categoryName);
    }

    public void selectSubCategory(String subCategoryName) {
        logger.logInfo("   - Переходим в категорию: " + subCategoryName);
        driver.findElement(By.xpath("//a[@class='category-item-desktop']//span[text()='" + subCategoryName + "']")).click();
        checkHelper.checkPageHeader(subCategoryName);
    }
}